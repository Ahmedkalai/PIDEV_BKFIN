package com.BKFIN.services;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Account;
import com.BKFIN.entities.Client;
import com.BKFIN.entities.Transaction;
import com.BKFIN.entities.Typeaccount;
import com.BKFIN.repositories.AccountRepository;
import com.BKFIN.repositories.ClientRepository;
import com.BKFIN.repositories.TransactionRespository;


@Service
public class AccountServiceImpl implements IAccountService {

	
	@Autowired
	AccountRepository accountrepository ; 
	@Autowired
	ClientRepository clientrepoitory ;
	@Autowired
	TransactionRespository tranrepository ; 
	@Override
	public List<Account> retrieveAllAccounts() {
		return  (List<Account>)accountrepository.findAll();
	}

	
	@Override
		public Account addAccount (Account a, Long CINclient ) {
		  Client client = clientrepoitory.findById(CINclient).orElse(null);
		  a.setClientAcc(client);
		  a.setRib(GenerateRib());
		  a.setInterest(0);
		  a.setindex_interest(0);
		accountrepository.save(a) ; 
		return a;
		
	}

	@Override
	public void deleteAccount(String id) {
		accountrepository.deleteById(id);
		
	}

	@Override
	public Account updateAccount(Account u) {
		// TODO Auto-generated method stub
		
		accountrepository.save(u) ; 
		return u;
	}

	@Override
	public Account retrieveAccount(String rib) {
	    Account  account = accountrepository.findById(rib).orElse(null);
		return account;
	}
	
	/*
	@Override
	public List<Transaction> retrieveAllTransactionsEmisesByRib(Long rib) {
		List<Transaction> ltr=accountrepository.getTransactionEmiseByRibAccount(rib);
		for (Transaction tr: ltr) {
			System.out.println("Transactions Emises :" + ltr);
		}
		return (List<Transaction>) accountrepository.getTransactionEmiseByRibAccount(rib);
	}
	
	@Override
	public List<Transaction> retrieveAllTransactionsRecuesByRib(Long rib) {
		List<Transaction> ltr=accountrepository.getTransactionEmiseByRibAccount(rib);
		for (Transaction tr: ltr) {
			System.out.println("Transactions Emises :" + ltr);
		}
		return (List<Transaction>) accountrepository.getTransactionEmiseByRibAccount(rib);
	}
*/
	
	
	//ICIIIIIIIIIIIIIIIIIIIIIIIIIIIII 
	@Override
	public Set <Transaction> retrieveAllTransactionsEmises1ByRib( String rib ){
		Account c = accountrepository.getById(rib);
		Set<Transaction> liste =  c.getTransactions() ; 
		//for (Transaction tr: liste)
		//{ 
			//if (tr.getCompte_Bancaire().getRib()==rib) 
			//liste.add(tr); 
		//}
		return liste ; 
	}
	
	///////---------------------Generation Du Rib-------------------------------------------- /////////
	/*
	Chaque lettre est remplacée par son équivalent numérique :

		A,J = 1 ; B,K,S = 2 ; C,L,T = 3 ; D,M,U = 4 ; E,N,V = 5
		F,O,W = 6 ; G,P,X = 7 ; H,Q,Y = 8 ; I,R,Z = 9

		La clé peut alors être calculée avec la formule suivante :

		Clé RIB = 97 - ( (
		   89 x Code banque +
		   15 x Code guichet +
		   3 x Numéro de compte ) modulo 97 )
    */
	//@Override
	public String GenerateRib() {
	//(code_B.MAX_VALUE==5)
		//&& (Num_Compte.length()==11)
		int i=0;
		String codeBanque="01920";
		String codeGuichet="00410";
		
		    int leftLimit = 48; // numeral '0'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 11;
		    Random random = new Random();
		    String generatedString = random.ints(leftLimit, rightLimit + 1)
		      .filter(k -> (k <= 57 || k >= 65) && (k <= 90 || k >= 97))
		      .limit(targetStringLength)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		   System.out.println(generatedString);
		   
		//Lezmou ykoun sequenceee
		String Numero_Compte=generatedString; 
		String Code_G_v=codeBanque+codeGuichet+Numero_Compte ;
		Code_G_v=Code_G_v.toUpperCase() ;
		String[]  convert=new String[21] ;
		String retour ="" ; 
		  
		
		for (i=0 ; i<21 ; i++ )
		{
			if (Character.toString (Code_G_v.charAt(i)).matches("[A,J]") )
			{
			  convert[i]="1" ; 
			  
			}
			else if (Character.toString (Code_G_v.charAt(i)).matches("[B,K,S]"))
			{
				convert[i]="2" ;
			}
			else if (Character.toString (Code_G_v.charAt(i)).matches("[C,L,T ]"))
			{
				convert[i]="3" ;
			 
			}
			else if (Character.toString (Code_G_v.charAt(i)).matches("[D,M,U]"))
			{
				convert[i]="4" ;
			}
			else if (Character.toString (Code_G_v.charAt(i)).matches("[E,N,V]"))
			{
				convert[i]="5" ;
			
			}	
			else if (Character.toString (Code_G_v.charAt(i)).matches("[F,O,W]"))
			{
			
				convert[i]="6" ;
			}
			else if (Character.toString (Code_G_v.charAt(i)).matches("[G,P,X]"))
			{
			
				convert[i]="7" ;
			}
			else if (Character.toString (Code_G_v.charAt(i)).matches("[H,Q,Y]"))
			{
				convert[i]="8" ;
			
			}
			else if (Character.toString (Code_G_v.charAt(i)).matches("[I,R,Z]"))
			{
				convert[i]="9" ;
			
			}
			else if (Character.toString (Code_G_v.charAt(i)).matches("[0-9]"))
			{
				convert[i]=""+Code_G_v.charAt(i)+"" ;
			
			}
		}
		
		{
			for(int j=0 ;j<21;j++)
				retour=retour+convert[j]; 
	
		}
		int b=Integer.parseInt(retour.substring(0,5)) ;
		System.out.println(b);
		int g=Integer.parseInt(retour.substring(5,10)) ;
		System.out.println(g);
		Long c=Long.parseLong(retour.substring(10,21));
		System.out.println(c);
		Long x= 97 - ((89 * b + 15 * g  + 3 * c) % 97) ;
		if (0<=x &&  9>=x )
		{
			return Code_G_v+"0"+x ;
		}
		return Code_G_v+x ;
		
	}
	
	//calcul du taux d'interet pour les comptes epargne 
	//chaque jour à minuit
	//“At 00:00.” nxet at 2022-03-23 00:00:00

	@Scheduled(cron = "0 0 0 * * *", zone="Africa/Tunis" ) 
	
	    @Transactional
		public void GetInterestAmount()
	    {   
	    	//calcul taux journalier
	    	final float T_journalier=(float) (0.05/360);
	    	List<Account> List_Acc = accountrepository.findByTypeAccount(Typeaccount.SAVINGSACCOUNT); 
	    	for (Account acc: List_Acc){
	    	
	    	acc.setInterest( ( acc.getSold()+acc.getInterest() ) * T_journalier + acc.getInterest() );
	    	
	    	if(acc.getindex_interest()+1==90)
	    		{
	    		//on a retranch' la retenue à la source de 20%
	    		 acc.setSold(acc.getSold()+acc.getInterest()*0.8f);
	             acc.setindex_interest(0);
	             acc.setInterest(0);
	    		}
	    	else acc.setindex_interest(acc.getindex_interest()+1);
	    	accountrepository.save(acc);


	    	
	        }
	        

	    }
	
  	
	
	
	
}

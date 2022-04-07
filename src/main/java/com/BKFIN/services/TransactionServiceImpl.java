package com.BKFIN.services;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.BKFIN.entities.Account;
import com.BKFIN.entities.Transaction;
import com.BKFIN.repositories.AccountRepository;
import com.BKFIN.repositories.TransactionRespository;




@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	TransactionRespository transrepo ; 
	@Autowired 
	AccountRepository accrepo ; 
	
	@Autowired
    public JavaMailSender emailSender;
	
	int code=0;
	/*
	@Transactional
	public Transaction addTransaction(Transaction s ,Long ribdest) {
		
	Set<Account>  listComptes= s.getComptes() ;
	Account[] Compte=(Account[]) listComptes.toArray();
	for(Account acc : Compte) {
		
		Long ribEmet= acc.getRib();
		//recuperer le rib de l'client connecté et le setter  
		s.setRibEmetteur(ribEmet);
		float tranAmount  =s.getAmount() ;
		float newSold = acc.getSold()+tranAmount ;
		acc.setSold(newSold);
		
	}
		//On peut faire un test sur l'user connecté puisqu'il ne peut pas inserer son rib 
		s.setRibRecipient(ribdest);
		//trancher le montant au utilisateur desirant envoyé la somme : l'user connécté ! 
		transrepo.save(s); 
		return s;
		
		
	}
*/
	
	 public int sendAttachmentEmail(String ReciverEmail) throws MessagingException {

	   	  MimeMessage message = emailSender.createMimeMessage();

	         boolean multipart = true;
	         
	         MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
	         int max = 999999 ;
	         int min = 9999 ; 
	         SecureRandom secureRandom = new SecureRandom();
	         int randomWithSecureRandomWithinARange = secureRandom.nextInt(max - min) + min;
	         
	         String htmlMsg = "<h3>Validate this Transaction by Using this number  </h3>"
	                 +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>"
	       		  + randomWithSecureRandomWithinARange;
	         
	         message.setContent(htmlMsg, "text/html");  
	         helper.setTo(ReciverEmail);
	         helper.setSubject("BKFIN Transaction endorsment "); 
	         this.emailSender.send(message);
	         
	         return randomWithSecureRandomWithinARange ;
	   }
	 
	@Transactional
	public int addTransaction(Transaction s ) throws MessagingException
	{		
		//Il n'as pas ajouter la trasaction au comptes qu'il l'a effectué ! 
	Account acc_emet =accrepo.findById(s.getRibEmetteur()).orElse(null) ;
	Account acc_dest =accrepo.findById(s.getRibRecipient()).orElse(null); 
	// Methode te3 GetSoldbesh
	// ajouter motif te3 transaction 
	int code_tr = sendAttachmentEmail(acc_emet.getClientAcc().getEmail()) ; 
	this.code=code_tr;
	if  (s.getAmount() < acc_emet.getSold())  
	 {
		acc_emet.setSold(acc_emet.getSold()-s.getAmount());
		s.setCompte_Bancaire(acc_emet);
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
		 //   Date date = new Date();  
		  //  formatter.format(date);
		    
		s.setDateTransaction(new Date());
		acc_dest.setSold(acc_dest.getSold()+s.getAmount());

	}
	else
	{
		code_tr=0;
	}
	
	return code_tr ;  
	}
	
	@Override
	public String  approveTransaction(Transaction s ) throws MessagingException {
		
		if((addTransaction(s)==code))
		{
		transrepo.save(s);
		return "transaction approuvée " ; 
		}
		else 
		{
		return "Transaction non approuvée" ; 		 
	    }
	} 
	
    
	@Override
	public Transaction retrieveTransaction(Long id) {
		 Transaction  tr = transrepo.findById(id).orElse(null);
			return tr; 
	}
	
	
	
	@Override
	public List<Transaction> retrieveAllTransactions(){
		
		return (List<Transaction>) transrepo.findAll();	
	}
	
	
	
	@Override
		public List<Transaction> AllTransactionsEmisesByRib(String rib) {
			List<Transaction> ltr=transrepo.getTransactionByRibAccount(rib);
			//for (Transaction tr: ltr) {
				//System.out.println("Transactions Emises :" + ltr);
			//}
			return (List<Transaction>) transrepo.getTransactionEmiseByRibAccount(rib);
		}

		
	
	@Override
	public List<Transaction> retrieveTransactions(String rib) {
	
		return (List<Transaction>) transrepo.getTransactionByRibAccount(rib);
	}
	
	
	
	
}

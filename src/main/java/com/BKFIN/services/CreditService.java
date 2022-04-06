package com.BKFIN.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Client;
import com.BKFIN.entities.Credit;
import com.BKFIN.entities.DuesHistory;
import com.BKFIN.entities.Fund;
import com.BKFIN.entities.Garantor;
import com.BKFIN.entities.Pack;
import com.BKFIN.repositories.ClientRepository;
import com.BKFIN.repositories.CreditRepository;
import com.BKFIN.repositories.DuesHistoryRepository;
import com.BKFIN.repositories.FundRepository;
import com.BKFIN.repositories.GarantorRepository;
import com.BKFIN.repositories.PackRepository;
import com.itextpdf.text.log.SysoCounter;




@Service
public class CreditService implements ICreditService {
	@Autowired
	GarantorRepository GRrepo;
	@Autowired
	CreditRepository Crepo;
	@Autowired
	ClientRepository ClientRepo;
	@Autowired
	FundRepository FundRepo;
	@Autowired
	PackRepository PackRepo;
	@Autowired
	DuesHistoryRepository DHrepo;
	
	@Override
	public List<Credit> retrieveAllCredits() {
		return (List<Credit>) Crepo.findAll();
		}
	
    
	
	//completed par default false
	
	@Override
	public Credit addCredit(Credit credit, Long Id_client, Long Id_fund, Long Id_pack ,Long Id_garantor) {
		Client client= ClientRepo.findById(Id_client).orElse(null);
		Fund fund=FundRepo.findById(Id_fund).orElse(null);
		Pack pack=PackRepo.findById(Id_pack).orElse(null);
		Garantor Garant= GRrepo.findById(Id_garantor).orElse(null);
		credit.setGarantor(Garant);
		credit.setClient(client);
		 credit.setFunds(fund);
		 credit.setPack_credit(pack);
	     credit.setDateDemande(new Date()); 
		 //NEW CLIENT
		 if(client.getCredit_authorization()==null)
		 {   //tester sur le risk(client nouveau) 
			 //NB LE TAUX DE RISQUE 1%<R<2.5%
			 if(1.5*credit.getGarantor().getSalaryGarantor()>=credit.getAmount())
			 {	 
				//CALCUL RISK
				 credit.setRisk((float) (0.01+credit.getAmount()/(credit.getGarantor().getSalaryGarantor()*100)));
				 Acceptation(credit,fund,"NouveauClient avec garant certifié");
				 
		     }
			 else
			 {credit.setState(false);
			 credit.setReason("Salaire garant insuffisant il doit etre egale à 0.33*montant du crédit");}
			 
		 }
		 //EXISTING CLIENT
		 else if(client.getCredit_authorization()==true)
		 {      //Ratio retard=late_days/period_of credit			
				float Ratio_retard=(CaculateLateDays(Crepo.getIDofLatestCompletedCreditsByClient(Id_client)))/(Crepo.getIDofLatestCompletedCreditsByClient(Id_client).getCreditPeriod()*12*30);
				//3 CAS 
				if (Ratio_retard<0.1)
					{credit.setRisk((float) 0.1);
				    Acceptation(credit,fund,"Ancien client avec un BON risque ");
			        }
				else if (Ratio_retard>=0.1 && Ratio_retard<=0.25)
					{credit.setRisk(Ratio_retard);
					Acceptation(credit,fund,"Ancien client avec un risque modérable ");
					}
				else 
					{credit.setState(false);
				    credit.setReason("Client trop Risqué Mauvais Historique");
				    client.setCredit_authorization(false);	//blackLIster le client
				    ClientRepo.save(client);
					}
			 
		 }
		 //BLACK LISTED CLIENT
		 else 
		 {
			 credit.setState(false);
			 credit.setReason("Interdiction de Crédit");  
		 }
		 Crepo.save(credit);
	        return credit;
		
	}
	
	
	//fonction de calcul du taux d'interet et de tranchement de la somme du fond 
	public void Acceptation(Credit  credit ,Fund fund ,String msg) {
		
		 //CALCUL DU TAUX D'INTERET
		 credit.setInterestRate(credit.getRisk()+fund.getTauxFund()+fund.getTauxGain());
		//changement du fond de la banque
		 if(fund.getAmountFund()-credit.getAmount()>0)
		 {   
			 fund.setAmountFund(fund.getAmountFund()-credit.getAmount());
		     credit.setState(true);
		     java.util.Date date=new java.util.Date(System.currentTimeMillis());
			 credit.setObtainingDate(date);
		     
			 if(credit.getDifféré()==false) 
			 { //System.out.println(Calcul_mensualite(credit));
				 credit.setMonthlyPaymentAmount(Calcul_mensualite(credit));
				 credit.setReason(msg);
				 credit.getClient().setCredit_authorization(false);
				 credit.setCompleted(false);
				 FundRepo.save(fund);
				 
	        }
			 //si credit avec différé
			 else if(credit.getDifféré()==true)
			 {   credit.setAmount(credit.getAmount()+(1+(credit.getCreditPeriod()*credit.getInterestRate())));
				 credit.setMonthlyPaymentAmount(Calcul_mensualite(credit));
				 //changement de la date de paiement prevue selon la periode du differe
				 
				 credit.setMonthlyPaymentDate(java.sql.Date.valueOf(Instant.ofEpochMilli(credit.getMonthlyPaymentDate().getTime())
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate().plusMonths((long) (credit.getCreditPeriod()*12))));
				 credit.setReason(msg);
				 credit.getClient().setCredit_authorization(false);
				 credit.setCompleted(false);
				 FundRepo.save(fund);
			 }
	     
		
		 }
		 else
		 {credit.setState(false);
		 credit.setCompleted(false);
		 credit.setReason("fond insuffisant");}
		
	}
	
	/************************************************************************************************************/
	
	//Fonction qui calcule les retards enregistré dans le history dues
	public int CaculateLateDays(Credit  cr) {
		
		 int _MS_PER_DAY = 1000 * 60 * 60 * 24;
		int S=0;
		
		List<DuesHistory> ListDH =DHrepo.getCredit_DuesHistory(cr.getIdCredit());
		for (DuesHistory DH : ListDH) {
			Date end=DH.getDateHistory();
			Date begin=DH.getSupposedDate();
			//difference entre deux dates en jours
			int diffInDays = (int)( (end.getTime() - begin.getTime()) 
	                 / (1000 * 60 * 60 * 24) );
			S=S+(diffInDays);
			
			
		}
		return S;
		
	}
	
/************************************************************************************************************/
	
	//Fonction qui calcule la mensualité
	public float Calcul_mensualite(Credit cr)
	{
		float montant=cr.getAmount();
		float tauxmensuel=cr.getInterestRate()/12;
	    float period=cr.getCreditPeriod()*12;
	    float mensualite=(float) ((montant*tauxmensuel)/(1-(Math.pow((1+tauxmensuel),-period ))));
		return mensualite;
	}
	
/************************************************************************************************************/
	//Fonction qui calcule le tabamortissement
	public Amortissement[] TabAmortissement(Credit cr)
	{   
		
			 
		double interest=cr.getInterestRate()/12;
        //System.out.println(interest);
        int leng=(int) (cr.getCreditPeriod()*12);
        
		Amortissement[] ListAmortissement =new Amortissement[leng];
		
		Amortissement amort=new Amortissement() ;
		//System.out.println(cr.getAmount());
		
		
		amort.setMontantR(cr.getAmount());
		amort.setMensualité(Calcul_mensualite(cr));
		amort.setInterest(amort.getMontantR()*interest);
		amort.setAmortissement(amort.getMensualité()-amort.getInterest());
		ListAmortissement[0]=amort;
		
		//System.out.println(ListAmortissement[0]);
		for (int i=1;i< cr.getCreditPeriod()*12;i++) {
			Amortissement amortPrecedant=ListAmortissement[i-1];
			Amortissement amortNEW=new Amortissement() ;
			amortNEW.setMontantR(amortPrecedant.getMontantR()-amortPrecedant.getAmortissement());
			amortNEW.setInterest(amortNEW.getMontantR()*interest);
			amortNEW.setMensualité(Calcul_mensualite(cr));
			amortNEW.setAmortissement(amortNEW.getMensualité()-amortNEW.getInterest());
			ListAmortissement[i]=amortNEW;
			
		}
		
		
		
		return ListAmortissement;
	}

	@Override
	public Credit updateCredit(Credit credit, Long Id_client, Long Id_fund, Long Id_pack ) {
		Client client= ClientRepo.findById(Id_client).orElse(null);
		Fund fund=FundRepo.findById(Id_fund).orElse(null);
		Pack pack=PackRepo.findById(Id_pack).orElse(null);
		 credit.setClient(client);
		 credit.setFunds(fund);
		 credit.setPack_credit(pack);
		 Crepo.save(credit);
        return credit;
		
	}

	@Override
	public Credit retrieveCredit(Long idCredit) {
		Credit credit= Crepo.findById(idCredit) .orElse(null) ; 
		return credit ;
	}
	
	@Override
	public void DeleteCredit(Long id) {
		Crepo.deleteById(id);
		}

	@Override
	public Credit ArchiveCredit(Long idCredit) {
		Credit credit= Crepo.findById(idCredit) .orElse(null) ; 
		credit.setState(false);
		Crepo.save(credit);
		return credit;
	}





	
   

}

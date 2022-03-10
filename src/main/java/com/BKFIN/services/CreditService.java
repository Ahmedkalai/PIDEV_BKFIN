package com.BKFIN.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BKFIN.entities.Client;
import com.BKFIN.entities.Credit;
import com.BKFIN.entities.DuesHistory;
import com.BKFIN.entities.Fund;
import com.BKFIN.entities.Pack;
import com.BKFIN.repositories.ClientRepository;
import com.BKFIN.repositories.CreditRepository;
import com.BKFIN.repositories.DuesHistoryRepository;
import com.BKFIN.repositories.FundRepository;
import com.BKFIN.repositories.PackRepository;




@Service
public class CreditService implements ICreditService {
    
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
	public Credit addCredit(Credit credit, Long Id_client, Long Id_fund, Long Id_pack) {
		Client client= ClientRepo.findById(Id_client).orElse(null);
		Fund fund=FundRepo.findById(Id_fund).orElse(null);
		Pack pack=PackRepo.findById(Id_pack).orElse(null);
		 credit.setClient(client);
		 credit.setFunds(fund);
		 credit.setPack_credit(pack);
		 
		 //tester si le client a deja des credits approuvés
		 if(Crepo.getApprovedCreditsByClient(Id_client).size()==0)//liste des credits approuvés =0 =>le client est nouveau 
		 {	 //tester sur le risk(client nouveau) 
			 //NB LE TAUX DE RISQUE 1%<R<2.5%
			 if(1.5*credit.getGarantor().getSalaryGarantor()>=credit.getAmount())
			 {	 
				//CALCUL RISK
				 credit.setRisk((float) (0.01+credit.getAmount()/credit.getGarantor().getSalaryGarantor()));
				 Acceptation(credit,fund,"NouveauClient avec garant certifié");
		     }
			 else
			 {credit.setState(false);
			 credit.setReason("Salaire garant insuffisant il doit etre egale à 0.33*montant du crédit");}
		  }
		 else//si le client a des credits approuvés
		 {
			 if(Crepo.getIncompletedCreditsByClient(Id_client).size()==0)//tester si les credits sont déja payés 
			 { //calcul jours de retard de la table dues history
				float Ratio_retard=CaculateLateDays(Crepo.getIDofLatestCompletedCreditsByClient(Id_client))/Crepo.getIDofLatestCompletedCreditsByClient(Id_client).getCreditPeriod()*30;
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
				    credit.setReason("Client trop Risqué MAuvais Historique");
				    client.setCredit_authorization(false);	//blackLIster le client
					}
			 }
			 else
			 {
				 credit.setState(false);
				 credit.setReason("présence de credit impayés"); 
			 } 
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
		 credit.setReason(msg);
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
		Date begin=cr.getMonthlyPaymentDate();
		
		List<DuesHistory> ListDH =DHrepo.getCredit_DuesHistory(cr.getIdCredit());
		for (DuesHistory DH : ListDH) {
			Date end=DH.getDateHistory();
			//difference entre deux dates en jours
			int diffInDays = (int)( (end.getTime() - begin.getTime()) 
	                 / (1000 * 60 * 60 * 24) );
			S=S+(diffInDays);
			
			
		}
		return S;
		
	}
	
	
	

	@Override
	public Credit updateCredit(Credit credit, Long Id_client, Long Id_fund, Long Id_pack) {
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

package com.BKFIN.batch;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.BKFIN.entities.Account;
import com.BKFIN.repositories.AccountRepository ;

@Component
public class DbWriter implements ItemWriter<Account> {
	
	@Autowired
	private AccountRepository AccountRepository;


   
	@Override
    public void write(List<? extends Account> Accounts) throws Exception{
        System.out.println("Data Saved for Accounts: " + Accounts);
        AccountRepository.saveAll(Accounts);
    }

}

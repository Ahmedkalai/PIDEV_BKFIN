package com.BKFIN.batch;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.BKFIN.entities.Account;
import com.BKFIN.entities.Typeaccount;
import com.BKFIN.entities.unemployedpopulation;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<unemployedpopulation, unemployedpopulation> {

    
    private static final Map<String, String> environment =
            new HashMap<>();
    
    public Processor() {
    	
                
    }

	@Override
	public unemployedpopulation process(unemployedpopulation item) throws Exception {
		return item;
	}
	

}

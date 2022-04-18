/*package com.BKFIN.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.BKFIN.entities.unemployedpopulation;
import com.BKFIN.repositories.UPopulationRepository;

@Component
public class DbWriterKhadija implements ItemWriter<unemployedpopulation> {

	

	@Autowired
	private UPopulationRepository uPopulationRepository;

	@Override
	public void write(List<? extends unemployedpopulation> unemployedpopulations) throws Exception {
		 System.out.println("Data Saved for unemployedpopulations : " + unemployedpopulations);
	     uPopulationRepository.saveAll(unemployedpopulations);
		
	}

}
*/
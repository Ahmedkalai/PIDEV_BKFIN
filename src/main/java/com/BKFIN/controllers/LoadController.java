package com.BKFIN.controllers;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/load")
public class LoadController {
	
	
	 
	    @Autowired
	    JobLauncher jobLauncher;	 
	 
	 
	    @Autowired
	    Job job;
	    
	    
	 // http://localhost:8083/BKFIN/load
	    @GetMapping
	    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {


	        Map<String, JobParameter> maps = new HashMap<>();
	        maps.put("time", new JobParameter(System.currentTimeMillis()));
	        JobParameters parameters = new JobParameters(maps);
	        JobExecution jobExecution = jobLauncher.run(job, parameters);

	        System.out.println("JobExecution: " + jobExecution.getStatus());

	        System.out.println("Batch is Running...");
	        while (jobExecution.isRunning()) {
	            System.out.println("...");
	        }

	        return jobExecution.getStatus();
	    }
}

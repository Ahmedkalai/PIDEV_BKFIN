package com.BKFIN.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.entities.Investesment;
import com.BKFIN.services.InvestesmentService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/Investesment")
public class InvestesmentController {
	@Autowired
	InvestesmentService investesmentService;

	
	// http://localhost:8083/BKFIN/Investesment/retrieve-all-investesments
			@GetMapping("/retrieve-all-investesments")
			@ResponseBody
			public List<Investesment> getInvestesment() {
			List<Investesment> listInvestesment = investesmentService.retrieveAllInvestesments();
			return listInvestesment;
			} 
			

			// http://localhost:8083/BKFIN/Investesment/retrieve-investesment/1
			@GetMapping("/retrieve-investesment/{investesment-id}")
			@ResponseBody
			public Investesment retrieveInvestesment(@PathVariable("investesment-id") Long investesmentId) {
			return investesmentService.retrieveInvestesment(investesmentId);
			}
			
			
			// http://localhost:8083/BKFIN/Investesment/add_investesment/1
			@PostMapping("/add_investesment/{Fund-id}")
			@ResponseBody
			public Investesment addInvestesment(@RequestBody Investesment i,@PathVariable("Fund-id") Long idFund)
			{
				System.out.println(idFund);
				Investesment investesment = investesmentService.addInvestesment(i,idFund);
			return investesment; 
			}
			
			// http://localhost:8083/BKFIN/Investesment/modify-investesment/1
						@PutMapping("/modify-investesment/{Fund-id}")
						@ResponseBody
						public Investesment modifyInvestesment(@RequestBody Investesment investesment,@PathVariable("Fund-id") Long idFund) {
						return investesmentService.updateInvestesment(investesment,idFund);}
			
			 //http://localhost:8083/BKFIN/Investesment/export
			@GetMapping("/export")
			public void exportToPDF(HttpServletResponse response) throws DocumentException,IOException {
				response.setContentType("application/pdf");
				DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
				String currentDateTime = dateFormater.format(new Date());
				String headerKey = "Content-Disposition"; 
				String headerValue = "Attachement;filename=inves_"+ currentDateTime + ".pdf";
				response.setHeader(headerKey, headerValue);
				List<Investesment> listInvestesment = investesmentService.retrieveAllInvestesments();
				investPDFExporter exporter = new investPDFExporter(listInvestesment);
				exporter.export(response);
			} 
			
			// http://localhost:8083/BKFIN/Investesment/CalculateAmoutOfInves/1
			@GetMapping("/CalculateAmoutOfInves/{Investesment-id}")
			@ResponseBody
						public float CalculateAmoutOfInves(@PathVariable("Investesment-id") Long idInvestesment) {
						return investesmentService.CalculateAmoutOfInves(idInvestesment);
						}
			
			// http://localhost:8083/BKFIN/Investesment/finalAmount
			@GetMapping("/finalAmount")
			@ResponseBody
						public void finalAmount() {
						investesmentService.finalAmount();
						}
						
			// http://localhost:8083/BKFIN/Investesment/CalculateRateOfInves/3/2
			@GetMapping("/CalculateRateOfInves/{Investesment-id}/{Fund-id}")
			@ResponseBody
						public float CalculateRateOfInves(@PathVariable("Investesment-id") Long idInvestesment,@PathVariable("Fund-id") Long idFund) {
						return investesmentService.CalculateRateOfInves(idInvestesment,idFund);
						}
			
						
}

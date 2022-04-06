package com.BKFIN.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BKFIN.services.EmailSenderService;
@RestController
public class SenderEmailController {
	
	@Autowired
	private EmailSenderService service;
	
	
	
	@GetMapping("/sendemail")
    

        public void sendmail() {
        service.sendSimpleEmail("bechir.jlidi@esprit.tn",
				"hello  ...",
        		"test"
				);
    }
	
	
	
	
	
	
	

}

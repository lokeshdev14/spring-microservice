package com.lokesh.mailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.mailsender.service.EmailService;



@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;
	@PostMapping("/sendemail")
	
	public String sendEmail(@RequestParam String to,
							@RequestParam String subject,
							@RequestParam String message) {
		return emailService.sendEmail(to,subject,message);
	}
	
	
}
package com.lokesh.currency.contoller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.currency.entity.CurrencyDetails;
import com.lokesh.currency.request.CurrencyRequest;
import com.lokesh.currency.service.CurrencyService;

@RestController
@RequestMapping("/api/v1")

public class CurrencyController {
	

	@Autowired
	CurrencyService currencyService;
	
	Logger logger=LoggerFactory.getLogger(CurrencyController.class);
	@Value("${my.custom.property}")
	private String customMessage;
	
	@PostMapping("/currency")
	public ResponseEntity<CurrencyDetails> currencyConversion(@RequestBody CurrencyRequest currencyRequest)
	{
		logger.info("This is Info log"+currencyRequest);
		logger.trace("This is Trace log Request is comming with input"+currencyRequest);
		
		CurrencyDetails currencyDetails=currencyService.currencyConversion(currencyRequest);
		logger.info("The transaction completed ");
		logger.warn("The stored information are"+currencyDetails);
		
		return ResponseEntity.status(HttpStatus.OK)
				             .header("info", "Conversion completed  " +customMessage)
				             .body(currencyDetails);
		
		
	
	}
	
}

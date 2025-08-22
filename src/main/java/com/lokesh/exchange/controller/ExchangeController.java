package com.lokesh.exchange.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.exchange.entity.CurrencyExchange;
import com.lokesh.exchange.repository.ExchangeRepository;
import com.lokesh.exchange.service.CurrencyExchangeService;


@RestController
@RequestMapping("/api/v1")
public class ExchangeController {

   
	
	@Autowired
	CurrencyExchangeService currencyExchangeService;
	
    @GetMapping("/from/{from}/to/{to}")
	public Double getCurrencyInfo(@PathVariable("from") String from,@PathVariable("to") String to)
	{
		double exchange=currencyExchangeService.getConversionRate(from,to);
		
		
			return exchange;
	}
}

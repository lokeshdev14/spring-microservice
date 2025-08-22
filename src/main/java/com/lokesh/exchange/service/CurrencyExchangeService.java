package com.lokesh.exchange.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lokesh.exchange.entity.CurrencyExchange;
import com.lokesh.exchange.repository.ExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	ExchangeRepository exchangeRepository;
	@Cacheable(value = "currency-exchange" ,key = "#from+'_'+#to")

	public Double getConversionRate(String from, String to) {
		
		System.out.println("DB/API caller exchange rule");
		Optional<CurrencyExchange> optional=exchangeRepository.findByFromCurrencyAndToCurrency(from, to);
	     if(optional.isPresent())
	     {
	    	 CurrencyExchange exchange=optional.get();
	    	 return exchange.getConversionRate();
	     }
	     else
	     {
	    	 return 0.0;
	     }
		
	}
	

}

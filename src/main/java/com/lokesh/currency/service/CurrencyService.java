package com.lokesh.currency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokesh.currency.entity.CurrencyDetails;
import com.lokesh.currency.feignclient.FeignClientCode;
import com.lokesh.currency.repository.CurrencyDetailsRepository;
import com.lokesh.currency.request.CurrencyRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CurrencyService {

	@Autowired
	CurrencyDetailsRepository currencyDetailsRepository;
    @Autowired
    FeignClientCode feignClientCode;
    @CircuitBreaker(name="currencyExchangeCB",fallbackMethod = "getFallBackDetails")
	public CurrencyDetails currencyConversion(CurrencyRequest currencyRequest) {
		
		double currencyRate=feignClientCode.retriveExchangeValue(currencyRequest.getFromCurrency(), currencyRequest.getToCurrency()).getBody();
		double totalAmount=currencyRequest.getQuantity()*currencyRate;
		
		CurrencyDetails currencyDetails=new CurrencyDetails();
		currencyDetails.setFromCurrency(currencyRequest.getFromCurrency());
		currencyDetails.setToCurrency(currencyRequest.getToCurrency());
		currencyDetails.setQuantity(currencyRequest.getQuantity());
		currencyDetails.setTotalAmount(totalAmount);
		currencyDetails.setCurrencyRate(currencyRate);
		
		
		
		return currencyDetailsRepository.save(currencyDetails);
	}
    
    public CurrencyDetails getFallBackDetails(CurrencyRequest currencyRequest ,Throwable t)
    {
//    	CurrencyDetails currencyDetails=new CurrencyDetails();
//		currencyDetails.setFromCurrency(currencyRequest.getFromCurrency());
//		currencyDetails.setToCurrency(currencyRequest.getToCurrency());
//		currencyDetails.setQuantity(currencyRequest.getQuantity());
//		currencyDetails.setTotalAmount(1.0);
//		currencyDetails.setCurrencyRate(1.0);
		
		 throw new RuntimeException("Server is slow,Please try after some time");
    	
    }
   
}

package com.lokesh.currency.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lokesh.currency.config.FeignConfig;
//import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "currency-exchange", configuration = FeignConfig.class)

public interface FeignClientCode {

	
	
	 @GetMapping("/api/v1/from/{from}/to/{to}")
		public ResponseEntity<Double> retriveExchangeValue(@PathVariable String from, @PathVariable String to);
		
}


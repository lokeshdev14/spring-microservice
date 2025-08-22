package com.lokesh.exchange.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lokesh.exchange.entity.CurrencyExchange;

@Repository
public interface ExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	Optional<CurrencyExchange> findByFromCurrencyAndToCurrency(String from, String to);

	
	


}

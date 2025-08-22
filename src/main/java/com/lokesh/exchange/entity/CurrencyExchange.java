package com.lokesh.exchange.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="currency_exchange")
public class CurrencyExchange {

	@Id
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private double conversionRate;
	
}

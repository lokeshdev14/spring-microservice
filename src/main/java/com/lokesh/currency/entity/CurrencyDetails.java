package com.lokesh.currency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDetails {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private int quantity;
	private double currencyRate;
	private double totalAmount;
	

}

package com.lokesh.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lokesh.currency.entity.CurrencyDetails;

@Repository
public interface CurrencyDetailsRepository extends JpaRepository<CurrencyDetails, Long>{

}

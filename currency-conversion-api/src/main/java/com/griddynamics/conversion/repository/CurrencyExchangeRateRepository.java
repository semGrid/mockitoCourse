package com.griddynamics.conversion.repository;

import com.griddynamics.conversion.entities.CurrencyConversionRate;
import com.griddynamics.conversion.entities.CurrencyId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRateRepository extends JpaRepository<CurrencyConversionRate, CurrencyId> {
}

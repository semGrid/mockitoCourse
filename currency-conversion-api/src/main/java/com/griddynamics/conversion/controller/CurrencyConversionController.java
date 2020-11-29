package com.griddynamics.conversion.controller;

import com.griddynamics.conversion.entities.CurrencyConversionRate;
import com.griddynamics.conversion.domain.CurrencyConversionRequest;
import com.griddynamics.conversion.services.CurrencyConversionService;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Collection;

@RestController
@RequestMapping(value = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyConversionController {

    private final static Logger LOGGER = Logger.getLogger(CurrencyConversionController.class);

    private final CurrencyConversionService service;

    public CurrencyConversionController(CurrencyConversionService service) {
        this.service = service;
    }

    @GetMapping(value = "/rates")
    private Collection<CurrencyConversionRate> rates() {
        LOGGER.info("Send GET all available currency rates");
        return service.getRates();
    }

    @PostMapping(value = "/convert")
    private BigDecimal convert(@Valid @RequestBody CurrencyConversionRequest exchangeMoney) {
        LOGGER.info("Send POST for currency conversion");
        return service.exchangeCurrency(exchangeMoney);
    }

}

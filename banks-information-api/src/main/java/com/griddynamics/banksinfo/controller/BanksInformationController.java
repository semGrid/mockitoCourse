package com.griddynamics.banksinfo.controller;

import com.griddynamics.banksinfo.domain.BankInformation;
import com.griddynamics.banksinfo.services.BanksInformationService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collection;

@RestController
@RequestMapping(value = "/banks", produces = MediaType.APPLICATION_JSON_VALUE)
public class BanksInformationController {

    private final BanksInformationService service;

    public BanksInformationController(BanksInformationService service) {
        this.service = service;
    }

    @GetMapping("/info")
    private Collection<BankInformation> getAllBanks() {
        return service.getAll();
    }

    @GetMapping("/currency/{bankCode}")
    private String getBankCurrency(@PathVariable String bankCode) {
        return service.getBankCurrency(bankCode.toUpperCase());
    }

    @GetMapping("/info/{bankCode}")
    private BankInformation getBankInfo(@PathVariable String bankCode) {
        return service.findByCode(bankCode.toUpperCase());
    }

    @GetMapping("/commission/{bankCode}")
    private BigDecimal getBankCommission(@PathVariable String bankCode) {
        return service.getBankCommission(bankCode.toUpperCase());
    }
}

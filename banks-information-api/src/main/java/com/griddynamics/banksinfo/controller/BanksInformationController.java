package com.griddynamics.banksinfo.controller;

import com.griddynamics.banksinfo.domain.BankInformation;
import com.griddynamics.banksinfo.services.BanksInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collection;

@RestController
@RequestMapping(value = "/banks", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "banksinfo", description = "Banks Information")
public class BanksInformationController {

    private final BanksInformationService service;

    public BanksInformationController(BanksInformationService service) {
        this.service = service;
    }

    @GetMapping("/info")
    @ApiOperation(value = "Get all banks list", response = BankInformation[].class)
    private Collection<BankInformation> getAllBanks() {
        return service.getAll();
    }

    @GetMapping("/currency/{bankCode}")
    @ApiOperation(value = "Get currency by bank code", response = String.class)
    private String getBankCurrency(
            @ApiParam(name = "bankCode", example = "HSBC", required = true)
            @PathVariable String bankCode) {
        return service.getBankCurrency(bankCode.toUpperCase());
    }

    @GetMapping("/info/{bankCode}")
    @ApiOperation(value = "Get information by bank code", response = String.class)
    private BankInformation getBankInfo(@ApiParam(name = "bankCode", example = "HSBC", required = true)
                                        @PathVariable String bankCode) {
        return service.findByCode(bankCode.toUpperCase());
    }

    @GetMapping("/commission/{bankCode}")
    @ApiOperation(value = "Get commission percentage by bank code", response = BigDecimal.class)
    private BigDecimal getBankCommission(@ApiParam(name = "bankCode", example = "HSBC", required = true)
                                         @PathVariable String bankCode) {
        return service.getBankCommission(bankCode.toUpperCase());
    }
}

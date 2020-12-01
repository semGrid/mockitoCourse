package com.griddynamics.transfer.controllers;

import com.google.common.collect.ImmutableMap;
import com.griddynamics.transfer.domain.TransferTransaction;
import com.griddynamics.transfer.domain.TransferredMoneyResponse;
import com.griddynamics.transfer.domain.exchange.CurrencyPairRate;
import com.griddynamics.transfer.services.MoneyTransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping(value = "/money", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "moneytransfer", description = "Perform money transactions")
public class MoneyTransferController {

    private final MoneyTransferService service;
    private final RestTemplate restTemplate;

    @Value("${banks.information.service.url}")
    private String bankInfoApiUrl;

    @Value("${currency.conversion.service.url}")
    private String currencyConversionApiUrl;

    public MoneyTransferController(MoneyTransferService service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/transactions")
    @ApiOperation(value = "Get all performed transactions", response = TransferTransaction[].class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = TransferTransaction[].class)
    })
    private Collection<TransferTransaction> getAllTransactions() {
        return service.getTransferTransactions();
    }

    @PostMapping("/transfer")
    @ApiOperation(value = "Transfer money to client bank account", response = TransferredMoneyResponse.class)
    private TransferredMoneyResponse sendMoney(@RequestBody TransferTransaction transaction) {
        final String bankCurrency = getBankCurrency(transaction.getBankOfRecipient());
        final BigDecimal commissionPercentage = getBankCommissionPercentage(transaction.getBankOfRecipient());

        final BigDecimal convertedAmount = convertAmount(new CurrencyPairRate()
                .setAmount(transaction.getTransactionAmount())
                .setFromCurrency(transaction.getTransactionCurrency())
                .setToCurrency(bankCurrency));

        final TransferredMoneyResponse response = service
                .calculateReceivedAmount(convertedAmount, commissionPercentage, bankCurrency);

        service.saveTransaction(transaction);
        return response;
    }

    private String getBankCurrency(final String bankCode) {
        final Map<String, String> bankCodeParam = ImmutableMap.of("bankCode", bankCode);
        final String currencyEndpoint = bankInfoApiUrl + "banks/currency/{bankCode}";

        return restTemplate.getForEntity(currencyEndpoint, String.class, bankCodeParam)
                .getBody();
    }

    private BigDecimal getBankCommissionPercentage(final String bankCode) {
        final Map<String, String> bankCodeParam = ImmutableMap.of("bankCode", bankCode);
        final String commissionEndpoint = bankInfoApiUrl + "banks/commission/{bankCode}";

        return restTemplate.getForEntity(commissionEndpoint, BigDecimal.class, bankCodeParam)
                .getBody();
    }

    private BigDecimal convertAmount(final CurrencyPairRate currencyPairRate) {
        final String exchangeEndpoint = currencyConversionApiUrl + "currency/convert";

        return restTemplate.postForEntity(exchangeEndpoint, currencyPairRate, BigDecimal.class)
                .getBody();
    }
}

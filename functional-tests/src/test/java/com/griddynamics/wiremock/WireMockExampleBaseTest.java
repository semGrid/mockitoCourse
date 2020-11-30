package com.griddynamics.wiremock;

import com.griddynamics.banksinfo.BanksInformationApplication;
import com.griddynamics.conversion.CurrencyConversionApplication;
import com.griddynamics.transfer.MoneyTransferApplication;
import com.griddynamics.transfer.domain.TransferTransaction;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class WireMockExampleBaseTest {

    @BeforeClass(alwaysRun = true)
    public void servicesStart() throws IOException {
        final SpringApplication currencyExchange = new SpringApplication(CurrencyConversionApplication.class);
        final Properties currencyExchangeProps = new Properties();
        currencyExchangeProps.setProperty("server.port", "8081");
        currencyExchange.setEnvironment(createTestEnvironment(currencyExchangeProps));
        currencyExchange.run();

        final SpringApplication banksInfo = new SpringApplication(BanksInformationApplication.class);
        final Properties bansInfoProps = new Properties();
        bansInfoProps.setProperty("server.port", "8082");
        banksInfo.setEnvironment(createTestEnvironment(bansInfoProps));
        banksInfo.run();


        final SpringApplication moneyTransfer = new SpringApplication(MoneyTransferApplication.class);
        final Properties moneyTransferProps = new Properties();
        moneyTransferProps.setProperty("server.port", "8083");
        moneyTransferProps.setProperty("currency.conversion.service.url", "http://localhost:8081/");
        moneyTransferProps.setProperty("banks.information.service.url", "http://localhost:8082/");
        moneyTransfer.setEnvironment(createTestEnvironment(moneyTransferProps));
        moneyTransfer.run();
    }


    @Test
    private void moneyTransferRequestStatusValidation() {
        given().baseUri("http://localhost:8083/")
                .contentType(ContentType.JSON)
                .when()
                .body(new TransferTransaction()
                        .setBankOfRecipient("CB")
                        .setTransactionAmount(new BigDecimal("100"))
                        .setTransactionCurrency("EUR"))
                .post("money/transfer")
                .then()
        .statusCode(HttpStatus.SC_OK);
    }

    private ConfigurableEnvironment createTestEnvironment(final Properties properties) throws IOException {
        final ConfigurableEnvironment env = new StandardEnvironment();
        env.getPropertySources().addLast(new ResourcePropertySource("classpath:application-test.properties"));
        env.getPropertySources().addLast(new PropertiesPropertySource("serviceProps", properties));
        return env;
    }
}

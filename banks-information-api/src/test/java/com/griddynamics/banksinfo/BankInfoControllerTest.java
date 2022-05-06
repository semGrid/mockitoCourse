package com.griddynamics.banksinfo;

import com.griddynamics.banksinfo.domain.BankInformation;
import com.griddynamics.banksinfo.repositories.BanksInformationRepository;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BankInfoControllerTest extends BankInformationBaseTest {

    /* TODO: Mockito assignment: implement tests for GET banks/commission/{bankCode} and
       GET banks/currency/{bankCode} using BanksInformationRepository mock
    */

    @MockBean
    private BanksInformationRepository repository;

    @Test
    public void verifyBankCurrencyCode(){
        Mockito.when(repository.findById("YN"))
                .thenReturn(Optional.of(new BankInformation()
                        .setCurrency("YEN")));

        Response response = given().baseUri("http://localhost:" + appPort)
                .log().all()
                .when()
                .get("/banks/currency/YN");

        assertThat(response.asString()).isEqualTo("YEN");
    }

    @Test
    public void verifyBankCommissionForCurrencyCode(){
        Mockito.when(repository.findById("YN"))
                .thenReturn(Optional.of(new BankInformation()
                        .setCommissionPercentage(new BigDecimal(10))));

        Response response = given().baseUri("http://localhost:" + appPort)
                .log().all()
                .when()
                .get("/banks/commission/YN");

        assertThat(response.asString()).isEqualTo("10");
    }
    
}

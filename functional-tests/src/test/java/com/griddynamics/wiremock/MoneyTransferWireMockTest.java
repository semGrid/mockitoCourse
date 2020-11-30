package com.griddynamics.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.griddynamics.transfer.domain.TransferTransaction;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTransferWireMockTest extends WireMockExampleBaseTest {

    @Test
    private void moneyTransferAmountValidation() {
        final BigDecimal transactionAmount = new BigDecimal("100.0");

        createAllStubs(transactionAmount);

        Response response = given().baseUri("http://localhost:8083/")
                .contentType(ContentType.JSON)
                .when()
                .body(new TransferTransaction()
                        .setBankOfRecipient("CB")
                        .setTransactionAmount(transactionAmount)
                        .setTransactionCurrency("EUR"))
                .post("money/transfer");

        BigDecimal sentAmount = response.jsonPath()
                .getObject("recipient.total", BigDecimal.class);

        assertThat(sentAmount)
                .isEqualTo(transactionAmount);
    }

    private void createAllStubs(final BigDecimal transactionAmount) {
        //TODO: assignment: add required stubs

        wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/currency/convert"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(transactionAmount.toString())));
    }
}

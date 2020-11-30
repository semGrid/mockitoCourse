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
    private void moneyTransferRequestStatusValidation() {
        final BigDecimal transactionAmount = new BigDecimal("100.0");

        wireMockServer.stubFor(WireMock.post(WireMock.urlEqualTo("/currency/convert"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(transactionAmount.toString())));

        Response response = given().baseUri("http://localhost:8083/")
                .contentType(ContentType.JSON)
                .when()
                .body(new TransferTransaction()
                        .setBankOfRecipient("CB")
                        .setTransactionAmount(transactionAmount)
                        .setTransactionCurrency("EUR"))
                .post("money/transfer");

        BigDecimal sentAmountPlusCommission = response.jsonPath()
                .getObject("recipient.total", BigDecimal.class).add(
                        response.jsonPath()
                                .getObject("recipient.commission", BigDecimal.class));

        assertThat(sentAmountPlusCommission)
                .isEqualTo(transactionAmount);
    }
}

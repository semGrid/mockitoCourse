package com.griddynamics.conversion;

import com.griddynamics.conversion.domain.CurrencyConversionRequest;
import com.griddynamics.conversion.entities.CurrencyConversionRate;
import com.griddynamics.conversion.entities.CurrencyId;
import com.griddynamics.conversion.repository.CurrencyExchangeRateRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyConversionTest extends CurrencyConversionBaseTest {

    @MockBean
    private CurrencyExchangeRateRepository repository;

    @Test
    void getRatesShouldReturnAllAvailableCurrencyRates() {
        final CurrencyId id = new CurrencyId("USD", "EUR");
        final List<CurrencyConversionRate> allRates = Collections.singletonList(rate(id));

        Mockito.when(repository.findAll())
                .thenReturn(allRates);

        Response response = given().baseUri("http://localhost:" + appPort)
                .when()
                .get("currency/rates");

        assertThat(response.as(allRates.getClass()))
                .hasSize(1);
    }

    @Test
    void currencyShouldBeConvertedUsingCurrencyPairRate() {
        final CurrencyId id = new CurrencyId("USD", "EUR");

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.of(rate(id)));

        Response response = RestAssured.given()
                .baseUri("http://localhost:" + appPort)
                .contentType(ContentType.JSON)
                .when()
                .body(new CurrencyConversionRequest()
                        .setFromCurrency("USD")
                        .setToCurrency("EUR")
                        .setAmount(new BigDecimal("100")))
                .post("currency/convert");

        assertThat(response.as(BigDecimal.class))
                .isEqualTo(new BigDecimal("50.0"));
    }

    private CurrencyConversionRate rate(final CurrencyId id) {
        return new CurrencyConversionRate()
                .setCurrency(id)
                .setExchangeRate(new BigDecimal("0.5"));
    }
}

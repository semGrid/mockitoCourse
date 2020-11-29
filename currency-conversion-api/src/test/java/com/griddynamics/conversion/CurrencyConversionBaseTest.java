package com.griddynamics.conversion;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = CurrencyConversionApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrencyConversionBaseTest {

    @LocalServerPort
    protected int appPort;

}

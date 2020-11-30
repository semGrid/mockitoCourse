package com.griddynamics.banksinfo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = BanksInformationApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BankInformationBaseTest {

    @LocalServerPort
    protected int appPort;

    /* TODO: Mockito assignment: implement tests for GET banks/commission/{bankCode} and
       GET banks/currency/{bankCode} using BanksInformationRepository mock
    */
}

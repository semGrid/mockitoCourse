package com.griddynamics.banksinfo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = BanksInformationApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BankInformationBaseTest {

    @LocalServerPort
    protected int appPort;

}

package com.griddynamics.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.griddynamics.banksinfo.BanksInformationApplication;
import com.griddynamics.transfer.MoneyTransferApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

public class WireMockExampleBaseTest {

    protected WireMockServer wireMockServer;

    @BeforeSuite(alwaysRun = true)
    public void servicesStart() throws IOException {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8888));
        wireMockServer.start();

        final SpringApplication banksInfo = new SpringApplication(BanksInformationApplication.class);
        final Properties bansInfoProps = new Properties();
        bansInfoProps.setProperty("server.port", "8082");
        banksInfo.setEnvironment(createTestEnvironment(bansInfoProps));
        banksInfo.run();


        final SpringApplication moneyTransfer = new SpringApplication(MoneyTransferApplication.class);
        final Properties moneyTransferProps = new Properties();
        moneyTransferProps.setProperty("server.port", "8083");
        moneyTransferProps.setProperty("currency.conversion.service.url", "http://localhost:8888/");
        moneyTransferProps.setProperty("banks.information.service.url", "http://localhost:8082/");
        moneyTransfer.setEnvironment(createTestEnvironment(moneyTransferProps));
        moneyTransfer.run();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        wireMockServer.stop();
    }

    private ConfigurableEnvironment createTestEnvironment(final Properties properties) throws IOException {
        final ConfigurableEnvironment env = new StandardEnvironment();
        env.getPropertySources().addLast(new ResourcePropertySource("classpath:application-test.properties"));
        env.getPropertySources().addLast(new PropertiesPropertySource("serviceProps", properties));
        return env;
    }
}

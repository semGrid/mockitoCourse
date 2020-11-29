package com.griddynamics.banksinfo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SwaggerConfig.class)
public class BanksInformationServiceConfiguration {
}

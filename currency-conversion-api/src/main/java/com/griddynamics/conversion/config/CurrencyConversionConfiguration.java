package com.griddynamics.conversion.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SwaggerConfig.class)
public class CurrencyConversionConfiguration {
}

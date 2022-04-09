package ru.hh.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.school.HhApiClient.HhApiClient;

@Configuration
@Import({HhApiClient.class})
public class ApiClientConfig {
}

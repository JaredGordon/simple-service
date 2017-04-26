package io.pivotal.ecosystem.simple;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DefaultConfig {

    @Bean
    public WeatherRepository weatherRepository() {
        return createRepository("http://api.wunderground.com/api/5fcd1f692e126cca");
    }

    private WeatherRepository createRepository(String url) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder()).target(WeatherRepository.class, url);
    }
}
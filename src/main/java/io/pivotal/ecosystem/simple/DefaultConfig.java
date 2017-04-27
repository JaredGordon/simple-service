package io.pivotal.ecosystem.simple;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DefaultConfig {

    @Bean
    public Repo weatherRepository() {
        return createRepository("http://api.wunderground.com/api/" + key);
    }

    private Repo createRepository(String url) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder()).target(Repo.class, url);
    }

    @Value("${API_KEY}")
    private String key;
}
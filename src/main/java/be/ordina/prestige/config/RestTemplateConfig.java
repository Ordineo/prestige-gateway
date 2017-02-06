package be.ordina.prestige.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JoLe on 01/02/2017.
 */
@Configuration
public class RestTemplateConfig {

    @Value("${github.user}")
    private String user;

    @Value("${github.token}")
    private String accessToken;

    @Bean(name="basicAuthRestTemplate")
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.basicAuthorization(user, accessToken).build();
    }
}

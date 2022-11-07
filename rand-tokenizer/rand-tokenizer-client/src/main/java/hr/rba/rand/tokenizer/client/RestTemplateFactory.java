package hr.rba.rand.tokenizer.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateFactory {

    @Value("${rand.generator.url}")
    private String remoteURL;

    @Bean
    public RestTemplate build() {
        return new RestTemplateBuilder()
                .rootUri(remoteURL)
                .build();
    }
}

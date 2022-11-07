package hr.rba.rand.generator.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Configuration
public class RandomFactory {
    public enum SecurityLevel { WEAK, SECURE, STRONG }

    @Value("${rand.generator.security}")
    private SecurityLevel security;

    /**
     * Default constructor.
     */
    public RandomFactory() {
        // reflections
    }

    @Bean
    public Random build() throws NoSuchAlgorithmException {
        return switch (security) {
            case WEAK   -> new Random();
            case SECURE -> new SecureRandom();
            case STRONG -> SecureRandom.getInstanceStrong();
        };
    }
}

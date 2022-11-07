package hr.rba.rand.tokenizer.jobs;

import hr.rba.rand.tokenizer.service.ITokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static java.util.Objects.requireNonNull;

@Component
public class NewTokenTask implements Runnable {

    private final ITokenGenerator generator;

    @Autowired
    public NewTokenTask(ITokenGenerator generator) {
        this.generator = requireNonNull(generator);
    }

    @Scheduled(fixedRateString = "${rand.token.frequency}", timeUnit = TimeUnit.SECONDS)
    @Override
    public void run() {
        generator.newToken();
    }
}

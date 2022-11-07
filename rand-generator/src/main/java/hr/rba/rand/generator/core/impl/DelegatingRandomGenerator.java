package hr.rba.rand.generator.core.impl;

import hr.rba.rand.generator.core.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

import static java.util.Objects.requireNonNull;

@Service
public class DelegatingRandomGenerator implements RandomGenerator {
    private final Random delegate;

    @Autowired
    public DelegatingRandomGenerator(Random random) {
        delegate = requireNonNull(random);
    }

    @Override
    public int nextInt() {
        return delegate.nextInt();
    }
}

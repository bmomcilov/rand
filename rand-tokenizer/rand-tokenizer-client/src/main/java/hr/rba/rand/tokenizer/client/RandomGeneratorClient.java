package hr.rba.rand.tokenizer.client;

import hr.rba.rand.tokenizer.service.IRandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.requireNonNull;

@Service
public class RandomGeneratorClient implements IRandomGenerator {

    private static final String RANDOM_INT_PATH = "/random/int";

    private final RestTemplate restTemplate;

    @Autowired
    public RandomGeneratorClient(RestTemplate restTemplate) {
        this.restTemplate = requireNonNull(restTemplate);
    }

    @Override
    public int getInt() {
        ResponseEntity<Integer> entity = restTemplate.getForEntity(RANDOM_INT_PATH, Integer.class);
        HttpStatus statusCode = entity.getStatusCode();

        if (!statusCode.is2xxSuccessful()) {
            throw new RandomGeneratorException("Unexpected response code: " + statusCode.value());
        }

        Integer i = entity.getBody();
        if (i == null) {
            throw new RandomGeneratorException("Server returned 'null' for primitive type");
        }

        return i;
    }
}

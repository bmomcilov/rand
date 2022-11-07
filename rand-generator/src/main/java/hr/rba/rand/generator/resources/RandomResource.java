package hr.rba.rand.generator.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.random.RandomGenerator;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/random")
public class RandomResource {
    private final RandomGenerator generator;

    @Autowired
    public RandomResource(RandomGenerator generator) {
        this.generator = requireNonNull(generator);
    }

    @GetMapping(path = "/int", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getInt() {
        return ResponseEntity.ok(generator.nextInt());
    }

}

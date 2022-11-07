package hr.rba.rand.tokenizer.client;

public class RandomGeneratorException extends RuntimeException {

    public RandomGeneratorException(String message) {
        super(message);
    }

    public RandomGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }
}

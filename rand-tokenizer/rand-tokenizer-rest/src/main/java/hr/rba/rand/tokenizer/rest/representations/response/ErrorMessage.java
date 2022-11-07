package hr.rba.rand.tokenizer.rest.representations.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;
import org.springframework.lang.Nullable;

@JsonDeserialize(builder = ErrorMessage.Builder.class)
@Immutable
public interface ErrorMessage extends BaseResponse {
    class Builder extends ImmutableErrorMessage.Builder {}

    @Default
    default boolean success() { return false; }

    @Nullable
    Integer code();

    @Nullable
    String message();
}

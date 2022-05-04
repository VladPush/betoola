package com.code.ms.dto.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.lang.NonNull;

@JsonIgnoreProperties({"cause", "stackTrace", "suppressed", "localizedMessage"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public abstract class JsonExceptionResponse extends RuntimeException {
    private final int status;
    private final String type;

    protected JsonExceptionResponse(final int statusParam,
                                    @NonNull final String typeParam,
                                    @NonNull final String messageParam) {
        super(messageParam);
        this.status = statusParam;
        this.type = typeParam;
    }
}

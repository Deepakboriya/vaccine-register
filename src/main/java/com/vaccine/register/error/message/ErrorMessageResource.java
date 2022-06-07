package com.vaccine.register.error.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
public class ErrorMessageResource {

    @JsonProperty("error-code")
    String errorCode;

    @JsonProperty("error-message")
    String errorMessage;

}

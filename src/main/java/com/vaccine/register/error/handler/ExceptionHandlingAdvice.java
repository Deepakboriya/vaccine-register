package com.vaccine.register.error.handler;

import com.vaccine.register.error.PersonNotRegisteredException;
import com.vaccine.register.error.message.ErrorMessageListResource;
import com.vaccine.register.error.message.ErrorMessageResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Collections;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingAdvice {

    private static final HttpHeaders HTTP_HEADERS = genericErrorHeaders();

    @ExceptionHandler(PersonNotRegisteredException.class)
    public ResponseEntity<ErrorMessageListResource> handlePersonNotRegisteredException(PersonNotRegisteredException ex) {
        ErrorMessageResource errorMessage = ErrorMessageResource.builder()
                .errorCode("100-01")
                .errorMessage(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .headers(HTTP_HEADERS)
                .body(new ErrorMessageListResource(Collections.singletonList(errorMessage)));
    }

    private static HttpHeaders genericErrorHeaders() {
        var httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE);
        return httpHeaders;
    }
}

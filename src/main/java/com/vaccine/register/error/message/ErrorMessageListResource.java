package com.vaccine.register.error.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessageListResource {
    private List<ErrorMessageResource> errors;
}

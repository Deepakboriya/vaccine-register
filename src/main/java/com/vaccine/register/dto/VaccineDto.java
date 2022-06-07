package com.vaccine.register.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class VaccineDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    @JsonIgnore
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("expiryDate")
    private LocalDate expiryDate;

}

package com.vaccine.register.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class VaccinateDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    @NotEmpty
    @JsonIgnore
    @JsonProperty("vaccine")
    private VaccineDto vaccine;

    @NotEmpty
    @JsonProperty("person")
    private PersonDto person;

    @NotEmpty
    @JsonProperty("center")
    private CenterDto center;
}

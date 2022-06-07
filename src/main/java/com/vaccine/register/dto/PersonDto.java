package com.vaccine.register.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaccine.register.common.Gender;
import lombok.*;

import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class PersonDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    @JsonIgnore
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @Digits(integer = 150, fraction = 0, message = "Age should be number and no larger than 150")
    @JsonProperty("age")
    private Integer age;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("contact")
    private ContactDto contact;

    @JsonProperty("vaccinationDetails")
    private Set<VaccinationDetailDto> vaccinationDetails;

}

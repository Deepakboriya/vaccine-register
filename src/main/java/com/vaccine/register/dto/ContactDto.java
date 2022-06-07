package com.vaccine.register.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class ContactDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    @JsonIgnore
    @JsonProperty("id")
    private Long id;

    @NotEmpty
    @Size(min=10, max=10, message = "Mobile numbers should be 10 characters")
    @JsonProperty("mobileNumber")
    private Long mobileNumber;

    @Email
    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("residenceAddress")
    private String residenceAddress;
}

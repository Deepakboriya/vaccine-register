package com.vaccine.register.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Builder
public class CenterDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    @JsonIgnore
    @JsonProperty("id")
    private Long id;

    @NotEmpty
    @JsonProperty("name")
    private String name;

    @NotEmpty
    @JsonProperty("regionCode")
    private String regionCode;

    @JsonProperty("stateCode")
    private String stateCode;
}

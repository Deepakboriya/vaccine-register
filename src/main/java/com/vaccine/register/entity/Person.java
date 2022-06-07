package com.vaccine.register.entity;

import com.vaccine.register.common.Gender;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    private String name;

    private Integer age;

    private Gender gender;

    @OneToOne
    private Contact contact;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<VaccinationDetail> vaccinationDetails;

}

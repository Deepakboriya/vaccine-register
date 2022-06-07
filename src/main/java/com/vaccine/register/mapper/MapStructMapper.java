package com.vaccine.register.mapper;

import com.vaccine.register.dto.*;
import com.vaccine.register.entity.*;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    ContactDto contactToContactDto(Contact contact);

    Contact contactDtoToContact(ContactDto contactDto);

    VaccinationDetailDto vaccinationDetailToVaccinationDetailDto (VaccinationDetail vaccinationDetail);

    VaccinationDetail vaccinationDetailDtoToVaccinationDetail (VaccinationDetailDto vaccinationDetailDto);

    PersonDto personToPersonDto (Person person);

    Person personDtoToPerson (PersonDto personDto);

    List<Person> personDtoToPerson(List<PersonDto> personDto);

    List<PersonDto> personToPersonDto(List<Person> person);

    PersonSlimDto personToPersonSlimDto (Person person);

    Person personSlimDtoToPerson (PersonSlimDto personSlimDto);

    VaccineDto vaccineToVaccineDto (Vaccine vaccine);

    List<VaccineDto> vaccineToVaccineDto (List<Vaccine> vaccine);

    Vaccine vaccineDtoToVaccine (VaccineDto vaccineDto);

    Center centerDtoToCenter (CenterDto centerDto);

    CenterDto centerToCenterDto (Center center);

    List<CenterDto> centerToCenterDto (List<Center> center);

}

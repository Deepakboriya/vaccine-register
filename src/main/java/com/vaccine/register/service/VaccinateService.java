package com.vaccine.register.service;

import com.vaccine.register.dto.VaccinateDto;
import com.vaccine.register.entity.Person;
import com.vaccine.register.entity.VaccinationDetail;
import com.vaccine.register.error.PersonNotRegisteredException;
import com.vaccine.register.mapper.MapStructMapper;
import com.vaccine.register.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VaccinateService {

    private final PersonRepository personRepository;

    private final MapStructMapper mapStructMapper;

    public void vaccinate(VaccinateDto vaccinate) {
        Person incomingPerson = mapStructMapper.personDtoToPerson(vaccinate.getPerson());

        Person person = getPersonByMobileNumber(incomingPerson);

        if (person == null) {
            throw new PersonNotRegisteredException("Please register the person first !!!");
        }

        VaccinationDetail vaccinationDetail = new VaccinationDetail();
        vaccinationDetail.setVaccine(mapStructMapper.vaccineDtoToVaccine(vaccinate.getVaccine()));
        vaccinationDetail.setCenter(mapStructMapper.centerDtoToCenter(vaccinate.getCenter()));
        person.getVaccinationDetails().add(vaccinationDetail);

        personRepository.save(person);
    }

    private Person getPersonByMobileNumber(Person person) {
        return personRepository.findPersonByContactMobileNumber(person.getContact().getMobileNumber()).orElse(null);
    }
}

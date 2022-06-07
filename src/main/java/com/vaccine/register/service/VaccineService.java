package com.vaccine.register.service;

import com.vaccine.register.entity.Vaccine;
import com.vaccine.register.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VaccineService {

    private final VaccineRepository vaccineRepository;

    public List<Vaccine> getVaccines() {
        return vaccineRepository.findAll();
    }

    public Vaccine getVaccineById(Long id) {
        return vaccineRepository.findById(id).orElse(null);
    }

    public Vaccine saveVaccine(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    public List<Vaccine> saveVaccines(List<Vaccine> vaccines) {
        return vaccineRepository.saveAll(vaccines);
    }

    public void deleteVaccine(Long id) {
        vaccineRepository.deleteById(id);
    }
}

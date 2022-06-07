package com.vaccine.register.controller;

import com.vaccine.register.dto.VaccineDto;
import com.vaccine.register.mapper.MapStructMapper;
import com.vaccine.register.service.VaccineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
@Slf4j
public class VaccineController {

    private final VaccineService vaccineService;

    private final MapStructMapper mapStructMapper;

    @GetMapping("/vaccines")
    public List<VaccineDto> getVaccines() {
        return mapStructMapper.vaccineToVaccineDto(vaccineService.getVaccines());
    }

    @GetMapping("/vaccine/{id}")
    public VaccineDto getVaccine(@PathVariable Long id) {
        return mapStructMapper.vaccineToVaccineDto(vaccineService.getVaccineById(id));
    }

    @PostMapping("/vaccine")
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineDto saveVaccine(@RequestBody VaccineDto vaccine) {
        return mapStructMapper.vaccineToVaccineDto(
                vaccineService.saveVaccine(mapStructMapper.vaccineDtoToVaccine(vaccine)));
    }

    @DeleteMapping("/vaccine/{id}")
    public void deleteVaccine(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
    }
}

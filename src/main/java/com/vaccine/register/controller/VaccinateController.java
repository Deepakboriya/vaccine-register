package com.vaccine.register.controller;

import com.vaccine.register.dto.VaccinateDto;
import com.vaccine.register.service.VaccinateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class VaccinateController {

    private final VaccinateService vaccinateService;

    @PostMapping("/vaccinate")
    public void vaccinate(@RequestBody VaccinateDto vaccinate) {
        vaccinateService.vaccinate(vaccinate);
        log.info("vaccinate body {}", vaccinate);
    }
}

package com.vaccine.register.service;

import com.vaccine.register.entity.Center;
import com.vaccine.register.repository.CenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CenterService {

    private final CenterRepository centerRepository;

    public List<Center> getCenters() {
        return centerRepository.findAll();
    }

    public Center getCenter(Long id) {
        return centerRepository.findById(id).orElse(null);
    }

    public Center saveCenter(Center center) {
        return centerRepository.save(center);
    }

    public void deleteCenter(Long id) {
        centerRepository.deleteById(id);
    }
}

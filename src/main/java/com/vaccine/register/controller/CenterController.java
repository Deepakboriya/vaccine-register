package com.vaccine.register.controller;

import com.vaccine.register.dto.CenterDto;
import com.vaccine.register.mapper.MapStructMapper;
import com.vaccine.register.service.CenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CenterController {

    private final CenterService centerService;

    private final MapStructMapper mapStructMapper;

    @GetMapping("/centers")
    public List<CenterDto> getCenters() {
        return mapStructMapper.centerToCenterDto(centerService.getCenters());
    }

    @GetMapping("/center/{id}")
    public CenterDto getCenter(@PathVariable Long id) {
        return mapStructMapper.centerToCenterDto(centerService.getCenter(id));
    }

    @PostMapping("/center")
    @ResponseStatus(HttpStatus.CREATED)
    public CenterDto saveCenter(@RequestBody CenterDto center) {
        return mapStructMapper.centerToCenterDto(
                centerService.saveCenter(mapStructMapper.centerDtoToCenter(center)));
    }

    @DeleteMapping("center/{id}")
    public void deleteCenter(@PathVariable Long id){
        centerService.deleteCenter(id);
    }
}

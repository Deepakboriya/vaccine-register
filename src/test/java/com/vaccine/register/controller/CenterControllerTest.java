package com.vaccine.register.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaccine.register.dto.CenterDto;
import com.vaccine.register.entity.Center;
import com.vaccine.register.mapper.MapStructMapper;
import com.vaccine.register.service.CenterService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.*;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CenterController.class)
@ActiveProfiles("test")
class CenterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CenterController centerController;

    @MockBean
    private CenterService centerService;

    @MockBean
    private MapStructMapper mapStructMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void getCenters() {
        // given
        CenterDto centerDto = CenterDto.builder()
                .id(1L)
                .name("Government Hospital")
                .regionCode("1")
                .stateCode("1")
                .build();
        // when
        when(centerController.getCenters()).thenReturn(List.of(centerDto));
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/centers")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is("Government Hospital")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].regionCode", is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].stateCode", is("1")));
    }

    @Test
    @SneakyThrows
    void getCenter() {
        // given
        CenterDto centerDto = CenterDto.builder()
                .id(2L)
                .name("Government Hospital 2")
                .regionCode("2")
                .stateCode("2")
                .build();
        // when
        when(centerController.getCenter(2L)).thenReturn(centerDto);
        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/center/{id}", 2)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("Government Hospital 2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.regionCode", is("2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.stateCode", is("2")));
    }

    @Test
    @SneakyThrows
    void saveCenter() {
        // given
        CenterDto centerDto = CenterDto.builder()
                .id(3L)
                .name("Government Hospital 3")
                .regionCode("3")
                .stateCode("3")
                .build();
        // when
        Center center = mapStructMapper.centerDtoToCenter(centerDto);
        when(centerService.saveCenter(center)).thenReturn(center);
        // then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/center")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(centerDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void deleteCenter() {
        doNothing().when(centerService).deleteCenter(4L);
        // then
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/center/{id}", 4)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
package ru.stanislave.astoncourse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.stanislave.astoncourse.controllers.EmployeeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController employeeController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void getEmployeeByIdOk() throws Exception {
        mockMvc.perform(get("/employee/{id}", 7))
                .andExpect(status().isOk());
    }

    @Test
    public void getEmployeeNotFound() throws Exception {
        mockMvc.perform(get("/employee/{id}", 0))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllEmployeeOk() throws Exception {
        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk());
    }
}
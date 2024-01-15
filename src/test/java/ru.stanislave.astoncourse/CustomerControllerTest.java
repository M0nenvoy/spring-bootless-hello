package ru.stanislave.astoncourse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.stanislave.astoncourse.controllers.CustomerController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @InjectMocks
    private CustomerController customerController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void getCustomerByIdOk() throws Exception {
        String id = "1";
        mockMvc.perform(get("/customer/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    public void getCustomerNotFound() throws Exception {
        mockMvc.perform(get("/customer/{id}", 0))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllCustomersOk() throws Exception {
        mockMvc.perform(get("/customer"))
                .andExpect(status().isOk());
    }
}

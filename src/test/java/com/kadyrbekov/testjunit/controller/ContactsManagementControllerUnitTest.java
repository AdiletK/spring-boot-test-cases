package com.kadyrbekov.testjunit.controller;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kadyrbekov.testjunit.domain.CustomerContact;
import com.kadyrbekov.testjunit.service.ContactsManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ContactsManagementController.class)
class ContactsManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactsManagementService service;
    @InjectMocks
    private ContactsManagementController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processAddContactSubmit() throws Exception {
        CustomerContact mockContact = new CustomerContact();
        mockContact.setFirstName("Jenny");
        mockContact.setLastName("Johnson");

        Mockito.when(service.add(Mockito.any(CustomerContact.class)))
                .thenReturn(mockContact);

        CustomerContact contact = new CustomerContact();
        contact.setFirstName("Jenny");

        mockMvc
                .perform(
                        post("/addContact")
                                .content(new ObjectMapper().writeValueAsString(contact))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    void findAll() {
    }
}
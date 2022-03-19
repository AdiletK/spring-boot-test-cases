package com.kadyrbekov.testjunit.controller;

import com.kadyrbekov.testjunit.domain.CustomerContact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactsManagementControllerIntegrationTest {

    @Autowired
    private ContactsManagementController controller;

    @Test
    void processSuccessCaseAddContact() {
        CustomerContact contact = new CustomerContact();
        contact.setFirstName("Jenny");
        contact.setLastName("Johnson");

        String result = controller.processAddContactSubmit(contact);

        Assertions.assertEquals(result, "success");
    }
    @Test
    void processFailCaseAddContact() {
        CustomerContact contact = new CustomerContact();
        contact.setLastName("Johnson");

        String result = controller.processAddContactSubmit(contact);

        Assertions.assertEquals(result, "failure");
    }

    @Test
    void findAll() {
    }
}
package com.kadyrbekov.testjunit.service;

import com.kadyrbekov.testjunit.domain.CustomerContact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ContactsManagementServiceIntegrationTest {

    @Autowired
    private ContactsManagementService service;

    @Test
    void add() {
        CustomerContact contact = new CustomerContact();
        contact.setFirstName("Test");
        contact.setLastName("Testov");

        CustomerContact added = service.add(contact);

        assertNotNull(added);
        assertNotNull(added.getId());

        assertEquals(contact.getFirstName(), added.getFirstName());
    }

    @Test
    void findAll() {
    }
}
package com.kadyrbekov.testjunit.service;

import com.kadyrbekov.testjunit.data.repos.CustomerContactRepository;
import com.kadyrbekov.testjunit.domain.CustomerContact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ContactsManagementServiceUnitTest {
    @Mock
    private CustomerContactRepository repository;

    @InjectMocks
    private ContactsManagementService service;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void add() {
        CustomerContact mockContact = new CustomerContact();
        mockContact.setFirstName("Jenny");
        mockContact.setLastName("Johnson");

        when(repository.save(any(CustomerContact.class))).thenReturn(mockContact);

        CustomerContact added = service.add(mockContact);

        verify(repository, times(1)).save(mockContact);
        Assertions.assertEquals(mockContact.getFirstName(), added.getFirstName());
    }

    @Test
    void findAll() {
    }
}
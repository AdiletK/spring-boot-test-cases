package com.kadyrbekov.testjunit.data.repos;

import com.kadyrbekov.testjunit.domain.CustomerContact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerContactRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager manager;

    @Autowired
    private CustomerContactRepository repository;

    @Test
    public void testFindByEmail(){
        String email = "adi@epam.com";
        CustomerContact contact = new CustomerContact();
        contact.setEmail(email);
        manager.persist(contact);

        CustomerContact byEmail = repository.findByEmail(email);

        System.out.println(byEmail.getId());
        Assertions.assertEquals(byEmail.getEmail(), email);
    }

}
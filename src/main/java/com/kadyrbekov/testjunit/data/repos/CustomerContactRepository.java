package com.kadyrbekov.testjunit.data.repos;

import com.kadyrbekov.testjunit.domain.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {
	CustomerContact findByEmail(String email);
}

package com.kadyrbekov.testjunit.service;

import com.kadyrbekov.testjunit.data.repos.CustomerContactRepository;
import com.kadyrbekov.testjunit.domain.CustomerContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactsManagementService {

	@Autowired
	private CustomerContactRepository repository;
	
	public CustomerContact add(CustomerContact aContact) {
		CustomerContact newContact = null;
		if (aContact.getFirstName() != null) {
			newContact =  repository.save(aContact);
		}
		return newContact;	
	}

	public List<CustomerContact> findAll() {
		return repository.findAll();
	}
	
	/*
	public CustomerContact addContactOccasion(CustomerContact aContact, ContactImportantOccasion anOccasion) {
		CustomerContact newContact = null;
		
		return newContact;	
	}
	*/
}

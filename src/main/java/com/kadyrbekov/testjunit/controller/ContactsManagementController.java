package com.kadyrbekov.testjunit.controller;

import com.kadyrbekov.testjunit.domain.CustomerContact;
import com.kadyrbekov.testjunit.service.ContactsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/addContact")
public class ContactsManagementController {

	@Autowired
	private ContactsManagementService contactsManagementService;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String processAddContactSubmit(@RequestBody CustomerContact aContact) {
		
		CustomerContact newContact = contactsManagementService.add(aContact);
		
		if (newContact != null) {
			return "success";
		}
		
		return "failure";
	}

	@GetMapping
	public List<CustomerContact> findAll(){
		return contactsManagementService.findAll();
	}
}

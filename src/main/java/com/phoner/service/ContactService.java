package com.phoner.service;

import java.util.List;

import com.phoner.entity.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Long id);
	
	public boolean deleteContact(Long id);
	
}

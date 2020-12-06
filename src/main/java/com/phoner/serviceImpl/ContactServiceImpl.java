package com.phoner.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoner.entity.Contact;
import com.phoner.repo.ContactRepository;
import com.phoner.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		try {
			contactRepository.save(contact);			
		} catch(Exception ex)
		{			
			ex.printStackTrace();
			return false;
		}		
		return true;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findByIsActive(true);
	}

	@Override
	public Contact getContactById(Long id) {
		Optional<Contact> optional = contactRepository.findById(id);
		if(optional.isPresent())
			return optional.get();		
		return null;
	}

	@Override
	public boolean deleteContact(Long id) {
		Contact contact = getContactById(id);
		try {
			contact.setActive(false);
			contactRepository.save(contact);
			return true;
		} catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}	
	}

}

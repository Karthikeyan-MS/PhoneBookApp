package com.phoner.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phoner.constants.PhoneBookConstants;
import com.phoner.entity.Contact;
import com.phoner.props.PhoneBookProperties;
import com.phoner.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private PhoneBookProperties phnBookProps;
	
	@Autowired
	private ContactService contactService;
	
	private Map<String,String> messages = null;
	
	@ModelAttribute
	public void initializer()
	{
		messages = phnBookProps.getMessages();
	}
	
	@GetMapping(value="/createContact")
	public String createContact(Contact contact,Model model)
	{
	
		model.addAttribute(PhoneBookConstants.HEADING, messages.get(PhoneBookConstants.SAVE_HEADING));		
		return "createContact";
	}
	
	@PostMapping(value="/saveContact")
	public String saveContact(Contact contact,Model model,RedirectAttributes redirectAttr)
	{		
		boolean isUpdate = false;
		System.out.println("Contact id is " + contact.getId());
		if(contact.getId() == null)
		{	
			model.addAttribute(PhoneBookConstants.HEADING, messages.get(PhoneBookConstants.SAVE_HEADING));
		}
		else
		{
			isUpdate = true;
			model.addAttribute(PhoneBookConstants.HEADING, messages.get(PhoneBookConstants.UPDATE_HEADING));
		}
		contact.setActive(true);
		boolean isContactSaved = contactService.saveContact(contact);		
		if(isContactSaved)	
			if(isUpdate)
			{
				redirectAttr.addFlashAttribute(PhoneBookConstants.SUCCESS_MSG, messages.get(PhoneBookConstants.UPDATE_SUCCESS));					
			}
			else
				redirectAttr.addFlashAttribute(PhoneBookConstants.SUCCESS_MSG,  messages.get(PhoneBookConstants.SAVE_SUCCESS));
		else
			if(isUpdate)
				model.addAttribute(PhoneBookConstants.FAILURE_MSG,messages.get(PhoneBookConstants.UPDATE_FAILURE));			
			else
				model.addAttribute(PhoneBookConstants.FAILURE_MSG,messages.get(PhoneBookConstants.SAVE_FAILURE));							
		return "redirect:/createContact";
	}
	
	
	@GetMapping(value="/showContacts")
	public String showContacts(Model model)
	{
		List<Contact> contactList =  contactService.getAllContacts();		
		model.addAttribute("contactList", contactList);
		return "showContacts";
	}
	
	@GetMapping(value="/updateContact")
	public String updateContact(@RequestParam(value="id") Long id,Model model)
	{		
		model.addAttribute(PhoneBookConstants.HEADING, messages.get(PhoneBookConstants.UPDATE_HEADING));
		Contact contact = null;
		if(id != null)
			contact = contactService.getContactById(id);		
		model.addAttribute("contact",contact);
		return "createContact";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("id") Long id)
	{		
		if(id != null)
			contactService.deleteContact(id);		
		return "redirect:/showContacts";		
	}
}

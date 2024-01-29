package com.kalyan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.entity.Contact;
import com.kalyan.exception.NoContactFoundException;
import com.kalyan.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	// insert record into table
	public boolean insertContactetails(Contact contact) {
		Contact contacDetails = contactRepository.save(contact);
		return contacDetails.getCid() != null ? true : false;

	}

	// get Contact Details
	public List<Contact> getContactDetails() throws NoContactFoundException {
		List<Contact> getContactDetails = contactRepository.findAll();
		if (getContactDetails.isEmpty())
			throw new NoContactFoundException("No record is found::");
		return getContactDetails;

	}

	// get contact details by id
	public Contact getContactDetailsById(Integer contactid) {

		Optional<Contact> getContact = contactRepository.findById(contactid);
		if (!getContact.isEmpty())
			return getContact.get();
		else
			throw new NoContactFoundException("No record is found::");

	}

	// Delete Contact Details by Id
	public String deleteContactDetailsById(Integer contactid) {
		Contact contactDetailsById = getContactDetailsById(contactid);
		if (contactDetailsById != null) {
			contactRepository.delete(contactDetailsById);
			return "Contact Details Deleted";
		} else
			throw new NoContactFoundException("No record is found::");

	}

	// Update Contact Details
	public String updateContactDetailsById(Contact contact) {
		String updateSucess = null;
		Contact contactDetailsById = getContactDetailsById(contact.getCid());
		if (contactDetailsById != null) {
			boolean insertContact = insertContactetails(contact);
			if (insertContact) {
				updateSucess = "Given Contact Details is Updated Sucessfully:" + contact.getCid();
			} else
				throw new NoContactFoundException("No record is found::");
		}
		return updateSucess;

	}

}

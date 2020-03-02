package com.moo.api.addressbookapi.service;

import com.moo.api.addressbookapi.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private final List<Contact> contactsList = new ArrayList<>();
	private final AtomicLong identityService = new AtomicLong();

    public ContactService() {
        this.addContact(new Contact("Thomas", "Anderson", 33, "1 Road Plaza, Buffalo, NY 12654, USA"));
        this.addContact(new Contact("Andrea", "Coulter", 44, "189 Fernboro Street, Rochester, NY 14618, USA"));
        this.addContact(new Contact("Azimbek", "Aliyev", 52, "45 Temple Apartments, Knoxville, KY 35665, USA"));
        this.addContact(new Contact("Shaxrizoda", "Munisa", 19, "10 Lomb Memorial Drive, Toledo, OH 73655, USA"));
        this.addContact(new Contact("James", "Anderson", 58, "10 Lomb Memorial Drive, Toledo, OH 73655, USA"));
        this.addContact(new Contact("Susan", "Anderson", 34, "10 Lomb Memorial Drive, Toledo, OH 73655, USA"));
        this.addContact(new Contact("Cathy", "Coulter", 37, "189 Fernboro Street, Rochester, NY 14618, USA"));
    }

    public Contact addContact(Contact contact) {
        contact.setId(identityService.incrementAndGet());
        contactsList.add(contact);
        return contact;
    }

    public Contact retrieveContact(final Long contactId) {
        Optional<Contact> contactToBeRetrieved = contactsList.stream().filter(contact -> contact.getId().equals(contactId)).findFirst();
        if (contactToBeRetrieved.isPresent()) {
            return contactToBeRetrieved.get();
        } else {
            throw new RuntimeException("The given contact does not exist!");
        }
    }

    public List<Long> searchContacts(final String lastName) {
        return contactsList.stream().filter(contact -> contact.getLastName().equalsIgnoreCase(lastName)).map(Contact::getId).collect(Collectors.toList());
    }
}

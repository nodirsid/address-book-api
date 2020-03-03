package com.moo.api.addressbookapi.service;

import com.moo.api.addressbookapi.model.Contact;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ContactServiceTest {

    private ContactService contactService;

    @Before
    public void init() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact newContactOne = contactService.addContact(createNewContact());
        Contact newContactTwo = createNewContact();
        Assert.assertTrue(newContactOne.equals(newContactTwo));
    }

    @Test
    public void testNegativeRetrieveContact() {
        Contact newContact = createNewContact();
        contactService.addContact(newContact);
        try {
            contactService.retrieveContact(1000L);
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals("The given contact does not exist!"));
        }
    }
    
    @Test
    public void testPositiveRetrieveContact() {
        Contact newContact = createNewContact();
        contactService.addContact(newContact);
        Assert.assertTrue(newContact.equals(contactService.retrieveContact(newContact.getId())));
    }

    private Contact createNewContact() {
        return new Contact("Thomas", "Anderson", 33, "1 Road Plaza, Buffalo, NY 12654, USA");
    }
}

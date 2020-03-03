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
    
    @Test
    public void testPositiveSearchContact() {
        Contact newContact = createNewContact();
        contactService.addContact(newContact);
        List<Long> foundContactIds = contactService.searchContacts("Anderson");
        System.out.println(foundContactIds);
        Assert.assertTrue(foundContactIds.containsAll(Arrays.asList(1L, 5L, 6L, 8L)));
        Assert.assertTrue(Arrays.asList(1L, 5L, 6L, 8L).containsAll(foundContactIds));
    }
    
    @Test
    public void testNegativeSearchContact() {
        Contact newContact = createNewContact();
        contactService.addContact(newContact);
        List<Long> foundContactIds = contactService.searchContacts("Oracle");
        System.out.println(foundContactIds);
        Assert.assertTrue(foundContactIds.containsAll(Arrays.asList()));
        Assert.assertTrue(Arrays.asList().containsAll(foundContactIds));
    }

    private Contact createNewContact() {
        return new Contact("Thomas", "Anderson", 33, "1 Road Plaza, Buffalo, NY 12654, USA");
    }
}

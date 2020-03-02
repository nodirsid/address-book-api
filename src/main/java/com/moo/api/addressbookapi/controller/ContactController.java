package com.moo.api.addressbookapi.controller;

import com.moo.api.addressbookapi.model.Contact;
import com.moo.api.addressbookapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/api/v1/contacts/search")
    public List<Long> searchContact(@RequestParam(value = "lastName") String lastName) {
        return contactService.searchContacts(lastName);
    }

    @GetMapping("/api/v1/contacts/get")
    public Contact retrieveContact(@RequestParam(value = "id") Long id) {
        return contactService.retrieveContact(id);
    }
}

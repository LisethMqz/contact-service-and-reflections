package com.grandstrandsystems;

import java.util.*;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        Objects.requireNonNull(contact, "contact cannot be null");
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate contact ID: " + id);
        }
        contacts.put(id, contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found: " + contactId);
        }
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        get(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        get(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        get(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        get(contactId).setAddress(address);
    }

    public Contact get(String contactId) {
        Contact c = contacts.get(contactId);
        if (c == null) throw new IllegalArgumentException("Contact not found: " + contactId);
        return c;
    }

    public int size() { return contacts.size(); }
}

package com.grandstrandsystems;

import java.util.Objects;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateId(contactId);
        this.contactId = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    private static void validateId(String id) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be non-null and <= 10 chars.");
        }
    }

    private static void requireNonNullLen(String value, int max, String field) {
        if (value == null || value.length() > max) {
            throw new IllegalArgumentException(field + " must be non-null and <= " + max + " chars.");
        }
    }

    private static void validatePhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits.");
        }
    }

    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public void setFirstName(String firstName) { requireNonNullLen(firstName, 10, "First name"); this.firstName = firstName; }
    public void setLastName(String lastName) { requireNonNullLen(lastName, 10, "Last name"); this.lastName = lastName; }
    public void setPhone(String phone) { validatePhone(phone); this.phone = phone; }
    public void setAddress(String address) { requireNonNullLen(address, 30, "Address"); this.address = address; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return contactId.equals(contact.contactId);
    }

    @Override public int hashCode() { return Objects.hash(contactId); }
}

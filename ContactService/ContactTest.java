package com.grandstrandsystems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void validContactConstructs() {
        Contact c = new Contact("ID123", "Ana", "Lopez", "1234567890", "123 Main St, Unit 2");
        assertEquals("ID123", c.getContactId());
        assertEquals("Ana", c.getFirstName());
        assertEquals("Lopez", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main St, Unit 2", c.getAddress());
    }

    @Test
    void idMustBeNonNullAndMax10() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "A", "B", "1234567890", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "A", "B", "1234567890", "addr"));
    }

    @Test
    void firstNameLastNameAddressConstraints() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", null, "B", "1234567890", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", "AAAAAAAAAAA", "B", "1234567890", "addr")); // >10

        assertThrows(IllegalArgumentException.class, () -> new Contact("ID2", "A", null, "1234567890", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID2", "A", "BBBBBBBBBBB", "1234567890", "addr"));

        String longAddr = "1234567890123456789012345678901"; // 31 chars
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID3", "A", "B", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID3", "A", "B", "1234567890", longAddr));
    }

    @Test
    void phoneMustBeExactly10Digits() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", "A", "B", null, "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", "A", "B", "123456789", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", "A", "B", "12345678901", "addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", "A", "B", "12345abcde", "addr"));
    }

    @Test
    void settersValidateAndUpdate() {
        Contact c = new Contact("ID", "Ana", "Lopez", "1234567890", "addr");
        c.setFirstName("Maria");
        c.setLastName("Perez");
        c.setPhone("0987654321");
        c.setAddress("New Address");
        assertEquals("Maria", c.getFirstName());
        assertEquals("Perez", c.getLastName());
        assertEquals("0987654321", c.getPhone());
        assertEquals("New Address", c.getAddress());

        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("WayTooLongName"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("1234567890123456789012345678901"));
    }
}

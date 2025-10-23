package com.grandstrandsystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setup() {
        service = new ContactService();
        service.addContact(new Contact("C1", "Ana", "Lopez", "1111111111", "Addr1"));
        service.addContact(new Contact("C2", "Ben", "Diaz", "2222222222", "Addr2"));
    }

    @Test
    void addRejectsDuplicateId() {
        assertThrows(IllegalArgumentException.class, () ->
            service.addContact(new Contact("C1", "X", "Y", "3333333333", "Addr3")));
    }

    @Test
    void deleteByIdRemoves() {
        assertEquals(2, service.size());
        service.deleteContact("C1");
        assertEquals(1, service.size());
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("NOPE"));
    }

    @Test
    void updatesWorkAndValidate() {
        service.updateFirstName("C1", "Eva");
        service.updateLastName("C1", "Lee");
        service.updatePhone("C1", "9999999999");
        service.updateAddress("C1", "NewAddr");
        Contact c = service.get("C1");
        assertEquals("Eva", c.getFirstName());
        assertEquals("Lee", c.getLastName());
        assertEquals("9999999999", c.getPhone());
        assertEquals("NewAddr", c.getAddress());

        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("C1", "bad"));
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("NOPE", "X"));
    }
}

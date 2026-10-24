package contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    void setUpContactService() {
        contactService = new ContactService();
        contactService.addContact(new Contact("1234567", "Jane", "Doe", "779A Jackson Street", "090078601"));
    }

    @Test
    void updateFirstNameTest() {
        contactService.updateFirstName("1234567", "Jade");
        assertEquals("Jade", contactService.getContact("1234567").getFirstName());
    }

    @Test
    void addContactFailsTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(new Contact("1234567", "Test", "Bain", "779A Jackson Street", "090078601"));
        });
    }

    @Test
    void deleteContactSucceedsTest() {
        assertTrue(contactService.deleteContact("1234567"));
        assertNull(contactService.getContact("1234567"));
    }

    @Test
    void updateAddressTest() {
        contactService.updateAddress("1234567", "new Address");
        assertEquals("new Address", contactService.getContact("1234567").getAddress());
    }
}
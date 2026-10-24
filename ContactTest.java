package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
    private Contact contact;

    @BeforeEach
    void resetContact() {
        // Initialize with valid placeholder values for testing setters
        contact = new Contact("12345", "Jane", "Doe", "123 Main St", "1234567890");
    }

    @Test
    void testContactConstructorSuccess() {
        Contact validContact = new Contact("1874509872", "Jade", "Bain", "address", "764590697");
        assertEquals("1874509872", validContact.getContactID());
        assertEquals("address", validContact.getAddress());
        assertEquals("Jade", validContact.getFirstName());
    }

    @Test
    void testContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1874509872987", "Jade", "Bain", "address", "764590697");
        });
    }
    
    @Test
    void testContactIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Jade", "Bain", "address", "764590697");
        });
    }

    @Test
    void testSetPhoneNumInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNum("98675638758392085");
        });
    }

    @Test
    void testSetAddressInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("3dfbsbahfhbyjgbbfsiufhiyyosjfsjfknv");
        });
    }

    @Test
    void testSetFirstNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("uojsgbshabduahgfhggd:g:");
        });
    }

    @Test
    void testSetLastNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("bfshdhadahdahfj:sflnfshb;jkfsj:hb");
        });
    }
}
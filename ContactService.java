package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private final ArrayList<Contact> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
    }

    // This will return a copy to protect the internal array list
    public List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

    public Contact getContact(String id) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equalsIgnoreCase(id)) {
                return contact;
            }
        }
        return null;
    }

    public void addContact(Contact c) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equalsIgnoreCase(c.getContactID())) {
                throw new IllegalArgumentException("Contact ID already exists.");
            }
        }
        contacts.add(c);
    }

    public boolean deleteContact(String id) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equalsIgnoreCase(id)) {
                contacts.remove(contact);
                return true;
            }
        }
        throw new IllegalArgumentException("Contact ID was not found.");
    }

    public boolean updateFirstName(String id, String newFirstName) {
        Contact contact = getContact(id);
        if (contact != null) {
            contact.setFirstName(newFirstName);
            return true;
        }
        throw new IllegalArgumentException("Contact ID was not found.");
    }

    public boolean updateLastName(String id, String newLastName) {
        Contact contact = getContact(id);
        if (contact != null) {
            contact.setLastName(newLastName);
            return true;
        }
        throw new IllegalArgumentException("Contact ID was not found.");
    }

    public boolean updateAddress(String id, String newAddress) {
        Contact contact = getContact(id);
        if (contact != null) {
            contact.setAddress(newAddress);
            return true;
        }
        throw new IllegalArgumentException("Contact ID was not found.");
    }

    public boolean updateNumber(String id, String newNumber) {
        Contact contact = getContact(id);
        if (contact != null) {
            contact.setPhoneNum(newNumber);
            return true;
        }
        throw new IllegalArgumentException("Contact ID was not found.");
    }
}
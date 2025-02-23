package org.example;

public class Contact {

    private final String name;
    private final String phone;
    private final String email;
    private final String group;

    public Contact(String name, String phone, String email, String group) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;
        return phone.equals(contact.phone) && email.equals(contact.email);
    }

    @Override
    public int hashCode() {
        int result = phone.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'';
    }
}

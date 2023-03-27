package whatsapp.model;

import whatsapp.enums.Status;

import java.util.ArrayList;
import java.util.Map;

public class User {
    private int id;
    private String firstName;
    private String LastName;
    private long phoneNumber;
    private String password;
    private String image;
    private Status status;
    private Map<String,String> messages;
    private ArrayList<User> users;

    public User() {
    }

    public User(int id, String firstName, String lastName, long phoneNumber, String password, String image, Status status, Map<String, String> messages, ArrayList<User> users) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.image = image;
        this.status = status;
        this.messages = messages;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public Status getStatus() {
        return status;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User{" +
                "\nid=" + id +
                "\nfirstName :" + firstName +
                "\n LastName :" + LastName +
                "\n phoneNumber :" + phoneNumber +
                "\n password :" + password +
                "\n image  :" + image +
                "\n status  :" + status +
                "\n contacts :"+users+
                "\n messages :" + messages +
                '}';
    }
}

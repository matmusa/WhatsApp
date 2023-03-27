package whatsapp.model;

import whatsapp.model.User;

import java.util.ArrayList;

public class Group {
  private   ArrayList<User> users = new ArrayList<>();

    public Group() {
    }

    public Group(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "\nGroup{" +
                "\nusers=" + users +
                '}';
    }
}

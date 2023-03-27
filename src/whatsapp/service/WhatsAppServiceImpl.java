package whatsapp.service;

import whatsapp.enums.Status;
import whatsapp.exceptons.MyException;
import whatsapp.model.Group;
import whatsapp.model.User;

import java.util.*;

public class WhatsAppServiceImpl implements WhatsAppService {

    @Override
    public User installWhatsApp(Group groups) {

        User user = new User();
        try {
            System.out.println("Enter first name: ");
            String name = new Scanner(System.in).nextLine();
            user.setFirstName(name);
            for (User user1 : groups.getUsers()) {
                if (user1.getFirstName().equals(name)) {
                    throw new MyException("User with the same name already exists");
                }
            }

            System.out.println("Enter last name: ");
            String lastName = new Scanner(System.in).nextLine();
            user.setLastName(lastName);
            System.out.println("Enter the password");
            String password = new Scanner(System.in).nextLine();
            if (password.length() < 7) {
                throw new MyException("Password length must be at least 7 characters");
            } else {
                user.setPassword(password);
            }
            System.out.println("Enter the phone number");
            long phoneNumber = new Scanner(System.in).nextLong();
            String s = Long.toString(phoneNumber);
            if (!s.startsWith("+996") && !s.startsWith("0") && s.length() > 10) {
                throw new MyException("Phone number must start with +996 or 0 and be 10 digits long.");
            } else {
                user.setPhoneNumber(phoneNumber);
            }

            user.setStatus(Status.HI_I_USE_A_WHATSAPP);
            user.setImage("DEFAULT_IMAGE");
            user.setMessages(new HashMap<>());
            user.setId(groups.getUsers().size() + 1);
            user.setUsers(new ArrayList<>());
            groups.getUsers().add(user);
            return user;

        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    @Override
    public User goToprofile(Group groups) {
        ArrayList<User> arrayList = new ArrayList<>();
        boolean isTrue = true;
        System.out.println("Enter first name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter the password");
        String password = new Scanner(System.in).nextLine();

        try {
            for (User p : groups.getUsers()) {
                if (p.getFirstName().equals(name) && p.getPassword().equals(password)) {
                    arrayList.add(p);
                } else {
                    isTrue = false;
                }

            }

            if (!arrayList.isEmpty()) {
                for (User p : groups.getUsers()) {
                    for (User o : arrayList
                    ) {
                        if (p.getFirstName().equals(o.getFirstName())) {
                            return o;
                        }
                    }
                }
            }
            if (!isTrue) {

                throw new MyException("Uncorrect password or password ");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());

        }
        return null;

    }

    @Override
    public void getAllWhatsAppStatus(Group groups) {

        System.out.println(Arrays.toString(Status.values()));
    }


    @Override
    public String changeProfileOfPhoto(Group groups) {
        boolean isTrue = true;
        ArrayList<User> arrayList = new ArrayList<>();
        System.out.println("Enter first name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter the password");
        String password = new Scanner(System.in).nextLine();

        try {
            for (User p : groups.getUsers()) {
                if (p.getFirstName().equals(name) && p.getPassword().equals(password)) {
                    arrayList.add(p);

                } else {
                    isTrue = false;
                }

            }
            System.out.println("set image in here :");
            String image = new Scanner(System.in).nextLine();
            if (!arrayList.isEmpty()) {
                for (User p : groups.getUsers()) {
                    for (User o : arrayList
                    ) {
                        if (p.getFirstName().equals(o.getFirstName())) {
                            o.setImage(image);
                            return o.toString();
                        }
                    }

                }

            }


            if (!isTrue) {

                throw new MyException("Uncorrect name  or password ");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    @Override
    public User changeProfileStatus(Group groups) {
        ArrayList<User> arrayList = new ArrayList<>();
        boolean isTrue = true;
        System.out.println("Enter first name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter the password");
        String password = new Scanner(System.in).nextLine();

        try {
            for (User p : groups.getUsers()) {
                if (p.getFirstName().equals(name) && p.getPassword().equals(password)) {
                    arrayList.add(p);


                } else {
                    isTrue = false;
                }
            }
            if (!arrayList.isEmpty()) {
                for (User p : groups.getUsers()) {
                    for (User o : arrayList
                    ) {
                        if (p.getFirstName().equals(o.getFirstName())) {

                        }
                        System.out.println("Choose a status  :" +
                                "\n1" + Status.valueOf(Status.HI_I_USE_A_WHATSAPP.toString()) +
                                "\n2" + Status.valueOf(Status.AT_HOME.toString()) +
                                "\n3" + Status.valueOf(Status.AT_WORK.toString()) +
                                "\n4" + Status.valueOf(Status.BUSY.toString()));
                        int image = new Scanner(System.in).nextInt();
                        switch (image) {
                            case 1 -> o.setStatus(Status.valueOf(Status.HI_I_USE_A_WHATSAPP.toString()));
                            case 2 -> o.setStatus(Status.valueOf(Status.AT_HOME.toString()));
                            case 3 -> o.setStatus(Status.valueOf(Status.AT_WORK.toString()));
                            case 4 -> o.setStatus(Status.valueOf(Status.BUSY.toString()));
                        }
                        return o;
                    }
                }
            }
            if (!isTrue) {

                throw new MyException("Uncorrect name  or password ");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }


    @Override
    public void addContact(Group groups) {


        ArrayList<User> arrayList = new ArrayList<>();
        boolean isTrue = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Enter the phone number of the contact you want to add: ");
        long phoneNumber = new Scanner(System.in).nextLong();
        ;
        try {
            for (User p : groups.getUsers()) {
                if (p.getFirstName().equals(firstName) && p.getPassword().equals(password)) {
                    for (User u : groups.getUsers()
                    ) {
                        if (u.getPhoneNumber() == phoneNumber) {
                            arrayList.add(u);
                            break;
                        } else {
                            isTrue = false;
                        }
                    }
                } else {
                    isTrue = false;
                }

                if (!arrayList.isEmpty()) {
                    for (User l : groups.getUsers()) {
                        for (User o : arrayList
                        ) {

                            if (p.getFirstName().equals(firstName) && p.getPassword().equals(password)) {
                                for (User u : groups.getUsers()
                                ) {
                                    if (u.getPhoneNumber() == o.getPhoneNumber()) {
                                    }
                                }
                                p.getUsers().add(o);
                                o.getUsers().add(p);
                                System.out.println(o + "seccesfully added to your contact!");
                            }
                        }
                    }
                }
            }

        if (!isTrue) {

            throw new MyException("Uncorrect name or password ");
        }
        if (!isTrue) {
            throw new MyException("Uncorrect contact number!");
        }

    } catch(
    MyException e)

    {
        System.out.println(e.getMessage());

    }


}


    @Override
    public void sendMessage(Group groups) {

        Map<String, String> stringStringMap = new HashMap<>();
        boolean isTrue = true;
        System.out.println("Enter first name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter the password");
        String password = new Scanner(System.in).nextLine();
        System.out.println("Write choose a one contact :");
        String contact = new Scanner(System.in).nextLine();
        try {
            for (User p : groups.getUsers()) {
                if (p.getFirstName().equals(name) && p.getPassword().equals(password)) {
                    for (User u : p.getUsers()
                    ) {
                        System.out.println(u.getFirstName());
                        for (User e : groups.getUsers()
                        ) {
                            if (e.getFirstName().equals(contact)) {
                                String message = new Scanner(System.in).nextLine();
                                stringStringMap.put(p.getFirstName(), message);
                                System.out.println("You want send a message (yes/no");
                                String question = new Scanner(System.in).nextLine();
                                if (question.equals("yes")) {
                                    e.getMessages().putAll(stringStringMap);
                                    p.getMessages().putAll(stringStringMap);
                                    System.out.println("your message succesfully sent !");
                                    break;
                                } else {
                                    System.out.println("Your message was not sent !!");
                                    isTrue = false;
                                }
                            } else {
                                isTrue = false;
                            }


                        }

                    }

                } else {
                }
                isTrue = false;


            }
            if (!isTrue) {

                throw new MyException("Uncorrect name or password ");
            }

            if (!isTrue) {
                throw new MyException("Uncorrect contact name !");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User deleteWhatsApp(Group group) {
        boolean isTrue = true;
        System.out.println("Enter first name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter the password");
        String password = new Scanner(System.in).nextLine();

        try {
            for (int i = 0; i < group.getUsers().size(); i++) {
                if (group.getUsers().get(i).getFirstName().equals(name) && group.getUsers().get(i).getPassword().equals(password)) {
                    group.getUsers().remove(group.getUsers().get(i));
                    System.out.println(group.getUsers().get(i).getFirstName() + "succsefully removed!!");
                } else {
                    isTrue = false;
                }

            }

            if (!isTrue) {

                throw new MyException("Uncorrect password or password ");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());

        }
        return null;

    }

}



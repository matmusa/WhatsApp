import whatsapp.model.Group;
import whatsapp.service.WhatsAppServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        WhatsAppServiceImpl whatsAppService = new WhatsAppServiceImpl();
        Group group = new Group();
        while (true) {

            try {
                System.out.println(" 1 -> Install whatsApp\n" +
                        " 2 -> Go to profile\n" +
                        " 3 -> Get all whatsApp status\n" +
                        " 4 -> Change profile photo\n" +
                        " 5 -> Change whatsApp status\n" +
                        " 6 ->Add contact\n" +
                        " 7->Send message\n" +
                        "8->delete whatsapp \n");
                int a = new Scanner(System.in).nextInt();
                switch (a) {
                    case 1 -> System.out.println(whatsAppService.installWhatsApp(group));
                    case 2 -> System.out.println(whatsAppService.goToprofile(group));
                    case 3 -> whatsAppService.getAllWhatsAppStatus(group);
                    case 4 -> System.out.println(whatsAppService.changeProfileOfPhoto(group));
                    case 5 -> System.out.println(whatsAppService.changeProfileStatus(group));
                    case 6 ->whatsAppService.addContact(group);
                    case 7 -> whatsAppService.sendMessage(group);
                    case 8 -> whatsAppService.deleteWhatsApp(group)
                    ;
                }

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
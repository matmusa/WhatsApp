package whatsapp.Dao;

import whatsapp.enums.Status;
import whatsapp.model.Group;
import whatsapp.model.User;

import java.util.ArrayList;
import java.util.List;

public interface WhatsappDao {

    User installWhatsApp(Group groups);

    User goToprofile(Group groups);

    void getAllWhatsAppStatus(Group groups);

    String changeProfileOfPhoto(Group groups);

    User changeProfileStatus(Group groups);

    void addContact(Group groups);

    void sendMessage(Group group);

    User deleteWhatsApp(Group group);
}

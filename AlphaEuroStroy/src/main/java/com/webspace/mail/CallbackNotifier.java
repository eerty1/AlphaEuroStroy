package com.webspace.mail;

import com.webspace.model.mail.Callback;
import com.webspace.rest_client.TgBotClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.Objects;

@ApplicationScoped
@Named("callbackNotifier")
public class CallbackNotifier extends Notifier<Callback> {

    public CallbackNotifier(MailService mailService, @Named("tgBotClient") TgBotClient tgBotClient) {
        super(mailService, tgBotClient);
    }

    @Override
    public String writeBody(Callback callback) {
        String name = !Objects.equals(callback.getPhoneNumber(), "") ? "Номер телефона : " + callback.getPhoneNumber() + " \n" : "";
        String phoneNumber = !Objects.equals(callback.getCommentary(), "") ? "Комментарий : " + callback.getCommentary() + " \n" : "";
        return String.format("Поступила заявка на обратную связь. \n%s" + "%s", name, phoneNumber);
    }
}

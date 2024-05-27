package com.webspace.mail;

import com.webspace.rest_client.TgBotClient;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@NoArgsConstructor
public abstract class Notifier<T> {
    protected MailService mailService;
    protected TgBotClient tgBotClient;
    @ConfigProperty(name = "telegram.chat-id")
    protected String chatId;

    public Notifier(MailService mailService, TgBotClient tgBotClient) {
        this.mailService = mailService;
        this.tgBotClient = tgBotClient;
    }


    protected abstract String writeBody(T input);

    public void sendNotification(T input) {
        String text = writeBody(input);
        tgBotClient.notifyTelegram(chatId, text);
        mailService.sendEmail(text);
    }
}

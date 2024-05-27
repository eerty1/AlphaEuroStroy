package com.webspace.mail;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MailService {
    @Inject
    protected Mailer mailer;
    @ConfigProperty(name = "mail.receiver")
    protected String receiver;

    public void sendEmail(String text) {
        mailer.send(
                Mail.withText(
                        receiver,
                        "Уведомление с AlphaEuroStroy",
                        text
                )
        );
    }
}

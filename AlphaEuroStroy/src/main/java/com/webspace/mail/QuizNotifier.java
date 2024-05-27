package com.webspace.mail;

import com.webspace.model.mail.Quiz;
import com.webspace.rest_client.TgBotClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("quizNotifier")
public class QuizNotifier extends Notifier<Quiz> {

    public QuizNotifier(MailService mailService, @Named("tgBotClient") TgBotClient tgBotClient) {
        super(mailService, tgBotClient);
    }

    @Override
    protected String writeBody(Quiz quiz) {
        StringBuilder body = new StringBuilder();
        quiz.getQuizAnswers().forEach(answer -> {
            body.append(answer);
            body.append("\n");
        });
        body.append(quiz.getPhoneNumber());
        return body.toString();
    }
}

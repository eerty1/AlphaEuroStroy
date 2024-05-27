package com.webspace.resource.user.mail;

import com.webspace.mail.CallbackNotifier;
import com.webspace.mail.QuizNotifier;
import com.webspace.model.mail.Callback;
import com.webspace.model.mail.Quiz;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;

@Path("/mail")
@PermitAll
@RequiredArgsConstructor
public class MailingResource {

    protected final CallbackNotifier callbackNotifier;
    protected final QuizNotifier quizNotifier;
    @POST
    @Path("/callback")
    public void sendCallbackNotification(Callback callback) {
        callbackNotifier.sendNotification(callback);
    }

    @POST
    @Path("/quiz")
    public void sendQuizNotification(Quiz quiz) {
        quizNotifier.sendNotification(quiz);
    }
}

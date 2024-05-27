package com.webspace.rest_client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient(configKey = "tg-bot-service")
@Named("tgBotClient")
public interface TgBotClient {
    @GET
    String notifyTelegram(@QueryParam("chat_id") String chatId, @QueryParam("text") String text);
}
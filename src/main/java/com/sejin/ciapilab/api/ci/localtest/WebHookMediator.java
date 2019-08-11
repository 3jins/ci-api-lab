package com.sejin.ciapilab.api.ci.localtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Profile("local")
@Component
public class WebHookMediator {
    private final WebHookMediatorConfig webHookMediatorConfig;
    private LocalWebHookController localWebHookController;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public WebHookMediator(WebHookMediatorConfig webHookMediatorConfig, LocalWebHookController localWebHookController) {
        this.webHookMediatorConfig = webHookMediatorConfig;
        this.localWebHookController = localWebHookController;
    }

    @Scheduled(fixedDelayString = "${webHookMediatorConfig.pollingPeriod}")
    public void checkIfWebHookIsFired() {
        String senderUrl = webHookMediatorConfig.getUrl() + webHookMediatorConfig.getSenderApi();
        String bodyUrl = webHookMediatorConfig.getUrl() + webHookMediatorConfig.getBodyApi();
        String sender = restTemplate.getForObject(senderUrl, String.class);

        try {
            if (sender.equals(webHookMediatorConfig.getGitHubSenderName())) {
                String webHookRaw = restTemplate.getForObject(bodyUrl, String.class);
                localWebHookController.handleGitHubWebHook(webHookRaw);
            } else if (sender.equals(webHookMediatorConfig.getTravisCiSenderName())) {
                String webHookRaw = restTemplate.getForObject(bodyUrl, String.class);
                localWebHookController.handleTravisCiWebHook(webHookRaw);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

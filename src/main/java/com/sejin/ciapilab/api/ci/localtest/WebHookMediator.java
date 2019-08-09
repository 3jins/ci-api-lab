package com.sejin.ciapilab.api.ci.localtest;

import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;
import com.sejin.ciapilab.api.ci.travisci.vo.TravisCiWebHook;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Profile("local")
@Controller
public class WebHookMediator {
    private final WebHookMediatorConfig webHookMediatorConfig;
    private RestTemplate restTemplate = new RestTemplate();

    public WebHookMediator(WebHookMediatorConfig webHookMediatorConfig) {
        this.webHookMediatorConfig = webHookMediatorConfig;
    }

    public Object checkIfWebHookIsFired() {
        String senderUrl = webHookMediatorConfig.getUrl() + webHookMediatorConfig.getSenderApi();
        String bodyUrl = webHookMediatorConfig.getUrl() + webHookMediatorConfig.getBodyApi();
        String sender = restTemplate.getForObject(senderUrl, String.class);

        if (sender == null) return null;
        if (sender.equals(webHookMediatorConfig.getGitHubSenderName())) {
            return restTemplate.getForObject(bodyUrl, GitHubWebHook.class);
        } else if (sender.equals(webHookMediatorConfig.getTravisCiSenderName())) {
            return restTemplate.getForObject(bodyUrl, TravisCiWebHook.class);
        }
        return null;
    }
}

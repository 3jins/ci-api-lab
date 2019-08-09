package com.sejin.ciapilab.api.ci.localtest;

import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;
import org.springframework.web.client.RestTemplate;

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

        if (sender.equals(webHookMediatorConfig.getGitHubSenderName())) {
            GitHubWebHook webHook = restTemplate.getForObject(bodyUrl, GitHubWebHook.class);
            return webHook;
        } else if (sender.equals(webHookMediatorConfig.getTravisCiSenderName())) {
            // >▽<
            return null;
        }

        return null;
    }
}

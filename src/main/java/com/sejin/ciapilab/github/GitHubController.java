package com.sejin.ciapilab.github;

import com.sejin.ciapilab.github.localtest.WebHookMediator;
import com.sejin.ciapilab.github.vo.GitHubWebHookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubController {
    private final WebHookMediator webHookMediator;

    private RestTemplate restTemplate = new RestTemplate();
    private GitHubService gitHubService = new GitHubService();

    @Autowired
    public GitHubController(WebHookMediator webHookMediator) {
        this.webHookMediator = webHookMediator;
    }

    // TODO: profile 설정할 것
    @Scheduled(fixedDelay = 1000)
    public void checkIfWebHookIsFired() {
        // HttpEntity<GitHubWebHookResponse> request = new HttpEntity<>(new GitHubWebhookResponse()); // post 요청시 필요
        GitHubWebHookResponse response = restTemplate.getForObject(webHookMediator.getUrl(), GitHubWebHookResponse.class);
        gitHubService.setGitHubWebhookResponse(response);
        System.out.println(gitHubService.getGitHubWebhookResponse().toString());
    }
}

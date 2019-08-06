package com.sejin.ciapilab.github;

import com.sejin.ciapilab.github.vo.GitHubWebHookResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class GitHubService {
    private GitHubWebHookResponse gitHubWebhookResponse = null;

    // WebhookMediatorService.checkIfWebhookIsFired를 주기적으로 호출해서 gitHubWebhookResponse를 업데이트해야 한다.

}

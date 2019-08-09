package com.sejin.ciapilab.api.ci.github;

import com.sejin.ciapilab.api.ci.CiApiLocalController;
import com.sejin.ciapilab.api.ci.localtest.WebHookMediator;
import com.sejin.ciapilab.api.ci.localtest.WebHookMediatorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Profile("local")
@Controller
public class GitHubApiLocalController implements CiApiLocalController {
    private WebHookMediator webHookMediator;

    @Autowired
    public GitHubApiLocalController(WebHookMediatorConfig webHookMediatorConfig) {
        webHookMediator = new WebHookMediator(webHookMediatorConfig);
    }

    @Override
    @Scheduled(fixedDelayString = "${webHookMediatorConfig.pollingPeriod}")
    public Object handleWebHook() {
        return webHookMediator.checkIfWebHookIsFired();
    }
}
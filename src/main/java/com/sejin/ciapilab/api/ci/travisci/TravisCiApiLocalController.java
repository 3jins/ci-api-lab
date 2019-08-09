package com.sejin.ciapilab.api.ci.travisci;

import com.sejin.ciapilab.api.ci.CiApiLocalController;
import com.sejin.ciapilab.api.ci.localtest.WebHookMediator;
import com.sejin.ciapilab.api.ci.localtest.WebHookMediatorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@Profile("local")
@RestController
public class TravisCiApiLocalController implements CiApiLocalController {
    private WebHookMediator webHookMediator;

    @Autowired
    public TravisCiApiLocalController(WebHookMediatorConfig webHookMediatorConfig) {
        webHookMediator = new WebHookMediator(webHookMediatorConfig);
    }

    @Override
    @Scheduled(fixedDelayString = "${webHookMediatorConfig.pollingPeriod}")
    public Object handleWebHook() {
        return webHookMediator.checkIfWebHookIsFired();
    }
}

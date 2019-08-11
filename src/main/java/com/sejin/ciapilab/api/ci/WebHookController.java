package com.sejin.ciapilab.api.ci;

import com.sejin.ciapilab.api.BodyParser;
import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;
import com.sejin.ciapilab.api.ci.travisci.vo.TravisCiWebHook;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Profile("prod")
@RestController
@RequestMapping("/webhookhandler")
public class WebHookController {

    @PostMapping("/github")
    @WebHookPostProcess(apiName = CiApi.GITHUB)
    public GitHubWebHook handleGitHubWebHook(@RequestBody GitHubWebHook webHook) {
        return webHook;
    }

    @PostMapping("/travisci")
    @WebHookPostProcess(apiName = CiApi.TRAVISCI)
    public TravisCiWebHook handleTravisCiWebHook(@RequestBody String webHook) throws IOException {
        return (new BodyParser()).parseUrlEncoded(webHook, TravisCiWebHook.class);
    }
}

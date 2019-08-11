package com.sejin.ciapilab.api.ci.localtest;

import com.sejin.ciapilab.api.BodyParser;
import com.sejin.ciapilab.api.ci.CiApi;
import com.sejin.ciapilab.api.ci.WebHookPostProcess;
import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;
import com.sejin.ciapilab.api.ci.travisci.vo.TravisCiWebHook;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
@Profile("local")
public class LocalWebHookController {
    @WebHookPostProcess(apiName = CiApi.GITHUB)
    public GitHubWebHook handleGitHubWebHook(String webHookRaw) throws IOException {
        return (new BodyParser()).parseJson(webHookRaw, GitHubWebHook.class);
    }

    @WebHookPostProcess(apiName = CiApi.TRAVISCI)
    public TravisCiWebHook handleTravisCiWebHook(String webHookRaw) throws IOException {
        return (new BodyParser()).parseUrlEncoded(webHookRaw, TravisCiWebHook.class);
    }
}

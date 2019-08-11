package com.sejin.ciapilab.api.ci.localtest;

import com.sejin.ciapilab.api.BodyParser;
import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;
import com.sejin.ciapilab.api.ci.travisci.vo.TravisCiWebHook;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
@Profile("local")
public class LocalWebHookController {
    public GitHubWebHook handleGitHubWebHook(String webHookRaw) throws IOException {
        System.out.println("handleGitHubWebHook is called");
        return (new BodyParser()).parseJson(webHookRaw, GitHubWebHook.class);
    }

    public TravisCiWebHook handleTravisCiWebHook(String webHookRaw) throws IOException {
        return (new BodyParser()).parseUrlEncoded(webHookRaw, TravisCiWebHook.class);
    }
}

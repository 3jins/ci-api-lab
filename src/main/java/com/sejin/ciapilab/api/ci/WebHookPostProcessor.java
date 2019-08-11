package com.sejin.ciapilab.api.ci;

import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;
import com.sejin.ciapilab.api.ci.travisci.vo.TravisCiWebHook;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebHookPostProcessor {
    private void postProcessGitHubWebHook(GitHubWebHook gitHubWebHook) {
        System.out.println(gitHubWebHook.toString());
    }

    private void postProcessTravisCiWebHook(TravisCiWebHook travisCiWebHook) {
        System.out.println(travisCiWebHook.toString());
    }

    @AfterReturning(pointcut = "@annotation(webHookPostProcess)", returning = "webHook")
    public void postProcess(Object webHook, WebHookPostProcess webHookPostProcess) {
        switch(webHookPostProcess.apiName()) {
            case GITHUB:
                postProcessGitHubWebHook((GitHubWebHook) webHook);
                break;
            case TRAVISCI:
                postProcessTravisCiWebHook((TravisCiWebHook) webHook);
                break;
            default:
                // TODO: Write a log
                System.out.println("Unknown type of web hook has arrived");
        }
    }
}

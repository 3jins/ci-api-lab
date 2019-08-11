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

    @AfterReturning(
            pointcut = "execution(* com.sejin.ciapilab.api.ci.localtest.LocalWebHookController.handle*WebHook(..)) " +
                    "|| execution(* com.sejin.ciapilab.api.ci.WebHookController.handle*WebHook(..)))",
            returning = "webHook"
    )
    public void postProcess(Object webHook) {
        if (webHook instanceof GitHubWebHook) {
            postProcessGitHubWebHook((GitHubWebHook) webHook);
        } else if (webHook instanceof TravisCiWebHook) {
            postProcessTravisCiWebHook((TravisCiWebHook) webHook);
        } else {
            // TODO: Write a log
            System.out.println("Unknown type of web hook has arrived");
        }
    }
}

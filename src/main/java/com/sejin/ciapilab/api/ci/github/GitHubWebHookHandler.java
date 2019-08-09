package com.sejin.ciapilab.api.ci.github;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GitHubWebHookHandler {
    @AfterReturning(
            pointcut = "execution(* com.sejin.ciapilab.api.ci.github.*Controller.handleWebHook(..))",
            returning = "webHook"
    )
    public void handleWebHook(Object webHook) {
        if (webHook == null) return; // Haven't received any web hook yet
        System.out.println(webHook.toString());
    }
}

package com.sejin.ciapilab.api.ci.travisci;

import org.aspectj.lang.annotation.AfterReturning;

public class TravisCiWebHookHandler {
    @AfterReturning(
            pointcut = "execution(* com.sejin.ciapilab.api.ci.travisci.*Controller.handleWebHook(..))",
            returning = "webHook"
    )
    public void handleWebHook(Object webHook) {
        if (webHook == null) return; // Haven't received any web hook yet
        System.out.println(webHook.toString());
    }
}

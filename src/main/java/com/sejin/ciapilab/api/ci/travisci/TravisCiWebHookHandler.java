package com.sejin.ciapilab.api.ci.travisci;

import com.sejin.ciapilab.api.ci.travisci.vo.TravisCiWebHook;

public class TravisCiWebHookHandler {
    public void handleTravisCiWebHook(TravisCiWebHook webHook) {
        System.out.println(webHook.toString());
    }
}

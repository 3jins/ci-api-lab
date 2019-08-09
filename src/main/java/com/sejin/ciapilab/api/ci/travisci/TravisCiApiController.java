package com.sejin.ciapilab.api.ci.travisci;

import com.sejin.ciapilab.api.ci.CiApiController;
import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Profile("prod")
@RestController
public class TravisCiApiController implements CiApiController {

    @Override
    @RequestMapping(value = "/webhookhandler/travisci", method = RequestMethod.POST)
    public Object handleWebHook(GitHubWebHook webHook) {
        return webHook;
    }
}

package com.sejin.ciapilab.api.ci.github;

import com.sejin.ciapilab.api.ci.CiApiController;
import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Profile("prod")
@RestController
public class GitHubApiController implements CiApiController {

    @Override
    @RequestMapping(value = "/webhookhandler/github", method = RequestMethod.POST)
    public Object handleWebHook(@RequestBody GitHubWebHook webHook) {
        return webHook;
    }
}

package com.sejin.ciapilab.api.ci;

import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;

public interface CiApiController {
    Object handleWebHook(GitHubWebHook webHook);
}

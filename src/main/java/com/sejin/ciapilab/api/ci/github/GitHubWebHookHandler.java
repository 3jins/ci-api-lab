package com.sejin.ciapilab.api.ci.github;

import com.sejin.ciapilab.api.ci.github.vo.GitHubWebHook;

public class GitHubWebHookHandler {
    public void handleGitHubWebHook(GitHubWebHook webHook) {
        System.out.println(webHook.toString());
    }
}

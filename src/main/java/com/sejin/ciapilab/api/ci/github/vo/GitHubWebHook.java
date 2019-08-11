package com.sejin.ciapilab.api.ci.github.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubWebHook {
    private String ref;
    private String before;  // commit hash code before this
    private String after;   // commit hash code after this
    private boolean created;
    private boolean deleted;
    private boolean forced;
    private ArrayList<GitHubCommit> commits;
    private GitHubCommit headCommit;
//    private Repository repository;
    private GitHubAuthor pusher;
    private GitHubUser sender;
}

package com.sejin.ciapilab.github.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class GitHubWebHookResponse {
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

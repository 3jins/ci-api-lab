package com.sejin.ciapilab.api.ci.github.vo;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class GitHubCommit {
    private String id;
    private String treeId;
    private boolean distinct;
    private String message;
    private String timestamp;
    private String url;
    private GitHubAuthor author;
    private ArrayList<String> added;
    private ArrayList<String> removed;
    private ArrayList<String> modified;
}

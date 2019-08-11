package com.sejin.ciapilab.api.ci.github.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubAuthor {
    private String name;
    private String email;
    private String username;
}

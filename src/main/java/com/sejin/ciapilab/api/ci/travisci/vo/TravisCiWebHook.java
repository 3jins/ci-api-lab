package com.sejin.ciapilab.api.ci.travisci.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravisCiWebHook {
    private String id;
    private int number; // build sequence
//    private TravisCiConfig config;
    private String type; // ex) "push"
    private String state; // ex) "passed"
    private String status_message; // ex) "Passed"
    private String result_message; // ex) "Passed"
    private String started_at;
    private String finished_at;
    private int duration;
    private String build_url;
    // ...
}

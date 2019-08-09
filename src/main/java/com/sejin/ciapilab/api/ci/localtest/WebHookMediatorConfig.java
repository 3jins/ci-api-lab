package com.sejin.ciapilab.api.ci.localtest;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("web-hook-mediator-config")
@Getter @Setter
public class WebHookMediatorConfig {
    private @NonNull String url;
    private @NonNull String senderApi;
    private @NonNull String bodyApi;
    private @NonNull String gitHubSenderName;
    private @NonNull String travisCiSenderName;
}

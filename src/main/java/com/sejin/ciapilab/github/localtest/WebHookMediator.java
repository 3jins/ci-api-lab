package com.sejin.ciapilab.github.localtest;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@Component
@PropertySource("classpath:/webhookMediator.properties")
@ConfigurationProperties("webhook-mediator")
public class WebHookMediator {
    private @NonNull String url;
}

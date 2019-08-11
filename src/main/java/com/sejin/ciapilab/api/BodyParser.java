package com.sejin.ciapilab.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sejin.ciapilab.api.ci.travisci.vo.TravisCiWebHook;

import java.io.IOException;
import java.net.URLDecoder;

public class BodyParser {
    public <T> T parseJson(String raw, Class<T> valueType) throws IOException {
        return (new ObjectMapper()).readValue(raw, valueType);
    }
    public <T> T parseUrlEncoded(String raw, Class<T> valueType) throws IOException {
        String payload = raw.split("=")[1];
        String decodedPayload = URLDecoder.decode(payload, "utf-8");
        return (new ObjectMapper()).readValue(decodedPayload, valueType);
    }
}

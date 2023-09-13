package com.michow.elasticcommonframework;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ElasticConfig {
    private final String path = "/api/v1/document";
    private String url;
    private String port;
    private String type;
    private String index;

    private String fullPath;

    public ElasticConfig(String url, String port, String type, String index) {
        this.url = url;
        this.port = port;
        this.fullPath = url + ":" + port + path;
        this.type = type;
        this.index = index;
    }
}

package com.michow.elasticcommonframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ElasticCommonService {

    private ElasticConfig config;

    private RestTemplate restTemplate;

    @Autowired
    public ElasticCommonService(ElasticConfig config) {
        this.config = config;
        this.restTemplate = new RestTemplate();
    }

    public void sendElasticLog(ElasticRequestDto requestDto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(requestDto, headers);

        restTemplate.postForObject(config.getFullPath(), request, ElasticRequestDto.class);
    }

}

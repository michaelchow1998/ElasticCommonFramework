package com.michow.elasticcommonframework;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElasticRequestDto {

    private String id;
    private String type;
    private String index;
    private String message;

    public ElasticRequestDto(String message, ElasticConfig config) {
        this.id = String.valueOf(UUID.randomUUID());
        this.type = config.getType();
        this.index = config.getIndex();
        this.message = message;
    }
}

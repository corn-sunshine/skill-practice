package com.elwood.es.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/11/6
 * @Version: 1.0
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        // 定义客户端配置对象
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("192.168.159.132:9200")
                .build();
        // 通过RestClients对象创建
        return RestClients.create(clientConfiguration).rest();
    }
}

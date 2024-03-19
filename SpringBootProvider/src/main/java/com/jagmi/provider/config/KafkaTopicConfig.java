package com.jagmi.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // DELETE: Borra el msj, COMPAC: Mantiene el mas actual
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //Retiene el msj el tiempo especificado - defecto -1 (nunca se borra)
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); //Tamaño máximo del segmento en Bytes -POR DEFECTO 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "100012"); //Tamaño máximo de cada mensaje -Defecto 1MB

        return TopicBuilder.name("Jorge-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}

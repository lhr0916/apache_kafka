package com.sample.apachekafka.service;

import com.sample.apachekafka.storage.MessageStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    MessageStorage storage;

    @KafkaListener(topics = "${jsa.kafka.topic}")
    public void processMessage(String content){
       log.info("Recieved MSG = {}", content);

       storage.put(content);
    }
}

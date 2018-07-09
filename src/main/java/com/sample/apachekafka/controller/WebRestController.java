package com.sample.apachekafka.controller;


import com.sample.apachekafka.service.KafkaConsumer;
import com.sample.apachekafka.service.KafkaProducer;
import com.sample.apachekafka.storage.MessageStorage;
//import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jsa/kafka")
public class WebRestController {

    private static final Logger log = LoggerFactory.getLogger(WebRestController.class);

    @Autowired
    KafkaProducer producer;

    @Autowired
    MessageStorage storage;

    @GetMapping(value="/producer")
    public String producer(@RequestParam("data")String data){
        producer.send(data);

        return "Done";
    }

    @GetMapping(value="/consumer")
    public String getAllRecievedMessage(){
        String messages = storage.toString();
        log.info("consumer = {}", messages);

        storage.clear();
        log.info("clear....");

        return messages;
    }
}

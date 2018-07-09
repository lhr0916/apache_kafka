package com.sample.apachekafka.storage;

import com.sample.apachekafka.service.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageStorage {
    private static final Logger log = LoggerFactory.getLogger(MessageStorage.class);

    private List<String> storage = new ArrayList<String>();

    public void put(String msg){
        log.info("put msg = {}" , msg);
        storage.add(msg);
        log.info("storage = {}" , storage.toString());
    }

    public String toString(){
        StringBuffer info = new StringBuffer();
        storage.forEach(msg -> info.append(msg).append("<br>/"));
        return info.toString();
    }

    public void clear(){
        storage.clear();
    }
}

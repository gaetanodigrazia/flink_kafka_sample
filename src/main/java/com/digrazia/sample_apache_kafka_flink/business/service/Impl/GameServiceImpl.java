package com.digrazia.sample_apache_kafka_flink.business.service.Impl;


import com.digrazia.sample_apache_kafka_flink.business.service.GameService;
import com.digrazia.sample_apache_kafka_flink.integration.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class GameServiceImpl implements GameService {

    private final Producer producer;

    @Autowired
    public GameServiceImpl(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void sendGame() throws ExecutionException, InterruptedException {
//        Faker faker = new Faker();
//
//        Game game = new GameBuilderRandom().randomize().build();

        producer.sendMessage("events", "game.toString()");
    }
}

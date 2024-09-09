package com.digrazia.kafka_sample.business.service.Impl;

import com.digrazia.kafka_sample.business.model.domain.Game;
import com.digrazia.kafka_sample.business.model.domain.GameBuilder;
import com.digrazia.kafka_sample.business.model.domain.GameBuilderRandom;
import com.digrazia.kafka_sample.business.model.domain.GoalBuilderRandom;
import com.digrazia.kafka_sample.business.service.GameService;
import com.digrazia.kafka_sample.integration.kafka.producer.Producer;
import com.github.javafaker.Faker;
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
        Faker faker = new Faker();

        Game game = new GameBuilderRandom().randomize().build();

        producer.sendMessage("events", game.toString());
    }
}

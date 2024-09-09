package com.digrazia.kafka_sample.business.service.Impl;

import com.digrazia.kafka_sample.business.model.domain.Goal;
import com.digrazia.kafka_sample.business.model.domain.GoalBuilder;
import com.digrazia.kafka_sample.business.model.domain.GoalBuilderRandom;
import com.digrazia.kafka_sample.business.service.GoalService;
import com.digrazia.kafka_sample.integration.kafka.producer.Producer;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService {

    private final Producer producer;

    @Autowired
    public GoalServiceImpl(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void sendGoal(String teamName) {
        Faker faker = new Faker();

        Goal goal = new GoalBuilderRandom()
                .randomize()
                .setTeamName("Milan")
                .setScorerName(faker.name().fullName())
                .build();

        producer.sendGoal(goal);
    }
}

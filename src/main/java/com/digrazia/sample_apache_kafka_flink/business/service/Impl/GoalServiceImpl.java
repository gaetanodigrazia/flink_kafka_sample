package com.digrazia.sample_apache_kafka_flink.business.service.Impl;


import com.digrazia.sample_apache_kafka_flink.business.model.domain.Goal;
import com.digrazia.sample_apache_kafka_flink.business.service.GoalService;
import com.digrazia.sample_apache_kafka_flink.integration.kafka.producer.Producer;
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
        Goal goal = new Goal();

        producer.sendGoal(goal);
    }
}

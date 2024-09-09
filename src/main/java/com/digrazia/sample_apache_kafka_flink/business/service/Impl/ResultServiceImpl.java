package com.digrazia.kafka_sample.business.service.Impl;

import com.digrazia.kafka_sample.business.service.ResultService;
import com.digrazia.kafka_sample.integration.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ResultServiceImpl implements ResultService {

    private final Producer producer;

    @Autowired
    public ResultServiceImpl(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void sendResult(String message) throws ExecutionException, InterruptedException {
        producer.sendResult(message);
    }
}

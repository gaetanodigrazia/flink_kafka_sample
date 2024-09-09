package com.digrazia.kafka_sample.business.service;

import java.util.concurrent.ExecutionException;

public interface ResultService {
    void sendResult(String message) throws ExecutionException, InterruptedException;
}

package com.digrazia.sample_apache_kafka_flink.business.service;

import java.util.concurrent.ExecutionException;

public interface ResultService {
    void sendResult(String message) throws ExecutionException, InterruptedException;
}

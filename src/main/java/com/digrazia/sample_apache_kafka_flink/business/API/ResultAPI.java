package com.digrazia.kafka_sample.business.API;

import java.util.concurrent.ExecutionException;

public interface ResultAPI {
    void sendResult(String result) throws ExecutionException, InterruptedException;
}

package com.digrazia.sample_apache_kafka_flink.business.API;

import java.util.concurrent.ExecutionException;

public interface ResultAPI {
    void sendResult(String result) throws ExecutionException, InterruptedException;
}

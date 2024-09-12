package com.digrazia.sample_apache_kafka_flink.business.API;

import java.util.concurrent.ExecutionException;

public interface GameAPI {

    void sendGame() throws ExecutionException, InterruptedException;
}

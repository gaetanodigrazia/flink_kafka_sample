package com.digrazia.kafka_sample.business.service;

import java.util.concurrent.ExecutionException;

public interface GameService {
    void sendGame() throws ExecutionException, InterruptedException;
}

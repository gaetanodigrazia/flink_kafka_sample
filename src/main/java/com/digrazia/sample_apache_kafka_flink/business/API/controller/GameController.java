package com.digrazia.sample_apache_kafka_flink.business.API.controller;


import com.digrazia.sample_apache_kafka_flink.business.API.GameAPI;
import com.digrazia.sample_apache_kafka_flink.business.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/game")
public class GameController implements GameAPI {
    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/send")
    @Override
    public void sendGame() throws ExecutionException, InterruptedException {
        gameService.sendGame();
    }
}

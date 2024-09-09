package com.digrazia.kafka_sample.business.API.controller;

import com.digrazia.kafka_sample.business.API.ResultAPI;
import com.digrazia.kafka_sample.business.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/result")
public class ResultController implements ResultAPI {
    ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/send")
    @Override
    public void sendResult(@RequestParam String result) throws ExecutionException, InterruptedException {
        resultService.sendResult(result);
    }
}

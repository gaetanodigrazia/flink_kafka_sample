package com.digrazia.kafka_sample.business.API.controller;

import com.digrazia.kafka_sample.business.API.GoalAPI;
import com.digrazia.kafka_sample.business.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/goal")
public class GoalController implements GoalAPI {

    GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/send")
    @Override
    public void sendGoal(@RequestParam String teamName) {
        goalService.sendGoal(teamName);
    }

}

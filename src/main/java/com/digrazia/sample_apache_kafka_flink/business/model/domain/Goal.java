package com.digrazia.sample_apache_kafka_flink.business.model.domain;

import java.util.Objects;

public class Goal extends Event{
    private String goalId;
    private String teamName;
    private String scorerName;

    public Goal() {
        super();
    }

    public String getGoalId() {
        return goalId;
    }

    public void setGoalId(String goalId) {
        this.goalId = goalId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getScorerName() {
        return scorerName;
    }

    public void setScorerName(String scorerName) {
        this.scorerName = scorerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return Objects.equals(goalId, goal.goalId) && Objects.equals(teamName, goal.teamName) && Objects.equals(scorerName, goal.scorerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goalId, teamName, scorerName);
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalId='" + goalId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", scorerName='" + scorerName + '\'' +
                '}';
    }
}

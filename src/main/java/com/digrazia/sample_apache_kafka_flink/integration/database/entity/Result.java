package com.digrazia.sample_apache_kafka_flink.integration.database.entity;


import java.util.Objects;

public class Result {
    private String resultId;
    private String firstTeamName;
    private String secondTeamName;
    private String result;
    private String gameDescription;
    private String gameType;
    private final String gameStatus = "FINISHED";
    private String gameDate;

    public Result() {
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getFirstTeamName() {
        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {
        this.firstTeamName = firstTeamName;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(resultId, result1.resultId) && Objects.equals(firstTeamName, result1.firstTeamName) && Objects.equals(secondTeamName, result1.secondTeamName) && Objects.equals(result, result1.result) && Objects.equals(gameDescription, result1.gameDescription) && Objects.equals(gameType, result1.gameType) && Objects.equals(gameStatus, result1.gameStatus) && Objects.equals(gameDate, result1.gameDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultId, firstTeamName, secondTeamName, result, gameDescription, gameType, gameStatus, gameDate);
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId='" + resultId + '\'' +
                ", firstTeamName='" + firstTeamName + '\'' +
                ", secondTeamName='" + secondTeamName + '\'' +
                ", result='" + result + '\'' +
                ", gameDescription='" + gameDescription + '\'' +
                ", gameType='" + gameType + '\'' +
                ", gameStatus='" + gameStatus + '\'' +
                ", gameDate='" + gameDate + '\'' +
                '}';
    }
}

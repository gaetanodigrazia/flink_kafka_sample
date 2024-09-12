package com.digrazia.sample_apache_kafka_flink.integration.database.entity;

public class Event {
    private String eventId;

    private String resultId;
    private String firstTeamName;
    private String secondTeamName;
    private String result;
    private String gameDescription;
    private String gameType;
    private final String gameStatus = "FINISHED";
    private String gameDate;

}

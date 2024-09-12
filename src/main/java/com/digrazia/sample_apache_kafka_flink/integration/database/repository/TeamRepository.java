package com.digrazia.sample_apache_kafka_flink.integration.database.repository;

import com.digrazia.sample_apache_kafka_flink.integration.database.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}

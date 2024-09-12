package com.digrazia.sample_apache_kafka_flink.integration.flink;

import com.digrazia.sample_apache_kafka_flink.business.model.domain.Result;
import com.digrazia.sample_apache_kafka_flink.integration.database.entity.Team;
import com.digrazia.sample_apache_kafka_flink.integration.database.repository.TeamRepository;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.formats.json.JsonDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.OnCheckpointRollingPolicy.build;

@Component
public class FlinkReaderFromKafka {
    FlinkReaderFromKafka() throws Exception {
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();

        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers("localhost:9092")
                .setTopics("result")
                .setGroupId("group_id")
                .setStartingOffsets(OffsetsInitializer.latest())
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();

        DataStream<String> messageStream = see.fromSource(source, WatermarkStrategy.noWatermarks(), "Result");

        messageStream.rebalance().map(new MapFunction<String, String>() {
            private static final long serialVersionUID = -6867736771747690202L;
            @Override
            public String map(String value) throws Exception {
                Pattern pattern = Pattern.compile("firstTeamId='(\\d+)'[,\\s]*secondTeamId='(\\d+)'");
                Matcher matcher = pattern.matcher(value);

                if (matcher.find()) {
                    String firstTeamId = matcher.group(1);
                    String secondTeamId = matcher.group(2);
                    System.out.println(firstTeamId);
                    System.out.println(secondTeamId);
                    System.out.println(value);
                } else {
                    System.out.println("Not found");
                }
                return value;
            }
        }).print();
        see.execute();
    }

}
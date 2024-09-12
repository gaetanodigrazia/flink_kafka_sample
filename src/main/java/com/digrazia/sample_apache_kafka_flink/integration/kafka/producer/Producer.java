package com.digrazia.sample_apache_kafka_flink.integration.kafka.producer;

import com.digrazia.sample_apache_kafka_flink.business.model.domain.Goal;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class Producer {
    CompletableFuture<SendResult<String, String>> future;

    private static final String RESULT_TOPIC = "result";
    private static final String GOAL_TOPIC = "goal";
    private static final String EVENT_TOPIC = "events";
    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendGoal(String message){
        this.kafkaTemplate.send(GOAL_TOPIC, message);
    }
    public void sendGoal(Goal goal){
        String message = goal.toString();
        log.info("Sending goal to topic: " + GOAL_TOPIC);
        log.info("Sending goal: " + message);

        this.kafkaTemplate.send(EVENT_TOPIC, message);
    }

    public void sendMessage(String topic, String message) throws ExecutionException, InterruptedException {
        future = this.kafkaTemplate.send(topic, message);
        future.whenComplete((result, ex) -> {
            try {
                log.info("Topic {}", future.get().getRecordMetadata().topic());
                log.info("Message {}", message);
                log.info("Offset {}", future.get().getRecordMetadata().offset());
                log.info("Partition {}", future.get().getRecordMetadata().partition());
                log.info("Timestamp {}", future.get().getRecordMetadata().timestamp());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void sendResult(String message) throws ExecutionException, InterruptedException {
        future = this.kafkaTemplate.send(RESULT_TOPIC, message);
        future.whenComplete((result, ex) -> {
            try {
                log.info("Message sent to topic {}", message);
                log.info("Topic {}", future.get().getRecordMetadata().topic());
                log.info("Offset {}", future.get().getRecordMetadata().offset());
                log.info("Partition {}", future.get().getRecordMetadata().partition());
                log.info("Timestamp {}", future.get().getRecordMetadata().timestamp());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }


    Thread thread = new Thread(){
        public void run(){
            future = this.getKafkaTemplate().send(RESULT_TOPIC, "message");
            future.whenComplete((result, ex) -> {
                try {
                    log.info("Message sent to topic {}", "message");
                    log.info("Topic {}", future.get().getRecordMetadata().topic());
                    log.info("Offset {}", future.get().getRecordMetadata().offset());
                    log.info("Partition {}", future.get().getRecordMetadata().partition());
                    log.info("Timestamp {}", future.get().getRecordMetadata().timestamp());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });        }

        private KafkaTemplate<String, String> getKafkaTemplate() {
            return kafkaTemplate;
        }
    };


    @Bean
    public NewTopic createTopic(){

        return new NewTopic("game",3,(short) 3);
    }

}
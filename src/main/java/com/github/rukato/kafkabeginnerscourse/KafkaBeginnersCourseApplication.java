package com.github.rukato.kafkabeginnerscourse;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaBeginnersCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBeginnersCourseApplication.class, args);
		// System.out.println("Hello peeps!");
		String bootstrapServer = "localhost:9092";

		//create producer properties
		Properties properties = new Properties();

		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		//Old way
		// properties.setProperty("bootstrap.servers", bootstrapServer);
		// properties.setProperty("key.serializer", StringSerializer.class.getName());
		// properties.setProperty("value.serializer", StringSerializer.class.getName());

		//create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
		
		//create a producer record
		ProducerRecord<String, String> record = new ProducerRecord<String,String>("first_topic", "Hola planeta!");

		//send data - async

		producer.send(record);
		//flush data
		producer.flush();
		//flush and close
		producer.close();
	}

}

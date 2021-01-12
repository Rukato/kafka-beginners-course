package com.github.rukato.kafkabeginnerscourse;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
<<<<<<< HEAD:src/main/java/com/github/rukato/kafkabeginnerscourse/KafkaBeginnersCourseApplicationSecondExample.java
public class KafkaBeginnersCourseApplicationSecondExample {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBeginnersCourseApplicationSecondExample.class, args);
		// System.out.println("Hello peeps!");
		String bootstrapServer = "localhost:9092";

		Logger logger = LoggerFactory.getLogger(KafkaBeginnersCourseApplicationSecondExample.class);
=======
public class ExampleB {

	public static void main(String[] args) {
		SpringApplication.run(ExampleB.class, args);
		// System.out.println("Hello peeps!");
		String bootstrapServer = "localhost:9092";

		Logger logger = LoggerFactory.getLogger(ExampleB.class);
>>>>>>> 14ebdd1ac6172db3b83d64205a65b19002083d3e:src/main/java/com/github/rukato/kafkabeginnerscourse/ExampleB.java
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

		producer.send(record, new Callback(){
			public void onCompletion(RecordMetadata recordMetadata, Exception e){
				//executes every time a record is succesfully sent or an exceptions is thrown
				if(e != null){
					//record succesfully sent
					logger.info("Received new Metadata ");
				} else {

				}
			}
		});
		//flush data
		producer.flush();
		//flush and close
		producer.close();
	}

}
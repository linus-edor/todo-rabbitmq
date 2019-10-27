package com.boot.todo.rabbitmq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot.todo.rabbitmq.component.ToDoProducer;
import com.boot.todo.rabbitmq.model.ToDo;

@Configuration
public class ToDoSender {
	@Bean
	public CommandLineRunner sendToDos(@Value("${todo.amqp.queue}") String destination, ToDoProducer producer) {
		return args -> {
			producer.sendTo(destination, new ToDo("workout tomorrow morning!"));
		};
	}
}
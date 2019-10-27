package com.boot.todo.rabbitmq.component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.boot.todo.rabbitmq.model.ToDo;
import com.boot.todo.rabbitmq.repository.ToDoRepository;

@Component
public class ToDoConsumer {
private Logger log = LoggerFactory.getLogger(ToDoConsumer.class);
private ToDoRepository repository;
public ToDoConsumer(ToDoRepository repository){
this.repository = repository;
}
@RabbitListener(queues = "${todo.amqp.queue}")
public void processToDo(ToDo todo){
log.info("Consumer> " + todo);
log.info("ToDo created> " + this.repository.save(todo));
}
}
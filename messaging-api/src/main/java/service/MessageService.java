package service;

import module.Message;

import repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;

public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {this.repository = repository;}

    public Message send(String sender, String receiver, String content){
        Message message = new Message(sender, receiver, content);
        return repository.save(message);
    }

    public List<Message> getAll(){
        return repository.findAll();
    }
}

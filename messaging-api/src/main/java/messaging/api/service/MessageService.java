package messaging.api.service;

import messaging.api.module.Message;

import messaging.api.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {this.repository = repository;}

    public Message send(String sender, String receiver, String content) {
        Message message = new Message(
                receiver,
                sender,
                content,
                LocalDateTime.now()
        );
        return repository.save(message);
    }

    public List<Message> getAll(){
        return repository.findAll();
    }
}

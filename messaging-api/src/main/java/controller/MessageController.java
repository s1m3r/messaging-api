package controller;

import module.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {this.messageService = messageService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message create(@RequestBody Message message) {
        return messageService.send(
                message.getSender(),
                message.getReceiver(),
                message.getContent()
        );
    }

    @GetMapping
    public List<Message> getAll(){ return messageService.getAll();}
}

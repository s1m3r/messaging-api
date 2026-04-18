package controller;

import dto.MessageDto;
import dto.MessageResponseDto;
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
    public MessageResponseDto create(@RequestBody MessageDto dto) {
        Message message = messageService.send(
                dto.getSender(),
                dto.getReceiver(),
                dto.getContent()
        );
        MessageResponseDto response = new MessageResponseDto(
                message.getId(),
                message.getSender(),
                message.getReceiver(),
                message.getContent(),
                message.getCreatedAt()
        );
        return response;
    }

    @GetMapping
    public List<Message> getAll(){ return messageService.getAll();}
}

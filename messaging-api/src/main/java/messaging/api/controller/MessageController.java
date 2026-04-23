package messaging.api.controller;

import messaging.api.dto.MessageDto;
import messaging.api.dto.MessageResponseDto;
import jakarta.validation.Valid;
import messaging.api.module.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import messaging.api.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto create(@Valid @RequestBody MessageDto dto) {
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
    public List<MessageResponseDto> getAll() {

        List<Message> messages = messageService.getAll();
        List<MessageResponseDto> response = new ArrayList<>();
        for (Message message : messages) {
            response.add(
                    new MessageResponseDto(
                            message.getId(),
                            message.getSender(),
                            message.getReceiver(),
                            message.getContent(),
                            message.getCreatedAt()
                    )
            );
        }
        return response;
    }
}

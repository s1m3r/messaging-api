package dto;

import java.time.LocalDateTime;

public class MessageResponseDto {
    private Integer id;
    private String sender;
    private String receiver;
    private String content;
    private LocalDateTime createdAt;

    public MessageResponseDto() {}

    public MessageResponseDto(Integer id, String sender, String receiver, String content, LocalDateTime createdAt) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

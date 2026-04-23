package dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;

public class MessageDto {
    @NotBlank
    private String sender;
    @NotBlank
    private String receiver;
    @NotBlank
    private String content;

    private LocalDateTime createdAt;
    public MessageDto() {}

    public MessageDto(String sender, String receiver, String content, LocalDateTime createdAt) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
}

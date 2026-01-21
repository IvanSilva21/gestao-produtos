package com.example.gestao_produtos.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private Map<String, String> messages;

    public ErrorResponse(int status, String error, Map<String, String> messages) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.messages = messages;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public Map<String, String> getMessages() {
        return messages;
    }
}



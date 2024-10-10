package ru.gb.danila.tablo;

import java.time.LocalDateTime;

public class Ticket {
    private final String number;
    private final LocalDateTime createdAt;

    public Ticket(String number, LocalDateTime createdAt) {
        this.number = number;
        this.createdAt = createdAt;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString(){
        return String.format("Ticket #%s createdAt=%s", number, createdAt);
    }
}

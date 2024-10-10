package ru.gb.danila.tablo;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TicketNumberGenerator {
    public String createNewNumber(){
        return UUID.randomUUID().toString();
    }
}

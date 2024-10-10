package ru.gb.danila.tablo;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

@Component
public class Tablo {
    private static final  Scanner scanner = new Scanner(System.in);

   private final TicketNumberGenerator ticketNumberGenerator;

    public Tablo(TicketNumberGenerator ticketNumberGenerator) {
        this.ticketNumberGenerator = ticketNumberGenerator;
    }

    public Ticket createNewTicket(){
        String number = ticketNumberGenerator.createNewNumber();
        return new Ticket(number, LocalDateTime.now());
    }

    public void run(){
        Deque<Ticket> ticketDeque = new ArrayDeque<>();


        while (true){
            try{
                System.out.printf("available commands: %s%n", Arrays.toString(CommandType.values()));
                CommandType command = CommandType.valueOf(prompt("input command: "));

                switch (command){
                    case CREATE -> {
                        Ticket ticket = createNewTicket();
                        System.out.println(ticket);
                        ticketDeque.addLast(ticket);
                    }
                    case INFO -> {
                        System.out.println(ticketDeque);
                    }
                    case EXIT -> {
                       throw new InterruptedException();
                    }

                }
            } catch (InterruptedException e) {
                System.out.println("EXIT");
                break;
            }catch (IllegalArgumentException e){
                System.out.println("command not found");
            }
        }
    }

    private String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}

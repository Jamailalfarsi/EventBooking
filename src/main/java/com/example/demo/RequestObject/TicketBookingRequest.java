package com.example.demo.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Data

public class TicketBookingRequest {
    Integer numberOfTickets;
    String createdDate;
    String updatedDate;
    Boolean isActive;
    String name;
    String password;
}

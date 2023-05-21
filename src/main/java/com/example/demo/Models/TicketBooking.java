package com.example.demo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;


import javax.persistence.*;

@Data
@Setter
@Getter
@Entity
public class TicketBooking extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer numberOfTickets;

    @ManyToOne
    @JoinColumn(name = "userRegistration_id", referencedColumnName = "id")// defining the foreign key which is ID
    UserRegistration userRegistration;

    @ManyToOne
    @JoinColumn(name ="event_id",referencedColumnName = "id")
    Event event;


}

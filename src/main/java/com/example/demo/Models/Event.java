package com.example.demo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Event  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String dateFrom;
    String dateTo;
    Integer numberOfDate;
    String time;
    String location;
    Double price;
    Integer ticketAvailable;

    @OneToMany
    @JoinColumn(name ="ticketBooking_id",referencedColumnName = "id")
    List<TicketBooking> ticketBookings;
}


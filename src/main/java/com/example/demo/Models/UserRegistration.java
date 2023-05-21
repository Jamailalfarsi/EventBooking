package com.example.demo.Models;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity

public class UserRegistration extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String userName;
    String password;

//    @OneToMany
//    @JoinColumn(name ="ticketBooking_id",referencedColumnName = "id")
//    List<TicketBooking> ticketBookings;

}

package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalBookingDTO {
    String eventName;
    String Date;
    String location;
    Integer ticketsSold;
    Double revenue;


}

package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class FilterEventDataDTO {
    String eventName;
    String location;
    Integer numberOfDate;

    public FilterEventDataDTO(String eventName, String location, Integer numberOfDate) {
        this.eventName = eventName;
        this.location = location;
        this.numberOfDate = numberOfDate;
    }



}

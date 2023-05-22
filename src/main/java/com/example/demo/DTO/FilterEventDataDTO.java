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

}

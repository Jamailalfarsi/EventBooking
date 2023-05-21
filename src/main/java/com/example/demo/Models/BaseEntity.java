package com.example.demo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@Data
@MappedSuperclass
public class BaseEntity {
    String createdDate;

    String updatedDate;

    Boolean isActive;
}

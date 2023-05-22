package com.example.demo.mailing.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class EmailDetails {
    private List<String> recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}

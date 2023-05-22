package com.example.demo.mailing.Model;

import lombok.Data;

import java.util.List;
@Data
public class EmailDetails {
    private List<String> recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}

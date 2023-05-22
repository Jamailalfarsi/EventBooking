package com.example.demo.Controller;

import com.example.demo.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "report")
public class ReportController {
    @Autowired
    ReportService reportService;
}

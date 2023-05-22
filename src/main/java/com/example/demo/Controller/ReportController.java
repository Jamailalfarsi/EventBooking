package com.example.demo.Controller;

import com.example.demo.Service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @RequestMapping(value="getEventReport",method = RequestMethod.GET)
    public void generateEventReport() throws JRException, FileNotFoundException {
        reportService.generateEventReport();
    }
}

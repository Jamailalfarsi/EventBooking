package com.example.demo.Service;

import com.example.demo.DTO.FilterEventDataDTO;
import com.example.demo.Models.Event;
import com.example.demo.Repository.EventRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    EventRepository eventRepository;
    public static final String pathToReports = "C:\\Users\\user021\\Desktop\\report";

    public String generateReport() throws FileNotFoundException, JRException {
        List<Event> eventList = eventRepository.getAllEvents();

        File file = ResourceUtils.getFile("classpath:Filter_Data.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(eventList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Jamail");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\events.pdf");
        return "Report generated : " + pathToReports + "\\events.pdf";
    }

    public String generateEventReport() throws FileNotFoundException, JRException {
        List<Event> eventList = eventRepository.getAllEvents();
        List<FilterEventDataDTO> studentDTOList = new ArrayList<>();
        for (Event evt : eventList) {
            String eventName = evt.getName();
            String location = evt.getLocation();
            Integer numberOfDate = evt.getNumberOfDate();

            FilterEventDataDTO eventDTO = new FilterEventDataDTO(eventName, location, numberOfDate);
            studentDTOList.add(eventDTO);
        }


    }

}



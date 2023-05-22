package com.example.demo.Service;

import com.example.demo.Models.Event;
import com.example.demo.Models.TicketBooking;
import com.example.demo.Models.UserRegistration;
import com.example.demo.Repository.EventRepository;
import com.example.demo.Repository.TicketBookingRepository;
import com.example.demo.Repository.UserRegistrationRepository;
import com.example.demo.RequestObject.TicketBookingRequest;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TicketBookingService {
    @Autowired
    TicketBookingRepository ticketBookingRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRegistrationRepository  userRegistrationRepository;

//    public void addTicketBookingData(Integer numberOfTickets, String createdDate, String updatedDate,
//                                     Boolean isActive,String name;,Integer userRegistrationId) {
//        TicketBooking ticketBooking = new TicketBooking();
//        Event event=new Event();
//        UserRegistration userRegistration=new UserRegistration();
//        ticketBooking.setNumberOfTickets(numberOfTickets);
//        ticketBooking.setCreatedDate(createdDate);
//        ticketBooking.setUpdatedDate(updatedDate);
//        ticketBooking.setIsActive(isActive);
//        ticketBooking.setUserRegistration(userRegistration);
//        ticketBooking.setEvent(event);
//        ticketBookingRepository.save(ticketBooking);
//    }
  public void addTicketBookingData(TicketBookingRequest ticketBooking) {
    TicketBooking ticketInfo = new TicketBooking();
    ticketInfo.setNumberOfTickets(ticketBooking.getNumberOfTickets());
    ticketInfo.setCreatedDate(ticketBooking.getCreatedDate());
    ticketInfo.setUpdatedDate(ticketBooking.getUpdatedDate());
    ticketInfo.setIsActive(ticketBooking.getIsActive());

    Integer id = eventRepository.findIdByEventName(ticketBooking.getName());
    Event eventId = eventRepository.findById(id).get();
    ticketInfo.setEvent(eventId);

    Integer userRegistrationId=userRegistrationRepository.findByIdUserPassword(ticketBooking.getPassword());
    UserRegistration userId = userRegistrationRepository.findById(userRegistrationId).get();
    ticketInfo.setUserRegistration(userId);
    ticketBookingRepository.save(ticketInfo);

}

    public List<TicketBooking> getAllBookings() {
            return ticketBookingRepository.getAllBookings();
        }
    @RequestMapping(value = "getById")
    public TicketBooking getBookingById(@RequestParam Integer id) {
        TicketBooking ticketBooking = ticketBookingRepository.getBookingById(id);
        return ticketBooking;
    }
//    @RequestMapping(value = "getIdByName")
//    public Integer getIdByName(@RequestParam String name) {
//      Integer  ticketBooking = ticketBookingRepository.generateIdByName(name);
//        return ticketBooking;
//    }


//    public void updateBooking(TicketBookingRequest ticketBooking){
//        TicketBooking ticketBooking =ticketBookingRepository.getBookingById(id);
//        ticketBooking.setNumberOfTickets(ticketBooking.getNumberOfTickets());
//        ticketBooking.setCreatedDate(ticketBooking.getCreatedDate());
//        ticketBooking.setUpdatedDate(ticketBooking.getUpdatedDate());
//        ticketBooking.setIsActive(ticketBooking.getIsActive());
//
//        ticketBookingRepository.save(ticketBooking);
//    }
public void deleteBookingById(Integer id){
    TicketBooking bookingToDelete = ticketBookingRepository.findById(id).get();
    ticketBookingRepository.delete(bookingToDelete);
}




}

package com.example.demo.Controller;

import com.example.demo.Models.TicketBooking;
import com.example.demo.Models.UserRegistration;
import com.example.demo.Service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value= "userRegistration" )
public class UserRegistrationController {
    @Autowired
    UserRegistrationService userRegistrationService;

//    @RequestMapping(value = "User" ,method = RequestMethod.POST)
//    public void addUserRegistrationData(@RequestParam String userName, String password,String createdDate,String updatedDate,Boolean isActive ) throws ParseException {
//        userRegistrationService.createUserRegistrationData(userName,password,createdDate,updatedDate,isActive );
//    }

    @RequestMapping(value = "User" ,method = RequestMethod.POST)
    public String addUserRegistrationData(@RequestParam String userName, String password,String createdDate,String updatedDate,Boolean isActive) {
    try {
        userRegistrationService.addUserRegistrationData(userName, password, createdDate, updatedDate, isActive);
        return "UserRegistration added Successfully";
    } catch (Exception e) {
        return "UserRegistration added Failed";
    }


}
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public List<UserRegistration> getAllUsers(){
        List<UserRegistration> userList = userRegistrationService.getAllUsers();
        return userList;
    }
    @RequestMapping(value = "getById")
    public UserRegistration getUserRegistrationById(@RequestParam Integer id) {
        UserRegistration userRegistration = userRegistrationService.getUserRegistrationById(id);
        return userRegistration;
    }
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public void updateUser(@RequestParam  String password,String createdDate,String updatedDate,Boolean isActive,Integer id){
        userRegistrationService.updateUser(password, createdDate,updatedDate, isActive,id);
    }

//    @GetMapping(value = "deleteById")
//    public String deleteUserById(@RequestParam Integer id) {
//
//        userRegistrationService.deleteUserById(id);
//        return "Record Deleted Successfully :)";
//
//    }
@GetMapping(value = "deleteById")
public String deleteUserById(@RequestParam Integer id) {

    userRegistrationService.deleteUserById(id);
    return "Record Deleted Successfully :)";

}



}

package com.example.demo.Service;

import com.example.demo.Models.TicketBooking;
import com.example.demo.Models.UserRegistration;
import com.example.demo.Repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserRegistrationService {
    @Autowired
    UserRegistrationRepository userRegistrationRepository;

    public void addUserRegistrationData(String userName, String password,String createdDate,String updatedDate,Boolean isActive ) {
        UserRegistration userRegistration=new UserRegistration();
        userRegistration.setUserName(userName);
        userRegistration.setPassword(password);
        userRegistration.setCreatedDate(createdDate);
        userRegistration.setUpdatedDate(updatedDate);
        userRegistration.setIsActive(isActive);
        userRegistrationRepository.save(userRegistration);

    }
    public List<UserRegistration> getAllUsers() {
        return userRegistrationRepository.getAllUsers();
    }
    @RequestMapping(value = "getById")
    public UserRegistration getUserRegistrationById(@RequestParam Integer id) {
        UserRegistration userRegistration = userRegistrationRepository.getUserRegistrationById(id);
        return userRegistration;
    }
    public void updateUser(String password,String createdDate,String updatedDate,Boolean isActive,Integer id){
        UserRegistration userRegistration =userRegistrationRepository.getUserRegistrationById(id);
        userRegistration.setPassword(password);
        userRegistration.setCreatedDate(createdDate);
        userRegistration.setUpdatedDate(updatedDate);
        userRegistration.setIsActive(isActive);
        userRegistrationRepository.save(userRegistration);
    }
//    public void deleteUserById(Integer id) {
//        UserRegistration userRegistration = userRegistrationRepository.deleteUserById(id);
//        userRegistration.setIsActive(false);
//        userRegistrationRepository.save(userRegistration);
//    }
 public void deleteUserById(Integer id){
     UserRegistration userToDelete = userRegistrationRepository.findById(id).get();
     userRegistrationRepository.delete(userToDelete);
}

}

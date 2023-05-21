package com.example.demo.Repository;

import com.example.demo.Models.TicketBooking;
import com.example.demo.Models.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Integer> {
    @Query(value = "SELECT id FROM user_registration  WHERE password = :password", nativeQuery = true)
    Integer findByIdUserPassword(@Param("password") String password);
    @Query(value = "SELECT s from UserRegistration s")
    List<UserRegistration> getAllUsers();
    @Query (value = "SELECT s from UserRegistration s where s.id = :id")
    UserRegistration getUserRegistrationById(@Param("id")Integer id);

//    @Query(value = "DELETE s from UserRegistration s where s.id = :id")
//    UserRegistration deleteUserById(@Param("id")Integer id);


}

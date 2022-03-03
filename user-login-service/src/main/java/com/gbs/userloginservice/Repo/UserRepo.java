package com.gbs.userloginservice.Repo;

import java.util.List;

import com.gbs.userloginservice.Model.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Registration,Integer> {

   

//    @Query("FROM Registration p WHERE p.userName LIKE %?1% and p.password LIKE %?1%")

@Query("FROM Registration p WHERE p.userName = ?1 and p.password = ?2")
    List<Registration> getUserByLogin(String userName, String password);

Registration findByEmail(String email);

    // @Query("FROM Registration p WHERE p.userName LIKE %?1%")
    // List<Registration> getUserByLogin(String userName);


    
}

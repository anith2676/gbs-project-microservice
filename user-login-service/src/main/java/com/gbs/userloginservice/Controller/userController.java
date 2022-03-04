package com.gbs.userloginservice.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gbs.userloginservice.Model.Registration;
import com.gbs.userloginservice.Repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class userController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public HashMap<Object, Object> getUserByLogin(@RequestParam String userName, String password) {
        var response = new HashMap<Object, Object>();
        List<Registration> listRegistration = null;
        try {
            if(!userName.equals(null) && !password.equals(null)) {
                listRegistration = new ArrayList<>();
                listRegistration = userRepo.getUserByLogin(userName, password);

                if(listRegistration.size() >= 1 && listRegistration != null) {
                    response.put("message", "user login successfully");
                }else {
                    response.put("message", "user login failed");
                }
            }            
        } catch (Exception e) {
     }
        return response;
    }

    @GetMapping("/users")
    public ResponseEntity<Map<Object, Object>> getAllUsers() {
        var Regist = userRepo.findAll();
        var response = new HashMap<Object, Object>();

        if (Regist.isEmpty()) {
            response.put("message", "No items found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "user found");
        response.put("users", Regist);
        response.put("status", HttpStatus.OK);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


 @PostMapping({ "/", "" })
    public ResponseEntity<Map<Object, Object>> createItem(@RequestBody Registration reg) {
        Map<Object, Object> response = new HashMap<>();
        try {
            Registration re = new Registration();
            re = userRepo.findByEmail(reg.getEmail());

            if(re != null) {
                response.put("email id", reg.getEmail());
                response.put("message", "Email Id Already Exist, Choose another email id");    
            } else{
                reg =userRepo.save(reg);
                response.put("status", HttpStatus.CREATED);
                response.put("item", userRepo.save(reg));
                response.put("message", "User created successfully");    
            }
    } catch (Exception e) {
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }    
}

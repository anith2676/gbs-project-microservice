package com.gbs.caterermenuservice.Controller;

import java.util.HashMap;
import java.util.Map;

import com.gbs.caterermenuservice.Model.Menu;
import com.gbs.caterermenuservice.Repo.MenuRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class menuController {
    
    
    @Autowired 
    private MenuRepo menuRepo;
    
    
    @GetMapping("/getMenu")
    public ResponseEntity<Map<Object,Object>>getAllMenu(){
        var response = new HashMap<Object, Object>();
        
        var menus = menuRepo.findAll();
        if (menus.isEmpty()) {
            response.put("message", "No menu found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "Menu found");
        response.put("items", menus);
        response.put("status", HttpStatus.OK);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("insert")
    public ResponseEntity<Map<Object, Object>> createItem(@RequestBody Menu menu) {
        Map<Object, Object> response = new HashMap<>();
        var it = menuRepo.save(menu);

        response.put("status", HttpStatus.CREATED);
        response.put("item", menuRepo.save(menu));
        response.put("message", "Item created successfully");
        response.put("location", "/store/items/" + it.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}

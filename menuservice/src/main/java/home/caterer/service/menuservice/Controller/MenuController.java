package home.caterer.service.menuservice.Controller;

import java.time.LocalDate;
import home.caterer.service.menuservice.Model.Menu;
import home.caterer.service.menuservice.Service.MenuService;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MenuService menuService;

    @PostMapping("/createMenu")
    public ResponseEntity<Menu> createMenu(@RequestBody MenuDTO mDto){

        ItemDTO itemDTO=restTemplate.postForObject("http://localhost:5000/api/items/list",
        mDto.getItems(), ItemDTO.class);
        itemDTO.getItems().forEach(System.out::println);
        Menu entity = new Menu();
        entity.setMenuDate(mDto.getMenuDate());
        entity.setItems(itemDTO.getItems());
        entity.setUpdatedDate(LocalDate.now());
        Menu menu=menuService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(menu);
    }
    }
    


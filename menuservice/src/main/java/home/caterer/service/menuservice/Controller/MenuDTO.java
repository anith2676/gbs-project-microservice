package home.caterer.service.menuservice.Controller;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@AllArgsConstructor 
@NoArgsConstructor

public class MenuDTO {
    
    private LocalDate menuDate;

    private List<Integer> items;


}

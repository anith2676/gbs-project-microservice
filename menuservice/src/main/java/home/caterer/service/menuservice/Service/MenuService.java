package home.caterer.service.menuservice.Service;

import java.time.LocalDate;
import java.util.List;

import home.caterer.service.menuservice.Model.Menu;

public interface MenuService {
    
    Menu findByMenuDate(LocalDate date);

    Menu save(Menu entity);

    void deleteByMenuDate(LocalDate date);

    List<Menu> findByMenuDateBetween(LocalDate startDate, LocalDate endDate);

}


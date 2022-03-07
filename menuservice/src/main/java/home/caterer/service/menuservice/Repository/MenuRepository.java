package home.caterer.service.menuservice.Repository;

import java.time.LocalDate;
import java.util.List;

import home.caterer.service.menuservice.Model.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository <Menu,Integer> {
    
    Menu findByMenuDate(LocalDate date);

    void deleteByMenuDate(LocalDate date);

    List<Menu> findByMenuDateBetween(LocalDate startDate, LocalDate endDate);
    
}


package home.caterer.service.menuservice.Service;

import java.time.LocalDate;
import java.util.List;

import home.caterer.service.menuservice.Model.Menu;
import home.caterer.service.menuservice.Repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MenuServiceImpl implements MenuService {
    
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu findByMenuDate(LocalDate date) {
        return menuRepository.findByMenuDate(date);
    }

    @Override
    public Menu save(Menu entity) {
        return menuRepository.save(entity);
    }

    @Override
    public void deleteByMenuDate(LocalDate date) {
        menuRepository.deleteByMenuDate(date);
    }

    @Override
    public List<Menu> findByMenuDateBetween(LocalDate startDate, LocalDate endDate) {
        return menuRepository.findByMenuDateBetween(startDate, endDate);
    }

    
}


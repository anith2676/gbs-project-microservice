package home.caterer.service.menuservice.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menus")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor

public class Menu {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    @Column(name="menu_date")
    private LocalDate menuDate;

    
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("menu") // Ignore this property when converting to JSON
    private List<Item> items;


    @Column(name = "updated_on", nullable = false)
    private LocalDate updatedDate;

  
}

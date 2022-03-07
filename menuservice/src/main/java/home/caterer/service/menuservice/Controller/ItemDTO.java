package home.caterer.service.menuservice.Controller;

import java.util.List;

import home.caterer.service.menuservice.Model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ItemDTO {

    private List<Item> items;
}


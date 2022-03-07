package home.caterer.service.itemservice.Controller;

import java.util.List;

import home.caterer.service.itemservice.Model.Item;
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


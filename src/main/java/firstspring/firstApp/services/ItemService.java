package firstspring.firstApp.services;

import firstspring.firstApp.entities.ShopItems;

import java.util.List;

public interface ItemService {

    ShopItems addItem(ShopItems items);

    List<ShopItems> getAllItems();
    void deleteItem(ShopItems item);
    ShopItems getItem(Long id);
    ShopItems saveItem(ShopItems item);
}

package firstspring.firstApp.services;

import firstspring.firstApp.entities.ShopItems;
import firstspring.firstApp.repositories.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIml implements ItemService{

    @Autowired
    private ShopItemRepository shopItemRepository;
    @Override
    public ShopItems addItem(ShopItems items) {
        return shopItemRepository.save(items);
    }

    @Override
    public List<ShopItems> getAllItems() {
        return shopItemRepository.findAllByAmountGreaterThanOrderByPriceDesc(0);
    }

    @Override
    public void deleteItem(ShopItems item) {
        shopItemRepository.delete(item);
    }

    @Override
    public ShopItems getItem(Long id) {
        return shopItemRepository.findByIdAndAmountGreaterThan(id, 0);
    }

    @Override
    public ShopItems saveItem(ShopItems item) {
        return shopItemRepository.save(item);
    }
}

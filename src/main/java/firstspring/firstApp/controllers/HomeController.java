package firstspring.firstApp.controllers;

import firstspring.firstApp.beans.FirstBean;
import firstspring.firstApp.beans.ThirdBean;
import firstspring.firstApp.db.DBManager;
import firstspring.firstApp.db.Items;
import firstspring.firstApp.entities.ShopItems;
import firstspring.firstApp.services.ItemService;
import firstspring.firstApp.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;


    @GetMapping(value = "/")
    public String index(Model model){
        List<ShopItems> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "index";
    }
    @PostMapping(value = "/addItem")
    public String addItem(@RequestParam(name = "item_name", defaultValue = "No Item") String name,
                          @RequestParam(name = "item_price", defaultValue = "0") int price,
                          @RequestParam(name = "item_amount", defaultValue = "0") int amount){

        itemService.addItem(new ShopItems(null, name,price,amount));
        return "redirect:/";
    }
    @GetMapping(value = "/details/{idshka}")
    public String details(Model model, @PathVariable(name = "idshka") Long id){
        ShopItems item = itemService.getItem(id);
        model.addAttribute("item", item);
        return "detail";
    }

    @PostMapping(value = "saveItem")
    public String saveItem(@RequestParam(name = "item_id", defaultValue = "0") Long id,
                           @RequestParam(name = "item_name", defaultValue = "No Item") String name,
                          @RequestParam(name = "item_price", defaultValue = "0") int price,
                          @RequestParam(name = "item_amount", defaultValue = "0") int amount) {
        ShopItems item = itemService.getItem(id);
        if(item!=null) {
            item.setName(name);
            item.setPrice(price);
            item.setAmount(amount);
            itemService.saveItem(item);
        }
        return "redirect:/";
    }

    @PostMapping(value = "deleteItem")
    public String deleteItem(@RequestParam(name = "item_id") Long id){
        ShopItems item = itemService.getItem(id);
        if(item!=null) {
            itemService.deleteItem(item);
        }
        return "redirect:/";
    }
}

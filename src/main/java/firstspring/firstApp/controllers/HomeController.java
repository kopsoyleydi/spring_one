package firstspring.firstApp.controllers;

import firstspring.firstApp.beans.FirstBean;
import firstspring.firstApp.db.DBManager;
import firstspring.firstApp.db.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private FirstBean firstBean;
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Items> items = DBManager.getItems();
        String text = firstBean.getText();
        model.addAttribute("text", text);
        model.addAttribute("items", items);
        return "index";
    }
    @PostMapping(value = "/addItem")
    public String addItem(@RequestParam(name = "item_name", defaultValue = "No Item") String name,
                          @RequestParam(name = "item_price", defaultValue = "0") int price){
        DBManager.AddItem((new Items(null, name, price)));
        return "redirect:/";
    }
    @GetMapping(value = "/details/{idshka}")
    public String details(Model model, @PathVariable(name = "idshka") Long id){
        Items item = DBManager.getItem(id);
        model.addAttribute("item", item);
        return "detail";
    }
}

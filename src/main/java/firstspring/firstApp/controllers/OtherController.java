package firstspring.firstApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class OtherController {
    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }
}

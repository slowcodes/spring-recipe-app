package ng.com.bitsystems.recipeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/index","/","","/index.html","index.htm", "/home"})
    public String getIndexPage(){

        return "index";
    }
}

package ng.com.bitsystems.recipeapp.controller;

import ng.com.bitsystems.recipeapp.repositories.CategoryRepository;
import ng.com.bitsystems.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/index","/","","/index.html","index.htm", "/home"})
    public String getIndexPage(){
        System.out.println("Found category ID: "+categoryRepository.findByDescription("American").get().getId());
        System.out.println("Found unit of measure ID: "+unitOfMeasureRepository.findByDescription("Pinch").get().getId());
        return "index";
    }
}

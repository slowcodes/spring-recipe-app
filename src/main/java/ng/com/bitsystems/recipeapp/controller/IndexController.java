package ng.com.bitsystems.recipeapp.controller;

import lombok.extern.slf4j.Slf4j;
import ng.com.bitsystems.recipeapp.repositories.CategoryRepository;
import ng.com.bitsystems.recipeapp.repositories.RecipeRepository;
import ng.com.bitsystems.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository,
                           UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/index","/","","/index.html","index.htm", "/home"})
    public String getIndexPage(Model model){
        log.info("initiated index controller");
        model.addAttribute("recipes", recipeRepository.findAll());
        System.out.println("Found category ID: "+categoryRepository.findByDescription("American").get().getId());
        System.out.println("Found unit of measure ID: "+unitOfMeasureRepository.findByDescription("pinch").get().getId());
        return "index";
    }
}

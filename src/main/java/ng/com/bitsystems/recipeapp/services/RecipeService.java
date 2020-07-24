package ng.com.bitsystems.recipeapp.services;

import ng.com.bitsystems.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}

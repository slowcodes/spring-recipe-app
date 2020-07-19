package ng.com.bitsystems.recipeapp.repositories;

import ng.com.bitsystems.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

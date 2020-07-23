package ng.com.bitsystems.recipeapp.repositories;

import ng.com.bitsystems.recipeapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}

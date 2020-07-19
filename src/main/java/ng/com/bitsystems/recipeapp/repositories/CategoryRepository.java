package ng.com.bitsystems.recipeapp.repositories;

import ng.com.bitsystems.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

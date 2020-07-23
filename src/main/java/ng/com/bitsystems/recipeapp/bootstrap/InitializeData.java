package ng.com.bitsystems.recipeapp.bootstrap;

import ng.com.bitsystems.recipeapp.domain.*;
import ng.com.bitsystems.recipeapp.repositories.CategoryRepository;
import ng.com.bitsystems.recipeapp.repositories.RecipeRepository;
import ng.com.bitsystems.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InitializeData implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public InitializeData(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaspoon.isPresent()){
            throw new RuntimeException("Could not find teaspoon");
        }

        Optional <UnitOfMeasure> clove = unitOfMeasureRepository.findByDescription("clove");
        if(!clove.isPresent()){
            throw new RuntimeException("Could not find clove");
        }

        Optional<UnitOfMeasure> piece = unitOfMeasureRepository.findByDescription("piece");
        if(!piece.isPresent()){
            throw new RuntimeException("Could not find piece");
        }

        Optional<UnitOfMeasure> cups = unitOfMeasureRepository.findByDescription("cups");
        if(!cups.isPresent()){
            throw new RuntimeException("could not find cups");
        }

        Optional<UnitOfMeasure> pint = unitOfMeasureRepository.findByDescription("pint");
        if(!pint.isPresent()){
            throw new RuntimeException("Could not find pint");
        }

        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tablespoon.isPresent()){
            throw new RuntimeException("Could not find pint");
        }

        Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!dash.isPresent()){
            throw new RuntimeException("Could not find pint");
        }

        //get recipe categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException ("Expected category not found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe chikenTacosRecipe = new Recipe();
        chikenTacosRecipe.setDescription("Spicy grilled chicken tacos");
        chikenTacosRecipe.setPrepTime("60 mins");
        chikenTacosRecipe.setCookTime(67);
        chikenTacosRecipe.setServing(90);
        chikenTacosRecipe.setSource("Simply Recipes");
        chikenTacosRecipe.setUrl("https://www.simplyrecipes.com/");
        chikenTacosRecipe.setDirections("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");

        chikenTacosRecipe.getIngredients().add(new Ingredient("ancho chili powder",BigDecimal.valueOf(2), teaspoon.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("dried oregano",BigDecimal.valueOf(1),teaspoon.get(), chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("dried cumin",BigDecimal.valueOf(1),teaspoon.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("sugar",BigDecimal.valueOf(1),teaspoon.get(), chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("salt",BigDecimal.valueOf(0.5),teaspoon.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("garlic, finely chopped",BigDecimal.valueOf(0.5),clove.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("finely grated orange zest",BigDecimal.valueOf(1),teaspoon.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice", BigDecimal.valueOf(3),teaspoon.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("tablespoons olive oil",BigDecimal.valueOf(3),teaspoon.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)",BigDecimal.valueOf(6),piece.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("small corn tortillas",BigDecimal.valueOf(8),piece.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("packed baby arugula (3 ounces)",BigDecimal.valueOf(6),cups.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("medium ripe avocados, sliced",BigDecimal.valueOf(2),piece.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("radishes, thinly sliced",BigDecimal.valueOf(4),piece.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("cherry tomatoes, halved",BigDecimal.valueOf(0.5),pint.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("red onion, thinly sliced",BigDecimal.valueOf(.25),piece.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("Roughly chopped cilantro",BigDecimal.valueOf(1),piece.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("sour cream thinned with 1/4 cup milk",BigDecimal.valueOf(.25),cups.get(),chikenTacosRecipe));
        chikenTacosRecipe.getIngredients().add(new Ingredient("lime, cut into wedges",BigDecimal.valueOf(1),piece.get(),chikenTacosRecipe));

        chikenTacosRecipe.setDifficulty(Difficulty.EASY);
        Notes notes = new Notes();
        notes.setNote("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, " +
                "usually with a healthy dose of pickled jalapenos. " +
                "I can always sniff out a late-night snacker when the aroma of" +
                " tortillas heating in a hot pan on the stove comes wafting through the house." +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, " +
                "cumin, and sweet orange juice while the grill is heating. You can also use this time to " +
                "prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. " +
                "Now you are ready to assemble the tacos and dig in. The whole meal comes together" +
                " in about 30 minutes! The ancho chiles I use in the marinade are named for their wide shape. " +
                "They are large, have a deep reddish brown color when dried, and are mild in flavor with just a " +
                "hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: " +
                "avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. " +
                "I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some " +
                "in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                "\n" +
                "Everyone can grab a warm tortilla from the pile and make their own tacos " +
                "just they way they like them.\n" +
                "\n" +
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that’s living!");
        notes.setRecipe(chikenTacosRecipe);
        chikenTacosRecipe.setNotes(notes);

        recipes.add(chikenTacosRecipe);
        chikenTacosRecipe.getCategories().add(americanCategory);
        chikenTacosRecipe.getCategories().add(mexicanCategory);

        Recipe perfectGuacamoleRecipe = new Recipe();
        perfectGuacamoleRecipe.setDescription("Perfect Guacamole");
        perfectGuacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamoleRecipe.setSource("Simply Recipe");
        perfectGuacamoleRecipe.setServing(39);
        perfectGuacamoleRecipe.setPrepTime("20 min");
        perfectGuacamoleRecipe.setDifficulty(Difficulty.EASY);
        perfectGuacamoleRecipe.setCookTime(98);
        perfectGuacamoleRecipe.setDirections("Add to Shopping List\n" +
                "The best guacamole keeps it simple: just ripe avocados, salt, a squeeze of lime, onions, chiles, cilantro, and some chopped tomato. Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.\n" +
                "Easy guacamole served in a traditional mexican bowl\n" +
                "Photography Credit: Elise Bauer\n" +
                "Guacamole! Did you know that over 2 billion pounds of avocados are consumed each year in the U.S.? (Google it.) That’s over 7 pounds per person. I’m guessing that most of those avocados go into what has become America’s favorite dip, guacamole.\n" +
                "\n" +
                "\n" +
                "WHERE DOES GUACAMOLE COME FROM?\n" +
                "The word “guacamole”, and the dip, are both originally from Mexico, where avocados have been cultivated for thousands of years. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).\n" +
                "\n" +
                "WATCH OUR VIDEO ON HOW TO MAKE GUACAMOLE!\n" +
                "\n" +
                "Guacamole\n" +
                "Play Video\n" +
                "INGREDIENTS FOR EASY GUACAMOLE\n" +
                "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "\n" +
                "GUACAMOLE TIP: USE RIPE AVOCADOS\n" +
                "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.\n" +
                "\n" +
                "Remove the pit from the avocado with a chef knife\n" +
                "THE BEST WAY TO CUT AN AVOCADO\n" +
                "To slice open an avocado, cut it in half lengthwise with a sharp chef’s knife and twist apart the sides. One side will have the pit. To remove it, you can do one of two things:\n" +
                "\n" +
                "Method #1: Gently tap the pit with your chef’s knife so the knife gets wedged into the pit. Twist your knife slightly to dislodge the pit and lift to remove. If you use this method, first protect your hand with a thick kitchen towel before proceeding.\n" +
                "Method #2: Cut the side with the pit in half again, exposing more of the pit. Use your fingers or a spoon to remove the pit\n" +
                "Once the pit is removed, just cut the avocado into chunks right inside the peel and use a spoon to scoop them out.\n" +
                "\n" +
                "Still curious? Read more about How to Cut and Peel an Avocado\n" +
                "Homemade guacamole on a chip\n" +
                "GUACAMOLE VARIATIONS\n" +
                "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!\n" +
                "\n" +
                "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "Here are a few other guacamole recipes to try:\n" +
                "\n" +
                "Spicy Three-Chile Guacamole\n" +
                "Strawberry Guacamole\n" +
                "Guacamole with Charred Sweet Corn, Bacon, and Tomato\n" +
                "Copycat Chipotle Guacamole\n" +
                "Bacon and Blue Cheese Guacamole\n" +
                "Authentic guacamole in a bowl with chips\n" +
                "OTHER WAYS TO USE GUACAMOLE\n" +
                "Guacamole has a role in the kitchen beyond a party dip, of course. It’s great scooped on top of nachos and also makes an excellent topping or side for enchiladas, tacos, grilled salmon, or oven-baked chicken.\n" +
                "\n" +
                "Guacamole is great in foods, as well. Try mixing some guacamole into a tuna sandwich or your next batch of deviled eggs.\n" +
                "\n" +
                "HOW TO STORE GUACAMOLE\n" +
                "Guacamole is best eaten right after it’s made. Like apples, avocados start to oxidize and turn brown once they’ve been cut. That said, the acid in the lime juice you add to guacamole can help slow down that process, and if you store the guacamole properly, you can easily make it a few hours ahead if you are preparing for a party.\n" +
                "\n" +
                "The trick to keeping guacamole green is to make sure air doesn’t touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.\n" +
                "\n" +
                "You can store the guacamole in the fridge this way for up to three days.\n" +
                "\n" +
                "If you leave the guacamole exposed to air, it will start to brown and discolor. That browning isn’t very appetizing, but the guacamole is still good. You can either scrape off the brown parts and discard, or stir them into the rest of the guacamole.\n" +
                "\n" +
                "UPDATED DECEMBER 28, 2019 : We spiffed up this post to make it sparkle! No changes to the original recipe.\n" +
                "\n" +
                "Follow me on Pinterest\n" +
                " Save It Print\n" +
                "How to Make Perfect Guacamole Recipe\n" +
                "Prep time: 10 minutesYield: Serves 2-4\n" +
                "Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.\n" +
                "\n" +
                "INGREDIENTS\n" +
                "2 ripe avocados\n" +
                "1/4 teaspoon of salt, more to taste\n" +
                "1 tablespoon fresh lime juice or lemon juice\n" +
                "2 tablespoons to 1/4 cup of minced red onion or thinly sliced green onion\n" +
                "1-2 serrano chiles, stems and seeds removed, minced\n" +
                "2 tablespoons cilantro (leaves and tender stems), finely chopped\n" +
                "A dash of freshly grated black pepper\n" +
                "1/2 ripe tomato, seeds and pulp removed, chopped\n" +
                "Red radishes or jicama, to garnish\n" +
                "Tortilla chips, to serve\n" +
                "\n" +
                "\n" +
                "METHODHIDE PHOTOS\n" +
                "1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        Notes guacamoleNote = new Notes();
        guacamoleNote.setRecipe(perfectGuacamoleRecipe);
        guacamoleNote.setNote("INGREDIENTS FOR EASY GUACAMOLE\n" +
                        "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                        "\n" +
                        "GUACAMOLE TIP: USE RIPE AVOCADOS\n" +
                        "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n" +
                        "\n" +
                        "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using." +
                        "THE BEST WAY TO CUT AN AVOCADO\n" +
                        "To slice open an avocado, cut it in half lengthwise with a sharp chef’s knife and twist apart the sides. One side will have the pit. To remove it, you can do one of two things:\n" +
                        "\n" +
                        "Method #1: Gently tap the pit with your chef’s knife so the knife gets wedged into the pit. Twist your knife slightly to dislodge the pit and lift to remove. If you use this method, first protect your hand with a thick kitchen towel before proceeding.\n" +
                        "Method #2: Cut the side with the pit in half again, exposing more of the pit. Use your fingers or a spoon to remove the pit\n" +
                        "Once the pit is removed, just cut the avocado into chunks right inside the peel and use a spoon to scoop them out." +
                        "GUACAMOLE VARIATIONS\n" +
                        "Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!\n" +
                        "\n" +
                        "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.\n" +
                        "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                        "Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great." +
                "HOW TO STORE GUACAMOLE\n" +
                "Guacamole is best eaten right after it’s made. Like apples, avocados start to oxidize and turn brown once they’ve been cut. That said, the acid in the lime juice you add to guacamole can help slow down that process, and if you store the guacamole properly, you can easily make it a few hours ahead if you are preparing for a party.\n" +
                "\n" +
                "The trick to keeping guacamole green is to make sure air doesn’t touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.\n" +
                "\n" +
                "You can store the guacamole in the fridge this way for up to three days.\n" +
                "\n" +
                "If you leave the guacamole exposed to air, it will start to brown and discolor. That browning isn’t very appetizing, but the guacamole is still good. You can either scrape off the brown parts and discard, or stir them into the rest of the guacamole." +
                "");
        perfectGuacamoleRecipe.setNotes(guacamoleNote);

        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("ripe avocados",BigDecimal.valueOf(2),
                piece.get(),perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("salt, more to taste", BigDecimal.valueOf(.25),
                teaspoon.get(),perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", BigDecimal.valueOf(1.0),
                tablespoon.get(), perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("1/4 cup of minced red onion or thinly sliced green onion", BigDecimal.valueOf(2),
                tablespoon.get(), perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced",
                BigDecimal.valueOf(2),piece.get(),perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped",
                BigDecimal.valueOf(2.0),tablespoon.get(),perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("freshly grated black pepper",BigDecimal.valueOf(1.0),
                dash.get(),perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped",
                BigDecimal.valueOf(.5),piece.get(),perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("Red radishes or jicama, to garnish",BigDecimal.valueOf(2.0),
                piece.get(),perfectGuacamoleRecipe));
        perfectGuacamoleRecipe.getIngredients().add(new Ingredient("Tortilla chips, to serve", BigDecimal.valueOf(2.0),
                piece.get(),perfectGuacamoleRecipe));

        perfectGuacamoleRecipe.getCategories().add(americanCategory);
        perfectGuacamoleRecipe.getCategories().add(mexicanCategory);
        recipes.add(perfectGuacamoleRecipe);
        recipeRepository.saveAll(recipes);
    }
}

/**
 * Alexander Hum 101180821
 */

import java.util.ArrayList;
import java.util.Random;
public class Agent implements Runnable {
    private CoffeeCounter coffeeCounter;
    private ArrayList<Ingredient> ingredients;
    private static final Random ingredient = new Random();

    /**
     * constructor for the agent
     * @param coffeeCounter
     */
    public Agent(CoffeeCounter coffeeCounter) {
        this.coffeeCounter = coffeeCounter;
    }

    /**
     * gets a ingredient
     * @return Ingredient
     */
    private static Ingredient getIngredient() {
        Ingredient[] ingredients = Ingredient.values();
        return ingredients[ingredient.nextInt(ingredients.length)];
    }

    /**
     * gets two random ingredients that are not the same
     * @return ArrayList of two random ingredients
     */
    private ArrayList<Ingredient> getTwoRandomIngredients() {
        Ingredient ingredient1 = getIngredient();
        Ingredient ingredient2;
        // ensures that the two ingredients are not identical
        do {
            ingredient2 = getIngredient();
        } while(ingredient2 == ingredient1);
        ingredients = new ArrayList<Ingredient>();
        // adds both ingredients to the arraylist
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        return ingredients;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (coffeeCounter) {
                while(coffeeCounter.isCounterFull()) {
                    // kills the agent thread when the number of coffees is 20
                    if(coffeeCounter.cupCounter == 20) {
                        return;
                    }
                    try {
                        coffeeCounter.wait();
                    } catch (InterruptedException e) {}
                }
                ingredients = getTwoRandomIngredients();
                //places two random ingredients on the coffee counter
                coffeeCounter.putIngredientsOnCounter(ingredients);
                System.out.println("Agent placed " + ingredients.get(0) + " and " + ingredients.get(1));
                //tells the other threads that are waiting
                coffeeCounter.notifyAll();
            }
        }
    }
}

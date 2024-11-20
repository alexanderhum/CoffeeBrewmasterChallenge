/**
 * Alexander Hum 101180821
 */

import java.util.ArrayList;

public class CoffeeCounter {
    public int cupCounter = 0;
    private ArrayList<Ingredient> coffeeIngredients;
    private boolean counterFull;
    private boolean counterEmpty;

    /**
     * constructor for the CoffeeCounter
     */
    public CoffeeCounter() {
        coffeeIngredients = new ArrayList<Ingredient>();
        counterFull = false;
        counterEmpty = true;
    }

    /**
     * clears the ingredients from the coffee counter
     * @param ingredient
     */
    public synchronized void getIngredientsOnCounter(Ingredient ingredient) {
        coffeeIngredients.clear();
        counterFull = false;
        counterEmpty = true;
        cupCounter += 1;
        System.out.println("Coffee Number: " + cupCounter);
    }

    /**
     * adds the ingredients to the coffee counter, the coffee counter is full
     * @param ingredients
     */
    public synchronized void putIngredientsOnCounter(ArrayList<Ingredient> ingredients) {
        coffeeIngredients.addAll(ingredients);
        counterFull = true;
        counterEmpty = false;
    }

    /**
     * checks if the coffee counter is full
     * @return boolean
     */
    public boolean isCounterFull() {
        return counterFull;
    }

    /**
     * checks if the coffee counter is empty
     * @return boolean
     */
    public boolean isCounterEmpty() {
        return counterEmpty;
    }

    /**
     * gets the ingredients
     * @return ArrayList of Ingredients
     */
    public ArrayList<Ingredient> getIngredients() {
        return coffeeIngredients;
    }
}

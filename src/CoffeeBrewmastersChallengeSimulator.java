/**
 * Alexander Hum 101180821
 */

public class CoffeeBrewmastersChallengeSimulator {
    public static void main(String[] args) {
        //creates the coffee counter
        CoffeeCounter coffeeCounter = new CoffeeCounter();
        //creates all three barista thread who all have different ingredients
        Thread barista1 = new Thread(new Barista(Ingredient.WATER, coffeeCounter));
        Thread barista2 = new Thread(new Barista(Ingredient.SUGAR, coffeeCounter));
        Thread barista3 = new Thread (new Barista(Ingredient.COFFEEBEANS, coffeeCounter));
        //creates the agent thread
        Thread agent = new Thread(new Agent(coffeeCounter));

        //begins the execution for all the threads
        agent.start();
        barista1.start();
        barista2.start();
        barista3.start();
    }
}
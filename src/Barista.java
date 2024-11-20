/**
 * Alexander Hum 101180821
 */
public class Barista implements Runnable {
    private final CoffeeCounter coffeeCounter;
    private final Ingredient ingredient;

    /**
     * the constructor for Barsita
     * @param ingredient
     * @param coffeeCounter
     */
    public Barista(Ingredient ingredient, CoffeeCounter coffeeCounter) {
        this.ingredient = ingredient;
        this.coffeeCounter = coffeeCounter;
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            synchronized (coffeeCounter) {
                while(coffeeCounter.isCounterEmpty() || coffeeCounter.getIngredients().contains(ingredient)) {
                    // kills the barista thread when the number of coffees is 20
                    if(coffeeCounter.cupCounter == 20) {
                        return;
                    }
                    try {
                        coffeeCounter.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                //barista places and makes the coffee with their ingredient
                if(coffeeCounter.getIngredients().size() > 0) {
                    System.out.println("Barista placed " + ingredient);
                    coffeeCounter.getIngredientsOnCounter(ingredient);
                }
                //tells the other threads that are waiting
                coffeeCounter.notifyAll();
            }
        }
    }
}

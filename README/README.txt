#README

SYSC 3303 Assignment 1

Coffee Brewmasters Challenge

Author: Alexander Hum 101180821

Project Description:
The purpose of the following assignment is to develop a programmimng system that allows three different barista all having each different ingredients (coffeebeans, water, sugar). An agent who has an unlimted amount of suply of all three ingredients, the agent places two ingredients on the coffee counter and the barista who has the missing ingredient will make the coffee with their missing ingredient. The following system of the cycle between the agent and barista repeats until 20 coffees are made.

File Names:
Ingredient - Holds all three ingredients (coffe beans, water, sugar) for the baristas and agent to access.
CoffeeCounter - A shared resource for the Barista and Agent to use and access to be able to put and get ingredients onto the coffee counter.
Agent - Places two out of the three random ingredients onto the coffee counter when there are ingredients on the counter.
Barista - Uses the two ingredients on the counter and places its own ingredient to make the coffee. Each barista has its own differet ingredient from the rest of the baristas.
CoffeeBrewmasterChallengeSimulator - Has the main method in which the coffee system simulation begins.

Set up instructions:
  1. Unzip the assignment submission.
  2. Open up IntelliJ IDE
  3. Open up the project folder in Intellij IDE
  4. Click on "src" folder and open CoffeeBrewmastersChallengeSimulation class.
  5. Run the main method in the CoffeeBrewmastersChallengeSimulation class.
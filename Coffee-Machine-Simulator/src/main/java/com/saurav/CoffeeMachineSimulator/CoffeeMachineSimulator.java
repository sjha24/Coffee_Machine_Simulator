package com.saurav.CoffeeMachineSimulator;


import java.util.Scanner;
public class CoffeeMachineSimulator {
    Scanner scn = new Scanner(System.in);
    private static int water = 0;
    private static int milk = 0;
    private static int money = 0;
    private static  int coffeeBeans = 0;
    private static  int espressoCount = 0;
    private static int cappuccinoCount = 0;
    private static int latteCount = 0;
    private int espressoPrice = 4;
    private int lattePrice = 7;
    private int cappuccinoPrice = 6;

    public void fillIngredients(){
        System.out.println("Enter the amount of water to add: ");
        water+=scn.nextInt();
        System.out.println("Enter the amount of milk to add: ");
        milk+=scn.nextInt();
        System.out.println("Enter the amount of coffee beans to add: ");
        coffeeBeans+=scn.nextInt();

    }
    public void buyCoffee(){
        System.out.println("Enter the number corresponding to the coffee you want to buy:");
        System.out.println("1:Espresso ($" + espressoPrice + ")");
        System.out.println("2:Latte ($" + lattePrice + ")");
        System.out.println("3:Cappuccino ($" + cappuccinoPrice + ")") ;

        int coffeeChoice = scn.nextInt();

        switch (coffeeChoice){
            case 1 :
                if(hasEnoughIngredients(Espresso.getEspressoWater(),Espresso.getEspressoCoffeeBeans(),Espresso.getEspressoMilk())){
                    makeCoffee("Espresso",espressoPrice,Espresso.getEspressoWater(),Espresso.getEspressoMilk(),Espresso.getEspressoCoffeeBeans());
                    espressoCount++;
                }else{
                    System.out.println("Not Enough ingredients to make Espresso ");
                }
            break;
            case 2 :
                if(hasEnoughIngredients(Latte.getLatteWater(),Latte.getLatteMilk(),Latte.getLatteCoffeeBeans())){
                    makeCoffee("Latte",lattePrice,Latte.getLatteWater(),Latte.getLatteMilk(),Latte.getLatteCoffeeBeans());
                    latteCount++;
                }else {
                    System.out.println("Not Enough ingredients to make Latte");
                }
            break;
            case 3 :
                if(hasEnoughIngredients(Cappuccino.getCappuccinoWater(),Cappuccino.getCappuccinoMilk(),Cappuccino.getCappuccinoCoffeeBeans())){
                    makeCoffee("Cappuccino",cappuccinoPrice,Cappuccino.getCappuccinoWater(),Cappuccino.getCappuccinoMilk(),Cappuccino.getCappuccinoCoffeeBeans());
                    cappuccinoCount++;
                }else {
                    System.out.println("Not Enough ingredients to make Cappuccino ");
                }
            break;
            default:
                System.out.println("Invalid coffee choice.");
        }
    }
    public void makeCoffee(String coffeeType, int price,int waterUsed,int milkUsed ,int coffeeBeansUsed){
        System.out.println("Dispensing " + coffeeType + ". Enjoy with Coffee");
        money += price;
        water -= waterUsed;
        milk -= milkUsed;
        coffeeBeans -= coffeeBeansUsed;
    }
    public void takeMoney(){
        System.out.println("Taking $ " +money+ " from the money box.");
        money = 0;
    }
    public boolean hasEnoughIngredients(int requireWater,int requireMilk,int requireCoffeeBeans){
        return water >= requireWater && milk >= requireMilk && coffeeBeans >= requireCoffeeBeans;
    }
    public void showIngredients() {
        System.out.println("Available ingredients:");
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Coffee beans: " + coffeeBeans + " units");
        System.out.println("Money: $" + money);
    }

    public void showAnalytics() {
        System.out.println("Coffee machine analytics:");
        System.out.println("Espresso sold: " + espressoCount);
        System.out.println("Latte sold: " + latteCount);
        System.out.println("Cappuccino sold: " + cappuccinoCount);
        System.out.println("Total earnings: $" + ((espressoCount * espressoPrice) + (latteCount * lattePrice) + (cappuccinoCount * cappuccinoPrice)));
        System.out.println("Total water used: " + ((espressoCount * Espresso.getEspressoWater() + latteCount * Latte.getLatteWater() + cappuccinoCount * Cappuccino.getCappuccinoWater())) + " ml");
        System.out.println("Total milk used: " + (latteCount * Latte.getLatteMilk() + cappuccinoCount * Cappuccino.getCappuccinoMilk()) + " ml");
        System.out.println("Total coffee beans used: " + (espressoCount * Espresso.getEspressoCoffeeBeans() + latteCount * Latte.getLatteCoffeeBeans() + cappuccinoCount * Cappuccino.getCappuccinoCoffeeBeans()) + " units");
    }

}


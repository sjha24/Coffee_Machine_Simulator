package com.saurav.CoffeeMachineSimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CoffeeMachineSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeMachineSimulatorApplication.class, args);

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("Select an action: (1:buy, 2:fill, 3:takeMoney, 4:showDetails, 5:analytics, 6:exit)");
			System.out.println("Press 1 to buy coffee");
			System.out.println("Press 2 to fill ingredients");
			System.out.println("Press 3 to take money from money box");
			System.out.println("Press 4 to show available ingredients");
			System.out.println("Press 5 to show analysis of coffee simulator");
			System.out.println("Press 6 to exit");

			int action = scn.nextInt();
			CoffeeMachineSimulator coffeeMachineSimulator = new CoffeeMachineSimulator();
			switch (action) {
				case 1:
					coffeeMachineSimulator.buyCoffee();
					break;
				case 2:
					coffeeMachineSimulator.fillIngredients();
					break;
				case 3:
					coffeeMachineSimulator.takeMoney();
					break;
				case 4:
					coffeeMachineSimulator.showIngredients();
					break;
				case 5:
					coffeeMachineSimulator.showAnalytics();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid action. Please try again.");
			}
		}
	}
}

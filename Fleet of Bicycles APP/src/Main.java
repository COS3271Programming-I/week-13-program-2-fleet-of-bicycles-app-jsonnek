// Jonathan Sonnek
// 1 May 2026
// Fleet of Bicycles APP

import java.util.Scanner;

class Bicycle {
    // the Bicycle class has five fields
    public int cadence, gear, speed;
    String owner, type;
    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear, String startType, String startOwner) {
        this.gear = startGear;
        this.cadence = startCadence;
        this.speed = startSpeed;
        this.type = startType;
        this.owner = startOwner;
    }
    // the Bicycle class has a method to print information
    public String getInfo (){
        String message;
        message = this.owner + " owns this " + this.type + " bicycle.";
        message += "\nCurrently we are in gear "+ this.gear + " and going " + this.speed + " MPH.";
        message += "\nThe cadence is " + this.cadence + " RPM.";
        return message;
    }
}

public class Main {
    static Scanner userinput = new Scanner(System.in);
    public static void main (String[] args)
    {
        int numBikes;
        do {
            System.out.println("How many bicycles would you like to enter? (1-6)");
            numBikes = userinput.nextInt();
            userinput.nextLine();
        } while (numBikes < 1 || numBikes > 6);

        Bicycle[] bikes = new Bicycle[numBikes];

        int cadence, gear, speed;
        String name, type;
        for (int i = 0; i < numBikes; i++) {
            System.out.println("\n--- Bicycle " + (i + 1) + " ---");

            System.out.println("Enter the cadence of the bicycle: ");
            cadence = userinput.nextInt();
            userinput.nextLine();
            System.out.println("Enter the gear of the bicycle: ");
            gear = userinput.nextInt();
            userinput.nextLine();
            System.out.println("Enter the average speed of the bicycle: ");
            speed = userinput.nextInt();
            userinput.nextLine();
            System.out.println("Enter the type of the bicycle: ");
            type = userinput.nextLine();
            System.out.println("Enter your name: ");
            name = userinput.nextLine();

            bikes[i] = new Bicycle(cadence, speed, gear, type, name);  // create and store immediately
        }

        System.out.println("\n--- Your Bicycles ---");
        for (int i = 0; i < bikes.length; i++) {
            System.out.println("\nBicycle " + (i + 1) + ":");
            System.out.println(bikes[i].getInfo());
        }

        // Calorie Burn calculator
        System.out.println("Would you like to calculate the number of calories you burned? (y/n)");
        String answer = userinput.nextLine();
        if (answer.equalsIgnoreCase("y")) {

            // Let user pick a bike
            int bikeChoice;
            do {
                System.out.println("Which bike did you ride? (1-" + numBikes + ")");
                bikeChoice = userinput.nextInt();
                userinput.nextLine();
            } while (bikeChoice < 1 || bikeChoice > numBikes);

            // Pull speed from the selected bike
            speed = bikes[bikeChoice - 1].speed;

            // Get user data for calorie calculation
            System.out.println("Please enter your weight (lbs): ");
            double weight = userinput.nextDouble();
            userinput.nextLine();
            System.out.println("Please enter your height (in): ");
            double height = userinput.nextDouble();
            userinput.nextLine();
            System.out.println("Please enter your age (years):");
            int age = userinput.nextInt();
            userinput.nextLine();
            System.out.println("How long did you ride the bicycle? (hr)");
            double time = userinput.nextDouble();
            userinput.nextLine();
            System.out.println("Enter your biological sex (m/f): ");
            String sex = userinput.nextLine();

            // Determine MET value based on bike speed
            double met;
            if (speed < 10) {
                met = 4.0;
            }
            else if (speed < 12) {
                met = 6.0;
            }
            else if (speed < 14) {
                met = 8.0;
            }
            else if (speed < 16) {
                met = 10.0;
            }
            else {
                met = 12.0;
            }

            // Determine BMR based on biological sex
            double bmr;
            if (sex.equalsIgnoreCase("m")) {
                bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
            }
            else {
                bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
            }

            // Calculate Calories burned
            double hourlyBurn = bmr / 24;
            double calories = hourlyBurn * met * time;

            System.out.printf("You burned approximately %.1f calories!%n", calories);
            System.out.println("Thank you for using the Bicycle APP!");
        }
        else {
            System.out.println("Thank you for using the Bicycle APP!");

        }
    }
}
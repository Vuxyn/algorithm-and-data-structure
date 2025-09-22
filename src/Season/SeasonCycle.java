package Season;

import java.util.Scanner;

public class SeasonCycle {
    static Cycle cycle = new Cycle();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSeasons();
        System.out.println("🌸 Welcome to Season Cycle Manager 🌸");

        boolean running = true;
        while(running) {
            displayMenu();
            int choice = getIntInput("Choose your option: ");

            switch(choice) {
                case 1: addSeason(); break;
                case 2: removeSeason(); break;
                case 3: nextSeason(); break;
                case 4: prevSeason(); break;
                case 5: autoCycleDemo(); break;
                case 0:
                    System.out.println("🌅 Goodbye! Enjoy all seasons!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("🌸 SEASON CYCLE MENU:");
        System.out.println("1. Add New Season");
        System.out.println("2. Remove Season");
        System.out.println("3. Next Season");
        System.out.println("4. Previous Season");
        System.out.println("5. Auto Cycle Demo");
        System.out.println("0. Exit");
        System.out.println("=".repeat(40));
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Enter valid number!");
            }
        }
    }

    private static void initializeSeasons() {
        cycle.addItem(new Season("Spring", 15, 3, "Mild and rainy", "Planting flowers"));
        cycle.addItem(new Season("Summer", 25, 3, "Hot and sunny", "Beach vacation"));
        cycle.addItem(new Season("Autumn", 10, 3, "Cool and windy", "Leaf watching"));
        cycle.addItem(new Season("Winter", -5, 3, "Cold and snowy", "Skiing"));
        
        System.out.println("✅ Basic seasons initialized!");
    }

    private static void autoCycleDemo() {
        if (cycle.isEmpty()) {
            System.out.println("❌ Cycle is empty!");
            return;
        }
        
        int steps = getIntInput("Number of steps: ");
        cycle.autoCycle(steps);
    }

    private static void nextSeason() {
        cycle.moveNext();
        SeasonItem current = cycle.getCurrentItem();
        if (current != null) {
            System.out.println("▶️ Moved to: " + current.getName());
        }
    }
    
    private static void prevSeason() {
        cycle.movePrevious();
        SeasonItem current = cycle.getCurrentItem();
        if (current != null) {
            System.out.println("◀️ Moved to: " + current.getName());
        }
    }

    private static void removeSeason() {
        if (cycle.isEmpty()) {
            System.out.println("❌ Cycle is empty!");
            return;
        }
        
        System.out.print("Enter name to remove: ");
        String name = scanner.nextLine();
        cycle.removeItem(name);
    }

    private static void addSeason() {
        System.out.println("\n=== ADD SEASON ===");
        System.out.print("Season name: ");
        String name = scanner.nextLine();
        
        int temperature = getIntInput("Average temperature (°C): ");
        int duration = getIntInput("Duration (months): ");
        
        System.out.print("Weather description: ");
        String weather = scanner.nextLine();
        
        System.out.print("Best activity: ");
        String activity = scanner.nextLine();
        
        Season season = new Season(name, temperature, duration, weather, activity);
        cycle.addItem(season);
    }
}

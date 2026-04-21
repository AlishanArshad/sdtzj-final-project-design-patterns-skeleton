package inventory;

import java.util.Scanner;

public class Main {

    private static InventoryManager manager;
    private static Scanner scanner;

    public static void main(String[] args) {

        manager = new InventoryManager();
        scanner = new Scanner(System.in);

        loadSampleData();

        boolean running = true;

        System.out.println("Welcome to Inventory Management System!");

        while (running) {
            showMenu();
            int choice = getChoice();
            running = handleChoice(choice);
        }

        System.out.println("Exiting... Goodbye!");
        scanner.close();
    }

    private static void loadSampleData() {
        manager.addProduct("B001", "Java Programming", "BOOK", 29.99, 10);
        manager.addProduct("B002", "Design Patterns", "BOOK", 35.50, 8);
        manager.addProduct("E001", "Laptop", "ELECTRONICS", 999.99, 5);
        manager.addProduct("E002", "Mouse", "ELECTRONICS", 25.99, 15);
    }

    private static void showMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Add Product");
        System.out.println("2. View Inventory");
        System.out.println("3. Sell Product");
        System.out.println("4. Add Stock");
        System.out.println("5. View Statistics");
        System.out.println("6. Exit");
    }

    private static int getChoice() {
        while (true) {
            try {
                System.out.print("Enter choice (1-6): ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= 1 && choice <= 6) {
                    return choice;
                } else {
                    System.out.println("Please enter a number between 1 and 6.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    private static boolean handleChoice(int choice) {

        switch (choice) {
            case 1:
                addProduct();
                break;

            case 2:
                manager.viewInventory();
                break;

            case 3:
                sellProduct();
                break;

            case 4:
                addStock();
                break;

            case 5:
                manager.viewStatistics();
                break;

            case 6:
                return false;

            default:
                System.out.println("Invalid choice.");
        }

        return true;
    }

    private static void addProduct() {
        String id = getStringInput("Enter Product ID: ");
        String name = getStringInput("Enter Product Name: ");
        String type = getStringInput("Enter Type (BOOK/ELECTRONICS): ");
        double price = getDoubleInput("Enter Price: ");
        int quantity = getIntInput("Enter Quantity: ");

        manager.addProduct(id, name, type, price, quantity);
        System.out.println("Product added successfully!");
    }

    private static void sellProduct() {
        String id = getStringInput("Enter Product ID: ");
        int quantity = getIntInput("Enter Quantity to Sell: ");

//        manager.sellProduct(id, quantity,);
    }

    private static void addStock() {
        String id = getStringInput("Enter Product ID: ");
        int quantity = getIntInput("Enter Quantity to Add: ");

        manager.addStock(id, quantity);
    }

    // ---------- Helper Methods ----------

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
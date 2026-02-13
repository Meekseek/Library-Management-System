import java.util.ArrayList;
import java.util.Scanner;

/**
 * Library Management System
 * A console-based application to manage book inventory, borrowing, and returns.
 * Demonstrates Java Collections, Input Validation, and OOP principles.
 */
public class Main {
    
    // Shared storage for our book collection
    static ArrayList<Book> library = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main Application Loop
        while (running) {
            System.out.println("\n===== Book Management System =====");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addBook(scanner); break;
                case "2": borrowBook(scanner); break;
                case "3": returnBook(scanner); break;
                case "4": viewInventory(); break;
                case "5": 
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid Option. Please Try Again.");
            }
        }
        scanner.close();
    }

    /**
     * Adds a new book or updates the stock of an existing book.
     * Includes validation for positive integers.
     */
    public static void addBook(Scanner scanner) {
        try {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine().trim();
            
            System.out.print("Enter author name: ");
            String author = scanner.nextLine().trim();
            
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            
            if (quantity <= 0) {
                System.out.println("Error: Quantity must be greater than zero.");
                return;
            }

            // Check if book exists
            for (Book book : library) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    book.setQuantity(book.getQuantity() + quantity);
                    System.out.println("Updated existing stock. New Quantity: " + book.getQuantity());
                    return;
                }
            }

            // Add new book if not found
            library.add(new Book(title, author, quantity));
            System.out.println("New book added to library.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid number for quantity.");
        }
    }

    /**
     * Handles the borrowing logic, ensuring stock does not go negative.
     */
    public static void borrowBook(Scanner scanner) {
        try {
            System.out.print("Enter book title to borrow: ");
            String title = scanner.nextLine().trim();
            
            System.out.print("Enter number of books to borrow: ");
            int amountToBorrow = Integer.parseInt(scanner.nextLine());

            for (Book book : library) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    if (book.getQuantity() >= amountToBorrow) {
                        book.setQuantity(book.getQuantity() - amountToBorrow);
                        System.out.println("Successfully borrowed " + amountToBorrow + " copy(ies).");
                    } else {
                        System.out.println("Transaction failed. Only " + book.getQuantity() + " available.");
                    }
                    return;
                }
            }
            System.out.println("Book not found.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
        }
    }

    /**
     * Handles return logic to restock inventory.
     */
    public static void returnBook(Scanner scanner) {
        try {
            System.out.print("Enter book title to return: ");
            String title = scanner.nextLine().trim();
            
            System.out.print("Enter number of books to return: ");
            int amountToReturn = Integer.parseInt(scanner.nextLine());

            if (amountToReturn <= 0) {
                System.out.println("Invalid return amount.");
                return;
            }

            for (Book book : library) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    book.setQuantity(book.getQuantity() + amountToReturn);
                    System.out.println("Return successful.");
                    return;
                }
            }
            System.out.println("This book does not belong to our library records.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid number.");
        }
    }

    public static void viewInventory() {
        if (library.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }
        System.out.println("\n--- Current Inventory ---");
        for (Book book : library) {
            System.out.printf("Title: %-20s | Author: %-20s | Stock: %d%n", 
                              book.getTitle(), book.getAuthor(), book.getQuantity());
        }
        System.out.println("-------------------------");
    }
}

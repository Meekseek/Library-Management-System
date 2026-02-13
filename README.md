# Java Library Management System 📚

A console-based application designed to manage book inventory, facilitate borrowing, and track returns. This project demonstrates core Java fundamentals, including **Object-Oriented Programming (OOP)**, **Collection Frameworks**, and **Input Validation**.

## 🚀 Features
* **Dynamic Inventory:** Uses `ArrayList` to allow the library to grow indefinitely without fixed array limits.
* **Stock Management:** Automatically updates quantities when adding existing books or returning items.
* **Input Validation:** Robust error handling (`try-catch` blocks) prevents crashes when non-numeric data is entered.
* **User Interface:** Clean CLI (Command Line Interface) menu for easy navigation.

## 🛠️ Technical Highlights
| Concept | Implementation |
| :--- | :--- |
| **Encapsulation** | `Book` class uses private fields with public getters/setters to protect data integrity. |
| **Collections** | `ArrayList<Book>` is used for dynamic storage management. |
| **Control Flow** | `Switch-Case` logic drives the main application menu. |
| **Error Handling** | `NumberFormatException` handling ensures the app doesn't crash on bad user input. |

## 💻 How to Run
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Meekseek/Library-Management-System.git](https://github.com/Meekseek/Library-Management-System.git)
    ```
2.  **Navigate to the source folder:**
    ```bash
    cd src
    ```
3.  **Compile and Run:**
    ```bash
    javac Main.java Book.java
    java Main
    ```

## 🔮 Future Improvements
* **File I/O:** Implement logic to save the inventory to a `.txt` or `.csv` file so data persists after the program closes.
* **Search Functionality:** Add a method to search for books by Author name.

---
*Created by Jeremy Schoenick as part of the Computer Science curriculum at University of the People.*

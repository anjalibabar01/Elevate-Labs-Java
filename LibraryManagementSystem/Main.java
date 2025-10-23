package LibraryManagementSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some sample data
        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        library.addUser(new User(101, "Anjali"));
        library.addUser(new User(102, "Rohan"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== 📚 Library Menu =====");
            System.out.println("1. Show all books");
            System.out.println("2. Issue book");
            System.out.println("3. Return book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.showAllBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.issueBook(bookId, userId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    System.out.println("👋 Exiting Library System...");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}

package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("❌ Book not found!");
        } else if (user == null) {
            System.out.println("❌ User not found!");
        } else if (book.isIssued()) {
            System.out.println("⚠️ Book already issued!");
        } else {
            book.issueBook();
            System.out.println("✅ Book '" + book.getTitle() + "' issued to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("❌ Book not found!");
        } else if (!book.isIssued()) {
            System.out.println("⚠️ Book is not issued!");
        } else {
            book.returnBook();
            System.out.println("✅ Book '" + book.getTitle() + "' returned successfully.");
        }
    }

    public void showAllBooks() {
        System.out.println("\n📚 Book List:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    private User findUserById(int id) {
        for (User user : users) {
            if (user.getUserId() == id) return user;
        }
        return null;
    }
}

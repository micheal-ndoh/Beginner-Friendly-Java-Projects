
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.library.services.BookManager;

class BookManagerTest {

    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
    }

    @Test
    void testAddBook() {
        String input = "Test Title\nTest Author\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        bookManager.addBook(scanner);
        assertEquals(1, bookManager.books.size());
        assertEquals("Test Title", bookManager.books.get(1).getTitle());
        assertEquals("Test Author", bookManager.books.get(1).getAuthor());
    }

    @Test
    void testRemoveBook() {
        String input = "Test Title\nTest Author\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        bookManager.addBook(scanner);

        String removeInput = "1\n";
        Scanner removeScanner = new Scanner(new ByteArrayInputStream(removeInput.getBytes()));
        bookManager.removeBook(removeScanner);

        assertEquals(0, bookManager.books.size());
    }

    @Test
    void testSearchBookFound() {
        String input = "Test Title\nTest Author\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        bookManager.addBook(scanner);

        String searchInput = "1\n";
        Scanner searchScanner = new Scanner(new ByteArrayInputStream(searchInput.getBytes()));
        assertDoesNotThrow(() -> bookManager.searchBook(searchScanner));
    }

    @Test
    void testBorrowAndReturnBook() {
        String input = "Test Title\nTest Author\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        bookManager.addBook(scanner);

        String borrowInput = "1\n";
        Scanner borrowScanner = new Scanner(new ByteArrayInputStream(borrowInput.getBytes()));
        bookManager.borrowBook(borrowScanner);
        assertTrue(bookManager.books.get(1).isBorrowed());

        String returnInput = "1\n";
        Scanner returnScanner = new Scanner(new ByteArrayInputStream(returnInput.getBytes()));
        bookManager.returnBook(returnScanner);
        assertFalse(bookManager.books.get(1).isBorrowed());
    }

    @Test
    void testRemoveBookReassignsIds() {
        // Add three books
        String input = "Book1\nAuthor1\nBook2\nAuthor2\nBook3\nAuthor3\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        bookManager.addBook(scanner);
        bookManager.addBook(scanner);
        bookManager.addBook(scanner);

        // Remove book with ID 2
        String removeInput = "2\n";
        Scanner removeScanner = new Scanner(new ByteArrayInputStream(removeInput.getBytes()));
        bookManager.removeBook(removeScanner);

        // After removal, IDs should be 1 and 2, and titles should be Book1 and Book3
        assertEquals(2, bookManager.books.size());
        assertEquals("Book1", bookManager.books.get(1).getTitle());
        assertEquals("Book3", bookManager.books.get(2).getTitle());
    }
}

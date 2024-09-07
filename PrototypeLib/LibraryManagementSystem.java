/* Name: Bj S. Camporedondo   Course: BSCS-2B
 * Date: 09/06/2024
 * 
 * This code is a Library Management System that uses encapsulation to store arrays of data in a private
 * storage that cannot be acces on the Main class. It gets the user input options of adding a book with its user details
 * (Title, Author, ISBN, Available copies), borrowing a book, returning a book, showing the book details in
 * the library where in the arrays of data are stored and last is exiting the program. */
 
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
   private static ArrayList<Book> books = new ArrayList<>();
   private static Scanner scn = new Scanner(System.in);
   
   public static void main(String[] args) {
      boolean exit = false;
      
      while (!exit) {
         System.out.println("\nLibrary Management System\n[1] Add Book\n[2] Borrow Book\n[3] Return Book\n[4] Show Book Details\n[5] Exit");
         int choice = getValidInteger("\nEnter your choice: ");
      
         switch (choice) {
            case 1:
               addBook();
               break;
            case 2:
               borrowBook();
               break;
            case 3:
               returnBook();
               break;
            case 4:
               showBookDetails();
               break;
            case 5:
               exit = true;
               System.out.println("Exiting the Library Management System.");
               break;
            default:
               System.out.println("Invalid choice. Please try again.");
         }
      }
   }
   private static void addBook() {
      String isbn;
      
      System.out.print("Enter book title: ");
      String title = scn.nextLine();
      System.out.print("Enter book author: ");
      String author = scn.nextLine();
      while (true) {
         System.out.print("Enter book ISBN: ");
         isbn = scn.nextLine();
            
         if (isNumeric(isbn)) 
            break;
         else 
            System.out.println("Invalid ISBN. Please enter numeric characters only.");
      }
      for (Book book : books) {
         if (book.getIsbn().equals(isbn)) {
            System.out.println("A book with this ISBN already exists. Cannot add duplicate ISBN.");
            return;
         }
      }
   
      int copies = getValidInteger("Enter number of copies: ");
     
      Book book = new Book(title, author, isbn, copies);
      books.add(book);
      System.out.println("Book added successfully!");
   }
   private static void borrowBook() {
      System.out.print("Enter book ISBN to borrow: ");
      String isbn = scn.nextLine();
      
      for (Book book : books) {
         if (book.getIsbn().equals(isbn)) {
            if (book.borrowBook()) 
               System.out.println("Successfully borrowed the book.");
            else 
               System.out.println("No copies available. For more information, please check the Book Details [4].");
            return;
         }
      }
      System.out.println("Book not found. For more information, please check the Book Details [4].");
   }
   private static void returnBook() {
      System.out.print("Enter book ISBN to return: ");
      String isbn = scn.nextLine();
      
      for (Book book : books) {
         if (book.getIsbn().equals(isbn)) {
            if (book.returnBook()) {
               System.out.println("Book returned.");
            } else {
               System.out.println("All copies are already returned. Cannot return the book.");
            }
            return;
         }
      }
      System.out.println("Book not found. For more information, please check the Book Details [4].");
   }      
   private static void showBookDetails() {
      if (books.isEmpty()) {
         System.out.println("No books available in the system. Type [1] to add a book.");
         return;
      }
   
      System.out.println("\nAll Books in the Library:");
      System.out.printf("%-20s %-20s %-15s %-15s\n", "Title", "Author", "ISBN", "Available Copies");
      System.out.println("-------------------------------------------------------------------------------");
   
      for (Book book : books) 
         System.out.printf("%-20s %-20s %-15s %-15d\n", book.getTitle(), book.getAuthor(), book.getIsbn(), book.getAvailableCopies());
   }
   private static boolean isNumeric(String str) {
      return str != null && str.matches("\\d+");
   }
   private static int getValidInteger(String prompt) {
      int number;
      while (true) {
         System.out.print(prompt);
         if (scn.hasNextInt()) {
            number = scn.nextInt(); 
            scn.nextLine();
            break;
         } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            scn.next();
         }
      }
      return number;
   }
}
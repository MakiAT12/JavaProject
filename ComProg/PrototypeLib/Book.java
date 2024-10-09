class Book {
   private String title;
   private String author;
   private String isbn;
   private int availableCopies;
   private int totalCopies;

   public Book(String title, String author, String isbn, int copies) {
      this.title = title;
      this.author = author;
      this.isbn = isbn;
      this.availableCopies = copies;
      this.totalCopies = copies;
   }
   public String getTitle() {
      return title;
   }
   public String getAuthor() {
      return author;
   }
   public String getIsbn() {
      return isbn;
   }
   public int getAvailableCopies() {
      return availableCopies;
   }
   public boolean borrowBook() {
      if (availableCopies > 0) {
         availableCopies--;
         return true;
      } 
      else 
         return false;
   }
   public boolean returnBook() {
      if (availableCopies < totalCopies) {
         availableCopies++;
         return true; 
      } 
      else 
         return false;
   }    
}
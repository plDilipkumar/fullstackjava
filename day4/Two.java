class Book {
  private String title;
  private String author;
  private String isbn;
  private int copies;

  public Book(String title, String author, String isbn, int copies) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.copies = copies;
  }

  public String getTitle() {
    return title;
  }

  public boolean isAvailable() {
    return copies > 0;
  }

  public void borrowBook() {
    if (copies > 0) {
      copies--;
      System.out.println(title + " borrowed successfully.");
    } else {
      System.out.println(title + " is not available.");
    }
  }

  public void returnBook() {
    copies++;
    System.out.println(title + " returned successfully.");
  }

  public void display() {
    System.out.println("Title: " + title + ", Author: " + author +
        ", ISBN: " + isbn + ", Available copies: " + copies);
  }
}

class Library {
  private Book[] books;
  private int count;

  public Library(int size) {
    books = new Book[size];
    count = 0;
  }

  public void addBook(Book b) {
    if (count < books.length) {
      books[count++] = b;
      System.out.println(b.getTitle() + " added to library.");
    } else {
      System.out.println("Library is full. Cannot add more books.");
    }
  }

  public void showAllBooks() {
    System.out.println("Books in Library:");
    for (int i = 0; i < count; i++) {
      books[i].display();
    }
  }

  public void borrowBook(String title) {
    for (int i = 0; i < count; i++) {
      if (books[i].getTitle().equalsIgnoreCase(title)) {
        books[i].borrowBook();
        return;
      }
    }
    System.out.println("Book not found.");
  }

  public void returnBook(String title) {
    for (int i = 0; i < count; i++) {
      if (books[i].getTitle().equalsIgnoreCase(title)) {
        books[i].returnBook();
        return;
      }
    }
    System.out.println("Book not found.");
  }
}

class Main {
  public static void main(String[] args) {
    Library lib = new Library(5);

    Book b1 = new Book("Java Basics", "James Gosling", "ISBN001", 2);
    Book b2 = new Book("Python Crash Course", "Eric Matthes", "ISBN002", 1);
    Book b3 = new Book("Data Structures", "Narasimha Karumanchi", "ISBN003", 3);

    lib.addBook(b1);
    lib.addBook(b2);
    lib.addBook(b3);

    lib.showAllBooks();

    lib.borrowBook("Java Basics");
    lib.borrowBook("Java Basics");
    lib.borrowBook("Java Basics"); // no copies left

    lib.returnBook("Java Basics");

    lib.showAllBooks();
  }
}

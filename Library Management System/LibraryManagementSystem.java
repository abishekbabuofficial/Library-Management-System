import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String bookid;
    private int copiesAvailable;

    public Book(String title, String author, String bookid, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.bookid = bookid;
        this.copiesAvailable = copiesAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getbookid() {
        return bookid;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void issueBook() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book out of stock.");
        }
    }

    public void returnBook() {
        copiesAvailable++;
        System.out.println("Book returned successfully.");
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n Author: " + author + "\n Book Id: " + bookid + "\n Copies Available: " + copiesAvailable+"\n";
    }
}

class Member {
    private String name;
    private String memberId;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nMember ID: " + memberId + "\n";
    }
}

class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added successfully.");
    }

    public void issueBook(String bookid, String memberId) {
        Book book = findBookBybookid(bookid);
        if (book != null) {
            book.issueBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String bookid) {
        Book book = findBookBybookid(bookid);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void listBooks() {
        int counter = 1;
        System.out.println("Books in the Library:");
        
        for (Book book : books) {
            System.out.println("Book " + counter);
            System.out.println(book);
            counter+=1;
        }
        
    }

    public void listMembers() {
        System.out.println("Library Members:");
        int counter = 1;
        for (Member member : members) {
            System.out.println("Member " + counter);
            System.out.println(member);
            counter+=1;
        }
    }

    private Book findBookBybookid(String bookid) {
        for (Book book : books) {
            if (book.getbookid().equals(bookid)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. List Members");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book bookid: ");
                    String bookid = scanner.nextLine();
                    System.out.print("Enter number of copies: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.addBook(new Book(title, author, bookid, copies));
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    library.addMember(new Member(name, memberId));
                    break;
                case 3:
                    System.out.print("Enter book bookid to issue: ");
                    String bookidIssue = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    String memberIdIssue = scanner.nextLine();
                    library.issueBook(bookidIssue, memberIdIssue);
                    break;
                case 4:
                    System.out.print("Enter book bookid to return: ");
                    String bookidReturn = scanner.nextLine();
                    library.returnBook(bookidReturn);
                    break;
                case 5:
                    library.listBooks();
                    break;
                case 6:
                    library.listMembers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

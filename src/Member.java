public class Member extends User {
    public Member(String name) {
        super(name);
    }

    public void searchBook(Library library, String title) {
        Book book = library.findBookByTitle(title);
        if (book != null) {
            System.out.println("Buku ditemukan: " + book);
        } else {
            System.out.println("Buku tidak ditemukan: " + title);
        }
    }public void borrowBook(Library library, String title) {
    Book book = library.findBookByTitle(title);
    if (book != null) {
        if (book.isAvailable()) {
            book.borrow();   
            library.logActivity("MEMBER " + name + " meminjam buku: " + title);
            library.saveBooks(); 
        } else {
            System.out.println("Buku sedang habis: " + title);
        }
    } else {
        System.out.println("Buku tidak ditemukan: " + title);
    }
}

public void returnBook(Library library, String title) {
    Book book = library.findBookByTitle(title);
    if (book != null) {
        book.returnBook(); 
        library.logActivity("MEMBER " + name + " mengembalikan buku: " + title);
        library.saveBooks(); 
    } else {
        System.out.println("Buku tidak ditemukan: " + title);
    }
}

    @Override
    public void displayInfo() {
        System.out.println("Member: " + name);
    }
}

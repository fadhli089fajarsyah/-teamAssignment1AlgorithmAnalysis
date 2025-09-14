public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    public void addBook(Library library, String title, String author, int stock) {
        library.addBook(title, author, stock, name);
    }

    public void removeBook(Library library, String title) {
        library.removeBook(title);
    }

    public void searchBook(Library library, String title) {
        Book book = library.findBookByTitle(title);
        if (book != null) {
            System.out.println("Buku ditemukan: " + book);
        } else {
            System.out.println("Buku tidak ditemukan: " + title);
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin: " + name);
    }
}

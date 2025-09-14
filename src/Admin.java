public class Admin extends User {

    public Admin(String name) {
        super(name);
    }

    public void addBook(
        Library library,
        String title,
        String author,
        int stock
    ) {
        library.addBook(title, author, stock, name);
    }

    public void removeBook(Library library, String title) {
        library.removeBook(title);
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin: " + name);
    }
}

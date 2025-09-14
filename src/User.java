public class User {

    protected String name;

    public User(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Nama User: " + name);
    }

    public void searchBook(Library library, String title) {
        Book book = library.findBookByTitle(title);
        if (book != null) {
            System.out.println("Buku ditemukan: " + book);
        } else {
            System.out.println("Buku tidak ditemukan: " + title);
        }
    }
}

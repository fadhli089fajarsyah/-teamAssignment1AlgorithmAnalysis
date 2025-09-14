import java.util.Scanner;

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

    @Override
    public void displayInfo() {
        System.out.println("Admin: " + name);
    }

    @Override
    public void interact(Library library, Scanner sc) {
        while (true) {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String title = sc.nextLine();
                    System.out.print("Masukkan pengarang: ");
                    String author = sc.nextLine();
                    System.out.print("Masukkan stok buku: ");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    addBook(library, title, author, stock);
                    break;
                case 2:
                    System.out.print("Masukkan judul buku: ");
                    String removeTitle = sc.nextLine();
                    removeBook(library, removeTitle);
                    break;
                case 3:
                    System.out.print("Masukkan judul buku: ");
                    String searchTitle = sc.nextLine();
                    searchBook(library, searchTitle);
                    break;
                case 4:
                    library.showAllBooks();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
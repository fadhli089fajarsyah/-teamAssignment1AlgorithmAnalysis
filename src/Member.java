import java.util.Scanner;

public class Member extends User {
    public Member(String name) {
        super(name);
    }

    public void borrowBook(Library library, String title) {
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

    @Override
    public void interact(Library library, Scanner sc) {
        while (true) {
            System.out.println("\n--- MENU MEMBER ---");
            System.out.println("1. Cari Buku");
            System.out.println("2. Lihat Buku Tersedia");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String searchTitle = sc.nextLine();
                    searchBook(library, searchTitle);
                    break;
                case 2:
                    library.showAvailableBooks();
                    break;
                case 3:
                    System.out.print("Masukkan judul buku: ");
                    String borrowTitle = sc.nextLine();
                    borrowBook(library, borrowTitle);
                    break;
                case 4:
                    System.out.print("Masukkan judul buku: ");
                    String returnTitle = sc.nextLine();
                    returnBook(library, returnTitle);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
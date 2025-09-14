import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEM PERPUSTAKAAN ===");

        while (true) {
            System.out.print(
                "\nMasukkan nama user (Admin: adminGroup2 / Member: memberGroup2, 0 untuk keluar): "
            );
            String name = sc.nextLine();

            if (name.equals("0")) {
                System.out.println("Terima kasih telah menggunakan sistem!");
                break;
            }

            User user;
            if (name.equals("adminGroup2")) {
                user = new Admin(name);
            } else if (name.equals("memberGroup2")) {
                user = new Member(name);
            } else {
                System.out.println("Nama user tidak valid!");
                continue;
            }

            user.interact(library, sc);
        }

        sc.close();
    }

    public static void adminMenu(Admin admin, Library library, Scanner sc) {
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
                    admin.addBook(library, title, author, stock);
                    break;
                case 2:
                    System.out.print("Masukkan judul buku: ");
                    String removeTitle = sc.nextLine();
                    admin.removeBook(library, removeTitle);
                    break;
                case 3:
                    System.out.print("Masukkan judul buku: ");
                    String searchTitle = sc.nextLine();
                    admin.searchBook(library, searchTitle);
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

    public static void memberMenu(Member member, Library library, Scanner sc) {
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
                    member.searchBook(library, searchTitle);
                    break;
                case 2:
                    library.showAvailableBooks();
                    break;
                case 3:
                    System.out.print("Masukkan judul buku: ");
                    String borrowTitle = sc.nextLine();
                    member.borrowBook(library, borrowTitle);
                    break;
                case 4:
                    System.out.print("Masukkan judul buku: ");
                    String returnTitle = sc.nextLine();
                    member.returnBook(library, returnTitle);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}

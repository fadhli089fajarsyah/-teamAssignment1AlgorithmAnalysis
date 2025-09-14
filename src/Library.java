import java.io.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(String title, String author, int stock, String adminName) {
        books.add(new Book(title, author, stock));
        System.out.println("Buku berhasil ditambahkan: " + title + " | Stok: " + stock);
        logActivity("ADMIN " + adminName + " menambahkan buku: " + title + " | Stok: " + stock);
        saveBooks();
    }

    public void removeBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            books.remove(book);
            System.out.println("Buku berhasil dihapus: " + title);
            logActivity("Buku dihapus: " + title);
            saveBooks();
        } else {
            System.out.println("Buku tidak ditemukan: " + title);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Belum ada buku di perpustakaan.");
        } else {
            System.out.println("=== Semua Buku ===");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void showAvailableBooks() {
        boolean anyAvailable = false;
        System.out.println("=== Buku Tersedia ===");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("Tidak ada buku tersedia.");
        }
    }

    private void loadBooks() {
        try {
            File file = new File("books.txt");
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

    public void saveBooks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                bw.write(book.getTitle() + ";" + book.getAuthor() + ";" + book.getStock());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan buku: " + e.getMessage());
        }
    }

    public void logActivity(String message) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("activity.txt", true))) {
            bw.write(message);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Gagal mencatat aktivitas: " + e.getMessage());
        }
    }
}

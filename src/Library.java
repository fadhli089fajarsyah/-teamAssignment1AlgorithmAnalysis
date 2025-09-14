import java.io.*;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(
        String title,
        String author,
        int stock,
        String adminName
    ) {
        books.add(new Book(title, author, stock));
        System.out.println(
            "Buku berhasil ditambahkan: " + title + " | Stok: " + stock
        );
        logActivity(
            "ADMIN " +
                adminName +
                " menambahkan buku: " +
                title +
                " | Stok: " +
                stock
        );
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
            String line =
                "+----+-------------------------+--------------------+------+-----------+";
            System.out.println(line);
            System.out.printf(
                "| %-2s | %-23s | %-18s | %-4s | %-9s |%n",
                "No",
                "Judul Buku",
                "Pengarang",
                "Stok",
                "Status"
            );
            System.out.println(line);
            int i = 1;
            for (Book book : books) {
                String status = book.isAvailable() ? "Tersedia" : "Habis";
                System.out.printf(
                    "| %-2d | %-23s | %-18s | %-4d | %-9s |%n",
                    i++,
                    book.getTitle(),
                    book.getAuthor(),
                    book.getStock(),
                    status
                );
            }
            System.out.println(line);
        }
    }

    public void showAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        if (availableBooks.isEmpty()) {
            System.out.println("Tidak ada buku tersedia saat ini.");
        } else {
            System.out.println("=== Buku Tersedia ===");
            String line =
                "+----+-------------------------+--------------------+------+-----------+";
            System.out.println(line);
            System.out.printf(
                "| %-2s | %-23s | %-18s | %-4s | %-9s |%n",
                "No",
                "Judul Buku",
                "Pengarang",
                "Stok",
                "Status"
            );
            System.out.println(line);
            int i = 1;
            for (Book book : availableBooks) {
                String status = book.isAvailable() ? "Tersedia" : "Habis";
                System.out.printf(
                    "| %-2d | %-23s | %-18s | %-4d | %-9s |%n",
                    i++,
                    book.getTitle(),
                    book.getAuthor(),
                    book.getStock(),
                    status
                );
            }
            System.out.println(line);
        }
    }

    private void loadBooks() {
        try (
            BufferedReader br = new BufferedReader(new FileReader("books.txt"))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    int stock = Integer.parseInt(parts[2]);
                    books.add(new Book(title, author, stock));
                }
            }
        } catch (FileNotFoundException e) {
            // Ini normal kalau file belum ada, file akan dibuat nanti.
        } catch (IOException | NumberFormatException e) {
            System.out.println(
                "Gagal memuat buku dari file: " + e.getMessage()
            );
        }
    }

    public void saveBooks() {
        try (
            BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"))
        ) {
            for (Book book : books) {
                bw.write(
                    book.getTitle() +
                        ";" +
                        book.getAuthor() +
                        ";" +
                        book.getStock()
                );
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan buku: " + e.getMessage());
        }
    }

    public void logActivity(String message) {
        try (
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("activity.txt", true)
            )
        ) {
            bw.write(message);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Gagal mencatat aktivitas: " + e.getMessage());
        }
    }
}

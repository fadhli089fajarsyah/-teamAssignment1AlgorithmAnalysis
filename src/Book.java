public class Book {
    private String title;
    private String author;
    private int stock;

    public Book(String title, String author, int stock) {
        this.title = title;
        this.author = author;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStock() {
        return stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void borrow() {
        if (stock > 0) {
            stock--;
            System.out.println("Buku dipinjam: " + title + " | Sisa stok: " + stock);
        } else {
            System.out.println("Buku sedang habis: " + title);
        }
    }

    public void returnBook() {
        stock++;
        System.out.println("Buku dikembalikan: " + title + " | Stok sekarang: " + stock);
    }

    @Override
    public String toString() {
        return "judul buku =" +title + " |pengarang =" + author + " | Stok: " + stock + (isAvailable() ? " | Tersedia" : " | Habis");
    }
}

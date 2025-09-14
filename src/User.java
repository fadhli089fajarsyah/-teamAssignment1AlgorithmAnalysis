public class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Nama User: " + name);
    }
}

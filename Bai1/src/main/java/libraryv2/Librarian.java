package libraryv2;

public class Librarian implements Observer {
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println("Nhân viên " + name + " nhận thông báo: " + message);
    }
}

package libraryv2;

public interface Subject {
    void attach(Observer observer);
    void notifyObservers(String message);
}

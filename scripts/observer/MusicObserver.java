package observer;

public class MusicObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notificacao recebida: " + message);
    }
}

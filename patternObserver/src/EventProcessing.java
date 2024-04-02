import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class EventProcessing implements MySubject{
    List<MyObserver> keys = new ArrayList<>();
    KeyAdapter adapter;
    int key;
    EventProcessing() {
        adapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                key = e.getKeyCode();

                notifyObservers(KeyEvent.getKeyText(key));
            }
        };
    }

    @Override
    public void attach(MyObserver observer) {
        keys.add(observer);
    }

    @Override
    public void detach(MyObserver observer) {
        keys.remove(observer);
    }

    @Override
    public void notifyObservers(String key) {
        for (MyObserver observer: keys) {
            observer.update(key);
        }
    }
}

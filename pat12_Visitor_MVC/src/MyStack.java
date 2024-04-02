import java.util.ArrayList;
import java.util.Iterator;

public class MyStack<T> {
    private ArrayList<T> base;

    public int size() {
        return base.size();
    }

    public void push(T a) {
        base.add(a);
    }

    public boolean isEmpty() {
        return base.isEmpty();
    }

    public T top() throws NullPointerException {
        if (this.isEmpty()) {
            throw new NullPointerException("Empty stack");
        }
        return base.get(size() - 1);
    }

    public MyIterator iterator() {
        return new MyIterator();
    }

    private class MyIterator {
        private int currentIndex = base.size() - 1;
        public T next(){
            return base.get(--currentIndex);
        }

        public boolean hasNext(){
            return currentIndex > 0;
        }

        public T current() {
            return base.get(currentIndex);
        }
    }
}
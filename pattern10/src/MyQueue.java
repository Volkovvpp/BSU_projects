import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class MyQueue<T> {
    private final ArrayList<T> base;
    DefaultListModel<T> listModel = new DefaultListModel<>();
    MyQueue () {
        base = new ArrayList<>();
    }
    public int size() {
        return base.size();
    }
    public boolean isEmpty() {
        return base.isEmpty();
    }
    public void clear() {
        base.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyQueue<?> myQueue = (MyQueue<?>) o;
        return Objects.deepEquals(base, myQueue.base);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        MyIterator iter = this.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next()).append(" ");
        }
        System.out.println(builder);
        return builder.toString();
    }

    public T front() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        return base.get(0);
    }
    public T back() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return base.get(base.size() - 1);
    }
    public void push(T e) {
        base.add(e);
    }
    public void pop()  throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        base.remove(0);
    }
    public DefaultListModel<T> getListModel() {
        listModel.clear();
        for (int i = 0; i < size(); i++) {
            listModel.add(i, base.get(i));
        }
        return listModel;
    }
    public void pushAll(MyQueue<T> queue) {
        base.addAll(queue.base);
    }
    public MyIterator iterator() {
        return new MyIterator();
    }

    private class MyIterator {
        int current = 0;
        public boolean hasNext() {
            return current != base.size();
        }
        public T next() {
            try {
                return base.get(current++);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("No more elements");
            }
        }
        public T current() {
            try {
                return base.get(current);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("No more elements");
            }
        }
    }
}

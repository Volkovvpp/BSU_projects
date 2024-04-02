import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class MySet {
    int minimum = 0;
    final ArrayList<MyInteger> base;
    public MySet() {
        base = new ArrayList<>();
    }

    public void clear() {
        base.clear();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        MyIterator iter = this.iterator();
        while (iter.hasNext()) {
            builder.append(iter.current()).append(" ");
            iter.next();
        }
        return builder.toString();
    }
    public void add(int elem) {
        int index = elem - minimum;

        while (index < 0) {
            base.add(0, new MyInteger("0"));
            minimum--;
            index++;
        }
        while (index >= base.size()) {
            base.add(new MyInteger("0"));
        }
        base.set(index, new MyInteger("1"));

    }
    public void save(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (MyInteger element : base) {
                writer.write(String.valueOf(element) + System.lineSeparator());
            }
            writer.write("\n");
            for (int i = 0; i < base.size(); i++) {
                if(base.get(i).integer == 1) writer.write((i + minimum) + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public long cardinality(PowerStrategy powerStrategy) {
        return powerStrategy.powerStrategy();
    }
    public MyIterator iterator() {
        return new MyIterator();
    }

    public class MyIterator {
        int current = 0;
        public boolean hasNext() {
            return current != base.size();
        }
        public MyInteger next() {
            try {
                return base.get(current++);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("No more elements");
            }
        }
        public MyInteger current() {
            try {
                return base.get(current);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("No more elements");
            }
        }
    }
}

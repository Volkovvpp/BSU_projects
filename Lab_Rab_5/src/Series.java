import java.io.*;
public abstract class Series {
    public double theFirstMember;
    public double delta;
    public int number;
    Series(double theFirstMember, double delta, int number) {
        this.theFirstMember = theFirstMember;
        this.delta = delta;
        this.number = number;
    }
    public abstract double calcMember(int j);
    public double sumSeries(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("wrong number input");
        }
        double sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += calcMember(i);
        }
        return sum;
    }
    public String toString() {
        StringBuilder allMembers = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            allMembers.append(calcMember(i)).append(" ");
        }
        return allMembers + "\nsum = " + sumSeries(number) + "\n";
    }
    public void saveInFile(File f) throws IOException {
        PrintWriter writer = new PrintWriter(f);
        writer.write(toString());
        writer.close();
    }
}
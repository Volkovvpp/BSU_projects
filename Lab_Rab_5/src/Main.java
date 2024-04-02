import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Series seria = new Exponential(10, 10, 10);
        seria.saveInFile(new File("src/output"));
    }
}
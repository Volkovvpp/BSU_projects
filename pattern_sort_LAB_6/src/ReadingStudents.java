import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ReadingStudents {
    String pathFileAllStudents = "src/allStudents.txt";
    List<Student> listOfAllStudents = new ArrayList<>();

    public ReadingStudents(String pathFileAllStudents) throws IOException, NumberFormatException {
        if (!pathFileAllStudents.equals("")) {
            this.pathFileAllStudents = pathFileAllStudents;
        }
        File allStudents = new File(this.pathFileAllStudents);
        Scanner scanner = new Scanner(allStudents);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                continue;
            }
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            int numOfCreditBook = Integer.parseInt(tokenizer.nextToken());
            String surname = tokenizer.nextToken();
            int numberSemester = Integer.parseInt(tokenizer.nextToken());
            String subject1 = tokenizer.nextToken();
            int mark1 = Integer.parseInt(tokenizer.nextToken());
            String subject2 = tokenizer.nextToken();
            int mark2 = Integer.parseInt(tokenizer.nextToken());

            if (subject1.compareTo(subject2) < 0) {
                String temp = subject2;
                subject2 = subject1;
                subject1 = temp;
            }

            if (numOfCreditBook < 0 || numberSemester < 0 || mark1 < 0 || mark2 < 0) {
                throw new NumberFormatException();
            }
            Student student = new Student(numOfCreditBook, surname, numberSemester, subject1, mark1, subject2, mark2);
            listOfAllStudents.add(student);
        }
    }

    public void addNewStudent(String newStudStr) throws NumberFormatException {
        StringTokenizer token = new StringTokenizer(newStudStr, " ");
        while (token.hasMoreTokens()) {
            int numOfCreditBook = Integer.parseInt(token.nextToken());
            String surname = token.nextToken();
            int numberSemester = Integer.parseInt(token.nextToken());
            String subject1 = token.nextToken();
            int mark1 = Integer.parseInt(token.nextToken());
            String subject2 = token.nextToken();
            int mark2 = Integer.parseInt(token.nextToken());

            if (subject1.compareTo(subject2) < 0) {
                String temp = subject2;
                subject2 = subject1;
                subject1 = temp;
            }

            if (numOfCreditBook < 0 || numberSemester < 0 || mark1 < 0 || mark2 < 0) {
                throw new NumberFormatException();
            }
            Student student = new Student(numOfCreditBook, surname, numberSemester, subject1, mark1, subject2, mark2);
            listOfAllStudents.add(student);
        }
    }
    int numOfSemester = 1;
    String theFirstSubj;
    String theSecondSubj;
    public void getStringForSort(String strForSort) throws NumberFormatException {
        StringTokenizer tokenizer = new StringTokenizer(strForSort, " ");
        numOfSemester = Integer.parseInt(tokenizer.nextToken());
        theFirstSubj = tokenizer.nextToken();
        theSecondSubj = tokenizer.nextToken();

        if (theFirstSubj.compareTo(theSecondSubj) < 0) {
            String temp = theSecondSubj;
            theSecondSubj = theFirstSubj;
            theFirstSubj = temp;
        }
    }
}

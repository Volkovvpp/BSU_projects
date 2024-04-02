public class Student {
    int numOfCreditBook;
    String surname;
    int numberSemester;
    String subject1;
    int mark1;
    String subject2;
    int mark2;

    public Student(int numOfCreditBook, String surname, int numberSemester, String subject1, int mark1, String subject2, int mark2) {
        this.numOfCreditBook = numOfCreditBook;
        this.surname = surname;
        this.numberSemester = numberSemester;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return numOfCreditBook + " " + surname + " " + numberSemester + " " + subject1 + " " + mark1 + " " + subject2 + " " + mark2;
    }
}

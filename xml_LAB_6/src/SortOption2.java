import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortOption2 implements SortStrategy{
    List<Student> listOfBadSemesterStudents = new ArrayList<>();
    @Override
    public List<Student> sortStrategy(List<Student> listOfAllStudents, int numOfSemester, String theFirstSubj, String theSecondSubj) {
        for (int i = 0; i < listOfAllStudents.size(); i++) {
            if (listOfAllStudents.get(i).numberSemester == numOfSemester && listOfAllStudents.get(i).subject1.equals(theFirstSubj) && listOfAllStudents.get(i).subject2.equals(theSecondSubj)) {
                listOfBadSemesterStudents.add(listOfAllStudents.get(i));
            }
        }
        listOfBadSemesterStudents.sort(Comparator.comparing(Student::getSurname));
        return listOfBadSemesterStudents;
    }
}

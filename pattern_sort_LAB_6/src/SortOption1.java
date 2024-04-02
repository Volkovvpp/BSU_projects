import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortOption1 implements SortStrategy{
    List<Student> listOfBadSemesterStudents = new ArrayList<>();
    @Override
    public List<Student> sortStrategy(List<Student> listOfAllStudents, int numOfSemester, String theFirstSubj, String theSecondSubj) {
        listOfBadSemesterStudents = listOfAllStudents.stream()
                .filter(x -> x.numberSemester == numOfSemester)
                .filter(x -> Objects.equals(x.subject1, theFirstSubj))
                .filter(x -> Objects.equals(x.subject2, theSecondSubj))
                .filter(x -> x.mark1 < 4 && x.mark2 < 4)
                .collect(Collectors.toCollection(ArrayList::new));
        listOfBadSemesterStudents = listOfBadSemesterStudents.
                stream().sorted(Comparator.comparing(Student::getSurname)).
                collect(Collectors.toCollection(ArrayList::new));
        return listOfBadSemesterStudents;
    }
}

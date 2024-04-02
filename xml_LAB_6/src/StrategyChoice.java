import java.util.List;

public class StrategyChoice {
    SortStrategy sortStrategy;
    public List<Student> sorting(List<Student> listOfAllStudents, int numOfSemester, String theFirstSubj, String theSecondSubj) {
        return sortStrategy.sortStrategy(listOfAllStudents, numOfSemester, theFirstSubj, theSecondSubj);
    }
}

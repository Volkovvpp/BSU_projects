import java.util.List;

public interface SortStrategy {
    public List<Student> sortStrategy(List<Student> studentList, int numberOfSemester, String firstSubj, String secondSubj);
}

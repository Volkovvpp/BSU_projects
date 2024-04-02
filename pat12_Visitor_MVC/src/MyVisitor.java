public class MyVisitor implements Visitor{
    int sum = 0;
    int count = 0;
    @Override
    public void visit(MyInteger element) {
        sum += element.integer;
        count++;
    }
    public double getAver() {
        return (double) sum / count;
    }
}

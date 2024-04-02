public class MyVisitor implements Visitor{
    int count = 0;
    @Override
    public void visit(MyInteger element) {
        if (element.integer == 1) {
            count++;
        }
    }
    public int getPower() {
        return count;
    }
}

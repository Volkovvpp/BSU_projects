public class PowerOption1 implements PowerStrategy{
    public MySet base;
    public PowerOption1(MySet mySet) {
        base = mySet;
    }
    @Override
    public int powerStrategy() {
        MyVisitor visitor = new MyVisitor();
        MySet.MyIterator iterator = base.iterator();
        while (iterator.hasNext()) {
            iterator.current().accept(visitor);
            iterator.next();
        }
        return visitor.getPower();
    }
}

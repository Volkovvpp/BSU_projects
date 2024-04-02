public class PowerOption2 implements PowerStrategy{
    public MySet base;

    public PowerOption2(MySet mySet) {
        base = mySet;
    }
    @Override
    public int powerStrategy() {
        return (int) base.base.stream().filter(x -> x.integer == 1).count();
    }
}

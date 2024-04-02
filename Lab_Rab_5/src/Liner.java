public class Liner extends Series{
    Liner(double theFirstMember, double delta, int number) {
        super(theFirstMember, delta, number);
    }
    @Override
    public double calcMember(int j) {
        return theFirstMember + delta * (j - 1);
    }
}
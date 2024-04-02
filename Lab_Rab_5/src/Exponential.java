public class Exponential extends Series {
    Exponential(double theFirstMember, double delta, int number) {
        super(theFirstMember, delta, number);
    }
    @Override
    public double calcMember(int j) {
        return theFirstMember * Math.pow(delta, j - 1);
    }
}
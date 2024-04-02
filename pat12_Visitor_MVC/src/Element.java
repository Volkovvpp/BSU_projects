abstract public class Element {
    public void accept(Visitor visitor) {
    }
}

class MyInteger extends Element {
    Integer integer;
    MyInteger(String integer) {
        try {
            this.integer = Integer.parseInt(integer);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
    public MyInteger parseIntElem() {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(integer);
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

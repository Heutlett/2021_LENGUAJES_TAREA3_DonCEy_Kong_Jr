package structure;

public class Tuple<A, B> {

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    private final A a;
    private final B b;

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

}

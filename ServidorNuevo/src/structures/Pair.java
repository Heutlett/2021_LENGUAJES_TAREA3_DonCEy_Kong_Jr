package structures;

public class Pair<I, J> {

    public Pair(I i, J j) {
        this.i = i;
        this.j = j;
    }

    public I i;
    public J j;

    public void setI(I i) {
        this.i = i;
    }

    public void setJ(J j) {
        this.j = j;
    }

    public I getI() {
        return i;
    }

    public J getJ() {
        return j;
    }
}

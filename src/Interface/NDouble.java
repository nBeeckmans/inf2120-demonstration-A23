package Interface;

public class NDouble implements Nombre<NDouble>{
    double var;

    public NDouble() {}
    public NDouble(double var) {
        this.var = var;
    }

    @Override
    public NDouble add(NDouble x) {
        double a = var + x.var;
        return new NDouble(a);
    }

    @Override
    public NDouble sub(NDouble x) {
        return new NDouble(var - x.var);
    }

    @Override
    public NDouble mul(NDouble x) {
        return new NDouble(var * x.var);
    }

    @Override
    public NDouble div(NDouble x) {
        return x.var != 0
                ? new NDouble(this.var / x.var)
                : new NDouble();
    }

    @Override
    public String toString() {
        return "NDouble{" +
                "var=" + var +
                '}';
    }
}

package TestVector;

/**
 * Created by Xuhao Chen on 16/5/10.
 */
public interface VectorInterface {

    public Boolean setDimension(int d);

    public Boolean setLocation(double ...x);

    public Integer getDimension();

    public double[] getLocation();

    public Boolean equals(Vector aVector);

    public Vector add(Vector aVector);

    public Vector minus(Vector aVector);

    public Vector multiply(Vector aVector);
}

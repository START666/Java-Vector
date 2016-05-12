package TestVector;

/**
 * Created by Xuhao Chen on 16/5/10.
 */
public class TestVector {
    public static void main(String args[]){new TestVector();}
    public TestVector(){
        Vector v = new Vector(2);
        v.setLocation(1,2);

        Vector w = new Vector(0.0,2.0);
        Vector result = v.add(w);
        result.printLocation();

    }
}

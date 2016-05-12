package TestVector;

/**
 * Created by Xuhao Chen on 16/5/10.
 */
public class TestVector {
    public static void main(String args[]){new TestVector();}
    public TestVector(){
        Vector v = new Vector(3);
        v.setLocation(1.5,2,0);

        Vector w = new Vector(1.0,2.0,1.0);
        Vector result = v.minus(w);
        result.printLocation();
        System.out.println(v.dotProduct(w));

    }
}

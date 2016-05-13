package TestVector;

import java.util.Objects;

/**
 * Created by Xuhao Chen on 16/5/10.
 */
public class Vector implements VectorInterface{

    private int dimension;
    private double[] location;

    public Vector(){
        this.dimension = 0;
        location = new double[0];
    }

    public Vector(int dimension){
        this.dimension = dimension;
        location = new double[dimension];
    }

    public Vector(double ...x){
        try{
            location = x.clone();
            this.dimension = location.length;
        }catch(Exception e){
            dimension=0;
            location = new double[0];
            e.printStackTrace();
        }
    }
    @Override
    public Boolean setDimension(int d){
        try{
            if(d<0) throw new ArithmeticException();
            this.dimension = d;
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean setLocation(double... x) {
        try {
            this.location = x.clone();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Integer getDimension() {
        return dimension;
    }

    @Override
    public double[] getLocation() {
        return location.clone();
    }

    @Override
    public Boolean equals(Vector aVector){

        if(aVector == null) throw new NullPointerException();

        if(aVector.getDimension() == dimension){
            for(int i=0;i<dimension;i++){
                if(location[i] != aVector.getLocation()[i]) return false;
            }
            return true;
        }
        return null;
    }

    @Override
    public Vector crossProduct(Vector aVector) {    //only in 3D vectors
        if(dimension != 3 || aVector.getDimension() != 3) throw new ArithmeticException();
        try{
            Vector resultVector = new Vector(3);
            double[] resultLocation = new double[3];

            resultLocation[0] = location[1] * aVector.getLocation()[2] - location[2] * aVector.getLocation()[1];
            resultLocation[1] = location[2] * aVector.getLocation()[0] - location[0] * aVector.getLocation()[2];
            resultLocation[2] = location[0] * aVector.getLocation()[1] - location[1] * aVector.getLocation()[0];
            resultVector.setLocation(resultLocation);

            return resultVector;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Double dotProduct(Vector aVector){
        if(aVector == null) throw new NullPointerException();
        if(this.dimension == aVector.dimension){
            double result=0.0;
            for(int i=0;i<dimension;i++){
                result += location[i] * aVector.getLocation()[i];
            }
            return result;
        }

        throw new ArithmeticException();
    }

    @Override
    public Vector minus(Vector aVector) {
        if(aVector == null) throw new NullPointerException();
        if(this.dimension == aVector.dimension){
            Vector result = new Vector(dimension);
            double[] resultLocation = new double[dimension];

            for(int i=0;i<dimension;i++){
                resultLocation[i] = location[i] - aVector.getLocation()[i];
            }
            result.setLocation(resultLocation);
            return result;
        }
        throw new ArithmeticException();
    }

    @Override
    public Vector add(Vector aVector) {
        if(aVector == null) throw new NullPointerException();
        if(this.dimension == aVector.dimension){
            Vector result = new Vector(dimension);
            double[] resultLocation = new double[dimension];

            for(int i=0;i<dimension;i++){
                resultLocation[i] = location[i] + aVector.getLocation()[i];
            }
            result.setLocation(resultLocation);
            return result;
        }
        throw new ArithmeticException();

    }

    public void printLocation() {
        try{
            String output = "[ ";
            for(int i=0;i<dimension;i++){
                output += location[i];
                if(i != dimension-1) output += ", ";
            }
            output += " ]";
            System.out.println(output);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}

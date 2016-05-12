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

        if(aVector.getDimension() == dimension){
            for(int i=0;i<dimension;i++){
                if(location[i] != aVector.getLocation()[i]) return false;
            }
            return true;
        }
        return null;
    }

    @Override
    public Vector multiply(Vector aVector) {
        return null;
    }

    @Override
    public Vector minus(Vector aVector) {
        return null;
    }

    @Override
    public Vector add(Vector aVector) {
        if(aVector == null) throw new NullPointerException();
        Vector result;
        if(this.dimension == aVector.dimension){
            result = new Vector(dimension);
            double[] resultLocation = new double[dimension];
            for(int i=0;i<dimension;i++){
                resultLocation[i] = location[i] + aVector.getLocation()[i];
            }
            result.setLocation(resultLocation);
            return result;
        }
        return null;
    }

    public void printLocation(){
        String output = "[ ";
        for(int i=0;i<dimension;i++){
            output += location[i];
            if(i != dimension-1) output += ", ";
        }
        output += " ]";
        System.out.println(output);
    }

}

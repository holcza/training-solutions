package exceptions;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] polinoms) {
        if (polinoms == null){
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = polinoms;
    }

    public Polynomial(String [] polinoms) {
        if (polinoms == null){
            throw new NullPointerException("coefficientStrs is null");
        }
        this.coefficients = new double[polinoms.length];
        for (int i = 0; i<polinoms.length;i++){

            try{
                this.coefficients[i] = Double.parseDouble(polinoms[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Illegal coefficients, not a number",e);
            }
        }
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double evaluate(double x){
        double result = 0;
        for (int i = 0; i< coefficients.length; i++){
            result += coefficients[coefficients.length-1-i]* Math.pow(x,i);
        }

        return result;
    }

    public static void main(String[] args) {
        double[] array = {2,3};
        Polynomial polinom = new Polynomial(array);
        System.out.println(polinom.evaluate(2));
    }
}

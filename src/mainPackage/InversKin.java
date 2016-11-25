package mainPackage;


public class InversKin {

    private int armLength1=140;
    private int armLength2=450;
    private int armLength3=350;
    private int armLength4=136;

    public InversKin() {
    }



    public double[] inverse(double x, double y, double z){
        double[] angleValue=new double[3];

        angleValue[0]=Math.atan2(y,x);
        double zdod=z-armLength1+armLength4;
        double a=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        angleValue[2]=-Math.acos((Math.pow(a,2)+Math.pow(zdod,2)-Math.pow(armLength2,2)-Math.pow(armLength3,2))/(2*armLength2*armLength3));
        double beta=Math.atan2(zdod,a);
        double psi=Math.acos((Math.pow(a,2)+Math.pow(zdod,2)+Math.pow(armLength2,2)-Math.pow(armLength3,2))/(2*armLength2*Math.sqrt(Math.pow(a,2)+Math.pow(zdod,2))));
        angleValue[1]=beta+psi;


        return angleValue;
    }

}

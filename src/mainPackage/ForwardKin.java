package mainPackage;


public class ForwardKin {

    public class MatrixHelper {

        public double[][] getIdentity(int size) {
            double[][] matrix = new double[size][size];
            for(int i = 0; i < size; i++) matrix[i][i] = 1;
            return matrix;
        }
    }

    public ForwardKin(){}

    public double[][] forward(double theta1,double theta2,double theta3){
        double[] alfa={Math.PI/2, 0, 0, Math.PI/2, 0};
        double[] a={0, 450, 350, 0, 0};
        double[] d={200, 0, 0, 0, 137};
        double[] theta={theta1, theta2, theta3, -(theta3+theta2), 0};
        double[][] T=(new MatrixHelper()).getIdentity(4);







        double[][] xyzValue=new double[5][3];
        int[][][] tablica3D = new int[3][4][5];
        int l=0;
        // trzeci wymiar
        for (int i = 0; i < tablica3D.length; i++) {
            // drugi wymiar
            for (int j = 0; j < tablica3D[i].length; j++) {
                // pierwszy wymiar
                for (int k = 0; k < tablica3D[i][j].length; k++) {
                    tablica3D[i][j][k] = l;
                    l++;
                }
            }
        }



        return xyzValue;

    }

}

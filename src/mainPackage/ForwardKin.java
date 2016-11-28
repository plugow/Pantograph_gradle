package mainPackage;

public class ForwardKin {


    public ForwardKin(){}

    double [][] P1=new double[4][1];
    double [][] P01=new double[4][1];
    double [][] P02=new double[4][1];
    double [][] P03=new double[4][1];
    double [][] P04=new double[4][1];


    public double[][] forward(double theta1,double theta2,double theta3){
        P1 [3][0]=1;
        double[][] xyzValue=new double[4][3];
        double[] alfa={Math.PI/2, 0, 0, Math.PI/2, 0};
        double[] a={0, 450, 350, 0, 0};
        double[] d={200, 0, 0, 0, 137};
        double[] theta={theta1, theta2, theta3, -(theta3+theta2), 0};
        double[][] t=(new MatrixHelper()).getIdentity(4);

        int MAX_LEVELS=6;
        int MAP_WIDTH=4;
        int MAP_HEIGHT=4;

        double [][][] tt = new double[MAX_LEVELS][MAP_WIDTH][MAP_HEIGHT];
        for (int currentLevel = 0; currentLevel < MAX_LEVELS; currentLevel++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                for (int y = 0; y < MAP_HEIGHT; y++) {
                    tt[currentLevel][x][y] = t[x][y];
                }
            }
        }



        for (int kk=0;kk<5;kk++) {
            double cA = Math.cos(alfa[kk]);
            double sA = Math.sin(alfa[kk]);
            double cT = Math.cos(theta[kk]);
            double sT = Math.sin(theta[kk]);
            double [][] bigT ={{cT, -cA*sT, sA*sT, a[kk]*cT},
                    {sT, cA*cT, -cT*sA, a[kk]*sT},
                    {0, sA, cA, d[kk]},
                    {0, 0, 0, 1}};

            tt[kk+1]=multMatrix(tt[kk],bigT);
        }

        P04=multMatrix(tt[5],P1);
        P03=multMatrix(tt[3],P1);
        P02=multMatrix(tt[2],P1);
        P01=multMatrix(tt[1],P1);

        xyzValue[3][0]=P04[0][0];
        xyzValue[3][1]=P04[1][0];
        xyzValue[3][2]=P04[2][0];

        xyzValue[2][0]=P03[0][0];
        xyzValue[2][1]=P03[1][0];
        xyzValue[2][2]=P03[2][0];

        xyzValue[1][0]=P02[0][0];
        xyzValue[1][1]=P02[1][0];
        xyzValue[1][2]=P02[2][0];

        xyzValue[0][0]=P01[0][0];
        xyzValue[0][1]=P01[1][0];
        xyzValue[0][2]=P01[2][0];

//        yy4(m)=P04(2);
//        zz4(m)=P04(3);
//        xx3(m)=P03(1);
//        yy3(m)=P03(2);
//        zz3(m)=P03(3);
//        xx2(m)=P02(1);
//        yy2(m)=P02(2);
//        zz2(m)=P02(3);
//        xx1(m)=P01(1);
//        yy1(m)=P01(2);
//        zz1(m)=P01(3);

        return xyzValue;
    }

    public static double[][] multMatrix(double a[][], double b[][]){//a[m][n], b[n][p]

        if(a.length == 0) return new double[0][0];
        if(a[0].length != b.length) return null; //invalid dims


        int n = a[0].length;
        int m = a.length;
        int p = b[0].length;
        double ans[][] = new double[m][p];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < p;j++){
                for(int k = 0;k < n;k++){
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }


    public class MatrixHelper {

        public double[][] getIdentity(int size) {
            double[][] matrix = new double[size][size];
            for(int ii = 0; ii < size; ii++) matrix[ii][ii] = 1;
            return matrix;
        }
    }


}
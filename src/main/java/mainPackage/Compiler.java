package mainPackage;





import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Compiler {



    public void compile(ArrayList<String> list){

        String moveFunction="MOVE";
        String mvsFunction="MVS";
        String effectorFunction="EFFECTOR";
        String delayFunction="DELAY";
        String whileFunction="DO";
        String endFunction="END";
        String velocityFunction="VELOCITY";
        int amountOfRepeat=0;
        int numberOfLine=0;
        int velocity=100;
        int velocityInit;
        int step;
        int helpStep =20;




        for(int i=0;i<list.size();i+=2){
            String choosedFunction=list.get(i);
            String funArgument=list.get(i+1);


            if(choosedFunction.equals(moveFunction)){
                int a=Integer.parseInt(funArgument.substring(1,2));
                Points point=MainModel.getInstance().getPointsList().get(a);
                setMove(point.getmFirstValue(),point.getmSecondValue(),point.getmThirdValue(),velocity);

                //MainModel.getInstance().getIntegerList().setAll(point.getmFirstValue(),point.getmSecondValue(),point.getmThirdValue(),MainModel.getInstance().getIntegerList().get(3));
                //System.out.println("pierwszy");

            }
            else if (choosedFunction.equals(mvsFunction)){


            }

            else if (choosedFunction.equals(effectorFunction)){
                if(funArgument.equals("OPEN")) MainModel.getInstance().getIntegerList().setAll(MainModel.getInstance().getIntegerList().get(0),MainModel.getInstance().getIntegerList().get(1),MainModel.getInstance().getIntegerList().get(2),90);
                else if(funArgument.equals("CLOSE")) MainModel.getInstance().getIntegerList().setAll(MainModel.getInstance().getIntegerList().get(0),MainModel.getInstance().getIntegerList().get(1),MainModel.getInstance().getIntegerList().get(2),118);

            }

            else if (choosedFunction.equals(delayFunction)){
                int valueOfDelay=Integer.parseInt(funArgument);
                try {
                    TimeUnit.MILLISECONDS.sleep(valueOfDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

            else if(choosedFunction.equals(whileFunction)){
                amountOfRepeat=Integer.parseInt(funArgument);
                numberOfLine=i;
                System.out.println("while"+numberOfLine);

            }

            else if (choosedFunction.equals(endFunction)){
                amountOfRepeat-=1;
                if(amountOfRepeat>0){
                    i=numberOfLine;
                    System.out.println("end"+i);

                }



            }











        }



    }

    private void setMove(int joint1, int joint2, int joint3, int velocity){
        int value1=MainModel.getInstance().getIntegerList().get(0);
        int value2=MainModel.getInstance().getIntegerList().get(1);
        int value3=MainModel.getInstance().getIntegerList().get(2);
        int value4=MainModel.getInstance().getIntegerList().get(3);



        while(value1!=joint1 || value2!=joint2 || value3!=joint3){
            if(value1<joint1) value1+=1;
            else value1-=1;
            if(value2<joint1) value2+=1;
            else value1-=1;
            if(value3<joint1) value3+=1;
            else value1-=1;


            try {
                MainModel.getInstance().getIntegerList().setAll(value1,value2,value3,value4);
                TimeUnit.MILLISECONDS.sleep(101-velocity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


    private boolean moveDirection(int target, int actual){
        boolean bool=false;
        if (target>=90){
            if(target>actual) bool=true;
            else bool=false;}
        else {
            if (target>actual) bool=true;
            else bool=false;
        }
        return bool;

        }



}








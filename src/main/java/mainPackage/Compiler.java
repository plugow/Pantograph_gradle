package mainPackage;





import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Compiler {



    public void compile(ArrayList<String> list){
        boolean isCompiled=false;
        String moveFunction=new String("MOVE");
        String mvsFunction=new String("MVS");
        String effectorFunction=new String("EFFECTOR");
        String delayFunction=new String("DELAY");




        for(int i=0;i<list.size();i+=2){
            String choosedFunction=list.get(i);
            String funArgument=list.get(i+1);

            if(choosedFunction.equals(moveFunction)){
                int a=Integer.parseInt(funArgument.substring(1,2));
                try {
                    MainModel.getInstance().getIntegerList().setAll(MainModel.getInstance().getPointsList().get(a).getmFirstValue(),MainModel.getInstance().getPointsList().get(a).getmSecondValue(),MainModel.getInstance().getPointsList().get(a).getmThirdValue(),90);
                    System.out.println("pierwszy");
                    TimeUnit.MILLISECONDS.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            else if (choosedFunction.equals(mvsFunction)){

            }

            else if (choosedFunction.equals(effectorFunction)){

            }

            else if (choosedFunction.equals(delayFunction)){
                int valueOfDelay=Integer.parseInt(funArgument);



            }









        }




    }







}

package mainPackage;




import java.util.ArrayList;


public class Compiler {


    public boolean compile(ArrayList<String> list){
        boolean isCompiled=false;
        String moveFunction=new String("MOVE");
        String mvsFunction=new String("MVS");
        String effectorFunction=new String("EFFECTOR");


        for(int i=0;i<list.size();i+=2){
            String choosedFunction=list.get(i);
            String funArgument=list.get(i+1);

            if(choosedFunction.equals(moveFunction)){
                int a=Integer.parseInt(funArgument.substring(1,2));
                MainModel.getInstance().getIntegerList().setAll(MainModel.getInstance().getPointsList().get(a).getmFirstValue(),MainModel.getInstance().getPointsList().get(a).getmSecondValue(),MainModel.getInstance().getPointsList().get(a).getmThirdValue(),90);

            }

            else if (choosedFunction.equals(mvsFunction)){

            }

            else if (choosedFunction.equals(effectorFunction)){

            }










        }



















        return isCompiled;
    }





}

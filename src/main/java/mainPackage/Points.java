package mainPackage;

import javafx.beans.property.*;

public class Points {

    private final StringProperty mName;
    private final StringProperty mCoordinates;
    private final IntegerProperty mFirstValue;
    private final IntegerProperty mSecondValue;
    private final IntegerProperty mThirdValue;





    public Points (String name, int firstValue,int secondValue,int thirdValue){
        float[][] results;
        ForwardKin forwardKin=new ForwardKin();
        results=forwardKin.forward((float) Math.toRadians(firstValue),(float) Math.toRadians(secondValue),-(float) Math.toRadians(thirdValue));
        String str=firstValue+"; "+secondValue+"; "+thirdValue+"; "+(int)results[3][0]+"; "+(int)results[3][1]+"; "+(int)results[3][2];



        this.mCoordinates=new SimpleStringProperty(str);
        this.mName=new SimpleStringProperty(name);
        this.mFirstValue=new SimpleIntegerProperty(firstValue);
        this.mSecondValue=new SimpleIntegerProperty(secondValue);
        this.mThirdValue=new SimpleIntegerProperty(thirdValue);
    }


    public String getmName() {
        return mName.get();
    }

    public StringProperty mNameProperty() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName.set(mName);
    }

    public String getmCoordinates() {
        return mCoordinates.get();
    }

    public StringProperty mCoordinatesProperty() {
        return mCoordinates;
    }

    public void setmCoordinates(String mCoordinates) {
        this.mCoordinates.set(mCoordinates);
    }

    public int getmFirstValue() {
        return mFirstValue.get();
    }

    public IntegerProperty mFirstValueProperty() {
        return mFirstValue;
    }

    public void setmFirstValue(int mFirstValue) {
        this.mFirstValue.set(mFirstValue);
    }

    public int getmSecondValue() {
        return mSecondValue.get();
    }

    public IntegerProperty mSecondValueProperty() {
        return mSecondValue;
    }

    public void setmSecondValue(int mSecondValue) {
        this.mSecondValue.set(mSecondValue);
    }

    public int getmThirdValue() {
        return mThirdValue.get();
    }

    public IntegerProperty mThirdValueProperty() {
        return mThirdValue;
    }

    public void setmThirdValue(int mThirdValue) {
        this.mThirdValue.set(mThirdValue);
    }
}

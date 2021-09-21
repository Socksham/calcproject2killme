package com.example.calculatorprojectv2;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class KeepCount implements Parcelable {
    private int count;
    private Boolean fgd;

    public KeepCount(int input){
        this.count = input;
        this.fgd = false;
    }

    protected KeepCount(Parcel in) {
        count = in.readInt();
    }
    public static final Creator<KeepCount> CREATOR = new Creator<KeepCount>() {
        @Override
        public KeepCount createFromParcel(Parcel in) {
            return new KeepCount(in);
        }

        @Override
        public KeepCount[] newArray(int size) {
            return new KeepCount[size];
        }
    };
    //^^ Parcel Stuff

    public void increaseCount(){
        this.count++;
    }

    public Integer getCount(){
        return this.count;
    }

    public Boolean getFGD(){
        return this.fgd;
    }

    public void fgdTrue(){
        this.fgd = true;

        Log.d("TAG", "FGD: " + fgd.toString());
    }

    public void fgdFalse(){
        this.fgd = false;
    }

    public void reset(){
        this.count = 0;
        fgd = false;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(count);
    }
    //^^ More Parcel Stuff
}

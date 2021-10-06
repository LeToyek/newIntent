package com.example.newintent;

import android.os.Parcel;
import android.os.Parcelable;

public class Drink implements Parcelable {
    private String name;
    private Double calories;

    public Drink(){

    }

    protected Drink(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            calories = null;
        } else {
            calories = in.readDouble();
        }
    }

    public static final Creator<Drink> CREATOR = new Creator<Drink>() {
        @Override
        public Drink createFromParcel(Parcel in) {
            return new Drink(in);
        }

        @Override
        public Drink[] newArray(int size) {
            return new Drink[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        if (calories == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(calories);
        }
    }
}

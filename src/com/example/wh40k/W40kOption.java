package com.example.wh40k;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Urgak_000 on 21.03.2015.
 */
public class W40kOption implements Parcelable {
     @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(cost);
        parcel.writeString(getDescription());
    }

    private String name;
    private Integer cost;
    private Integer value;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String toString() {
        return name;
    }

    public static final Parcelable.Creator<W40kOption> CREATOR = new Parcelable.Creator<W40kOption>(){
        @Override
        public W40kOption createFromParcel(Parcel parcel) {
            W40kOption option = new W40kOption();
            option.name = parcel.readString();
            option.cost = parcel.readInt();
            option.setDescription(parcel.readString());
            return option;
        }

        @Override
        public W40kOption[] newArray(int i) {
            return new W40kOption[i];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.portfolio_new.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {
    private String organisation;
    private String name;
    private String year;

    public Course(String organisation, String name, String year) {
        this.organisation = organisation;
        this.name = name;
        this.year = year;
    }

    protected Course(Parcel in) {
        organisation = in.readString();
        name = in.readString();
        year = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(organisation);
        dest.writeString(name);
        dest.writeString(year);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

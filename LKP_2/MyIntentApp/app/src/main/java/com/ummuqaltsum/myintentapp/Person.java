package com.ummuqaltsum.myintentapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String name;
    private int age;
    private String email;

    private String city;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.city);
        dest.writeInt(this.age);
        dest.writeString(this.email);
        dest.writeString(this.name);
    }

    public void readFromParcel(Parcel source) {
        this.city = source.readString();
        this.age = source.readInt();
        this.email = source.readString();
        this.name = source.readString();
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.city = in.readString();
        this.age = in.readInt();
        this.email = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}


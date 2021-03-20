package com.example.myapplication;

public class DriverList
{
    private String name;
    private String dis;
    private double lat,lon;
    private String phno;
    private String car_type;
    public DriverList(String name,String dis,double lat,double lon,String phno, String car_type)
    {
        this.name=name;
        this.dis=dis;
        this.lat=lat;
        this.lon=lon;
        this.phno=phno;
        this.car_type = car_type;
    }

    public String getPhno() {
        return phno;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getName(){
        return name;
    }
    public String getDis() {
        return dis;
    }
    public String getCar_type() {return car_type;}
    public void setDis(String dis) {
        this.dis = dis;
    }
    public void setName(String name) {
        this.name = name;
    }


}

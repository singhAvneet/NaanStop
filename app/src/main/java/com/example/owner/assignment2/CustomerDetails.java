package com.example.owner.assignment2;

import java.io.Serializable;

/**
 * Created by Owner on 2015-09-27.
 */
public class CustomerDetails implements Serializable {
    private String name="",place="",brand="",emal="",order="",credit="";
    public CustomerDetails(String name,String place,String brand,String email,String credit,String order){
        this.name=name;
        this.place=place;
        this.brand=brand;
        this.emal=email;
        this.credit=credit;
        this.order=order;
    }
    public String getname() { return name;  }
    public String getCredite() {  return credit; }
    public String getPlace() { return place;  }
    public String getOrder() { return order;  }
    public String getEmail() {
        return emal;
    }
    public String getBrand() { return brand;  }






}

package com.example.tanvir.adddata;

import java.util.Date;

/**
 * Created by Tanvir on 2/23/2018.
 */

public class Item {
    private String WishString;
    private Date date;

    public Item(String WishString,Date date){
        super();
        this.WishString=WishString;
        this.date=date;
    }

    public void setWString(String WishString){
        this.WishString=WishString;
    }
    public String getWishString(){
        return WishString;
    }
    public void setdate(Date date){
        this.date=date;
    }
    public Date getDate(){
        return date;
    }

}

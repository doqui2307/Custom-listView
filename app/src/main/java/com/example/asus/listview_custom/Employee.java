package com.example.asus.listview_custom;

import static android.os.Build.ID;

/**
 * Created by ASUS on 3/17/2017.
 */

public class Employee {
    private String id;
    private String name;
    private boolean sex;
    public String getID()
    {
        return ID;
    }
    public void setID(String id)
    {
        this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public boolean isSex()
    {
        return sex;
    }
    public void setSex(boolean sex)
    {
        this.sex=sex;
    }
    public String toString()
    {
        return this.id +"-"+ this.name;
    }
}

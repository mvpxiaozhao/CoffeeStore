package com.example.dell.coffeestore.Class;

/**
 * Created by dell on 2017/07/18.
 */

public class T_feedbackinformation {
    public int feedID;
    public String Name;
    public String type;
    public String feedcontent;
    public String fendphone;
    public T_feedbackinformation(String name,String type,String feedcontent,String fendphone)
    {
        this.Name=name;
        this.type=type;
        this.feedcontent=feedcontent;
        this.fendphone=fendphone;
    }
    public String showInfo(){
        String text="";
        text+="ID:"+feedID+"   ";
        text+="姓名:"+Name+"   ";
        text+="类型:"+type+"   ";
        text+="内容:"+feedcontent+"   ";
        text+="电话号码:"+fendphone+";\n";
        return  text;
    }
}


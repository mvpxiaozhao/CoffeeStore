package com.example.dell.coffeestore.Class;

/**
 * Created by dell on 2017/07/18.
 */

public class T_styleinformation {
    public int ID;
    public String Name;
    public String Phone_Number;
    public String Address;
    public String E_mail;
    public T_styleinformation(String name,String phone_number,String address,String e_mail)
    {
        this.Name=name;
        this.Phone_Number=phone_number;
        this.Address=address;
        this.E_mail=e_mail;
    }
    public String showInfo(){
        String text="";
        text+="ID:"+ID+"   ";
        text+="姓名:"+Name+"   ";
        text+="电话号码:"+Phone_Number+"   ";
        text+="地址:"+Address+"   ";
        text+="电子邮件:"+E_mail+";\n";
        return  text;
    }
}


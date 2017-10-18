package com.example.dell.coffeestore.Class;

/**
 * Created by dell on 2017/07/18.
 */

public class T_addressinformation {
    public int user_id;
    public String user_name;
    public String user_password;
    public String user_birthday;
    public String user_sex;
    public String user_phone;
    public T_addressinformation(int user_id, String user_name,String user_password,String user_birthday,String user_sex,String user_phone)
    {
        this.user_id=user_id;
        this.user_name=user_name;
        this.user_password=user_password;
        this.user_birthday=user_birthday;
        this.user_sex=user_sex;
        this.user_phone=user_phone;
    }
    public String showInfo(){
        String text="";
        text+="ID:"+user_id+"   ";
        text+="姓名:"+user_name+"   ";
        text+="密码:"+user_password+"   ";
        text+="生日:"+user_birthday+"   ";
        text+="性别:"+user_sex+"  ";
        text+="手机号"+user_phone+";\n";

        return  text;
    }
}


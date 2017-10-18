package com.example.dell.coffeestore.Class;

/**
 * Created by dell on 2017/07/18.
 */

public class T_userinformation {
    public int id1;
    public String user_name1;
    public String user_password1;
    public String user_birthday1;
    public String user_sex1;
    public String user_phone1;
    public T_userinformation( String user_name,String user_password,String user_birthday,String user_sex,String user_phone)
    {

        this.user_name1=user_name;
        this.user_password1=user_password;
        this.user_birthday1=user_birthday;
        this.user_sex1=user_sex;
        this.user_phone1=user_phone;
    }
    public String showInfo(){
        String text="";
        text+="ID:"+id1+"   ";
        text+="姓名:"+user_name1+"   ";
        text+="密码:"+user_password1+"   ";
        text+="生日:"+user_birthday1+"   ";
        text+="性别:"+user_sex1+"  ";
        text+="手机号"+user_phone1+";\n";

        return  text;
    }
}


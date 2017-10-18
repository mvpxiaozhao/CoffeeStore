package com.example.dell.coffeestore.Class;

public class PeopleInfo {

	public int ID;
	public String Name;
	public String Phone_Number;
	public String Address;
	public String E_mail;
	public PeopleInfo(String name, String phone_number, String address, String e_mail)
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
		text+="密码:"+Phone_Number+"   ";
		text+="性别:"+Address+"   ";
		text+="电话:"+E_mail+";\n";
		return  text;
	}
	public String name(){
		String text=Name;

		return  text;
	}
	public String pass(){
		String text=Phone_Number;

		return  text;
	}
}

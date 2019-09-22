package com.aui.web.Interfaces;

public interface RegisterUser {
	
int userExist(String user);

int contactExist(String contact);
int registerUser(String first,String last,String user,String password,String contact,String address);

}

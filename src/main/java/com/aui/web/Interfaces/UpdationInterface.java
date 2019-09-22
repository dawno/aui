package com.aui.web.Interfaces;

public interface UpdationInterface {
	int userExist(String user);
int passwordMatch(String user,String oldPassword);

int updatePassword(String user,String newPassword);
}

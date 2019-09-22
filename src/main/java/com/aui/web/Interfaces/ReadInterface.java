package com.aui.web.Interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ReadInterface {
int  userExist(String user);
void readUser(String user,HttpServletRequest request,HttpServletResponse response);
}

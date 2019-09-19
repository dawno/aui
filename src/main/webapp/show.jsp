<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import ="com.aui.web.models.User" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details</title>
</head>
<body>
<h1>Details<h1>

<%  
/* User user= (User)request.getAttribute("UserObject");
 String first_name= user.getFirst();
String second_name= user.getSecond();
String address= user.getAddress();
String contact= user.getContact();*/
String first_name=(String) request.getAttribute("first_name");
String last_name =(String) request.getAttribute("last_name");
String contact=(String) request.getAttribute("contact");
String address=(String) request.getAttribute("address");
String firstName=(String) request.getAttribute("firstName");
String lastName =(String) request.getAttribute("lastName");
String contactInfo=(String) request.getAttribute("contactInfo");
String addressName=(String) request.getAttribute("addressName");
out.println("Data from sql");
out.println(first_name);
out.println(last_name);
out.println(contact);
out.println(address);
out.println("Data fron mongo");
out.println(firstName);
out.println(lastName);
out.println(contactInfo);
out.println(addressName);

%>


</body>
</html>
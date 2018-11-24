<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Spring MVC Form Handling</title>
 </head>
 <body>
 <marquee>Logged In User ${LoggedInUserEmailId}</marquee>
 
   <c:if test="${!empty users}">
  <h2>List Users</h2>
 <table align="left" border="1">
  <tr>
   <th>Employee ID</th>
   <th>Employee Email</th>
           <th>Actions on Row</th>
  </tr>

  <c:forEach items="${users}" var="user">
   <tr>
    <td><c:out value="${user.id}"/></td>
    <td><c:out value="${user.emailId}"/></td>
    <td align="center"><a href="chat.html?id=${user.id}">Chat</a></td>
   </tr>
  </c:forEach>
 </table>
</c:if> 

<br>
<br>
<br>
<br>

   <c:if test="${!empty chatId}">
   <form action="submitChat.html">
   <input type="text" size="20" name="chatmessage">
   <input type="hidden" name="selectedChatId" value="${chatId}">
   <input type="submit" value="chat">
   </form>
   </c:if>
</body>
</html>
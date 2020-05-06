<%@page import="javax.faces.convert.BigIntegerConverter"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.DbConnection"%>
<%
String firstname = request.getParameter("firstname");
String lastname = request.getParameter("lastname");
String username = request.getParameter("username");
String email = request.getParameter("email");
String password = request.getParameter("password");
Long phone = Long.parseLong(request.getParameter("phone"));
String gender = request.getParameter("gender");
String answer = request.getParameter("answer");
String address = request.getParameter("address");
String country = request.getParameter("country");
DbConnection db = new DbConnection();
Connection con = db.createConnection();
PreparedStatement pstm = con.prepareStatement("insert into admin values(null,?,?,?,?,?,?,?,CURDATE(),?,?,?)");
pstm.setString(1, firstname);
pstm.setString(2, lastname);
pstm.setString(3, username);
pstm.setString(4, email);
pstm.setString(5, password);
pstm.setString(6, gender);
pstm.setLong(7, phone);
pstm.setString(8, answer);
pstm.setString(9, address);
pstm.setString(10, country);
pstm.executeUpdate();
con.close();
%>
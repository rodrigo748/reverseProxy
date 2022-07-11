package com.RequestHeaders;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestHeaders")
public class RequestHeaders extends HttpServlet {
   
 protected void doGet(
   HttpServletRequest request,
   HttpServletResponse response)
   throws ServletException, IOException
 {
  
  doPost(request, response);
    
 }

 
 protected void doPost(
   HttpServletRequest request, 
   HttpServletResponse response) 
   throws ServletException, IOException 
 {
  Enumeration<String> headers = request.getHeaderNames();
  PrintWriter out = response.getWriter();
  response.setContentType("text/html");
  out.print("<html>");
  out.print("<body>");
  out.print("<h1>The Request Headers are as follows : </h1>");
  out.print("<table border='1'>");  
  
  while(headers.hasMoreElements())
  {
   String header = headers.nextElement();
   String headerValue = request.getHeader(header);
   out.print("<tr>");
   out.print("<td>");
   out.print(header);
   out.print("</td>");
   out.print("<td>");
   out.print(headerValue);   
   out.print("</td>");
   out.print("</tr>");
  }
  out.print("</table>");
  out.print("</body>");  
  out.print("</html>");

 }
}

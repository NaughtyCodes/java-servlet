package com.lab.call;

//Import required java libraries
import java.io.*;
import java.util.stream.Collectors;

import javax.servlet.*;
import javax.servlet.http.*;

//Extend HttpServlet class
public class ServiceCall extends HttpServlet {

	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "I Am Getting This Service Call Out";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie c1 = new Cookie("CookieMessage", "Get-Call-Cookie-Setted");
		response.addCookie(c1);
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("hi....." + message + ".....!!!");
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie c1 = new Cookie("CookieMessage", "Post-Call-Cookie-Setted");
		response.addCookie(c1);
		// Set response content type
		response.setContentType("text/html");
		String data = request.getReader().lines().collect(Collectors.joining());;
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("hi....." + data  + ".....!!!");
		out.close();
	}

	public void destroy() {
		// do nothing.
	}
}
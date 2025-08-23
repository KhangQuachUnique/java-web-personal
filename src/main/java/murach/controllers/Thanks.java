package murach.controllers;

import murach.data.UserDB;
import murach.models.User;

import java.util.Enumeration;
import java.util.logging.Logger;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Thanks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Logger logger = Logger.getLogger(Thanks.class.getName());

        // Log request details
        logger.info("Request Method: " + request.getMethod());
        logger.info("Request URI: " + request.getRequestURI());
        logger.info("Query String: " + request.getQueryString());
        logger.info("Client IP: " + request.getRemoteAddr());

        // Log request headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            logger.info("Header: " + headerName + " = " + request.getHeader(headerName));
        }

        // Log response details (before forwarding)
        logger.info("Response Content Type: " + response.getContentType());

        User user = UserDB.getLastUser();
        String url = "/pages/thanks.jsp";
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}



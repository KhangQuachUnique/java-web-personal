package murach.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.constants.PathConstants;

public class Survey extends HttpServlet {
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PathConstants.SURVEY_JSP;

         getServletContext()
            .getRequestDispatcher(page)
            .forward(request, response);
    }
}


package murach.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.constants.PathConstants;
import murach.data.UserDB;
import murach.models.User;

public class Survey extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String page;
        if (action == null) {
            action = "survey";  // default action
        }

        switch (action) {
            case "join":
                page = PathConstants.SURVEY_JSP; // sử dụng constant
                break;

            case "submit":
                // Lấy dữ liệu từ form
                String firstName = request.getParameter("firstName");
                String lastName  = request.getParameter("lastName");
                String email     = request.getParameter("email");

                // Tạo User object và lưu DB
                User user = new User(firstName, lastName, email);
                UserDB.insert(user);

                // Sử dụng constant thay vì hard-code URL
                response.sendRedirect(PathConstants.THANKS);
                return;

            default:
                page = PathConstants.SURVEY_JSP; // sử dụng constant
                break;
        }

        getServletContext()
                .getRequestDispatcher(page)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


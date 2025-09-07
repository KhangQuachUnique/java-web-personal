package murach.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.models.User;
import murach.data.UserDB;

import murach.constants.PathConstants;

public class JoinForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        String url;
        String page;
        switch (action) {
            case "join":
                page = PathConstants.JOIN_FORM_JSP; // sử dụng constant
                break;

            case "add":
                // Lấy dữ liệu từ form
                String firstName = request.getParameter("firstName");
                String lastName  = request.getParameter("lastName");
                String email     = request.getParameter("email");

                // Tạo User object và lưu DB
                User user = new User(firstName, lastName, email, "", "", "", false, "");
                UserDB.insert(user);

                // Sử dụng constant thay vì hard-code URL
                response.sendRedirect(PathConstants.THANKS);
                return;


            default:
                page = PathConstants.JOIN_FORM_JSP; // sử dụng constant
                break;
        }

        // Forward request & response
        getServletContext()
            .getRequestDispatcher(page)
            .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

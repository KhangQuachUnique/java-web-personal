package murach.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.models.User;
import murach.data.UserDB;

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
        switch (action) {
            case "join":
                url = "/pages/joinForm.jsp"; // trang đăng ký
                break;

            case "add":
                // Lấy dữ liệu từ form
                String firstName = request.getParameter("firstName");
                String lastName  = request.getParameter("lastName");
                String email     = request.getParameter("email");

                // Tạo User object và lưu DB
                User user = new User(firstName, lastName, email);
                UserDB.insert(user);

                url = "/untitled/thanks"; // trang cảm ơn
                response.sendRedirect(url);
                return;

            default:
                url = "/pages/joinForm.jsp";
                break;
        }

        // Forward request & response
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

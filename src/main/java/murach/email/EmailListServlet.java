package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.business.User;
import murach.data.UserDB;

public class EmailListServlet extends HttpServlet {

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
                url = "/index.jsp"; // trang đăng ký
                break;

            case "add":
                // Lấy dữ liệu từ form
                String firstName = request.getParameter("firstName");
                String lastName  = request.getParameter("lastName");
                String email     = request.getParameter("email");

                // Tạo User object và lưu DB
                User user = new User(firstName, lastName, email);
                UserDB.insert(user);

                // Gửi user object sang JSP
                request.setAttribute("user", user);

                url = "/thanks.jsp"; // trang cảm ơn
                break;

            default:
                url = "/index.jsp";
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

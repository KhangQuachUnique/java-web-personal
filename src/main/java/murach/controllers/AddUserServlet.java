package murach.controllers;

import murach.data.UserRepository;
import murach.models.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", urlPatterns = {"/users/add"})
public class AddUserServlet extends HttpServlet {

    private final UserRepository repo = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/add_user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = trim(req.getParameter("name"));
        String email = trim(req.getParameter("email"));
        String phone = trim(req.getParameter("phone"));

        // simple validation
        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            req.setAttribute("error", "Vui lòng nhập đầy đủ Name và Email.");
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("phone", phone);
            doGet(req, resp);
            return;
        }

        try {
            UserEntity u = new UserEntity(name, email, phone);
            repo.save(u);
        } catch (RuntimeException ex) {
            req.setAttribute("error", "Lỗi lưu user: " + ex.getMessage());
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("phone", phone);
            doGet(req, resp);
            return;
        }

        // redirect back to list with a message
        resp.sendRedirect(req.getContextPath() + "/users?msg=User%20added");
    }

    private String trim(String s) {
        return s == null ? null : s.trim();
    }
}

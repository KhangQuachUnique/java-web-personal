package murach.controllers;

import murach.data.UserRepository;
import murach.data.SchemaEnsurer;
import murach.models.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {

    private final UserRepository userRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // defensive: ensure schema before querying
        SchemaEnsurer.ensureUsersTable();
        try {
            List<UserEntity> users = userRepository.findAll();
            req.setAttribute("users", users);
        } catch (Exception e) {
            req.setAttribute("error", "Không thể kết nối tới database: " + e.getMessage());
        }
        req.getRequestDispatcher("/pages/users.jsp").forward(req, resp);
    }
}

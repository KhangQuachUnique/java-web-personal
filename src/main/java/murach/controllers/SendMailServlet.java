package murach.controllers;

import murach.util.SendMailUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendMailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/sendMail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String baseUrl = req.getRequestURL().toString().replace(req.getRequestURI(), req.getContextPath());
        // Dummy verification link for demo; in real app, generate token and persist
        String verifyLink = baseUrl + "/thanks";
        try {
            SendMailUtil.sendVerification(email, verifyLink);
            req.setAttribute("message", "Đã gửi email xác nhận tới " + email);
        } catch (Exception e) {
            req.setAttribute("error", "Gửi email thất bại: " + e.getMessage());
        }
        req.getRequestDispatcher("/pages/sendMail.jsp").forward(req, resp);
    }
}

package murach.controllers;

import murach.data.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SqlConsoleServlet", urlPatterns = {"/sql"})
public class SqlConsoleServlet extends HttpServlet {

    private static final String DEFAULT_SQL = "select * from users";
    private static final int MAX_ROWS = 200;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("sql") == null) {
            req.setAttribute("sql", DEFAULT_SQL);
        }
        req.getRequestDispatcher("/pages/sql.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = req.getParameter("sql");
        if (sql == null || sql.trim().isEmpty()) {
            sql = DEFAULT_SQL;
        }

        String normalized = sql.trim().toLowerCase();
        // Allow SELECT and WITH (for CTEs) only, block other statements for safety
        if (!(normalized.startsWith("select") || normalized.startsWith("with"))) {
            req.setAttribute("error", "Chỉ hỗ trợ câu lệnh SELECT/WITH để đọc dữ liệu.");
            req.setAttribute("sql", sql);
            doGet(req, resp);
            return;
        }

        long start = System.currentTimeMillis();
        List<String> columns = new ArrayList<>();
        List<List<Object>> rows = new ArrayList<>();
        int rowCount = 0;
        String error = null;

        try (Connection conn = DbUtil.getConnection();
             Statement st = conn.createStatement()) {
            st.setMaxRows(MAX_ROWS);
            boolean hasResult = st.execute(sql);
            if (hasResult) {
                try (ResultSet rs = st.getResultSet()) {
                    ResultSetMetaData meta = rs.getMetaData();
                    int colCount = meta.getColumnCount();
                    for (int i = 1; i <= colCount; i++) {
                        columns.add(meta.getColumnLabel(i));
                    }
                    while (rs.next()) {
                        List<Object> row = new ArrayList<>(colCount);
                        for (int i = 1; i <= colCount; i++) {
                            Object val = rs.getObject(i);
                            row.add(val);
                        }
                        rows.add(row);
                        rowCount++;
                    }
                }
            }
        } catch (SQLException e) {
            error = e.getMessage();
        }

        long elapsed = System.currentTimeMillis() - start;
        req.setAttribute("sql", sql);
        req.setAttribute("columns", columns);
        req.setAttribute("rows", rows);
        req.setAttribute("rowCount", rowCount);
        req.setAttribute("elapsedMs", elapsed);
        if (error != null) req.setAttribute("error", error);

        req.getRequestDispatcher("/pages/sql.jsp").forward(req, resp);
    }
}

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%
    String sql = (String) request.getAttribute("sql");
    if (sql == null) sql = "select * from users";
    String error = (String) request.getAttribute("error");
    List<String> columns = (List<String>) request.getAttribute("columns");
    List<List<Object>> rows = (List<List<Object>>) request.getAttribute("rows");
    Integer rowCount = (Integer) request.getAttribute("rowCount");
    Long elapsed = (Long) request.getAttribute("elapsedMs");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>SQL Console</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        textarea { width: 100%; height: 120px; font-family: Consolas, monospace; }
        .actions { margin: 10px 0; }
        .error { color: #b00020; margin-top: 10px; white-space: pre-wrap; }
        table { border-collapse: collapse; width: 100%; margin-top: 16px; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background: #f4f4f4; text-align: left; }
        .meta { color: #666; margin-top: 8px; }
        .hint { color: #666; margin: 8px 0; }
        .nav { margin-bottom: 16px; }
        .nav a { text-decoration: none; color: #0366d6; }
    </style>
</head>
<body>
<div class="nav"><a href="<%=request.getContextPath()%>/">&laquo; Trang chủ</a></div>
<h1>SQL Console (read-only)</h1>
<p class="hint">Chỉ hỗ trợ SELECT/WITH để đọc dữ liệu. Mặc định: <code>select * from users</code>.</p>

<form method="post" action="<%=request.getContextPath()%>/sql">
    <textarea name="sql"><%= sql %></textarea>
    <div class="actions">
        <button type="submit">Run query</button>
    </div>
</form>

<% if (error != null) { %>
    <div class="error">Error: <%= error %></div>
<% } %>

<% if (rows != null && columns != null) { %>
    <div class="meta">Rows: <%= rowCount %> <% if (elapsed != null) { %>| Time: <%= elapsed %> ms<% } %></div>
    <table>
        <thead>
        <tr>
            <% for (String c : columns) { %>
            <th><%= c %></th>
            <% } %>
        </tr>
        </thead>
        <tbody>
        <% for (List<Object> r : rows) { %>
        <tr>
            <% for (Object v : r) { %>
            <td><%= v %></td>
            <% } %>
        </tr>
        <% } %>
        </tbody>
    </table>
<% } %>

</body>
</html>

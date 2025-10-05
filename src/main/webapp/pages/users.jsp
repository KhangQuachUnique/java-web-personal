<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="murach.models.UserEntity" %>
<%
    List<UserEntity> users = (List<UserEntity>) request.getAttribute("users");
    String msg = request.getParameter("msg");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="vi">
      <head>
        <meta charset="UTF-8" />
        <title>Users</title>
        <style>
          body {
            font-family: Arial, sans-serif;
            margin: 20px;
          }
          table {
            border-collapse: collapse;
            width: 100%;
          }
          th,
          td {
            border: 1px solid #ddd;
            padding: 8px;
          }
          th {
            background: #f4f4f4;
            text-align: left;
          }
          .toolbar {
            margin: 12px 0;
            display: flex;
            gap: 8px;
            align-items: center;
          }
          .msg {
            color: #2e7d32;
          }
          a.btn {
            background: #0366d6;
            color: white;
            padding: 6px 10px;
            text-decoration: none;
            border-radius: 4px;
          }
          a.link {
            text-decoration: none;
            color: #0366d6;
          }
        </style>
      </head>
      <body>
        <div class="toolbar">
          <a class="link" href="<%=request.getContextPath()%>/"
            >&laquo; Trang chủ</a
          >
          <a class="btn" href="<%=request.getContextPath()%>/users/add"
            >+ Add user</a
          >
          <% if (msg != null) { %><span class="msg"><%= msg %></span><% } %>
          <span style="margin-left: auto"
            ><a class="link" href="<%=request.getContextPath()%>/sql"
              >SQL Console</a
            ></span
          >
        </div>

  <h1>Users</h1>
  <% if (error != null) { %>
  <div style="color:#b00020; margin: 8px 0;">Error: <%= error %></div>
  <% } %>

  <% if (users == null) { %>
  <p>Không thể tải dữ liệu.</p>
  <% } else if (users.isEmpty()) { %>
  <p>Chưa có user nào.</p>
        <% } else { %>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Phone</th>
            </tr>
          </thead>
          <tbody>
            <% for (UserEntity u : users) { %>
            <tr>
              <td><%= u.getId() %></td>
              <td><%= u.getName() %></td>
              <td><%= u.getEmail() %></td>
              <td><%= u.getPhoneNumber() %></td>
            </tr>
            <% } %>
          </tbody>
        </table>
        <% } %>
      </body>
    </html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %> <% String
error = (String) request.getAttribute("error"); String name = (String)
request.getAttribute("name"); String email = (String)
request.getAttribute("email"); String phone = (String)
request.getAttribute("phone"); %>
<!DOCTYPE html>
<html lang="vi">
  <head>
    <meta charset="UTF-8" />
    <title>Add User</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 20px;
      }
      label {
        display: block;
        margin-top: 10px;
      }
      input {
        width: 320px;
        padding: 6px;
      }
      .error {
        color: #b00020;
        margin: 10px 0;
      }
      .actions {
        margin-top: 12px;
      }
      a {
        text-decoration: none;
        color: #0366d6;
      }
    </style>
  </head>
  <body>
    <div>
      <a href="<%=request.getContextPath()%>/users">&laquo; Back to Users</a>
    </div>
    <h1>Add User</h1>

    <% if (error != null) { %>
    <div class="error"><%= error %></div>
    <% } %>

    <form method="post" action="<%=request.getContextPath()%>/users/add">
      <label>
        Name <input type="text" name="name" value="<%= name != null ? name : ""
        %>" required>
      </label>
      <label>
        Email <input type="email" name="email" value="<%= email != null ? email
        : "" %>" required>
      </label>
      <label>
        Phone <input type="text" name="phone" value="<%= phone != null ? phone :
        "" %>">
      </label>
      <div class="actions">
        <button type="submit">Save</button>
      </div>
    </form>
  </body>
</html>

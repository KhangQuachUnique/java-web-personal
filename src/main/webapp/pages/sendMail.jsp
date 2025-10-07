<%@ page contentType="text/html; charset=UTF-8" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
  <head>
    <meta charset="UTF-8" />
    <title>Gửi email xác nhận</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/styles/emailList.css"
    />
    <style>
      .container {
        max-width: 520px;
        margin: 40px auto;
        padding: 24px;
        border: 1px solid #e5e7eb;
        border-radius: 8px;
      }
      label {
        display: block;
        margin-bottom: 8px;
        font-weight: 600;
      }
      input[type="email"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #cbd5e1;
        border-radius: 6px;
      }
      button {
        margin-top: 12px;
        background: #2563eb;
        color: #fff;
        border: none;
        padding: 10px 16px;
        border-radius: 6px;
        cursor: pointer;
      }
      .msg {
        margin-top: 12px;
        padding: 10px;
        border-radius: 6px;
      }
      .ok {
        background: #ecfdf5;
        color: #065f46;
        border: 1px solid #34d399;
      }
      .err {
        background: #fef2f2;
        color: #991b1b;
        border: 1px solid #fca5a5;
      }
    </style>
    <jsp:include page="../includes/header.html" />
  </head>
  <body>
    <div class="container">
      <h2>Gửi email xác nhận</h2>
      <form method="post" action="${pageContext.request.contextPath}/send-mail">
        <label for="email">Email</label>
        <input
          id="email"
          name="email"
          type="email"
          required
          placeholder="nhap@example.com"
        />
        <button type="submit">Gửi email xác nhận</button>
      </form>

      <c:if test="${not empty message}">
        <div class="msg ok">${message}</div>
      </c:if>
      <c:if test="${not empty error}">
        <div class="msg err">${error}</div>
      </c:if>
      <p style="margin-top: 16px">
        <a href="${pageContext.request.contextPath}/index.jsp">Trang chủ</a>
      </p>
    </div>

    <jsp:include page="../includes/footer.jsp" />
  </body>
</html>

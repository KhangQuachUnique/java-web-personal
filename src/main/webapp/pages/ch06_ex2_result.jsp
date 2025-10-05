<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Created by
IntelliJ IDEA. User: kadfw Date: 9/7/2025 Time: 11:28 AM To change this template
use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
    <link rel="stylesheet" href="../styles/vintage.css" />
  </head>
  <body>
    <h1>Thanks for taking our survey!</h1>

    <p>
      <label><b>Email:</b></label>
      <span>${user.email}</span>
    </p>
    <p>
      <label><b>First Name:</b></label>
      <span>${user.firstName}</span>
    </p>
    <p>
      <label><b>Last Name:</b></label>
      <span>${user.lastName}</span>
    </p>
    <p>
      <label><b>Heard From:</b></label>
      <span>${user.heardFrom}</span>
    </p>
    <p>
      <label><b>Updates:</b></label>
      <span>${user.wantsUpdates}</span>
    </p>

    <c:if test="${user.wantsUpdates eq 'Yes'}">
      <p>
        <label><b>Contact Via:</b></label>
        <span>${user.contactVia}</span>
      </p>
    </c:if>
  </body>
</html>

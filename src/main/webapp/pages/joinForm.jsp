<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title><%= application.getInitParameter("siteTitle") %></title>
    <link rel="stylesheet" href="../styles/joinForm.css" />
  </head>
  <body class="form-body">
    <h1>JOIN OUR EMAIL LIST</h1>
    <span
      >To join our email list, enter your name and email address below.</span
    >

    <form action="join" method="post">
      <input type="hidden" name="action" value="add" />
      <div class="input-element">
        <label for="firstName">First name: </label>
        <input type="text" id="firstName" name="firstName" required />
      </div>
      <div class="input-element">
        <label for="lastName">Last name: </label>
        <input type="text" id="lastName" name="lastName" required />
      </div>
      <div class="input-element">
        <label for="email">Email: </label>
        <input type="email" id="email" name="email" required />
      </div>
      <button type="submit" class="submit-button">Join now</button>
    </form>
  </body>
</html>

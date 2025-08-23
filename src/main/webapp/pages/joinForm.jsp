<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Form</title>
    <link rel="stylesheet" href="index.css" />
  </head>
  <body>
    <h1>Join our email list</h1>
    <span>To join our email list, enter your name and email address below.</span>

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


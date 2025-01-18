<%@page isELIgnored = "false"%>
<html>
<head>
<title>Practice project</title>
</head>
<body>
<h2>${msg}</h2>
<form action="signup" method="post">
<pre>
Name    <input type="text" name="name">
Email   <input type="email" name="email">
password<input type="password" name="password">
Phone No<input type="number" name="phone">


<input type="submit" value="Login">
</pre>
</form>
</body>
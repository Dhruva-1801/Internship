<%
    String user = (String) session.getAttribute("username");
    if (user == null) {
        request.setAttribute("error", "Session expired. Please login again.");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome <%= user %></h2>
<a href="LogoutServlet">Logout</a>
</body>
</html>
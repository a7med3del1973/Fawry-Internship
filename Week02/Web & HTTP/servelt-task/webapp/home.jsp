<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        /* Add your styling here or link to your CSS file */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        nav {
            background-color: #333;
            color: #fff;
            padding: 10px 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        nav ul li {
            display: inline;
            margin-right: 20px;
        }
        nav ul li a {
            color: #fff;
            text-decoration: none;
        }
        .container {
            padding: 20px;
        }
        h1 {
            color: #333;
        }
    </style>
</head>
<body>

<nav>
    <div>
        <a href="${pageContext.request.contextPath}/home" style="color: #fff; text-decoration: none;">Home</a>
    </div>
    <ul>
        <%
            // Check if user is logged in
            Boolean isLoggedIn = true;
            if (isLoggedIn != null && isLoggedIn) {
        %>
            <li><a href="${pageContext.request.contextPath}/products">All Products</a></li>
            <li><a href="${pageContext.request.contextPath}/my-products">My Products</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        <%
        } else {
        %>
            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
        <%
            }
        %>
    </ul>
</nav>

<div class="container">
    <h1>Welcome to Our Product Management System</h1>
    <p>Manage your products with ease. If you're not logged in, please log in to access your products and more.</p>
    <p>
        <% if (isLoggedIn != null && isLoggedIn) { %>
            <a href="${pageContext.request.contextPath}/products">View All Products</a> |
            <a href="${pageContext.request.contextPath}/my-products">View My Products</a>
        <% } else { %>
            <a href="${pageContext.request.contextPath}/login">Login</a> to access your products.
        <% } %>
    </p>
</div>

</body>
</html>

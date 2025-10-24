<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Portal</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(#74ebd5, #ACB6E5);
        height: 100vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .login-container {
        background: #fff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 8px 16px rgba(0,0,0,0.2);
        width: 350px;
        text-align: center;
    }
    .login-container h1 {
        margin-bottom: 30px;
        color: #333;
    }
    .role-button {
        background-color: #2A2F4F;
        color: white;
        border: none;
        padding: 15px 25px;
        margin: 10px 0;
        border-radius: 5px;
        width: 100%;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    .role-button:hover {
        background-color: #1d2036;
    }
</style>

</head>
<body>

<div class="login-container">
    <h1>Welcome to Portal</h1>

    <!-- Admin Login -->
    <form action="AdminLogin.jsp" method="post">
        <button type="submit" class="role-button">Admin Login</button>
    </form>

    <!-- Agent Login -->
    <form action="AgentLogin.jsp" method="post">
        <button type="submit" class="role-button">Agent Login</button>
    </form>

    <!-- User Login -->
    <form action="Login.html" method="post">
        <button type="submit" class="role-button">User Login</button>
    </form>
</div>

</body>
</html>

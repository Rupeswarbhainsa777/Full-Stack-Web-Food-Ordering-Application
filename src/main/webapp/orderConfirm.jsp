<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #00c6ff, #0072ff);
        height: 100vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .confirmation-container {
        background: #fff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 8px 16px rgba(0,0,0,0.2);
        width: 400px;
        text-align: center;
    }
    .confirmation-container h1 {
        color: #28a745;
        margin-bottom: 20px;
    }
    .order-details {
        margin-top: 20px;
        text-align: left;
    }
    .order-details p {
        margin: 8px 0;
    }
    .home-button {
        margin-top: 30px;
        background-color: #28a745;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        text-decoration: none;
    }
    .home-button:hover {
        background-color: #218838;
    }
</style>

</head>
<body>

<%
    String orderId = (String) request.getAttribute("orderId");
    String paymentMethod = (String) request.getAttribute("paymentMethod");
    Double totalPrice = (Double) request.getAttribute("totalPrice");
    Date orderDate = new Date(); // or get from DB if available
%>

<div class="confirmation-container">
    <h1>Thank You!</h1>
    <p>Your order has been placed successfully.</p>

    <div class="order-details">
        <p><strong>Order ID:</strong> <%= orderId != null ? orderId : "N/A" %></p>
        <p><strong>Payment Method:</strong> <%= paymentMethod != null ? paymentMethod : "N/A" %></p>
        <p><strong>Total Amount:</strong> ₹<%= totalPrice != null ? String.format("%.2f", totalPrice) : "0.00" %></p>
        <p><strong>Order Date:</strong> <%= orderDate.toString() %></p>
    </div>

    <a href="Home.jsp" class="home-button">Back to Home</a>
</div>

</body>
</html>

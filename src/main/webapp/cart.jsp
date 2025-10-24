<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.modeal.Cart, com.tap.modeal.CartItem, java.util.*, java.text.DecimalFormat" %>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    DecimalFormat df = new DecimalFormat("₹#.00");
    double subtotal = 0.0;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1000px;
            margin: 40px auto;
            padding: 20px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(0,0,0,0.05);
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 16px;
            border-bottom: 1px solid #eaeaea;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            font-weight: 600;
        }

        .remove-link {
            color: #f44336;
            font-size: 12px;
            margin-top: 4px;
            display: inline-block;
            text-decoration: none;
        }

        .summary {
            display: flex;
            justify-content: space-between;
            margin-top: 40px;
            gap: 20px;
            flex-wrap: wrap;
        }

        .coupon, .cart-summary {
            flex: 1;
            background: #fafafa;
            padding: 20px;
            border-radius: 10px;
            border: 1px solid #ddd;
        }

        .coupon input[type="text"] {
            width: 70%;
            padding: 8px;
            margin-right: 10px;
        }

        .coupon button {
            padding: 8px 16px;
        }

        .cart-summary label {
            display: block;
            margin-bottom: 10px;
        }

        .checkout {
            width: 100%;
            padding: 12px;
            background: black;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            margin-top: 20px;
            cursor: pointer;
        }

        .add-more-btn {
            display: inline-block;
            padding: 10px 18px;
            background: #444;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 14px;
            margin-top: 20px;
        }

        .qty-btn {
            width: 32px;
            height: 32px;
            font-size: 18px;
            font-weight: bold;
            border: 1px solid #ccc;
            background: #fff;
            cursor: pointer;
            border-radius: 6px;
        }

        .quantity-input {
            width: 45px;
            text-align: center;
            margin: 0 6px;
            background: #f2f2f2;
            border: none;
            pointer-events: none;
        }

        .empty-cart {
            text-align: center;
            font-size: 24px;
            color: #777;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Cart</h1>

    <% if (cart != null && !cart.getItems().isEmpty()) { %>
    <table>
        <thead>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Subtotal</th>
            </tr>
        </thead>
        <tbody>
            <% for (CartItem item : cart.getItems().values()) {
                   double itemTotal = item.getPrice() * item.getQuantity();
                   subtotal += itemTotal;
            %>
            <tr>
                <td>
                    <strong><%= item.getName() %></strong><br/>
                    <a href="Cart?action=remove&itemId=<%= item.getItemId() %>" class="remove-link">Remove</a>
                </td>
                <td>
                    <form action="Cart" method="post" style="display: flex; align-items: center;">
                        <input type="hidden" name="restaurantId" value="<%= item.getRestaurantId() %>">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <input type="hidden" name="action" value="update">

                        <div class="qty-group">
                            <button type="button" class="qty-btn" onclick="updateQty(this, -1)">−</button>
                            <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" class="quantity-input" readonly>
                            <button type="button" class="qty-btn" onclick="updateQty(this, 1)">+</button>
                        </div>
                    </form>
                </td>
                <td><%= df.format(item.getPrice()) %></td>
                <td><%= df.format(itemTotal) %></td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <div class="summary">
        <div class="coupon">
            <h3>Have a coupon?</h3>
            <input type="text" placeholder="Enter code">
            <button>Apply</button>
        </div>

        <div class="cart-summary">
            <h3>Cart Summary</h3>
            <label><input type="radio" name="shipping" checked> Free Shipping - ₹0.00</label>
            <label><input type="radio" name="shipping"> Express Shipping - ₹15.00</label>
            <p>Subtotal: <strong><%= df.format(subtotal) %></strong></p>
            <p>Total: <strong><%= df.format(subtotal) %></strong></p>

            <a href="Menu?restaurantId=<%= session.getAttribute("restaurantId") %>" class="add-more-btn">Add More Items</a>

            <form action="CheckOut.jsp">
                <button type="submit" class="checkout">Checkout</button>
            </form>
        </div>
    </div>

    <% } else { %>
        <div class="empty-cart">Your Cart is Empty</div>
    <% } %>
</div>

<script>
    function updateQty(button, delta) {
        const form = button.closest("form");
        const input = form.querySelector('input[name="quantity"]');
        let value = parseInt(input.value);
        if (isNaN(value)) value = 1;
        value += delta;
        if (value < 1) value = 1;
        input.value = value;
        form.submit(); // submit the form after updating quantity
    }
</script>

</body>
</html>




















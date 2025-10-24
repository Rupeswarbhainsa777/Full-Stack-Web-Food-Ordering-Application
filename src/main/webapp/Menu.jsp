<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tap.modeal.Menu" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu - Tap Food</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
        }
        .menu-container {
            margin-top: 40px;
        }
        .card img {
            height: 180px;
            object-fit: cover;
        }
        .footer {
            background-color: #2e2e2e;
            color: white;
            padding: 20px 0;
            margin-top: 40px;
            text-align: center;
        }
        .order-btn {
            background-color: #000000;
            border: none;
            color: white;
            padding: 8px 16px;
            border-radius: 5px;
        }
        .order-btn:hover {
            background-color: #e56d00;
        }
        .qty-group {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 10px;
        }
        .qty-btn {
               background-color:  #f8f9fa;
            border: none;
              border-radius: 5px;
            padding: 6px 12px;
            font-size: 16px;
        }
        .quantity-input {
            width: 50px;
            text-align: center;
            margin: 0 5px;
        }
    </style>
    <script>
        function updateQty(button, delta) {
            const input = button.parentElement.querySelector('.quantity-input');
            let qty = parseInt(input.value);
            qty = isNaN(qty) ? 1 : qty + delta;
            if (qty < 1) qty = 1;
            input.value = qty;
        }
    </script>
</head>
<body>

<!-- Header -->
<header class="d-flex justify-content-between align-items-center px-4 py-3 shadow bg-white">
    <div class="h4 text-black font-weight-bold">CodeFood</div>
    <nav>
        <ul class="nav">
            <li class="nav-item"><a class="nav-link text-dark" href="home.jsp">Home</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="cart.jsp">Cart</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="LogoutServlet">Logout</a></li>
        </ul>
    </nav>
</header>

<!-- Menu Items -->
<div class="container menu-container">
    <h2 class="mb-4 text-center">Menu</h2>
    <div class="row">
        <%
        List<Menu> obj = (List<Menu>) session.getAttribute("menuList");
        if (obj != null) {
            for (Menu item : obj) {
        %>
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="<%= item.getImagePath() %>" class="card-img-top" alt="<%= item.getItemName() %>">
                <div class="card-body">
                    <h5 class="card-title"><%= item.getItemName() %></h5>
                    <p class="card-text"><%= item.getDescription() %></p>
                    <p class="card-text font-weight-bold">₹<%= item.getItemPrice() %></p>

                    <!-- Add to Cart Form -->
                    <form action="Cart" method="post">
                        <input type="hidden" name="restaurantId" value="<%= item.getRestaurantId() %>">
                        <input type="hidden" name="itemId" value="<%= item.getMenuId() %>">
                        <input type="hidden" name="action" value="add">

                        <div class="qty-group">
                            <button type="button" class="qty-btn" onclick="updateQty(this, -1)">−</button>
                            <input type="number" name="quantity" value="1" min="1" class="quantity-input" readonly>
                            <button type="button" class="qty-btn" onclick="updateQty(this, 1)">+</button>
                        </div>

                        <div class="text-center">
                            <input type="submit" class="order-btn" value="Add to Cart">
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <div class="col-12 text-center">
            <p>No menu items available.</p>
        </div>
        <%
        }
        %>
    </div>
</div>

<!-- Footer -->
<footer class="footer">
    <p>&copy; 2025</p>
</footer>

</body>
</html>


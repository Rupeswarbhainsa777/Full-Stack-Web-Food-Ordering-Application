<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.tap.modeal.Cart"%>
<%@ page import="com.tap.modeal.CartItem"%>
<%@ page import="java.util.*"%>

<%
Cart cart = (Cart) session.getAttribute("cart");
Integer restaurantId = (Integer) session.getAttribute("restaurantId");

%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Your Cart - Tap Food</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.cart-container {
	margin-top: 40px;
}

.btn-custom {
	border: none;
	padding: 5px 10px;
	font-size: 18px;
	margin: 0 2px;
	border-radius: 50%;
	background-color: #fc8019;
	color: white;
}

.btn-custom:hover {
	background-color: #e56d00;
}

.btn-remove {
	background-color: #dc3545;
}

.btn-remove:hover {
	background-color: #b02a37;
}

.footer {
	background-color: #2e2e2e;
	color: white;
	padding: 20px 0;
	margin-top: 40px;
	text-align: center;
}
</style>
</head>
<body>

	<!-- Header -->
	<header
		class="d-flex justify-content-between align-items-center px-4 py-3 shadow bg-white">
		<div class="h4 text-warning font-weight-bold">Tap Food</div>
		<nav>
			<ul class="nav">
				<li class="nav-item"><a class="nav-link text-dark"
					href="home.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link text-dark"
					href="cart.jsp">Cart</a></li>
				<li class="nav-item"><a class="nav-link text-dark"
					href="LogoutServlet">Logout</a></li>
			</ul>
		</nav>
	</header>

	<!-- Cart Items -->
	<div class="container cart-container">
		<h2 class="text-center mb-4">Your Cart</h2>

		<%
		if (cart != null && !cart.getItems().isEmpty()) {
		%>

		<table class="table table-bordered bg-white">
			<thead class="thead-dark">
				<tr>
					<th>Item Name</th>
					<th>Quantity</th>
					<th>Price (₹)</th>
					<th>Total (₹)</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (CartItem item : cart.getItems().values()) {
				%>
				<tr>
					<td><%=item.getName()%></td>
					<td>
					
					       
						<form action="cart" method="post" style="display: inline-block;">
							<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
							<input type="hidden" name="action" value="update"> <input
								type="hidden" name="quantity"
								value="<%=item.getQuantity() + 1%>">

							<button class="btn-custom">+</button>
						</form>
						
                      <span><%=item.getQuantity()%></span>
                      
                      
                      <form action="cart" method="post" style="display: inline-block;">
							<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
							<input type="hidden" name="action" value="update"> 
							<input	type="hidden" name="quantity" 	value="<%=item.getQuantity() - 1%>">
							<button class="btn-custom" <%= item.getQuantity() == 1 ? "disabled" : "" %>>-</button>
							
					  </form> 
                      

							
								

						
						
						
					</td>
					<td>₹<%=item.getPrice()%></td>
					<td>₹<%=item.getPrice() * item.getQuantity()%></td>
					<td>
						<form action="cart" method="post">
							<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
							<input type="hidden" name="action" value="remove">
							<button class="btn btn-danger btn-sm">Remove</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<div class="text-center">
			<a href="checkout.jsp" class="btn btn-success">Proceed to
				Checkout</a>
		</div>

		<%
		} else {
		%>

		<div class="text-center">
			<h4>Your cart is empty!</h4>
			<a href="home.jsp" class="btn btn-primary mt-3">Browse Menu</a>
		</div>

		<%
		}
		%>

	</div>

	<!-- Footer -->
	<footer class="footer">
		<p>&copy; 2025</p>
	</footer>

</body>
</html>

<%@ page import="com.tap.modeal.Dish"%>
<%@ page import="com.tap.Dao.Dishdao"%>
<%@ page import="com.tap.DaoImple.DishDAOImp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
DishDAOImp dishDAO = new DishDAOImp();
    Dish specialDish = dishDAO.getSpecialDish();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resto | Home</title>
    <style >
    body {
  margin: 0;
  font-family: 'Segoe UI', sans-serif;
}

header {
  background: #fff;
  padding: 1rem 2rem;
  box-shadow: 0 2px 5px rgba(0,0,0,0.1);
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.nav-links {
  list-style: none;
  display: flex;
  gap: 1.5rem;
}

.nav-links li a {
  text-decoration: none;
  color: #333;
  font-weight: 500;
}

.hero {
  display: flex;
  align-items: center;
  justify-content: space-around;
  padding: 3rem;
}

.hero-text {
  max-width: 500px;
}

.hero-text .special {
  color: green;
  font-weight: bold;
}

.hero-text h1 {
  font-size: 3rem;
  margin: 0.5rem 0;
}

.hero-text button {
  padding: 0.7rem 1.2rem;
  font-size: 1rem;
  background-color: navy;
  color: white;
  border: none;
  cursor: pointer;
}

.hero-image img {
  width: 400px;
  border-radius: 10px;
}</style>
</head>
<body>
<header>
    <nav>
        <div class="logo">🍴CodeFood</div>
        <ul class="nav-links">
            <li><a href="home.jsp">Home</a></li>
            <li><a href="dishes.jsp">Dishes</a></li>
            <li><a href="about.jsp">About</a></li>
            <li><a href="order.jsp">Order</a></li>
        </ul>
    </nav>
</header>

<section class="hero">
    <div class="hero-text">
        <p class="special">Our Special Dish</p>
        <h1><%= specialDish != null ? specialDish.getName() : "Not Available" %></h1>
        <p><%= specialDish != null ? specialDish.getDescription() : "No description available." %></p>
        <form action="order.jsp" method="get">
            <input type="hidden" name="dish" value="<%= specialDish != null ? specialDish.getName() : "" %>">
            <button type="submit">Order Now</button>
        </form>
    </div>
    <div class="hero-image">
        <img src="<%= specialDish.getImagePath() %>" alt="Special Dish">
    </div>
</section>

</body>
</html>

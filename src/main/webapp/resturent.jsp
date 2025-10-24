<%@ page import="java.util.List"%>
<%@ page import="com.tap.modeal.Restaurant"%>
<%@ page import="com.tap.modeal.User"%>
<%@ page import="com.tap.modeal.Dish"%>
<%@ page import="com.tap.Dao.Dishdao"%>
<%@ page import="com.tap.DaoImple.DishDAOImp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
User user = (User) session.getAttribute("user1");
boolean isLoggedIn = (user != null);
List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("restaurant");
DishDAOImp dishDAO = new DishDAOImp();
List<Dish> menuList = dishDAO.getAllDishes();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tap Food - Restaurants</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f3f3f3;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #fc8019;
        }

        .navbar-brand, .nav-link {
            color: white;
        }

        .hero-text, .hero-image {
            flex: 1;
            transition: transform 0.5s ease, opacity 0.5s ease;
        }

        .footer {
            background-color: #2e2e2e;
            color: white;
            padding: 20px 0;
            margin-top: 40px;
            text-align: center;
        }

        .submit-button {
            background-color: #000000;
            border: none;
            color: white;
            padding: 10px 20px;
            margin-top: 10px;
            cursor: pointer;
            border-radius: 5px;
        }

        .submit-button:hover {
            background-color: #e57012;
        }

        .swiper {
            width: 100%;
            padding: 40px 0;
            height:80vh:
        }

        .swiper-slide {
            display: flex;
            justify-content: center;
        }

        .card1 {
            display: flex;
            flex-direction: row;  
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
            padding: 30px;
            width: 80%;
            max-width: 8800px;
        
            align-items: center;
            justify-content: space-between;
            gap: 30px;
           
        }

        .text1 {
            flex: 1;
        }

        .text1 h3 {
            color: green;
            font-size: 18px;
            margin: 0;
        }

        .text1 h1 {
            font-size: 28px;
            margin: 10px 0;
            color: #14213d;
        }

        .text1 p {
            font-size: 16px;
            color: #555;
            margin-bottom: 20px;
        }

        .text1 button {
            padding: 10px 25px;
            background: #000000;
            color: white;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .text1 button:hover {
            background: #1a1a2e;
        }

        .image1 img {
            width: 200px;
            height: 200px;
            border-radius: 12px;
            object-fit: cover;
        }

        .card {
            border-radius: 12px;
            transition: all 0.3s ease-in-out;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            border: none;
            
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(255, 77, 77, 0.25),
                        0 0 0 3px rgba(255, 77, 77, 0.1);
        }

        .card img {
            height: 200px;
            object-fit: cover;
            border-top-left-radius: 12px;
            border-top-right-radius: 12px;
        }
    </style>
</head>
<body>

<header class="d-flex justify-content-between align-items-center px-4 py-3 shadow bg-white">
    <div class="h4 text-black font-weight-bold">CodeFood</div>
    <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</header>

<!-- Swiper Carousel for Dishes -->
<section  style="height:50vh;">
<div class="swiper mySwiper">
    <div class="swiper-wrapper">
        <% if (menuList != null && !menuList.isEmpty()) {
            for (Dish dish : menuList) { %>
        <div class="swiper-slide">
            <div class="card1">
                <div class="text1">
                    <h3>Special Dish</h3>
                    <h1><%= dish.getName() %></h1>
                    <p><%= dish.getDescription() %></p>
                    <button>Order Now</button>
                </div>
                <div class="image1">
                    <img src="<%= dish.getImagePath() %>" alt="Dish Image" onerror="this.src='default-dish.jpg';">
                </div>
            </div>
        </div>
        <% } } else { %>
        <div class="swiper-slide">
            <div class="card1">
                <h1>No dishes found.</h1>
            </div>
        </div>
        <% } %>
    </div>
    <div class="swiper-pagination"></div>
</div>
</section>

<!-- Restaurant Cards -->
<div class="container mt-4">
    <div class="row">
        <% if (restaurants != null && !restaurants.isEmpty()) {
            for (Restaurant res : restaurants) { %>
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="<%= res.getImagepath() %>" class="card-img-top" alt="Restaurant Image">
                <div class="card-body">
                    <h5 class="card-title font-weight-bold"><%= res.getName() %></h5>
                    <div class="d-flex justify-content-between mb-2">
                        <div><i class="bi bi-star-fill text-warning"></i> <%= res.getRating() %></div>
                        <div><i class="bi bi-clock"></i> <%= res.getEta() %></div>
                    </div>
                    <p class="mb-1"><%= res.getCuisineType() %></p>
                    <p class="text-muted"><%= res.getAddress() %></p>
                    <div class="text-center">
                        <a href="Menu?restaurantId=<%= res.getRestaurantId() %>">
                            <input type="submit" value="View Menu" class="submit-button">
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <% } } else { %>
        <div class="col-12">
            <p class="text-center">No restaurants available at the moment.</p>
        </div>
        <% } %>
    </div>
</div>

<!-- Footer -->
<footer class="footer">
    <div style="display: flex; justify-content: space-between; flex-wrap: wrap;">
        <div style="flex: 1 1 180px; margin-bottom: 20px;">
            <p style="margin-top: 10px;">© 2025 FoodApp Limited</p>
        </div>
        <div style="flex: 1 1 180px; margin-bottom: 20px;">
            <h6 style="font-weight: bold;">Company</h6>
            <p>About Us</p><p>Corporate</p><p>Careers</p><p>Team</p>
        </div>
        <div style="flex: 1 1 180px; margin-bottom: 20px;">
            <h6 style="font-weight: bold;">Contact Us</h6>
            <p>Help & Support</p><p>Partner With Us</p><p>Ride With Us</p>
        </div>
        <div style="flex: 1 1 180px; margin-bottom: 20px;">
            <h6 style="font-weight: bold;">Legal</h6>
            <p>Terms & Conditions</p><p>Cookie Policy</p><p>Privacy Policy</p>
        </div>
        <div style="flex: 1 1 180px; margin-bottom: 20px;">
            <h6 style="font-weight: bold;">Available In</h6>
            <p>Bangalore</p><p>Hyderabad</p><p>Delhi</p><p>Mumbai</p>
        </div>
        <div style="flex: 1 1 180px; margin-bottom: 20px;">
            <h6 style="font-weight: bold;">Follow Us</h6>
            <div style="display: flex; gap: 10px;">
                <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/145/145807.png" width="24" alt="LinkedIn"></a>
                <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/145/145802.png" width="24" alt="Instagram"></a>
                <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/145/145805.png" width="24" alt="Facebook"></a>
                <a href="#"><img src="https://cdn-icons-png.flaticon.com/512/145/145812.png" width="24" alt="Twitter"></a>
            </div>
        </div>
    </div>
</footer>

<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
    var swiper = new Swiper(".mySwiper", {
        slidesPerView: 1,
        spaceBetween: 30,
        loop: true,
        pagination: {
            el: ".swiper-pagination",
            clickable: true,
        },
        autoplay: {
            delay: 3000,
            disableOnInteraction: false,
        },
    });
</script>
</body>
</html>



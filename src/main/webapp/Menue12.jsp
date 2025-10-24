<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.modeal.Dish" %>
<%@ page import="com.tap.DaoImple.DishDAOImp" %>

<%
    DishDAOImp dishDAO = new DishDAOImp();
    List<Dish> menuList = dishDAO.getAllDishes();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Food Menu</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
    
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f3f3f3;
            margin: 0;
            padding: 0;
        }

        .swiper-container {
            width: 100%;
            height: 100vh;
        }

        .swiper-slide {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card1 {
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
            padding: 30px;
            width: 120vw;
            max-width: 1020px;
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
            font-size: 36px;
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
            background: #14213d;
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
            width: 250px;
            height: auto;
            border-radius: 12px;
            object-fit: cover;
        }

        .swiper-pagination {
            bottom: 15px;
        }

        @media screen and (max-width: 768px) {
            .card1 {
                flex-direction: column;
                text-align: center;
                padding: 20px;
            }

            .image1 img {
                width: 200px;
            }
        }
    </style>
</head>
<body>

<div class="swiper-container">
    <div class="swiper-wrapper">
        <% 
            if (menuList != null && !menuList.isEmpty()) {
                for (Dish dish : menuList) {
        %>
        <div class="swiper-slide">
            <div class="card1">
                <div class="text1">
                    <h3>Special Dish</h3>
                    <h1><%= dish.getName() %></h1>
                    <p><%= dish.getDescription() %></p>
                    <button>Order Now</button>
                </div>
                <div class="image1">
                    <img src="<%= dish.getImagePath() %>" alt="<%= dish.getName() %> Image">
                </div>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <div class="swiper-slide">
            <div class="card1">
                <h1>No dishes found.</h1>
            </div>
        </div>
        <%
            }
        %>
    </div>
    <!-- Pagination Dots -->
    <div class="swiper-pagination"></div>
</div>

<!-- Swiper JS -->
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script>
    const swiper = new Swiper('.swiper-container', {
        loop: true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        grabCursor: true,
        autoplay: {
            delay: 4000,
            disableOnInteraction: false,
        },
        touchEventsTarget: 'container',
        spaceBetween: 30,
    });
</script>

</body>
</html>


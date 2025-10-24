<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.modeal.Menu" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu Items</title>
    <style>

    .menu-scroll-wrapper {
        display: flex;
        overflow-x: auto;
        scroll-behavior: smooth;
        gap: 15px;
        padding: 20px;
    }

    .menu-scroll-wrapper::-webkit-scrollbar {
        display: none; /* Hide scrollbar for Chrome, Safari */
    }

    .menu-scroll-wrapper {
        -ms-overflow-style: none;  /* IE and Edge */
        scrollbar-width: none;     /* Firefox */
    }

    .menu-card {
        flex: 0 0 auto;
        width: 160px;
        padding: 10px;
        border-radius: 10px;
        box-shadow: 0 0 10px #ccc;
        text-align: center;
        background-color: rgba(255, 255, 255, 0.2);
        backdrop-filter: blur(10px);
    }

    .menu-card img {
        width: 100px;
        height: 100px;
        object-fit: cover;
    }

    .menu-card h3 {
        margin: 10px 0 5px 0;
    }

    .menu-card p {
        margin: 0;
    }

    .scroll-btn {
        position: absolute;
        top: 50%;
        transform: translateY(-50%);
        background-color: rgba(200, 200, 200, 0.7);
        border: none;
        border-radius: 50%;
        width: 40px;
        height: 40px;
        font-size: 20px;
        cursor: pointer;
        z-index: 2;
    }

    .scroll-btn.left {
        left: 5px;
    }

    .scroll-btn.right {
        right: 5px;
    }
</style>

   
</head>
<body>

<h2 style="text-align:center;">Menu Items</h2>

<div style="position: relative;">
    <button class="scroll-btn left" onclick="scrollLeft()">&#8592;</button>
    <div class="menu-scroll-wrapper" id="menuScroll">
        <%
            ArrayList<Menu> listmenu = (ArrayList<Menu>) session.getAttribute("listmenu");
            if (listmenu != null) {
                for (Menu item : listmenu) {
        %>
        <div class="menu-card">
            <img src="<%= item.getImagePath() %>" alt="<%= item.getItemName() %>" />
            <h3><%= item.getItemName() %></h3>
         
        </div>
        <%
                }
            } else {
        %>
        <p>No menu items available.</p>
        <%
            }
        %>
    </div>
    <button class="scroll-btn right" onclick="scrollRight()">&#8594;</button>
</div>


<script>
    function scrollLeft() {
        document.getElementById("menuScroll").scrollBy({ left: -200, behavior: 'smooth' });
    }

    function scrollRight() {
        document.getElementById("menuScroll").scrollBy({ left: 200, behavior: 'smooth' });
    }
</script>


</body>
</html>

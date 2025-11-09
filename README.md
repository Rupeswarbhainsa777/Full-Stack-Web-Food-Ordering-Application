# Tap-Foods 🍽

*Tap-Foods* is a full-stack Java-based food ordering application developed using Spring Boot, MySQL, HTML, CSS, and JavaScript. It enables customers to browse menus, place orders, and manage their accounts, while administrators can manage menu items, users, and order statuses.

---

## 🚀 Features

* Customer registration and login
* Browse food menu by categories
* Add items to cart and place orders
* Payment method selection (e.g., COD, online)
* Admin panel to manage:

  * Menu items
  * Users
  * Orders (status updates)
* Order history and tracking

---

## 🛠 Technologies Used

* *Backend:* Java, Jee/Servlet/ Jdbc
* *Frontend:* HTML, CSS, JavaScript
* *Database:* MySQL
* *Build Tool:* Maven

---
## 📁 Project Structure

```
tap-food-app/
│
├── src/
│ ├── main/
│ │ ├── java/com/tapfoods/
│ │ │ ├── controller/ # Handles HTTP requests
│ │ │ ├── model/ # pojo class 
│ │ │ ├── dao interface/ 
│ │ │ ├── dao implementation / 
│ │ │ └── application.properties # Configuration
│ │ └── webapp/ # jsp, htm ,css ,img 
│ └── test/ # Unit/integration tests
│
├── db/ # SQL scripts
├── README.md # Project documentation
├── pom.xml # Maven configuration

```


## 📸 Screenshots  

<table> <tr> <td align="center"> <b>🏠 Home Page</b><br> <img src="https://github.com/user-attachments/assets/1914ec2f-237d-42b6-85b8-560d9284eec7" width="380" height="220"/><br> Explore food categories & featured dishes. </td> <td align="center"> <b>📝 Sign Up Page</b><br> <img src="https://github.com/user-attachments/assets/697badc0-c7e3-47e6-a116-9687021a107e" width="380" height="220"/><br> New users can create an account. </td> </tr> <tr> <td align="center"> <b>🔑 Login Page</b><br> <img src="https://github.com/user-attachments/assets/5c53f112-0cb9-488c-8223-7d7fa9676deb" width="380" height="220"/><br> Secure login for registered users. </td> <td align="center"> <b>🍔 Menu Page</b><br> <img src="https://github.com/user-attachments/assets/a27d1f02-01ee-4c21-8b21-68958b318427" width="380" height="220"/><br> Browse categorized menu items. </td> </tr> <tr> <td align="center"> <b>🛒 Cart Page</b><br> <img src="https://github.com/user-attachments/assets/f5b65f98-7373-4fb6-96ca-c6bc39975eb3" width="380" height="220"/><br> Review and manage selected items. </td> <td align="center"> <b>💳 Checkout Page</b><br> <img src="https://github.com/user-attachments/assets/fab92716-976d-4d51-b927-ed30eb21341f" width="380" height="220"/><br> Choose payment method & confirm delivery. </td> </tr> <tr> <td align="center"> <b>✅ Order Confirmation</b><br> <img src="https://github.com/user-attachments/assets/d6f11884-eeb4-441b-9fcf-fbec8ee084b0" width="380" height="220"/><br> Display success message with order ID. </td> <td align="center"> <b>🚚 Track Order</b><br> <img src="https://github.com/user-attachments/assets/a4a3458c-7f08-4771-a4dd-dc633f5fe187" width="380" height="220"/><br> Real-time tracking of order status. </td> </tr> </table>

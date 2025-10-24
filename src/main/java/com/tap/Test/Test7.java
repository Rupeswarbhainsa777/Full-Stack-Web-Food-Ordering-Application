package com.tap.Test;



import com.tap.DaoImple.DishDAOImp;
import com.tap.modeal.Dish;

public class Test7 {
    public static void main(String[] args) {
        DishDAOImp dao = new DishDAOImp();

        Dish dish = new Dish("Veg", "Delicious spiced rice with vegetables", "images/veg_biryani.jpg");

        boolean result = dao.addDish(dish);

        if (result) 
        {
            System.out.println("Dish inserted successfully!");
        } else {
            System.out.println("Failed to insert dish.");
        }
    }
}

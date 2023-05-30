package gr.codelearn;

import gr.codelearn.model.Category;
import gr.codelearn.model.Item;
import gr.codelearn.service.CartService;
import gr.codelearn.service.CartServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Item item = new Item("Tomatoes", BigDecimal.valueOf(3), 2, Category.HARDWARE);
        Item item2 = new Item("Potatoes", BigDecimal.valueOf(2), 2, Category.SOFTWARE);
        Item item3 = new Item("Tomatoes", BigDecimal.valueOf(3), 2, Category.HARDWARE);
        double finalPrice = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())).doubleValue();
        System.out.println(finalPrice);

        CartService cartService = new CartServiceImpl(new ArrayList<>());
        cartService.addItem(item);
        cartService.addItem(item2);
        cartService.addItem(item3);
        BigDecimal totalPrice = cartService.getTotalPrice();
        System.out.println(totalPrice);

    }
}
package gr.codelearn.service;

import gr.codelearn.model.Category;
import gr.codelearn.model.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceImplTest {

    @Test
    void shouldAddASingleItem() {
        CartService cartService = new CartServiceImpl(new ArrayList<>());
        Item item = new Item("Tomatoes", BigDecimal.valueOf(3), 2, Category.HARDWARE);
        cartService.addItem(item);
        List<Item> cartItems = cartService.getCartItems();
        assertEquals(1, cartItems.size());
    }

    @Test
    void shouldNotAddItemWithZeroQuantity() {
        CartService cartService = new CartServiceImpl(new ArrayList<>());
        Item item = new Item("Tomatoes", BigDecimal.valueOf(3), 0, Category.HARDWARE);
        cartService.addItem(item);
        List<Item> cartItems = cartService.getCartItems();
        assertEquals(0, cartItems.size());
    }

    @Test
    void shouldOnlyHaveASingleCartItemWhenSameItemIsAdded() {
        CartService cartService = new CartServiceImpl(new ArrayList<>());
        Item item1 = new Item("Tomatoes", BigDecimal.valueOf(3), 2, Category.HARDWARE);
        Item item2 = new Item("Tomatoes", BigDecimal.valueOf(3), 3, Category.HARDWARE);
        cartService.addItem(item1);
        cartService.addItem(item2);
        List<Item> cartItems = cartService.getCartItems();
        assertEquals(1, cartItems.size());
    }
}
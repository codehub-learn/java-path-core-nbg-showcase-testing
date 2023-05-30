package gr.codelearn.service;

import gr.codelearn.model.Item;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    boolean addItem(Item item);
    boolean removeItem(Item item);
    List<Item> getCartItems();
    BigDecimal getTotalPrice();
    boolean checkout();
}

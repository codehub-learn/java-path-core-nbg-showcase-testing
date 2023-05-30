package gr.codelearn.service;

import gr.codelearn.model.Item;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private List<Item> cart;

    @Override
    public boolean addItem(Item item) {
        if (validate(item)){
            int index = cart.indexOf(item);
            if (index == - 1){
                cart.add(item);
            }
            else {
                cart.get(index).setQuantity(cart.get(index).getQuantity() + item.getQuantity());
            }
            return true;
        }
        return false;
    }

    private boolean validate(Item item){
        return item.getQuantity() > 0 && item.getPrice().doubleValue() > 0;
    }

    @Override
    public boolean removeItem(Item item) {
        return cart.remove(item);
    }

    @Override
    public List<Item> getCartItems() {
        return new ArrayList<>(cart);
    }

    @Override
    public BigDecimal getTotalPrice() {
        return cart
                .stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean checkout() {
        return false;
    }
}

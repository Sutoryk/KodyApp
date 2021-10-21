package controller.frontend;

import entity.Kody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
    private Map<Kody, Integer> cart = new HashMap<>();

    public void addItem(Kody kod){
        if(cart.containsKey(kod)) {
            Integer quantity = cart.get(kod) + 1;
            cart.put(kod, quantity);
        }else
        {cart.put(kod,1);

        }

    }
    public Map<Kody,Integer>getItems(){
        return this.cart;
    }
    public void removeItem(Kody kod){
        cart.remove(kod);
    }
    public int  getTotalQuantity(){
        int total = 0;

        Iterator<Kody> iterator = cart.keySet().iterator();
        while(iterator.hasNext()){
            Kody next = iterator.next();
            Integer quantity = cart.get(next);
            total += quantity;
        }
        return total;
    }


}

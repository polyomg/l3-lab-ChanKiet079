package com.poly.demo.service;

import com.poly.demo.entity.DB;
import com.poly.demo.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        if (DB.items.containsKey(id)) {
            Item base = DB.items.get(id);
            if (map.containsKey(id)) {
                Item it = map.get(id);
                it.setQty(it.getQty() + 1);
                return it;
            } else {
                Item it = new Item(base.getId(), base.getName(), base.getPrice(), 1);
                map.put(id, it);
                return it;
            }
        }
        return null;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        if (map.containsKey(id)) {
            Item it = map.get(id);
            it.setQty(qty);
            if (qty <= 0) map.remove(id);
            return it;
        }
        return null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream().mapToInt(Item::getQty).sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(i -> i.getQty() * i.getPrice()).sum();
    }
}

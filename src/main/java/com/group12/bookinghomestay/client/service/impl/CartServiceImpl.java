package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.admin.service.HotelService;
import com.group12.bookinghomestay.client.dto.response.CartResponse;
import com.group12.bookinghomestay.client.model.Cart;
import com.group12.bookinghomestay.client.repository.CartRepository;
import com.group12.bookinghomestay.client.service.CartService;
import com.group12.bookinghomestay.client.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CartRepository repository;

    @Override
    public String addNewCart(Cart item) throws Exception {
        //create new session record
        if (item.getSessionId().isEmpty()) {
            int maxId = repository.findAll().size();
            item.setSessionId(MD5.getHashedString(String.valueOf(maxId + 1)));
            Cart addedItem = repository.save(item);
            return addedItem.getSessionId();
        } else {
            //update to existed record
            Cart cart = repository.findCartItemByHotelId(item.getSessionId(), item.getHotelId());
            if (cart != null) {
                throw new Exception("This item is already in cart !");
            }
            repository.save(item);
            return item.getSessionId();
        }
    }

    @Override
    public TreeMap<Integer, CartResponse> getCartItems(String id) {
        TreeMap<Integer, CartResponse> re = new TreeMap<>();
        List<Cart> items = repository.findAllBySessionId(id);
        if (items.size() > 0) {
            CartResponse res;
            for (Cart c : items) {
                Optional<Hotel> hotel = hotelService.findById(Long.valueOf(c.getHotelId()));
                String from = c.getFromDate();
                String to = c.getToDate();
                int adult = c.getAdult();
                int children = c.getChildren();
                res = new CartResponse(hotel.get(), from, to, adult, children);
                re.put(c.getHotelId(), res);
            }
        }
        return re;
    }

    @Override
    public boolean removeItemFromCart(String sessionId, int hotelId) {
        Cart c = repository.findCartItemByHotelId(sessionId, hotelId);
        if (c != null) {
            repository.delete(c);
            return true;
        }
        return false;
    }


}

package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.admin.model.Hotel;
import com.group12.bookinghomestay.client.dto.CartRequest;
import com.group12.bookinghomestay.client.dto.CartResponse;
import com.group12.bookinghomestay.client.service.CartService;
import com.group12.bookinghomestay.client.service.HotelClientService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private HotelClientService hotelClientService;
    @Autowired
    ObjectFactory<HttpSession> sessionFactory;

    @Override
    public boolean addToCart(CartRequest item) throws Exception {
        TreeMap<Integer, CartRequest> sessionCart = (TreeMap<Integer, CartRequest>) sessionFactory.getObject().getAttribute("cart");
        if (sessionCart != null) {
            if (sessionCart.containsKey(item.getHotelId())) {
                throw new Exception("This item is already in cart");
            } else {
                sessionCart.put(item.getHotelId(), item);
                sessionFactory.getObject().setAttribute("cart", sessionCart);
                return true;
            }
        } else {
            sessionCart = new TreeMap<>();
            sessionCart.put(item.getHotelId(), item);
            sessionFactory.getObject().setAttribute("cart", sessionCart);
            return true;
        }
    }

    @Override
    public TreeMap<Integer, CartResponse> getCartItems() {
        TreeMap<Integer, CartResponse> re = new TreeMap<>();
        TreeMap<Integer, CartRequest> sessionCart = (TreeMap<Integer, CartRequest>) sessionFactory.getObject().getAttribute("cart");
        if (sessionCart != null) {
            CartResponse res;
            for (Map.Entry<Integer, CartRequest> entry : sessionCart.entrySet()) {
                int hotelId = entry.getKey();
                CartRequest cartRequest = entry.getValue();
                Optional<Hotel> hotel = hotelClientService.findById(Long.valueOf(hotelId));
                String from = cartRequest.getFrom();
                String to = cartRequest.getTo();
                int adult = cartRequest.getAdult();
                int children = cartRequest.getChildren();
                res = new CartResponse(hotel.get(), from, to, adult, children);
                re.put(hotelId, res);
            }
        }
        return re;
    }

    @Override
    public boolean removeItemFromCart(Integer id) {
        TreeMap<Integer, CartRequest> sessionCart = (TreeMap<Integer, CartRequest>) sessionFactory.getObject().getAttribute("cart");
        if (sessionCart.containsKey(id)) {
            sessionCart.remove(id);
            sessionFactory.getObject().setAttribute("cart", sessionCart);
            return true;
        }
        return false;
    }


}

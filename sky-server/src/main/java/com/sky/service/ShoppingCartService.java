package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShoppingCartService {

    /**
     * add shopping cart
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * display shopping cart
     * @return
     */
    List<ShoppingCart> list();

    /**
     * delete from shopping cart
     */
    void clean();


    void deleteOneItem(ShoppingCartDTO shoppingCartDTO);
}

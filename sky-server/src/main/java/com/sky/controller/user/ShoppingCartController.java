package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "customer shopping cart apis")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    /**
     * add cart
     * @param shoppingCartDTO
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("add shopping cart")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("add {} to cart", shoppingCartDTO);
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.success();
    }

    /**
     * display shopping cart
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("display shopping cart")
    public Result<List<ShoppingCart>> list() {
        log.info("list shopping cart");
        List<ShoppingCart> list = shoppingCartService.list();
        return Result.success(list);
    }

    /**
     * delete from shopping cart
     * @return
     */
    @DeleteMapping("/clean")
    @ApiOperation("delete from shopping cart")
    public Result clean() {
        log.info("delete from shopping cart");
        shoppingCartService.clean();
        return Result.success();
    }

    @PostMapping("/sub")
    @ApiOperation("delete 1 item from shopping cart")
    public Result deleteOneItem(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("delete 1 item from shopping cart");
        shoppingCartService.deleteOneItem(shoppingCartDTO);
        return Result.success();
    }
}

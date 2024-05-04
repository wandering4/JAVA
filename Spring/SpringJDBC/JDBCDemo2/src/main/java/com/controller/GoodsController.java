package com.controller;

import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 17:32
 * @Description: com.controller
 * @version: 1.0
 */
@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    public void buyGoods(Integer userId,Integer goodsId){
        try {
            goodsService.buyGoods(userId,goodsId);
        }catch (DataIntegrityViolationException ex){

        }
    }

}

package com.dao;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 17:29
 * @Description: com.dao
 * @version: 1.0
 */
public interface GoodsDao {
    //查询商品价格
    public Integer queryGoodsById(Integer goodsId);

    //更新商品库存
    public void updateGoodsStock(Integer goodsId);

    //更新用户余额
    public void updateUserBalance(Integer userId, Integer price);

}

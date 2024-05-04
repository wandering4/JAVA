package com.service.impl;

import com.dao.GoodsDao;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 17:32
 * @Description: com.service.impl
 * @version: 1.0
 */
@Transactional
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    /**
     * readOnly只读：表示该方法中的所有数据库的操作只能是读取
     * timeout：超出时间会自动释放
     * isolation 事务隔离级别 : 初学----了解
     * @param userId
     * @param goodsId
     */
    @Transactional
    @Override
    public void buyGoods(Integer userId, Integer goodsId) {
        //1.查询价格
        Integer price = goodsDao.queryGoodsById(goodsId);
        //2.更新库存
        goodsDao.updateGoodsStock(goodsId);
        //3.更新余额
        goodsDao.updateUserBalance(userId,price);

    }
}

package com.dao.impl;

import com.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 17:29
 * @Description: com.dao.impl
 * @version: 1.0
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer queryGoodsById(Integer goodsId) {
        String sql="select price from t_goods where id=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,goodsId);
    }

    @Override
    public void updateGoodsStock(Integer goodsId) {
        String sql="update t_goods set stock = stock - 1 where id= ?";
        jdbcTemplate.update(sql,goodsId);
    }

    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql="update t_user set balance = balance - ? where id = ?";
        jdbcTemplate.update(sql,price,userId);
    }
}

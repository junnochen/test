package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * @program: sell
 * @description:
 * @author: Junno
 * @create: 2018-09-08 22:18
 **/
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);



    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}

package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sell
 * @description: 订单DAO
 * @author: Junno
 * @create: 2018-09-03 20:44
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    //分页查询,按照买家的openid来查
    Page<OrderMaster> findByBuyerOpenid(String Openid, Pageable pageable);




}

package com.example.msaservicecoffeeorder.domain.service;


import com.example.msaservicecoffeeorder.domain.vo.OrderVO;

import java.util.List;

public interface IOrderService {

	long getAllOrderCount();
	List<OrderVO> getAllOrder(String page, String size, String sort, String sortKey);

	OrderVO addOrder(OrderVO orderVO);
	OrderVO modifyOrder(OrderVO orderVO);
	void removeOrder(List<OrderVO> orderVOList);
}
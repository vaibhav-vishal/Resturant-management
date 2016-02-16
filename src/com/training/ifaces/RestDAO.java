package com.training.ifaces;

import com.training.entity.OrderInfo;

public interface RestDAO<T> {
	public int addOrder(T t);

	public String checkOrderStatus(int orderNo);

	public String checkPaymentInfo(int orderNo);

	public int deleteOrderItems(int orderNo, int menuCode);

	public int deleteOrder(int orderNo);

	public OrderInfo getOrderInfo(int orderNo);

	public int updateOrder(int orderNo, int quantity, int menuCode);
	
	public void showOrderItems(int orderNo);
}

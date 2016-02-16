package com.training.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.training.daos.WaiterDAO;
import com.training.entity.OrderInfo;

public class ResturantTestCases {
	OrderInfo orderInfo = null;
	WaiterDAO waiterDAO = null;

	@Before
	public void beforetest() {
		waiterDAO = new WaiterDAO();
	}

	@Test
	public void test() {

		System.out.println(waiterDAO.getOrderInfo(10));
	}

}

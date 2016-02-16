package com.training.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderInfo {

	private int employeeId;
	private int orderNo;
	private int tableNo;
	private String status;
	private String payment;
	private HashMap<Integer, Integer> menuCode;

	public OrderInfo() {
		super();
	}

	public HashMap<Integer, Integer> getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(HashMap<Integer, Integer> menuCode) {
		this.menuCode = menuCode;
	}

	public OrderInfo(int employeeId, int orderNo, int tableNo, String status, String payment,
			HashMap<Integer, Integer> menuCode) {
		super();
		this.employeeId = employeeId;
		this.orderNo = orderNo;
		this.tableNo = tableNo;
		this.status = status;
		this.payment = payment;
		this.menuCode = menuCode;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "OrderInfo [employeeId=" + employeeId + ", orderNo=" + orderNo + ", tableNo=" + tableNo + ", status="
				+ status + ", payment=" + payment + ", menuCode=" + menuCode + "]";
	}

}

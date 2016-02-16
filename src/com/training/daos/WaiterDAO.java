package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.training.entity.OrderInfo;
import com.training.ifaces.RestDAO;
import com.training.util.SqlConnection;

public class WaiterDAO implements RestDAO<OrderInfo> {
	private Connection con;

	public WaiterDAO(Connection con) {
		super();
		this.con = con;
	}

	public WaiterDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	@Override
	public OrderInfo getOrderInfo(int orderNo) {
		OrderInfo orderInfo = null;
		int OrderNo = 0;
		int employeeId = 0;
		int tableNo = 0;
		String status = null;
		String payment = null;
		HashMap<Integer, Integer> menuCodes = new HashMap<>();
		try {
			String sql = "Select * from orderInfo";
			String sql2 = "Select * from ORDERTEMPDETAILS where orderno =?";

			PreparedStatement pstmt, pstmt1;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			pstmt1 = con.prepareStatement(sql2);
			while (rs.next()) {
				OrderNo = rs.getInt("orderno");
				employeeId = rs.getInt("empid");
				tableNo = rs.getInt("tableno");
				status = rs.getString("status");
				payment = rs.getString("payment");
			}
			pstmt1.setInt(1, OrderNo);
			ResultSet rs2 = pstmt1.executeQuery();
			while (rs2.next()) {
				menuCodes.put(rs2.getInt("MENUCODE"), rs2.getInt("QUANTITY"));
			}

			orderInfo = new OrderInfo(employeeId, OrderNo, tableNo, status, payment, menuCodes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderInfo;
	}

	@Override
	public int addOrder(OrderInfo t) {
		String sql = "insert into orderinfo values(?,?,?,?,?)";
		String sql2 = "insert into ORDERTEMPDETAILS values(?,?,?)";

		int rowadded = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getOrderNo());
			pstmt.setInt(2, t.getEmployeeId());
			pstmt.setInt(3, t.getTableNo());
			pstmt.setString(4, t.getStatus());
			pstmt.setString(5, t.getPayment());

			rowadded = pstmt.executeUpdate();

			HashMap<Integer, Integer> menuCodes = t.getMenuCode();
			Iterator it = menuCodes.entrySet().iterator();
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				pstmt2.setInt(1, t.getOrderNo());
				pstmt2.setInt(2, (int) pair.getKey());
				pstmt2.setInt(3, (int) pair.getValue());
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rowadded;

	}

	@Override
	public String checkOrderStatus(int orderNo) {
		String orderStatus = null;
		String sql = "select * from orderinfo where orderno=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orderStatus = rs.getString("Status");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orderStatus;

	}

	@Override
	public String checkPaymentInfo(int orderNo) {
		String paymenmtInfo = null;
		String sql = "select * from orderinfo where orderno=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				paymenmtInfo = rs.getString("paymentInfo");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paymenmtInfo;

	}

	@Override
	public int deleteOrderItems(int orderNo, int menuCode) {
		String sql = "DELETE FROM ORDERTEMPDETAILS WHERE ORDERno = ? AND MENUCODE = ?";
		int rowDeleted = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, menuCode);
			rowDeleted = pstmt.executeUpdate();
			// set to constructor
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
	public int updateOrder(int orderNo, int quantity, int menuCode) {
		String sql = "UPDATE ORDERTEMPDETAILS  SET quantity = ? WHERE orderno = ? AND menucode = ?";
		int rowUpdated = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, orderNo);
			pstmt.setInt(3, menuCode);
			rowUpdated = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;

	}

	@Override
	public int deleteOrder(int orderNo) {
		String sql1 = "DELETE FROM ORDERINFO WHERE ORDERno = ?";
		String sql2 = "DELETE FROM ORDERTEMPDETAILS WHERE ORDERno = ?";
		int rowDeleted = 0;
		try {
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, orderNo);
			rowDeleted = pstmt1.executeUpdate();
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt1.setInt(1, orderNo);
			rowDeleted += pstmt2.executeUpdate();
			// set to constructor
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

}

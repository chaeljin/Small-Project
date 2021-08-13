package usedItem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import usedItem.model.dto.BuyerDTO;
import usedItem.model.util.DBUtil;

public class BuyerDAO {

	private static Properties sql = DBUtil.getSql();

	public static boolean addBuyer(BuyerDTO buyer) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addBuyer"));

			pstmt.setString(1, buyer.getId());
			pstmt.setString(2, buyer.getName());
			pstmt.setString(3, buyer.getPhone());
			pstmt.setString(4, buyer.getLoc());
			pstmt.setString(5, buyer.getGrade());
			pstmt.setString(6, buyer.getItem());
			pstmt.setString(7, buyer.getDealType());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateBuyer(String buyerId, String dealType) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateBuyer"));

			pstmt.setString(1, dealType);
			pstmt.setString(2, buyerId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteBuyer(String buyerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteBuyer"));

			pstmt.setString(1, buyerId);
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static BuyerDTO getBuyer(String buyerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BuyerDTO recipient = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getBuyer"));
			pstmt.setString(1, buyerId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				recipient = new BuyerDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return recipient;
	}

	public static ArrayList<BuyerDTO> getAllBuyers() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuyerDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllBuyers"));
			rset = pstmt.executeQuery();

			list = new ArrayList<BuyerDTO>();
			while (rset.next()) {
				list.add(new BuyerDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}

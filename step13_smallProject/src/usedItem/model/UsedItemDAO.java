package usedItem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import usedItem.model.dto.UsedItemDTO;
import usedItem.model.util.DBUtil;

public class UsedItemDAO {

	private static Properties sql = DBUtil.getSql();

	public static boolean addUsedItem(UsedItemDTO usedItem) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addUsedItem"));
			
			pstmt.setString(1, usedItem.getUsedItemId());
			pstmt.setString(2, usedItem.getUsedItemName());
			pstmt.setString(3, usedItem.getUsedItemPrice());
			pstmt.setString(4, usedItem.getUsedItemCondition());
			pstmt.setString(5, usedItem.getUsedItemDetail());
			pstmt.setString(6, usedItem.getDealStatus());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateUsedItemPrice(String usedItemId, String usedItemPrice) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateUsedItemPrice"));
			
			pstmt.setString(1, usedItemPrice);
			pstmt.setString(2, usedItemId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean updateDealStatus(String usedItemId, String dealStatus) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateDealStatus"));
			
			pstmt.setString(1, dealStatus);
			pstmt.setString(2, usedItemId);
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteUsedItem(String usedItemId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteUsedItem"));
			
			pstmt.setString(1, usedItemId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static UsedItemDTO getUsedItem(String usedItemId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UsedItemDTO usedItem = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getUsedItem"));
			
			pstmt.setString(1, usedItemId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				usedItem = new UsedItemDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return usedItem;
	}


	public static ArrayList<UsedItemDTO> getAllUsedItems() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UsedItemDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllUsedItems"));
			
			rset = pstmt.executeQuery();

			list = new ArrayList<UsedItemDTO>();
			while (rset.next()) {
				list.add(new UsedItemDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}

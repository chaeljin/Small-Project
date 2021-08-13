package usedItem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import usedItem.model.dto.UsedItemUploadDTO;
import usedItem.model.util.DBUtil;

public class UsedItemUploadDAO {
	private static Properties sql = DBUtil.getSql();

	public static boolean addUsedItemUpload(UsedItemUploadDTO usedItemProject) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addUsedItemUpload"));

			pstmt.setString(1, usedItemProject.getUsedItemUploadName());
			pstmt.setString(2, usedItemProject.getUsedItemId());
			pstmt.setString(3, usedItemProject.getSellerId());
			pstmt.setString(4, usedItemProject.getBuyerId());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정
	// 프로보노 프로젝트 ID로 재능기부자 수정
	public static boolean updateUsedItemUploadSeller(int UsedItemUploadId, String sellerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateUsedItemUploadSeller"));

			pstmt.setString(1, sellerId);
			pstmt.setInt(2, UsedItemUploadId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정
	// 프로보노 프로젝트 id로 수해자 정보 변경
	public static boolean updateUsedItemUploadBuyer(int UsedItemUploadId, String BuyerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateUsedItemUploadBuyer"));

			pstmt.setString(1, BuyerId);
			pstmt.setInt(2, UsedItemUploadId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteUsedItemUpload(int UsedItemUploadId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteUsedItemUpload"));

			pstmt.setInt(1, UsedItemUploadId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static UsedItemUploadDTO getUsedItemUpload(int UsedItemUploadId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UsedItemUploadDTO usedItemUser = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getUsedItemUpload"));

			pstmt.setInt(1, UsedItemUploadId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				usedItemUser = new UsedItemUploadDTO(rset.getInt(1), rset.getString(2), rset.getString(3),
						rset.getString(4), rset.getString(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return usedItemUser;
	}

	// 모든 프로보노 프로젝트 검색
	public static ArrayList<UsedItemUploadDTO> getAllUsedItemUploads() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UsedItemUploadDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllUsedItemUploads"));

			rset = pstmt.executeQuery();

			list = new ArrayList<UsedItemUploadDTO>();
			while (rset.next()) {
				list.add(new UsedItemUploadDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}

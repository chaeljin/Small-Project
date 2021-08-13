package usedItem.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	//db의 설정 정보를 보유한 객체
	private static Properties dbinfo = new Properties();

	// 모든 DAO들이 사용하는 sql 문장 정보를 보유한 객체
	private static Properties sql = new Properties();

	static{ 
		try {
			dbinfo.load(new FileInputStream("db.properties"));
			sql.load( new FileInputStream("usedItemsql.properties"));

//			Class.forName(dbinfo.getProperty("jdbc.driver"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Properties getSql() {
		return sql;
	}

	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(dbinfo.getProperty("jdbc.url") , 
				dbinfo.getProperty("jdbc.id"), 
				dbinfo.getProperty("jdbc.pw"));
	}

	// DML용
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	// SELECT용
	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			close(con, stmt);
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}

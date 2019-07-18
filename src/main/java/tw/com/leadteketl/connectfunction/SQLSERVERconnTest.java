package tw.com.leadteketl.connectfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.com.leadteketl.bean.t_datasource;

public class SQLSERVERconnTest {

	public static final String readTableNameSQL = "SELECT name FROM master.dbo.sysdatabases";

	public boolean connTest(t_datasource t_database) throws SQLException {
		String insertTableNameSQL = "INSERT INTO t_table_master(project_id,database_id,table_id) values (" +t_database.project_id+","+t_database.database_id+","+ "?)";
		String url = null;
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		
		
		if ("".equals(t_database.database_port)) {
			url = "jdbc:sqlserver://" + t_database.database_ip + ";";
		} else {
			url = "jdbc:sqlserver://" + t_database.database_ip + ":" + t_database.database_port + ";";
		}
		boolean conntest = false;
		try {
			conn = DriverManager.getConnection(url, t_database.database_user, t_database.database_password);
			if (conn != null) {
				conntest = true;
				state = conn.prepareStatement(readTableNameSQL);
				rs = state.executeQuery();
				while (rs != null) {
					rs.getString("name");
					stmt = conn.prepareStatement(insertTableNameSQL);
					stmt.setString(1, rs.getString("name"));
				}

			} else {
				conntest = false;
			}
			rs.close();
			state.close();
			conn.close();
			stmt.close();
		} catch (Exception e) {
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (state != null) {
				state.close();
			}
			if(stmt!= null) {
				stmt.close();
			}

		}

		return conntest;
	}
}

package Lab2;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;

public class BookDelete extends ActionSupport {
	private String bkID = new String();

	public String execute() {
		String ret = ERROR;
		Connection conn = null;
		try {
			String URL = "jdbc:mysql://localhost:3306/bookdb";
			int rs;
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(bkID);
			conn = DriverManager.getConnection(URL, "root", "19941016");
			String sql = "delete from Book  where ISBN = '" + bkID + "'";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeUpdate();
			ret = SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			ret = ERROR;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	public String getBkID() {
		return bkID;
	}

	public void setBkID(String bkID) {
		this.bkID = bkID;
	}
}

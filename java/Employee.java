import java.sql.*;

public class Employee {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/Company";

	private static final String UNAME = "root";
	private static final String PASS = "";

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;

		try {

			// check if class exist
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Making connection");

			conn = DriverManager.getConnection(DB_URL, UNAME, PASS);

			if(conn != null)
				System.out.println("Connection established");
			else
				System.exit(0);

			conn.setAutoCommit(false);

			System.out.println("Creating Statement");

			stmt = conn.createStatement();

			String sql = "INSERT INTO employee(age, first_name, last_name) VALUES(20, 'Dev','Kaka')";

			stmt.executeUpdate(sql);

			//String sql;
			sql = "SELECT * FROM employee";
			ResultSet res = stmt.executeQuery(sql);

			while(res.next()) {

				int id = res.getInt("id");
				int age = res.getInt("age");
				String fname = res.getString("first_name");
				String lname = res.getString("last_name");

				System.out.println(id + "  " + age + " " + fname + " " + lname);
			}
			conn.rollback();
			res.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(stmt != null)
					stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try{
				if(conn != null)
					conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		System.out.println("Operations completed");
	}

}
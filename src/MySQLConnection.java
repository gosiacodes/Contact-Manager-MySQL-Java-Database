import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	static Connection connectionSQL = null;
	static Statement statementSQL = null;
	static ResultSet resultsetSQL = null;

	static boolean connectSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception ex){
			System.out.print("Exception Driver: " + ex);
			return false;
		}
		
		try {
			//value="jdbc:mysql://localhost:3306/dbname?serverTimezone=UTC"  ?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm
			 
			connectionSQL = DriverManager.getConnection("jdbc:mysql://localhost:3308/uppgift2mysql?serverTimezone=UTC",
					DatabaseLoginMySQLJava.getuserName(), DatabaseLoginMySQLJava.getuserPass());
			return true;
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}		
	}
	
	static void stateSQL() {
		try {
			statementSQL = connectionSQL.createStatement();
			resultsetSQL = statementSQL.executeQuery("SELECT * FROM `customers`");
			
			while (resultsetSQL.next()) {
				System.out.println(resultsetSQL.getInt(1) + "  " + resultsetSQL.getString(2) + "  " + resultsetSQL.getString(3));

			}

			connectionSQL.close();
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	
}

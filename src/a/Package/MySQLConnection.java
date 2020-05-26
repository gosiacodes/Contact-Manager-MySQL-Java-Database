package a.Package;
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
			ex.printStackTrace();
			System.out.print("Exception Driver: " + ex);
			return false;
		}
		
		try {				
			connectionSQL = DriverManager.getConnection("jdbc:mysql://localhost:3308/contactdb?serverTimezone=UTC",
					DatabaseLoginMySQLJava.getuserName(), DatabaseLoginMySQLJava.getuserPass());
			return true;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}		
	}
	
	static void stateSQL() {
		try {
			
			String table = aBean.getTable();
			String conName = aBean.getConName();
			String email = aBean.getEmail();
			String address = aBean.getAddress();
			String phone = aBean.getPhone();
			String sql;
			
			if (table.equals("contact")) {
				//Updating contact table
				sql = "INSERT INTO contact(name,email,address,phone)"
						+ "VALUES('"+conName+ "', '" +email+ "', '" +address+ "', '" +phone+ "')";
				statementSQL = connectionSQL.prepareStatement(sql);
				
				int check = statementSQL.executeUpdate(sql);
				if(check != 0){
					System.out.println("Contact table updated successfully");   
				}
				
				resultsetSQL = statementSQL.executeQuery("SELECT * FROM `contact`");
				while(resultsetSQL.next()) {
					System.out.println(resultsetSQL.getInt(1) + "  " + resultsetSQL.getString(2) + "  " 
							+ resultsetSQL.getString(3) + " " + resultsetSQL.getString(4) + " " + resultsetSQL.getString(5));
				}				 
			}
			else if  (table.equals("customer")){
				//Updating customer table
				sql = "INSERT INTO customer(name,email,address,phone)"
						+ "VALUES('"+conName+ "', '" +email+ "', '" +address+ "', '" +phone+ "')";	
				statementSQL = connectionSQL.prepareStatement(sql);
				
				int check = statementSQL.executeUpdate(sql);
				if(check != 0){
					System.out.println("Customer table updated successfully");   
				}
					
				resultsetSQL = statementSQL.executeQuery("SELECT * FROM `customer`");
				while(resultsetSQL.next()) {
					System.out.println(resultsetSQL.getInt(1) + "  " + resultsetSQL.getString(2) + "  " 
							+ resultsetSQL.getString(3) + " " + resultsetSQL.getString(4) + " " + resultsetSQL.getString(5));
				}
			}

			connectionSQL.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	
}

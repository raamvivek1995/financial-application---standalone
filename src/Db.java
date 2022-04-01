import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Db{

	public void insertTable(String ledger, String description, Double debitamount, String date,Double creditamount, String source, String validdate, FileInputStream input )
	{
		InputStream in = null;
		System.out.println("the image is"+input);
		
		System.out.println("inside insert table method");
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String sql = "Insert into  accounts (ledger,description,debitamount,date,creditamount,source,validdate,pic) values ('" + ledger +"','" + description +"','" + debitamount +"','" + date +"','" + creditamount +"','"+source+"','"+validdate+"','"+input+"')";
			stmt.executeUpdate(sql);
			System.out.println("query exec");
			JOptionPane.showMessageDialog(null, "DATA SAVED SUCCESSFULLY");
			con.close();      
		}
		
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	}
}

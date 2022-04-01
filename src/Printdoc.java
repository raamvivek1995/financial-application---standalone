import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Printdoc extends JFrame {
	
	public Printdoc()
	{
		super ("printer");
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		JScrollPane scrollpane = new JScrollPane();
		JTable table = new JTable();
		DefaultTableModel model1 = new DefaultTableModel();
		//table.setBackground(new java.awt.Color(0, 0, 0));
        table.setFont(new java.awt.Font("Berlin Sans FB", 0, 18));
        //table.setForeground(new java.awt.Color(255, 255, 255));
        table.setFont(new java.awt.Font("Cambria", 0, 14));
        table.setRowHeight(28);
        table.setModel(model1);
        model1.addColumn("ID");        
        model1.addColumn("LEDGER");
        model1.addColumn("DATE");
        model1.addColumn("DEBIT");
        model1.addColumn("DESCRIPTION");
        model1.addColumn("CREDIT");
        
   
        scrollpane.setViewportView(table);
        getContentPane().add(scrollpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1330, 290));
        
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String sql = "select id,ledger,description,debitamount,date,creditamount from accounts ORDER BY date DESC";
			ResultSet Rs = stmt.executeQuery(sql);
			System.out.println("query exec");
			while (Rs.next()) {
				
				model1.addRow(new Object[] {Rs.getString(1),Rs.getString(2),Rs.getString(5) ,Rs.getInt(4),Rs.getString(3),Rs.getInt(6)} );
				} 
		con.close();
        }
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
        
        print(table);
        pack();
        
	}
 public void print(JTable table)
 
 {
	 MessageFormat m = new MessageFormat("HOUSE ACCOUNTS ");
		MessageFormat f = new MessageFormat("");
	 try {
		 table.setRowHeight(40);
		 table.print(JTable.PrintMode.FIT_WIDTH,m,f);
		} catch (PrinterException e1) {
			e1.printStackTrace();
		}
 }
}

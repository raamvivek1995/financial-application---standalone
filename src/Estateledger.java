import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class Estateledger extends JFrame {
	
	private JButton delete;
	private JButton save;
	private JTextField ledgername1;
	private JLabel legder;
	private JScrollPane scroll;
	private JTable table;
	private JLabel jLabel;
	private JButton refresh;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	String selectedvaluefromledger;
	private JButton view;
	
	public Estateledger() {
		super("LEDGER PAGE");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		ImageIcon img = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
		this.setIconImage(img.getImage());
		// escape btn support
	    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
	    Action escapeAction = new AbstractAction() {
	      public void actionPerformed(ActionEvent e) {
	        dispose();
	      }
	    };
	    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        escapeKeyStroke, "ESCAPE");
		    getRootPane().getActionMap().put("ESCAPE", escapeAction);
	
		    delete = new JButton();
	        save = new JButton();
	        ledgername1 = new JTextField();
	        legder = new JLabel();
	        scroll = new JScrollPane();
	        table = new JTable();
	        jLabel = new JLabel();
	        refresh = new JButton();
            view = new JButton();
	        
	        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
	        
	        refresh.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
	        refresh.setText("REFRESH");
	        refresh.setOpaque(false);
	        getContentPane().add(refresh, new AbsoluteConstraints(550, 260, 210, 50));
	        
	        view.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
	        view.setText("VIEW");
	        view.setOpaque(false);
	        getContentPane().add(view, new AbsoluteConstraints(550, 350, 210, 50));
	        
	        delete.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
	        delete.setText("DELETE");
	        delete.setOpaque(false);
	        getContentPane().add(delete, new AbsoluteConstraints(550, 170, 210, 50));
	        
			
			  delete.addActionListener(new ActionListener() {
			  
			  public void actionPerformed(ActionEvent e) {
				  
				  String name = selectedvaluefromledger;
				  
				  deleteLedger(name,"estate");
			  
			  } 
			  });
			 

	        save.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
	        save.setText("SAVE");
	        save.setOpaque(false);
	        getContentPane().add(save, new AbsoluteConstraints(550, 80, 210, 50));
	        
	        save.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					String name = ledgername1.getText();
					
					saveLedger(name,"estate");
				}
			});

	        ledgername1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
	        ledgername1.setForeground(new java.awt.Color(255, 255, 255));
	        ledgername1.setText("Ledgername");
	        ledgername1.setOpaque(false);
	        getContentPane().add(ledgername1, new AbsoluteConstraints(140, 20, 350, 40));

	        legder.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
	        legder.setForeground(new java.awt.Color(255, 255, 255));
	        legder.setText("LEDGER");
	        getContentPane().add(legder, new AbsoluteConstraints(20, 24, 120, 30));

	        table.setBackground(new Color(0, 0, 0));
	        table.setForeground(new Color(255, 255, 255));
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        model = new DefaultTableModel();
	        table.setRowHeight(28);
	        table.setModel(model);
	        table.setFont(new Font("Berlin Sans FB", 0, 18));
	        model.addColumn("LEDGER NAME");
	        
	        refreshLedger("estate");
	        
	        
	        System.out.println("selected row" +table.getSelectedRow());
	        table.setOpaque(false);
	        scroll.setViewportView(table);

	        getContentPane().add(scroll, new AbsoluteConstraints(20, 77, 470, 360));
	        
	        table.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent evt) {
	            	model1 = (DefaultTableModel) table.getModel(); 
	            	int selectedRowindex = table.getSelectedRow();
	            	selectedvaluefromledger = model.getValueAt(selectedRowindex, 0).toString();
	            }
	        });
	        
	        jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/ledger new1111.jpg"))); // NOI18N
	        jLabel.setText("jLabel1");
	        getContentPane().add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 460));
	        
	        refresh.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					model.setRowCount(0);
					
					refreshLedger("estate");
                    
					ledgername1.setText("");
				}
			});
	        
	        view.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRowindex = table.getSelectedRow();
	            	selectedvaluefromledger = model.getValueAt(selectedRowindex, 0).toString();
					new Estateaccounts().ledgerTable(selectedvaluefromledger, "estate");	
				
				}
			});
	        
	        pack();
	        	
				}
			
public void deleteLedger(String name, String source)
{
	if (name != null) 
	  { 
		  try 
	  {
	  Class.forName("com.mysql.jdbc.Driver");
	  System.out.println("before connection"); 
	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root",
	  "root"); System.out.println("conneted sql"); 
	  Statement stmt =con.createStatement(); 
	  String sql = "Delete from ledger where ledgername = '"+name+"' and source = '"+source +"'"; 
	  stmt.executeUpdate(sql);
	  System.out.println("query exec"); 
	  JOptionPane.showMessageDialog(null,"DATA DELETED");
	  con.close();
	  } 
		  catch (Exception e1) { System.out.println("sql exception" +e1); }
	  }
	  
	  else { JOptionPane.showMessageDialog(null, "SELECT LEDGERNAME"); 
}
	        
	       
	        
	
	}

public void refreshLedger(String source)
{
try
{
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("before connection");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
	System.out.println("conneted sql");
	Statement stmt = con.createStatement();
	String sql = "select ledgername from ledger where source = '"+source +"'";
	ResultSet Rs = stmt.executeQuery(sql);
	System.out.println("query exec");
	while (Rs.next()) {
		
		model.addRow(new Object[] {Rs.getString(1)});
         
      } 
	con.close();
       
}
catch (Exception e1)
{
	System.out.println("sql exception" +e1);
}
}

public void saveLedger(String name, String source)
{
if (name != null)
{
	try
    {
    	Class.forName("com.mysql.jdbc.Driver");
		System.out.println("before connection");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		System.out.println("conneted sql");
		Statement stmt = con.createStatement();
		String sql = "Insert into  ledger (ledgername,source) values ('" + name +"','"+source+"')";
		stmt.executeUpdate(sql);
		System.out.println("query exec");
		JOptionPane.showMessageDialog(null, "DATA SAVED" +" "+name);
		con.close();      
	}
	catch (Exception e1)
	{
		System.out.println("sql exception" +e1);
	}
	
}

else
{
	JOptionPane.showMessageDialog(null, "TEXTFIELD IS EMPTY");
}

}
}





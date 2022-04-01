import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.toedter.calendar.JDateChooser;

public class Vehicleaccounts extends JFrame {

	private JComboBox combobox;
	private JLabel ledger;
	private JLabel amount;
	private JFormattedTextField amount1;
	private JLabel background;
	private JButton print;
	private JButton save;
	private JButton delete;
	private JTable table;
	private JScrollPane scrollpane;
	private JLabel date;
	private JDateChooser date1;
	private JDateChooser date2;
	private JLabel credit;
	private JButton ledgersave;
	private JFormattedTextField creditamt;
	private Vehicleledger ledgerpage;
	//private FileChooser filechooser;
	private JTextField descriptiontext;
	private JLabel desclabel;
	private JButton refresh;
	private JButton upload;
	int selectedRowindex;
	private JDateChooser fromdate;
	private JDateChooser todate;
	private JButton view;
	private JTextField balance;
	private DecimalFormatSymbols dfs;
    private DecimalFormat dFormat;
    private DefaultTableModel model1;
	
	public Vehicleaccounts()
	{
		super ("VEHICLE ACCOUNTS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		Dimension dim = new Dimension();
		dim.setSize(2147483647, 2147483647);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(dim);
		ImageIcon img = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
		this.setIconImage(img.getImage());
		
		
		//enter button support
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
        KeyStroke ctrlTab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, KeyEvent.CTRL_DOWN_MASK);
        Set<KeyStroke> keys = new HashSet<>();
        //keys.add(enter);
        keys.add(tab);
        keys.add(ctrlTab);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        
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
	    
		combobox = new JComboBox();
		amount = new JLabel();
		ledger = new JLabel();
		
		background = new JLabel();
		print = new JButton();
		save = new JButton();
		delete = new JButton();
		table = new JTable();
		scrollpane = new JScrollPane();
		date = new JLabel();
		date1 = new JDateChooser("dd-MM-yyyy","####/##/##", '_');
		credit = new JLabel();
		ledgersave = new JButton();
		descriptiontext = new JFormattedTextField();
		desclabel = new JLabel();
		refresh = new JButton();
		upload = new JButton();
		fromdate = new JDateChooser("dd-MM-yyyy","####/##/##", '_');
		todate = new JDateChooser("dd-MM-yyyy","####/##/##", '_');
		view = new JButton();
		balance = new JTextField();
		model1 = new DefaultTableModel();
		
		
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		
		/*upload.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		upload.setText("UPLOAD");
		upload.setOpaque(false);
        getContentPane().add(upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 110, -1));
        
        upload.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				filechooser = new FileChooser();
		            }
		        });*/
		
		view.setFont(new java.awt.Font("Berlin Sans FB", 0, 18));
		view.setBackground(new java.awt.Color(0, 0, 0));// NOI18N
		view.setForeground(new java.awt.Color(255, 255, 255));
		view.setText("VIEW");
		view.setOpaque(false);
        getContentPane().add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 180, 110, 30));
		
        
        Date date3 = new Date();
        DateFormat formatter4 = new SimpleDateFormat("dd-MM-yyyy");
        todate.setDate(date3);
        todate.setFont(new java.awt.Font("Tahoma", 0, 18));
        todate.setBackground(new java.awt.Color(204, 204, 204));
		getContentPane().add(todate, new AbsoluteConstraints(1080, 100, 200, 40));
		//System.out.println("get date"+" :"+" " +formatter.format(date1.getDate()));

		Date date6 = new Date();
        DateFormat formatter6 = new SimpleDateFormat("dd-MM-yyyy");
        fromdate.setDate(date6);
        fromdate.setFont(new java.awt.Font("Tahoma", 0, 18));
        fromdate.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(fromdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 200, 40));
		
        
		
        
        balance.setFont(new java.awt.Font("Arial", 0, 80)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 0, 0));
        balance.setText("0,00");
        balance.setBorder(null);
        balance.setOpaque(false);
        balance.setEditable(false);
        getContentPane().add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, 450, 100));
        
        
		
		descriptiontext.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		descriptiontext.setForeground(new java.awt.Color(255, 255, 255));
		descriptiontext.setCaretColor(Color.RED);
		descriptiontext.setText("Enter your description for the expenses here.");
		descriptiontext.setOpaque(false);
        getContentPane().add(descriptiontext, new AbsoluteConstraints(160, 280, 510, 120));

        desclabel.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        desclabel.setForeground(new java.awt.Color(255, 255, 255));
        desclabel.setText("DESCRIPTION");
        getContentPane().add(desclabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 30));
		
        ledgersave.setBackground(new java.awt.Color(0, 0, 0));
        ledgersave.setForeground(new java.awt.Color(255, 255, 255));
        ledgersave.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		ledgersave.setText("LEDGER");
		ledgersave.setOpaque(false);
		getContentPane().add(ledgersave, new AbsoluteConstraints(550, 160, 120, 30));
		
		ledgersave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ledgerpage = new Vehicleledger();
				}
		});
		
		dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(',');
        dFormat = new DecimalFormat ("#0.##", dfs);
        creditamt = new JFormattedTextField(dFormat);
		creditamt.setBackground(new java.awt.Color(204, 204, 204));
		creditamt.setText("0.00");
		creditamt.setCaretColor(Color.RED);
		creditamt.setFont(new java.awt.Font("Tahoma", 0, 24));
		creditamt.setForeground(new java.awt.Color(255, 255, 255));
		creditamt.setOpaque(false);
        getContentPane().add(creditamt, new AbsoluteConstraints(160, 220, 150, 40));
        
		Date date4 = new Date();
        DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
        date1.setDate(date4);
        date1.setFont(new java.awt.Font("Tahoma", 0, 18));
		date1.setBackground(new java.awt.Color(204, 204, 204));
		getContentPane().add(date1, new AbsoluteConstraints(160, 160, 150, 40));
		
		
        //System.out.println("get date"+" :"+" " +formatter.format(date1.getDate()));
		
		
		
		date.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		date.setForeground(new java.awt.Color(255, 255, 255));
		date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		date.setBackground(new java.awt.Color(204, 204, 204));
		date.setOpaque(false);
		date.setText("DATE ");
		
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 160, 110, 50));
        table.setBackground(new java.awt.Color(0, 0, 0));
        table.setFont(new java.awt.Font("Berlin Sans FB", 0, 18));
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setRowHeight(28);
        table.setModel(model1);
        model1.addColumn("ID");        
        model1.addColumn("LEDGER");
        model1.addColumn("DATE");
        model1.addColumn("DEBIT");
        model1.addColumn("DESCRIPTION");
        model1.addColumn("CREDIT");
        
        refreshTable("vehicle"); 
		scrollpane.setViewportView(table);

        getContentPane().add(scrollpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1330, 290));
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	DefaultTableModel	model = (DefaultTableModel) table.getModel(); 
            	selectedRowindex = table.getSelectedRow();
            	System.out.println("the row count is" +selectedRowindex);
            }
        });
        
        
        refresh.setBackground(new java.awt.Color(0, 0, 0));
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		refresh.setText("REFRESH");
		refresh.setOpaque(false);
        getContentPane().add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 120, 30));
        
        refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model1.setRowCount(0);
				
				refreshTable("vehicle");
				amount1.setText("");
				creditamt.setText("");
				descriptiontext.setText("");
				
			}
		});
        
		print.setBackground(new java.awt.Color(0, 0, 0));
		print.setForeground(new java.awt.Color(255, 255, 255));
		print.setFont(new Font("Berlin Sans FB", 0, 18));
		print.setText("PRINT");
		print.setOpaque(false);
        getContentPane().add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 120, 30));

        delete.setBackground(new Color(0, 0, 0));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setFont(new Font("Berlin Sans FB", 0, 18));
        delete.setText("DELETE");
        delete.setOpaque(false);
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 120, 30));
        
        delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowcount = table.getSelectedRow();
				String cell = table.getModel().getValueAt(rowcount, 0).toString();
				deleteTable("vehicle", cell);
				}
		});
        
        save.setBackground(new Color(0, 0, 0));
        save.setFont(new Font("Berlin Sans FB", 0, 18));
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setOpaque(false);
        save.setText("SAVE");
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 120, 30));
        
        save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String ledger = (String) combobox.getSelectedItem();
                String description = descriptiontext.getText();
                double debitamount = 0;
                double credit = 0;
                try {
                	 debitamount = Double.parseDouble(amount1.getText());
                	 credit = Double.parseDouble(creditamt.getText());
                } catch (NumberFormatException exc) {
                    exc.printStackTrace();
                 }
                String date = formatter1.format(date1.getDate());
                
                insertTable (ledger,description,debitamount,date,credit,"vehicle"); 
               
			}
		});
        
        dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        dfs.setGroupingSeparator(',');
        dFormat = new DecimalFormat ("#0.##", dfs);
        amount1 = new JFormattedTextField(dFormat);
        amount1.setText("0.00");
        amount1.setCaretColor(Color.RED);
        amount1.setBackground(new Color(204, 204, 204));
        amount1.setFont(new Font("Tahoma", 0, 24));
        amount1.setForeground(new Color(255, 255, 255));
        amount1.setOpaque(false);

        getContentPane().add(amount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, 40));
        
        combobox.setBackground(new java.awt.Color(240, 240, 240));
        combobox.setFont(new java.awt.Font("Tahoma", 0, 24));
        combobox.setOpaque(false);
        combobox.setEditable(false);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        combobox.setModel(model);
        combobox.insertItemAt("", 0);
        
        
        comboboxAdd("vehicle");     
        
        getContentPane().add(combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 360, 40));
        
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("combobox selected"+ combobox.getSelectedItem());
            }
        });
        
        amount.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        amount.setText("DEBIT  ");
        getContentPane().add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));

        ledger.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        ledger.setForeground(new java.awt.Color(255, 255, 255));
        ledger.setText("LEDGER     ");
        getContentPane().add(ledger, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, 40));

        credit.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        credit.setForeground(new java.awt.Color(255, 255, 255));
        credit.setText("CREDIT");
        getContentPane().add(credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 50));
        
        background.setBackground(new java.awt.Color(102, 102, 102));
        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/benz.jpeg"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-81, 0, 1940, -1));

        view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model1.setRowCount(0);
				String ledger12 = (String) combobox.getSelectedItem();
				int sum = 0;
				int creditamount = 0; 
				String startdate = formatter6.format(fromdate.getDate());
				String enddate = formatter4.format(todate.getDate());
				filterTable (startdate,enddate,"vehicle",ledger12,sum,creditamount);			 
			}
			});
        
            descriptiontext.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	String ledger = (String) combobox.getSelectedItem();
                    String description = descriptiontext.getText();
                    double debitamount = 0;
                    double credit = 0;
                    try {
                    	 debitamount = Double.parseDouble(amount1.getText());
                    	 credit = Double.parseDouble(creditamt.getText());
                    } catch (NumberFormatException exc) {
                        exc.printStackTrace();
                     }
                    String date = formatter1.format(date1.getDate());
                    
                    insertTable (ledger,description,debitamount,date,credit,"vehicle");
    				
    			      }
            }
        });
        
        combobox.addKeyListener(new KeyAdapter() {

			public void actionPerformed(KeyEvent e) {
				
					amount1.requestFocusInWindow();
					
			}

		});
        
        amount1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				date1.requestFocusInWindow();
				
			}
		});
        
        date1.addAncestorListener(new AncestorListener() {

			public void ancestorRemoved(AncestorEvent event) {
				
			}

			public void ancestorAdded(AncestorEvent event) {
				creditamt.requestFocusInWindow();
			}

			public void ancestorMoved(AncestorEvent event) {

				
			}


		});
        
        creditamt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				descriptiontext.requestFocusInWindow();
			}
		});
        
        print.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String startdate = formatter6.format(fromdate.getDate());
				String enddate = formatter4.format(todate.getDate());
				createPDF("vehicle",startdate,enddate);
				
			}
		});
        pack();
	}
	
	public void ledgerTable(String ledgervalue, String source)
	{ 
		String value = ledgervalue;
		model1.setRowCount(0);
		
		int debitsum = 0;
		int creditsum = 0;
		int rem = 0;
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String sql = "Select ledger,description,debitamount,date,creditamount from accounts where ledger = '"+value+"' and source = '"+source+"'" ;
			ResultSet Rs = stmt.executeQuery(sql);
			System.out.println("query exec"+sql);
			int i = 0;
			while (Rs.next()) {
				System.out.println("inside while in view ledger");
				model1.addRow(new Object[] {i++,Rs.getString(1),Rs.getString(4),Rs.getInt(3) ,Rs.getString(2),Rs.getInt(5)} );
		        debitsum = debitsum + Rs.getInt(3);
		        creditsum = creditsum+Rs.getInt(5);
		    System.out.println("debitsum" +debitsum);  
			} 
			con.close();
		       rem = creditsum - debitsum;
		       
		       balanceget(rem, debitsum, creditsum);
		              
		}
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	}
	
	public void balanceget(int rem, int debsum, int credsum)
	{
		String s = null;
		try {
	        // The comma in the format specifier does the trick
	        s = String.format("%,d", rem);
	    } catch (NumberFormatException exc) {
	    }
		amount1.setText(Integer.toString(debsum));
		creditamt.setText(Integer.toString(credsum));
		balance.setText(s);	
	}
	
	public void createPDF (String source, String startdate, String enddate)
	{
		System.out.println("Inside create pdf");
		 Document document=new Document();
		 File file = new File("C:\\demo\\data.pdf"); 
	       try {
			PdfWriter.getInstance(document,new FileOutputStream(file));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	       document.open();
	       PdfPTable table=new PdfPTable(2);
	       table.addCell("ledger");
	       table.addCell("description");
	       table.addCell("debitamount");
	       table.addCell("date");
	       table.addCell("creditamount");
	       try
	        {
	        	Class.forName("com.mysql.jdbc.Driver");
				System.out.println("before connection");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
				System.out.println("conneted sql");
				Statement stmt = con.createStatement();
				String sql = "Select ledger,description,debitamount,date,creditamount from accounts where source = '"+source+"'and (date between '"+startdate+"' and '"+enddate+"')" ;
				ResultSet Rs = stmt.executeQuery(sql);
				System.out.println("query exec"+sql);
				while (Rs.next()) {
					table.addCell(Rs.getString(1));
				       table.addCell(Rs.getString(2));
				       table.addCell(Integer.toString(Rs.getInt(3)));
				       table.addCell(Rs.getString(4));
				       table.addCell(Integer.toString(Rs.getInt(5)));
				       
				} 
				con.close();
				document.add(table);
				 document.close();
			}
			catch (Exception e1)
			{
				System.out.println("sql exception" +e1);
			}
	}
	
	public void refreshTable (String source)
	{
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String sql = "select id,ledger,description,debitamount,date,creditamount from accounts where source = '"+source+"' ORDER BY date DESC";
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
	}
	
	public void insertTable(String ledger, String description, double debitamount, String date, double credit, String source )
	{
		System.out.println("inside insert table method");
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String sql = "Insert into  accounts (ledger,description,debitamount,date,creditamount,source) values ('" + ledger +"','" + description +"','" + debitamount +"','" + date +"','" + credit +"','"+source+"')";
			stmt.executeUpdate(sql);
			if (credit > 0)
			{
			String sql1 = "Insert into creditamount (amount , date, source) values ('" + credit +"','"+date+"','"+source+"')";
			stmt.executeUpdate(sql1);
			}
			System.out.println("query exec");
			JOptionPane.showMessageDialog(null, "DATA SAVED SUCCESSFULLY");
			con.close();      
		}
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	}
	
	public void filterTable (String startdate, String enddate, String source, String ledger12, int sum, int creditamount )
	{

		try
		{
    	Class.forName("com.mysql.jdbc.Driver");
		System.out.println("before connection");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		System.out.println("conneted sql");
		Statement stmt = con.createStatement();
		String sql = "Select amount , date from creditamount where (date between '"+startdate+"' and '"+enddate+"') and source = '"+source+"' ";
		String sql1 = null;
		if (ledger12 == null || ledger12.equals(""))
		{
			System.out.println("inside if led != null");
		sql1 = "Select  ledger,description,debitamount,date,creditamount from accounts where (date between '"+startdate+"' and '"+enddate+"') and source = '"+source+"' order by date DESC";
		}
		else
		{
			System.out.println("inside elseif led != null");
		sql1 = "Select ledger,description,debitamount,date,creditamount from accounts where (date between '"+startdate+"' and '"+enddate+"') and ledger = '"+ledger12+"' and source = '"+source+"' order by date DESC";	
		}
		ResultSet rs2 = stmt.executeQuery(sql);					
		while (rs2.next()) 
		{
	        creditamount = creditamount+rs2.getInt(1); 
	    } 
		ResultSet rs3 = stmt.executeQuery(sql1);
		System.out.println("query executed if else "+sql1);
		int i = 0;
		while(rs3.next())
         {
	        
			model1.addRow(new Object[] {i++,rs3.getString(1),rs3.getString(4),rs3.getInt(3) ,rs3.getString(2),rs3.getInt(5)} );
	          sum = sum + rs3.getInt(3);
         }
		int rem = creditamount-sum;
		System.out.println("the reminder is"+rem);
		
		balanceget(rem, sum, creditamount);
	}
		      				
	catch (Exception e1)
	{
		System.out.println("sql exception" +e1);
	}
	}
	
	public void comboboxAdd(String source)
	{
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String sql = "select ledgername from ledger where source = '"+source+"'";
			ResultSet Rs = stmt.executeQuery(sql);
			System.out.println("query exec");
			while (Rs.next()) {
				
				combobox.addItem(Rs.getString(1));
		         
		      } 
		       
		}
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	}
	public void deleteTable(String Source, String cell)
	{
	try
    {
    	Class.forName("com.mysql.jdbc.Driver");
		System.out.println("before connection");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");					
		String sql4 = "Delete from accounts where id IN ("+cell+") and source = '"+Source+"'";
		Statement stmt = con.createStatement();
		System.out.println("query is "+sql4);
		stmt.execute(sql4);
		JOptionPane.showMessageDialog(null, "DATA DELETED SUCCESSFULLY");
	       }
	catch (Exception e1)
	{
		System.out.println("sql exception" +e1);
	}
	
        }
	
        }





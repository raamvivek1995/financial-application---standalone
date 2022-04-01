import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lowagie.text.Cell;
import com.lowagie.text.Row;

public class Reportslist extends JFrame {
	private javax.swing.JLabel balance;
    private javax.swing.JLabel cr;
    private javax.swing.JLabel creditamt;
    private javax.swing.JLabel debitamt;
    private javax.swing.JLabel dr;
    private javax.swing.JLabel header;
    private javax.swing.JLabel reportslistlabel;
    private javax.swing.JPanel toppanel;
    private javax.swing.JScrollPane reportstable;
    private javax.swing.JTable reportstableshow;
    private DefaultTableModel model1;
    private DecimalFormat dc;
    private javax.swing.JLabel credlabel;
    private javax.swing.JLabel deblabel;
    private javax.swing.JLabel balancelabel;
    private JButton reportsprint;
    private JLabel interestlabel;
    private javax.swing.JLabel intr;
    private javax.swing.JLabel intramt;
    
    String source = "";
    String ledger = "";
    String fromdate =  null;
    String todate = null;
    String subledger = "";
    
	public Reportslist()
	{
		super ("VR TECHNO CORP");

        reportslistlabel = new javax.swing.JLabel();
        toppanel = new javax.swing.JPanel();
        balance = new javax.swing.JLabel();
        debitamt = new javax.swing.JLabel();
        interestlabel = new javax.swing.JLabel();
        intr = new JLabel();
        intramt = new JLabel();
        creditamt = new javax.swing.JLabel();
        dc = new DecimalFormat("0.00");
        dr = new javax.swing.JLabel();
        cr = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        credlabel = new javax.swing.JLabel();
        deblabel = new javax.swing.JLabel();
        reportsprint = new JButton();
        balancelabel = new javax.swing.JLabel();
        reportstable = new javax.swing.JScrollPane();
        reportstableshow = new javax.swing.JTable();
        model1 = new DefaultTableModel(
        		
	            new Object [][] {
	            },
	            new String [] {
	                
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        };
		
		
		//esc btn to close
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
	    Action escapeAction = new AbstractAction() {
	      public void actionPerformed(ActionEvent e) {
	        dispose();
	      }
	    };
	    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	        escapeKeyStroke, "ESCAPE");
	    getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
		ImageIcon img = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
		this.setIconImage(img.getImage());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //reportstableshow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        reportstableshow.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        reportstableshow.setRowHeight(28);
        reportstableshow.setModel(model1);
        model1.addColumn("Source");
        model1.addColumn("Ledger");
        model1.addColumn("Sub Ledger");
        model1.addColumn("Paid date");
        model1.addColumn("A/C Date");
        model1.addColumn("Valid Date");
        model1.addColumn("Description");
        model1.addColumn("Debit");
        model1.addColumn("Credit");
        model1.addColumn("Interest Paid");
        model1.addColumn("Balance");
       // model1.addColumn("Receipt");
        reportstableshow.getTableHeader().setFont(new Font("Calibri", 1, 14));
        reportstableshow.getTableHeader().setOpaque(false);
        reportstableshow.getTableHeader().setBackground(new Color(32,136,203));
        reportstableshow.getTableHeader().setForeground(new Color(255,255,255));
        reportstableshow.getColumnModel().getColumn(0).setPreferredWidth(50);
        reportstableshow.getColumnModel().getColumn(1).setPreferredWidth(100);
        reportstableshow.getColumnModel().getColumn(2).setPreferredWidth(100);
        reportstableshow.getColumnModel().getColumn(3).setPreferredWidth(20);
        reportstableshow.getColumnModel().getColumn(4).setPreferredWidth(20);
        reportstableshow.getColumnModel().getColumn(5).setPreferredWidth(20);
        reportstableshow.getColumnModel().getColumn(6).setPreferredWidth(200);
        reportstableshow.getColumnModel().getColumn(7).setPreferredWidth(30);
        reportstableshow.getColumnModel().getColumn(8).setPreferredWidth(30);
        reportstableshow.getColumnModel().getColumn(9).setPreferredWidth(45);
        reportstableshow.getColumnModel().getColumn(10).setPreferredWidth(45);
        //reportstableshow.getColumnModel().getColumn(11).setPreferredWidth(5);
        reportstableshow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        reportstableshow.setSelectionBackground(new java.awt.Color(255, 102, 102));
        reportstableshow.setSelectionForeground(new java.awt.Color(255 , 255 , 255));
        reportstableshow.setShowHorizontalLines(false);
        reportstableshow.setShowVerticalLines(false);
        reportstable.setViewportView(reportstableshow);

        getContentPane().add(reportstable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1350, 560));

        
        
        reportstableshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	if (evt.getClickCount() == 2) {
            		
            	try {
            		int index = reportstableshow.getSelectedRow();
            		//String id = model1.getValueAt(index, 0).toString();
            		String sourcedisp = model1.getValueAt(index, 0).toString();
            		String ledgerdisp = model1.getValueAt(index, 1).toString();
            		String subledgerdisp = model1.getValueAt(index, 2).toString();
            		String creditdisp = model1.getValueAt(index, 8).toString();
            		String interestdisp = model1.getValueAt(index, 9).toString();
            		String debitdisp = model1.getValueAt(index, 7).toString();
            		String datedisp = model1.getValueAt(index, 4).toString();
            		String paiddate = model1.getValueAt(index, 3).toString();
            		String validdatedisp = "";
            		try
            		{
            		validdatedisp = model1.getValueAt(index, 5).toString();
            		}
            		catch (Exception e)
            		{
            			System.out.println("reportslist"+e);
            		}
            		String descdisp = model1.getValueAt(index, 6).toString();
            		String blob = model1.getValueAt(index, 11).toString();
            		new Showdata().setDataFixed(sourcedisp, ledgerdisp, creditdisp, debitdisp, datedisp, validdatedisp, descdisp,paiddate,interestdisp,subledgerdisp);
				} catch (SQLException e) {
					e.printStackTrace();
				}};
            	
            }});
        
        
        reportslistlabel.setBackground(new java.awt.Color(255, 153, 153));
        getContentPane().add(reportslistlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1820, 770));

        credlabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        credlabel.setForeground(new java.awt.Color(51, 51, 255));
        credlabel.setText("432653.00");
        getContentPane().add(credlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 690, 130, 30));
        
        interestlabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        interestlabel.setForeground(new java.awt.Color(51, 51, 255));
        interestlabel.setText("3365214.00");
        getContentPane().add(interestlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 690, 110, 30));

        deblabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        deblabel.setForeground(new java.awt.Color(51, 51, 255));
        deblabel.setText("3365214.00");
        getContentPane().add(deblabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 690, 150, 30));
        
        balancelabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        balancelabel.setForeground(new java.awt.Color(255, 0, 51));
        balancelabel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        balancelabel.setText("9632185.00");
        getContentPane().add(balancelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 690, 210, 30));
        
        toppanel.setBackground(new java.awt.Color(0, 153, 153));
        toppanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));
        toppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        
        reportsprint.setOpaque(false);
        reportsprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/print.png")));
        toppanel.add(reportsprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 25, 60, 60));
        
        reportsprint.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				model1.setColumnCount(0);
				reportstableshow.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		        reportstableshow.setRowHeight(28);
		        reportstableshow.setModel(model1);
		        model1.addColumn("Id");
		        model1.addColumn("Source");
		        model1.addColumn("Ledger");
		        model1.addColumn("A/C Date");
		        model1.addColumn("Description");
		        model1.addColumn("Debit");
		        model1.addColumn("Credit");
		        model1.addColumn("Balance");
		        reportstableshow.getTableHeader().setFont(new Font("Calibri", 1, 14));
		        reportstableshow.getTableHeader().setOpaque(false);
		        reportstableshow.getTableHeader().setBackground(new Color(32,136,203));
		        reportstableshow.getTableHeader().setForeground(new Color(255,255,255));
		        reportstableshow.getColumnModel().getColumn(0).setPreferredWidth(5);
		        reportstableshow.getColumnModel().getColumn(1).setPreferredWidth(30);
		        reportstableshow.getColumnModel().getColumn(2).setPreferredWidth(60);
		        reportstableshow.getColumnModel().getColumn(3).setPreferredWidth(30);
		        reportstableshow.getColumnModel().getColumn(4).setPreferredWidth(200);
		        reportstableshow.getColumnModel().getColumn(5).setPreferredWidth(30);
		        reportstableshow.getColumnModel().getColumn(6).setPreferredWidth(30);
		        reportstableshow.getColumnModel().getColumn(7).setPreferredWidth(40);
		        reportstableshow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		        reportstableshow.setSelectionBackground(new java.awt.Color(255, 102, 102));
		        reportstableshow.setSelectionForeground(new java.awt.Color(255 , 255 , 255));
		        reportstableshow.setShowHorizontalLines(false);
		        reportstableshow.setShowVerticalLines(false);
		        reportstable.setViewportView(reportstableshow);
		        
				printtableview(source , ledger, fromdate, todate);
				
				FileOutputStream excelFOU = null;
				 BufferedOutputStream excelbou = null;
				 XSSFWorkbook excelexporter = null; 
				 XSSFRow row;
				  XSSFCell cell;
				  
				 try
				{

				 JFileChooser excelfilechoose = new JFileChooser("E:\\BACKUPS");
				 excelfilechoose.setDialogTitle("SAVE AS");
				 FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls" , "xlsx" , "xlsm");
				 excelfilechoose.setFileFilter(fnef);
				 int excelchooser = excelfilechoose.showSaveDialog(null);
				 
				 if (excelchooser == JFileChooser.APPROVE_OPTION)
				 {
					 excelexporter = new XSSFWorkbook();
					 XSSFSheet excelsheet = excelexporter.createSheet("ACCOUNT SHEET");
					 
					 
					 for (int i=0 ; i< model1.getRowCount(); i++)
					 {
						 XSSFRow excelrow = excelsheet.createRow(i);
						  
						 for (int j=0 ; j<model1.getColumnCount(); j++)
						 {
							 XSSFCell exelcell = excelrow.createCell(j);
							 exelcell.setCellValue(model1.getColumnName(j));
							 exelcell.setCellValue(model1.getValueAt(i, j).toString());
						 }
					 }
					 excelFOU = new FileOutputStream(excelfilechoose.getSelectedFile() +".xlsx");
					 excelbou = new BufferedOutputStream(excelFOU);
					 excelexporter.write(excelbou);
					 JOptionPane.showMessageDialog(null, "EXPORTED SUCCESSFULLY AND STORED IN" +excelfilechoose.getSelectedFile());
					 dispose();
				 }
				
			}
			
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
				finally
				{
					 try {
						 
						 if (excelbou != null)
						 {
							 excelbou.close();
						 }
						 if(excelFOU != null)
						 {
						excelFOU.close();
						 } 
		                if(excelexporter != null)
						 {
							 excelexporter.close();
						 }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
				
			
		});
        
        balance.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        balance.setForeground(new java.awt.Color(51, 255, 51));
        balance.setText("450000023568.00");
        toppanel.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 480, 60));

        debitamt.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        debitamt.setForeground(new java.awt.Color(255, 255, 255));
        debitamt.setText("3164351686.00");
        toppanel.add(debitamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 170, 30));

        creditamt.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        creditamt.setForeground(new java.awt.Color(255, 255, 255));
        creditamt.setText("250656933.00");
        toppanel.add(creditamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 200, 30));

        dr.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        dr.setForeground(new java.awt.Color(255, 255, 255));
        dr.setText("Debit :");
        toppanel.add(dr, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 50, 30));

        cr.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cr.setForeground(new java.awt.Color(255, 255, 255));
        cr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cr.setText("Credit :");
        toppanel.add(cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 60, 10));

        header.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("REPORTS  ");
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        toppanel.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 300, 40));
        
        intr.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        intr.setForeground(new java.awt.Color(255, 255, 255));
        intr.setText("Intr    :");
        toppanel.add(intr, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 50, 30));

        intramt.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        intramt.setForeground(new java.awt.Color(51, 255, 51));
        intramt.setText("3164351686.00");
        toppanel.add(intramt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 170, 30));

        getContentPane().add(toppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1830, 110));

        pack();
	}
	public void showReport(String ledger, String subledger, String source, String from, String to)
	{
		
		this.ledger = ledger;
		this.source = source;
		this.fromdate = from;
		this.todate = to;
		this.subledger = subledger;
		
		String empty = "";
		double debitsum = 0;
		double  creditsum = 0;
		double rem = 0;
		double interestsum = 0;
		Connection con = null;
		Connection con1 = null;
		String from1 = null;
		ResultSet Rs1 = null;
		
		System.out.println("from date is"+from);
		System.out.println("to date is"+to);
		
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where ");
			
			if(source != empty)
   			{   
   				sql.append("source = '"+source+"'");
   			}
   			
   			if (ledger != empty)
   			{
   				sql.append("and ");
   				sql.append("ledger = '"+ledger+"'");
   				System.out.println("reports entry subledger---------->1"+subledger);
   				if(subledger != empty)
   				{
   					System.out.println("reports entry subledger---------->2"+subledger);
   					sql.append("and ");
   					sql.append("subledger ='"+subledger+"'");
   					}
   				
   				
   			}
   			//System.out.println("from date:" +ef+"to date" +et);  	
   			
   			if (source!= empty )
   			{
   			if (from.isEmpty() && to.isEmpty())
   			{
   				
   			}
   			else
   			{
   				sql.append("and ");
   			}
   			}
   			
   			if (from.isEmpty() && to.isEmpty())
   			{
   				
   			}
   			else
   			{
   				sql.append("(date between '"+from+"' and '"+to+"')");
   			}
			//sql.append(")");
			sql.append("order by date ");
			ResultSet Rs = stmt.executeQuery(sql.toString());
			
			System.out.println("query exec in reportslist"+sql);
			model1.setRowCount(0);
			/*if (Rs1.next())
			{
				
				from1 = Rs1.getString(1);
				System.out.println("inside while Rs1.next()"+from1);
			}*/
		
			while (Rs.next()) {
				//System.out.println("inside resultset modeledit");
				  
				String debitformat = dc.format(Rs.getDouble(4));
				String creditformat = dc.format(Rs.getDouble(6));
				debitsum = debitsum + Rs.getDouble(4);
			    creditsum = creditsum + Rs.getDouble(6);
			    interestsum = interestsum + Rs.getDouble(11);
			    String interest = dc.format(Rs.getDouble(11));
			   rem = ( creditsum - debitsum);
			  //String k ="19/03/2020";
			   String fromd = Rs.getString(5);
			   //while (fromd .equals (from1)) {  
               model1.addRow(new Object[] {Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,interest ,rem} ); 
			   
			  /* 
			   {
			  model1.addRow(new Object[] {"","","","","CLOSING BALANCE","","","","",""} );
			  model1.addRow(new Object[] {"","","","","OPENING BALANCE","","","","",""} );
			  if (Rs1.next())
				{
					
					from1 = Rs1.getString(1);
					System.out.println("inside while Rs1.next() inside second if"+from1);
				}
			   }*/
			  // k = from +1;
			   //System.out.println("value of added date"+k);
			} 
			//}
			//String rem1 = Integer.toString(rem);
			balance.setText(printCurrency(rem));
			con.close();
			//con1.close();
			//String cred1 = Integer.toString(creditsum);
			//String deb1 = Integer.toString(debitsum);
			
			creditamt.setText(printCurrency(creditsum));
			debitamt.setText(printCurrency(debitsum));
			 //Locale indian = new Locale("en", "IN");
			 //NumberFormat indianFormat = NumberFormat.getCurrencyInstance(indian);
			intramt.setText(printCurrency(interestsum));
			
			credlabel.setText(dc.format(debitsum));
			deblabel.setText(dc.format(creditsum));
			balancelabel.setText(dc.format(rem));
			interestlabel.setText(dc.format(interestsum));
		 
        }
		
		
		
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	

}
	
	public void printtableview(String source, String ledger, String from, String to )
	   {
		   String empty = "";
			double debitsum = 0;
			double  creditsum = 0;
			double rem = 0;
			Connection con = null;
			Connection con1 = null;
			String from1 = null;
			ResultSet Rs1 = null;
			
			System.out.println("from date is"+from);
			System.out.println("to date is"+to);
			
			try
	       {
	       	Class.forName("com.mysql.jdbc.Driver");
				System.out.println("before connection");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
				System.out.println("conneted sql");
				Statement stmt = con.createStatement();
				StringBuffer sql = new StringBuffer();
				sql.append("Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where ");
       			
       			if(source != empty)
       			{   
       				sql.append("source = '"+source+"'");
       			}
       			
       			if (ledger != empty)
       			{
       				sql.append("and ");
       				sql.append("ledger = '"+ledger+"'");
       				System.out.println("edit entry subledger---------->1"+subledger);
       				
       				
       				
       			}
       			//System.out.println("from date:" +ef+"to date" +et);  	
       			
       			if (source!= empty )
       			{
       			if (from.isEmpty() && to.isEmpty())
       			{
       				
       			}
       			else
       			{
       				sql.append("and ");
       			}
       			}
       			
       			if (from.isEmpty() && to.isEmpty())
       			{
       				
       			}
       			else
       			{
       				sql.append("(date between '"+from+"' and '"+to+"')");
       			}
				//sql.append(")");
				sql.append("order by date ");
				ResultSet Rs = stmt.executeQuery(sql.toString());
				
				System.out.println("query exec"+sql);
				model1.setRowCount(0);
			int i =0;
				while (Rs.next()) {
					System.out.println("inside resultset modelprint");
					  
					String debitformat = dc.format(Rs.getDouble(4));
					String creditformat = dc.format(Rs.getDouble(6));
					debitsum = debitsum + Rs.getDouble(4);
				    creditsum = creditsum + Rs.getDouble(6);
				   rem = (creditsum - debitsum);
				   String fromd = Rs.getString(5);  
	              model1.addRow(new Object[] {i++,Rs.getString(8),Rs.getString(2),Rs.getString(5),Rs.getString(3),debitformat,creditformat,rem} ); 
	 
	       }
				
			
	       }
			
			catch (Exception e1)
			{
				System.out.println("sql exception" +e1);
			}
	   
		
	}
	
	public void showledgerReport(String subledger)
	{
		
		
		
		String empty = "";
		double debitsum = 0;
		double  creditsum = 0;
		double rem = 0;
		double interestsum = 0;
		Connection con = null;
		Connection con1 = null;
		String from1 = null;
		ResultSet Rs1 = null;
		reportsprint.setVisible(false);
		
		
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where subledger = '"+subledger+"'");
			ResultSet Rs = stmt.executeQuery(sql.toString());
			
			System.out.println("query exec in reportslist"+sql);
			model1.setRowCount(0);
			/*if (Rs1.next())
			{
				
				from1 = Rs1.getString(1);
				System.out.println("inside while Rs1.next()"+from1);
			}*/
		
			while (Rs.next()) {
				//System.out.println("inside resultset modeledit");
				  
				String debitformat = dc.format(Rs.getDouble(4));
				String creditformat = dc.format(Rs.getDouble(6));
				debitsum = debitsum + Rs.getDouble(4);
			    creditsum = creditsum + Rs.getDouble(6);
			    interestsum = interestsum + Rs.getDouble(11);
			    String interest = dc.format(Rs.getDouble(11));
			   rem = ( creditsum - debitsum);
			  //String k ="19/03/2020";
			   String fromd = Rs.getString(5);
			   //while (fromd .equals (from1)) {  
               model1.addRow(new Object[] {Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,interest ,rem,Rs.getBlob(9)} ); 
			   
			  /* 
			   {
			  model1.addRow(new Object[] {"","","","","CLOSING BALANCE","","","","",""} );
			  model1.addRow(new Object[] {"","","","","OPENING BALANCE","","","","",""} );
			  if (Rs1.next())
				{
					
					from1 = Rs1.getString(1);
					System.out.println("inside while Rs1.next() inside second if"+from1);
				}
			   }*/
			  // k = from +1;
			   //System.out.println("value of added date"+k);
			} 
			//}
			//String rem1 = Integer.toString(rem);
			balance.setText(printCurrency(rem));
			con.close();
			//con1.close();
			//String cred1 = Integer.toString(creditsum);
			//String deb1 = Integer.toString(debitsum);
			
			creditamt.setText(printCurrency(creditsum));
			debitamt.setText(printCurrency(debitsum));
			 //Locale indian = new Locale("en", "IN");
			 //NumberFormat indianFormat = NumberFormat.getCurrencyInstance(indian);
			intramt.setText(printCurrency(interestsum));
			
			credlabel.setText(dc.format(debitsum));
			deblabel.setText(dc.format(creditsum));
			balancelabel.setText(dc.format(rem));
			interestlabel.setText(dc.format(interestsum));
		 
        }
		
		
		
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	

}

	public void showledgerReport1(String ledger)
	{
		
		
		
		String empty = "";
		double debitsum = 0;
		double  creditsum = 0;
		double rem = 0;
		double interestsum = 0;
		Connection con = null;
		Connection con1 = null;
		String from1 = null;
		ResultSet Rs1 = null;
		reportsprint.setVisible(false);
		
		
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where ledger = '"+ledger+"'");
			ResultSet Rs = stmt.executeQuery(sql.toString());
			
			System.out.println("query exec in reportslist"+sql);
			model1.setRowCount(0);
			/*if (Rs1.next())
			{
				
				from1 = Rs1.getString(1);
				System.out.println("inside while Rs1.next()"+from1);
			}*/
		
			while (Rs.next()) {
				//System.out.println("inside resultset modeledit");
				  
				String debitformat = dc.format(Rs.getDouble(4));
				String creditformat = dc.format(Rs.getDouble(6));
				debitsum = debitsum + Rs.getDouble(4);
			    creditsum = creditsum + Rs.getDouble(6);
			    interestsum = interestsum + Rs.getDouble(11);
			    String interest = dc.format(Rs.getDouble(11));
			   rem = ( creditsum - debitsum);
			  //String k ="19/03/2020";
			   String fromd = Rs.getString(5);
			   //while (fromd .equals (from1)) {  
               model1.addRow(new Object[] {Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,interest ,rem,Rs.getBlob(9)} ); 
			   
			  /* 
			   {
			  model1.addRow(new Object[] {"","","","","CLOSING BALANCE","","","","",""} );
			  model1.addRow(new Object[] {"","","","","OPENING BALANCE","","","","",""} );
			  if (Rs1.next())
				{
					
					from1 = Rs1.getString(1);
					System.out.println("inside while Rs1.next() inside second if"+from1);
				}
			   }*/
			  // k = from +1;
			   //System.out.println("value of added date"+k);
			} 
			//}
			//String rem1 = Integer.toString(rem);
			//balance.setText(dc.format(rem));
			balance.setText(printCurrency(rem));
			con.close();
			//con1.close();
			//String cred1 = Integer.toString(creditsum);
			//String deb1 = Integer.toString(debitsum);
			
			creditamt.setText(printCurrency(creditsum));
			debitamt.setText(printCurrency(debitsum));
			 //Locale indian = new Locale("en", "IN");
			 //NumberFormat indianFormat = NumberFormat.getCurrencyInstance(indian);
			intramt.setText(printCurrency(interestsum));
			
			credlabel.setText(dc.format(debitsum));
			deblabel.setText(dc.format(creditsum));
			balancelabel.setText(dc.format(rem));
			interestlabel.setText(dc.format(interestsum));
		 
        }
		
		
		
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	

}
	
	public String printCurrency(Double d){  
		 double dbl= d;  
		 NumberFormat formatter=NumberFormat.getCurrencyInstance(new Locale("en","IN"));  
		 String currency=formatter.format(dbl);  
		 System.out.println(currency+" for the locale ");  
		 return currency;
		}  
	
	
}


	

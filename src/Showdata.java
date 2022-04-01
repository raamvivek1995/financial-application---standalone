import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.mysql.cj.protocol.Resultset;

public class Showdata extends JFrame {
	private javax.swing.JLabel credit;
    private javax.swing.JTextField creditamt;
    private javax.swing.JLabel date;
    private javax.swing.JFormattedTextField datebox;
    private javax.swing.JLabel debit;
    private javax.swing.JTextField debitamt;
    private javax.swing.JButton deletebtn;
    private javax.swing.JLabel desclabel;
    private javax.swing.JTextField descriptionbox;
    private javax.swing.JLabel entrychooselabel;
    private javax.swing.JButton entryuploadbtn;
    private javax.swing.JLabel headerpanelreport;
    private javax.swing.JComboBox<String> ledgercombo;
    private javax.swing.JComboBox<String> subledgercombo;
    private javax.swing.JLabel ledgerlabel;
    private javax.swing.JLabel piclabel;
    private javax.swing.JLabel reportheader;
    private javax.swing.JLabel source;
    private javax.swing.JComboBox<String> sourcecombo;
    private javax.swing.JButton submitbtn;
    private javax.swing.JPanel tablereports;
    private javax.swing.JButton updatebtn;
    private javax.swing.JFormattedTextField validdatebox;
    private javax.swing.JLabel validity;
    String index = null;
    private JTable table;
    private JTable table1;
    private SimpleDateFormat frmt1;
    private DecimalFormat dc;
    private String paiddate;
    private JFormattedTextField paiddatebox;
    private JLabel dateac;
    private JLabel interestname;
    private JTextField interestbox;
    
    //editentry
    
   private String searchtext = "";
   private String empty = "";
   private String ledgerdata = "";
   private String sourcedata = null;
   private String ef = null;
   private String et = null;
   String mask = "##/##/####";
   private String validdate = null;
   private String sourcesearch = null;
   private String ledgersearch = "";
   private String datesearch = null;
   private String descsearch = null;
   private String subledgerdisp = "";
   
   
    
	public Showdata()
	{
		super ("VR TECHNO CORP");
		ImageIcon img = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
		this.setIconImage(img.getImage());
        setVisible(true);
		setResizable(false);
		setPreferredSize(new java.awt.Dimension(1148, 720));
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = new Dimension();
		Toolkit toolkit = getToolkit();
		dim = toolkit.getScreenSize();
		 setLocation(dim.width/14 - getWidth()/14 , dim.height/40 - getHeight()/40);
		
		 
		 dc = new DecimalFormat("0.00");
		 frmt1 = new SimpleDateFormat();
		tablereports = new javax.swing.JPanel();
        ledgerlabel = new javax.swing.JLabel();
        credit = new javax.swing.JLabel();
        creditamt = new javax.swing.JTextField();
        interestname = new javax.swing.JLabel();
        interestbox = new javax.swing.JTextField();
        ledgercombo = new javax.swing.JComboBox<>();
        subledgercombo = new javax.swing.JComboBox<>();
        date = new JLabel();
        datebox = new JFormattedTextField(createFormatter(mask));
        desclabel = new javax.swing.JLabel();
        descriptionbox = new javax.swing.JTextField();
        source = new javax.swing.JLabel();
        sourcecombo = new javax.swing.JComboBox<>();
        debit = new javax.swing.JLabel();
        debitamt = new javax.swing.JTextField();
        validity = new javax.swing.JLabel();
        validdatebox = new JFormattedTextField(createFormatter(mask));
        submitbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        entrychooselabel = new javax.swing.JLabel();
        entryuploadbtn = new javax.swing.JButton();
        piclabel = new javax.swing.JLabel();
        headerpanelreport = new javax.swing.JLabel();
        reportheader = new javax.swing.JLabel();
        paiddatebox = new JFormattedTextField(createFormatter(mask));
        dateac = new JLabel();
        
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        reportheader.setBackground(new java.awt.Color(102, 102, 102));
        reportheader.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        reportheader.setForeground(new java.awt.Color(255, 255, 255));
        reportheader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reportheader.setText("EDIT RECORDS");
        reportheader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        getContentPane().add(reportheader, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 290, 50));

        tablereports.setBackground(new java.awt.Color(255, 255, 255));
        tablereports.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        tablereports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        submitbtn.setText("Update");
        tablereports.add(submitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 210, 103, 36));
        
        submitbtn.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
            String source = (String) sourcecombo.getSelectedItem();
            String ledger = (String)ledgercombo.getSelectedItem();
            Double credamt = Double.parseDouble(creditamt.getText());
            Double debamt = Double.parseDouble(debitamt.getText());
            Double interestamt = Double.parseDouble(interestbox.getText());
            String date = datebox.getText();
            String validdate1 = validdatebox.getText();
            String desc = descriptionbox.getText();
            String paiddate = paiddatebox.getText();
            String subledgerdisp = (String) subledgercombo.getSelectedItem();
            
				
				try
			    {
			    	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");					
					String sql4 = "update accounts SET ledger = '"+ledger+"',description= '"+desc+"',debitamount = '"+debamt+"',date = '"+date+"',creditamount = '"+credamt+"',source = '"+source+"',validdate = '"+validdate1+"',paiddate = '"+paiddate+"',interestpaid = '"+interestamt+"',subledger = '"+subledgerdisp+"' where id IN ("+index+") ";
					Statement stmt = con.createStatement();
					System.out.println("query is to update "+sql4);
					stmt.execute(sql4);
					JOptionPane.showMessageDialog(null, "DATA UPDATED SUCCESSFULLY");
					System.out.println("inside if of notify validdate is "+validdate);
					if(validdate .equals("00/00/0000"))
					{
						System.out.println("inside if of notify validdate is "+validdate);
						if (validdatebox.getText().equals("00/00/0000"))
						{
							System.out.println("valid already zero");
						}
						else
						{
							
							System.out.println("inside notification insert");
							notificationinsert(source, ledger, date, validdate1, desc);
						}
					}
					else
					{
						System.out.println("before notify update********************");
					    notificationupdate(source, ledger, date, validdate1, desc);
						
					}

					searchtablerefresh();
					edittablerefresh();
				       }
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
				
			
				
			}
		});

        updatebtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        updatebtn.setText("Delete");
      
        tablereports.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 250, 103, 30));
        updatebtn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				String source = (String) sourcecombo.getSelectedItem();
	              String ledger = (String)ledgercombo.getSelectedItem();
	              String date = datebox.getText();
	              String validdate = validdatebox.getText();
	              String desc = descriptionbox.getText();
	              String subledgerdisp = (String) subledgercombo.getSelectedItem();
	              
	              
	              System.out.println("before deleting process "+source+""+ledger+""+date+""+validdate+""+desc+""+subledgerdisp+"");
	              
				try
			    {
			    	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");					
					String sql4 = "Delete from accounts where id IN ("+index+") ";
					Statement stmt = con.createStatement();
					System.out.println("query is "+sql4);
					stmt.execute(sql4);
					JOptionPane.showMessageDialog(null, "DATA DELETED SUCCESSFULLY");
					searchtablerefresh();
					edittablerefresh();
					if(validdatebox.getText() .equals("00/00/0000"))
					{
						System.out.println("no entry of insert notify");
					}
					else
					{
						notificationdelete(source, ledger, date, validdate, desc);
					}
			    }
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
				
			}
		});
        
        deletebtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        deletebtn.setText("Back");
       
        tablereports.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 310, 103, -1));
        
        deletebtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

        piclabel.setBackground(new java.awt.Color(102, 102, 102));
        piclabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        piclabel.setMaximumSize(new java.awt.Dimension(208, 212));
        piclabel.setMinimumSize(new java.awt.Dimension(208, 212));
        tablereports.add(piclabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 277, 386));

        source.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        source.setText("SOURCE");
        tablereports.add(source, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 120, 40));

        sourcecombo.setBackground(new java.awt.Color(255, 204, 204));
        sourcecombo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        sourcecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"House","Estate","Finance","Vehicle"}));
        sourcecombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
      
        tablereports.add(sourcecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 180, -1));

        ledgerlabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgerlabel.setText("LEDGER    ");
        tablereports.add(ledgerlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 120, 40));

        ledgercombo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ledgercombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        
        tablereports.add(ledgercombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 360, -1));

              ledgercombo.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				ledgercombo.setBackground(new java.awt.Color(255, 255, 255));
			}
			
			public void focusGained(final FocusEvent e) {
				
				ledgercombo.setBackground(new java.awt.Color(255, 204, 204));
				
				String ledgername = (String) ledgercombo.getSelectedItem();
				//String subledgername = (String) subledgercombo.getSelectedItem();
				String sourcename = (String) sourcecombo.getSelectedItem();
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select ledgername from ledger where source = '"+sourcename+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec in show screen"+sql);
					ledgercombo.removeAllItems();
					ledgercombo.insertItemAt("", 0);
					while (Rs.next()) {
						
						ledgercombo.addItem(Rs.getString(1));
				         
				      } 
				       
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
			}
		});
        credit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        credit.setText("CREDIT");
        tablereports.add(credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 100, 30));

        creditamt.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        creditamt.setForeground(new java.awt.Color(255, 51, 51));
        creditamt.setText("00.000");
       
        tablereports.add(creditamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 150, 39));
        
        creditamt.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				creditamt.selectAll();
				
			}
		});

        debit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        debit.setText("DEBIT");
        tablereports.add(debit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 100, 30));

        debitamt.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        debitamt.setForeground(new java.awt.Color(255, 51, 51));
        debitamt.setText("00.000");
        
        tablereports.add(debitamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 150, 39));
        
        debitamt.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				debitamt.selectAll();
				
			}
		});

        date.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("    PAID DATE   ");
        tablereports.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 265, 110, 50));

        datebox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        datebox.setText("00/00/0000");
        datebox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
       
        tablereports.add(datebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 120, 40));

        datebox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				datebox.selectAll();
				
			}
		});
        
        paiddatebox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        paiddatebox.setText("00/00/0000");
        paiddatebox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tablereports.add(paiddatebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 270, 120, 40));
        
        paiddatebox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				paiddatebox.selectAll();
				
			}
		});
        
        
        validity.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        validity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        validity.setText("VALID DATE       ");
        tablereports.add(validity, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 50));

        validdatebox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        validdatebox.setText("00/00/0000");
        validdatebox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
       
        tablereports.add(validdatebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 150, 40));
        
        validdatebox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				validdatebox.selectAll();
				
			}
		});

        desclabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        desclabel.setText("DESCRIPTION");
        tablereports.add(desclabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 130, 30));

        descriptionbox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        descriptionbox.setText("Enter your description for the expenses here.");
        descriptionbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        descriptionbox.setOpaque(false);
        tablereports.add(descriptionbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 361, 30));

        descriptionbox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				descriptionbox.selectAll();
				
			}
		});
        
        
        entrychooselabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        entrychooselabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entrychooselabel.setText("             Choose pic");
        tablereports.add(entrychooselabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 151, 32));

        entryuploadbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        entryuploadbtn.setText("Upload");
        tablereports.add(entryuploadbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 150, 32));
        dateac.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        dateac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateac.setText(" A/C DATE   ");
        tablereports.add(dateac, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 90, 40));
        
        interestname.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        interestname.setText("INT PAID");
        tablereports.add(interestname, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 190, 90, 20));

        interestbox.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        interestbox.setForeground(new java.awt.Color(255, 51, 51));
        interestbox.setText("0.00");
        tablereports.add(interestbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 150, 39));
        
        interestbox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				
			}

			public void focusGained(FocusEvent e) {
				interestbox.selectAll();
			}
		});

        
        
        
        
        subledgercombo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        subledgercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        subledgercombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        
        tablereports.add(subledgercombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 360, 30));

        subledgercombo.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				subledgercombo.setBackground(new java.awt.Color(255, 255, 255));
			}
			
			public void focusGained(final FocusEvent e) {
				
				subledgercombo.setBackground(new java.awt.Color(255, 204, 204));
				String ledgername = (String) ledgercombo.getSelectedItem();
				//String subledgername = (String) subledgercombo.getSelectedItem();
				//String sourcename = (String) sourcecombo.getSelectedItem();
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select subledgername from subledger where ledgername = '"+ledgername+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec");
					subledgercombo.removeAllItems();
					subledgercombo.insertItemAt("", 0);
					while (Rs.next()) {
						
						subledgercombo.addItem(Rs.getString(1));
				         
				      } 
				       
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
			}
		});
        
        
        getContentPane().add(tablereports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1140, 570));

        headerpanelreport.setBackground(new java.awt.Color(102, 102, 102));
        headerpanelreport.setOpaque(true);
        getContentPane().add(headerpanelreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 120));

        

        pack();
	}
	protected static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
          formatter = new MaskFormatter(s);
        } catch (ParseException ex) {
          System.err.println("formatter is bad: " + ex.getMessage());
        }
        return formatter;
      }
	public void setData (String source, String ledger, String creditdisp, String debitdisp, String date, String validdate, String desc , ImageIcon im) throws SQLException
	{
		System.out.println("inside setdata method");
		Image image = im.getImage().getScaledInstance(piclabel.getWidth(), piclabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image3 = new ImageIcon(image);
		sourcecombo.insertItemAt(source, 0);
		sourcecombo.setSelectedIndex(0);
		ledgercombo.insertItemAt(ledger, 0);
		ledgercombo.setSelectedIndex(0);
		creditamt.setText(creditdisp.toString());
		debitamt.setText(debitdisp.toString());
		datebox.setText(date);
		validdatebox.setText(validdate);
		descriptionbox.setText(desc);
        piclabel.setIcon(image3);
			
	}
	public void setDatacpy (String id , String source, String ledger, String creditdisp, String debitdisp, String date, String validdate, String desc, JTable table, String paiddate, String interestdisp, String subledgerdisp ) throws SQLException
	{
		this.table = table;
		System.out.println("inside setdata method");
		//Image image = im.getImage().getScaledInstance(piclabel.getWidth(), piclabel.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon image3 = new ImageIcon(image);
		sourcecombo.insertItemAt(source, 0);
		sourcecombo.setSelectedIndex(0);
		ledgercombo.insertItemAt(ledger, 0);
		ledgercombo.setSelectedIndex(0);
		subledgercombo.insertItemAt(subledgerdisp, 0);
		subledgercombo.setSelectedIndex(0);
		creditamt.setText(creditdisp.toString());
		debitamt.setText(debitdisp.toString());
		interestbox.setText(interestdisp.toString());
		datebox.setText(date);
		validdatebox.setText(validdate);
		descriptionbox.setText(desc);
		reportheader.setText("EDIT RECORDS"+":"+id);
		subledgercombo.insertItemAt(subledgerdisp, 0);
		this.index = id;
		
        //piclabel.setIcon(image3);
		paiddatebox.setText(paiddate);
		this.paiddate = paiddate;	
		this.validdate = validdate;
		this.sourcesearch = source;
		this.ledgersearch = ledger;
		this.datesearch = date;
		this.descsearch = desc;
		this.subledgerdisp = subledgerdisp;
	}
	
	public void setDatacpyedit (String id , String source, String ledger, String creditdisp, String debitdisp, String date, String validdate, String desc, JTable table, String searchtext , String empty , String ledgerdata, String sourcedata, String ef,String et ,String paiddate, String interest, String subledgerdisp) throws SQLException
	{
		this.table = table;
		this.searchtext = searchtext;
		this.empty = empty;
		this.ledgerdata = ledgerdata;
		this.sourcedata = sourcedata;
		this.ef = ef;
		this.et = et;
		System.out.println("inside setdataedit method");
		//Image image = im.getImage().getScaledInstance(piclabel.getWidth(), piclabel.getHeight(), Image.SCALE_SMOOTH);
		//ImageIcon image3 = new ImageIcon(image);
		sourcecombo.insertItemAt(source, 0);
		sourcecombo.setSelectedIndex(0);
		ledgercombo.insertItemAt(ledger, 0);
		ledgercombo.setSelectedIndex(0);
		System.out.println("subledgerdisp is show ------------->"+subledgerdisp);
		subledgercombo.insertItemAt(subledgerdisp, 0);
		subledgercombo.setSelectedIndex(0);
		creditamt.setText(creditdisp.toString());
		debitamt.setText(debitdisp.toString());
		interestbox.setText(interest.toString());
		datebox.setText(date);
		validdatebox.setText(validdate);
		descriptionbox.setText(desc);
		reportheader.setText("EDIT RECORDS"+":"+id);
		this.index = id;
        //piclabel.setIcon(image3);
		paiddatebox.setText(paiddate);
		this.paiddate = paiddate;
		
		this.validdate = validdate;
		this.sourcesearch = source;
		this.ledgersearch = ledger;
		this.datesearch = date;
		this.descsearch = desc;
		this.subledgerdisp = subledgerdisp;
			
	}
	public void setDataFixed(String source, String ledger, String creditdisp, String debitdisp, String date, String validdate, String desc , String paiddate, String interestdisp, String subledgerdisp) throws SQLException
	{
		System.out.println("inside setdata method");
		reportheader.setText("RECORD SHOW");
		sourcecombo.insertItemAt(source, 0);
		sourcecombo.setSelectedIndex(0);
		ledgercombo.insertItemAt(ledger, 0);
		ledgercombo.setSelectedIndex(0);
		subledgercombo.insertItemAt(subledgerdisp, 0);
		subledgercombo.setSelectedIndex(0);
		creditamt.setText(creditdisp.toString());
		debitamt.setText(debitdisp.toString());
		datebox.setText(date);
		interestbox.setText(interestdisp.toString());
		interestbox.setEditable(false);
		validdatebox.setText(validdate);
		descriptionbox.setText(desc);
		creditamt.setEditable(false);
		debitamt.setEditable(false);
		datebox.setEditable(false);
		validdatebox.setEditable(false);
		descriptionbox.setEditable(false);
		paiddatebox.setEditable(false);
		entryuploadbtn.setVisible(false);
		entrychooselabel.setVisible(false);
		updatebtn.setVisible(false);
		submitbtn.setVisible(false);
		paiddatebox.setText(paiddate);
		this.paiddate = paiddate;
	}
	
	public void searchtablerefresh()
	{
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String sql = null;
			sql = "Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate, interestpaid,subledger from accounts order by id DESC";
			ResultSet Rs = stmt.executeQuery(sql);
			System.out.println("query exec"+sql);
			model1.setRowCount(0);
			//Object[]fila = new Object[4];
			while (Rs.next()) {
				String debitformat = dc.format(Rs.getDouble(4));
				String creditformat = dc.format(Rs.getDouble(6)); 
				String interestformat = dc.format(Rs.getDouble(11));
				//System.out.println("query exec 22222222222222");
	        // System.out.println("query exec 444444");
	      //fila [1] = new ImageIcon(new ImageIcon(Rs.getBytes("pic")).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
	         //System.out.println("query exec 66666666"+fila [1] );
				model1.addRow(new Object[] {Rs.getInt(1),Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,interestformat, Rs.getBytes("pic")} ); 
			} 
			con.close();
		}
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
		
	}
	public void edittablerefresh()
	{
		DefaultTableModel model1 = (DefaultTableModel) table.getModel();
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			StringBuffer sql = new StringBuffer();
			
			sql.append("Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where ");
			
			if(ledgerdata != empty)
			{   
				sql.append("ledger = '"+ledgerdata+"'");
				if(sourcedata != empty)
				{sql.append("and ");}
				if (ef.isEmpty() && et.isEmpty())
    			{}    else {sql.append("and ");}

			}
			if (sourcedata != empty)
			{
				sql.append("source = '"+sourcedata+"'");
				if (ef.isEmpty() && et.isEmpty())
    			{
    				
    			}
    			else
    			{
    				sql.append("and ");
    			}
				
			}
			//System.out.println("from date:" +ef+"to date" +et);
			
			if (ef.isEmpty() && et.isEmpty())
			{
				
			}
			else
			{
				sql.append("(date between '"+ef+"' and '"+et+"')");
			}
			//sql.append(")");
			sql.append("order by date ");
			ResultSet Rs = stmt.executeQuery(sql.toString());
			System.out.println("query exec"+sql);
			model1.setRowCount(0);
			while (Rs.next()) {
				//System.out.println("inside resultset modeledit");
				String debitformat = dc.format(Rs.getDouble(4));
				String creditformat = dc.format(Rs.getDouble(6));
				String interestformat = dc.format(Rs.getDouble(11));
				model1.addRow(new Object[] {Rs.getInt(1),Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,interestformat,Rs.getBlob(9)} ); 
			} 
			con.close();
		}
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	}
	 public void notificationinsert(String source, String ledger, String date, String validdate, String description)
	   {
		  
		   System.out.println("inside notification insert table method");
		   if (validdate.equals("") || validdate.equals("00/00/0000"))
		   {
			System.out.println("notifiation insert failed");
		   }
		   else
		   {
			   try
		       {
		       	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "Insert into  notification (source,ledger,date, validdate , description) values ('" + source +"','" + ledger +"','" + date +"','" + validdate +"','" + description +"')";
					stmt.executeUpdate(sql);
					System.out.println("query exec"+sql);
					con.close(); 
					System.out.println("notifiation insert success");
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				} 
		   }
			
	   }
	 
	 
	 public void notificationupdate(String source, String ledger, String date, String validdate, String description)
	   {
		  
		   System.out.println("inside notification insert table method");
		  
			   try
		       {
		       	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con1.createStatement();
					//String sql = "Insert into  notification (source,ledger,date, validdate , description) values ('" + source +"','" + ledger +"','" + date +"','" + validdate +"','" + description +"')";
					String sql ="update notification SET source = '"+(String) sourcecombo.getSelectedItem()+"', ledger = '"+(String)ledgercombo.getSelectedItem()+"', date = '"+datebox.getText()+"',validdate = '"+validdatebox.getText()+"', description = '"+descriptionbox.getText()+"' where ledger = '"+ledgersearch+"' and description= '"+descsearch+"'and date = '"+datesearch+"'and source = '"+sourcesearch+"'and validdate = '"+this.validdate+"'";
					stmt.executeUpdate(sql);
					System.out.println("query exec"+sql);
					con1.close(); 
					System.out.println("notifiation update success");
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				} 
		   
			
	   }
	 
	 public void notificationdelete(String source, String ledger, String date, String validdate, String description)
	   {
		  
		   System.out.println("inside notification insert table method"); 
		   
			   try
		       {
		       	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con1.createStatement();
					String sql ="delete from notification where validdate = '"+validdate+"' and ledger = '"+ledger+"' and description= '"+description+"'and date = '"+date+"'and source = '"+source+"'";
					stmt.execute(sql);
					System.out.println("query exec"+sql);
					con1.close(); 
					System.out.println("notifiation delete success");
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				} 
		   
			
	   }
	
}

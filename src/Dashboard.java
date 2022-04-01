import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextLayout.CaretPolicy;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class Dashboard extends JFrame {
	
	private JButton Addentry;
    private JButton dashboard;
    private JButton editentry;
    private JButton ledger;
    private JPanel leftpanel;
    private JLabel  leftlabel;
    private JPanel home;
    private JButton alert;
    private JButton reports;
    private JPanel rightpanel;
    private JLabel rightlabel;
    private javax.swing.JTable addledgersubtable;
    private JComboBox<String> ledgersourcecombo;
    private JComboBox<String> subledgercombo;
    private JLabel welcome;
    private JButton ext;
    private JButton dashrefresh;
    private JButton logout;
	private JPanel toppanel;
	private JLabel Ledger;
	private javax.swing.JScrollPane jScrollPane7;
	private JLabel source;
	private JComboBox<String> sourceselector;
	private JPanel Toppanel;
	private JTextField Header;
	private JSeparator Separatorup;
	private JSeparator Separatordown;
	private JPanel scrollpanel;
	private JPanel housepanel;
	private JLabel house;
	private JLabel tab1;
	private JPanel estatepanel ;
    private JLabel estate ;
    private JPanel financepanel ;
    private JLabel finance;
    private JPanel vehiclepanel ;
    private JLabel  vehicle;
    private JLabel userlabel;
    private JTextField Welcomeuser;
    private JPanel notification;
    private JTextField countshow;
    private JPanel Entrypanel;
    private JLabel ledgerlabel;
    private JLabel credit;
    private JTextField creditamt;
    private JComboBox<String> ledgercombo;
    private JLabel date;
    private JLabel acdate;
    private JFormattedTextField datebox;
    private JFormattedTextField accountdatebox;
    private JLabel desclabel;
    private JTextField descriptionbox;
    private JComboBox<String> sourcecombo;
    private JLabel debit;
    private JTextField debitamt;
    private JLabel validity;
    private JTextField validdatebox;
    private JTable searchtable;
    private JScrollPane jScrollPane1;
    private JPanel searchpanel;
    private JLabel searchlabel;
    private JTextField searchbox;
    private JButton viewbtn;
    private JButton submitbtn;
    private JButton updatebtn;
    private JButton deletebtn;
    private JButton addbtn;
    private JButton backbtn;
    private JPanel editpanel;
    private JPanel editsearchpanel;
    private JLabel editledger;
    private JComboBox<String> editledgercombo;
    private JComboBox<String> editsubledgercombo;
    private JLabel editfrom;
    private JLabel editto;
    private JLabel editsource1;
    private JComboBox<String> editsourcecombo;
    private JFormattedTextField editfromdate;
    private JFormattedTextField edittodate;
    private JButton editsubmit;
    private JTable editsearchtable;
    private JScrollPane jScrollPane2;
    private JPanel ledgerpanel;
    private JLabel ledgername;
    private JTextField addledgerbox;
    private JTextField addledgersubbox;
    private JTable addledgerviewtable;
    private JScrollPane jScrollPane3;
    private JButton ledgersubmitbtn;
    private JButton ledgerupdatebtn;
    private JButton ledgerdeletebtn;
    private JButton ledgeraddbtn;
    private JButton ledgerbackbtn;
    private JPanel reportspanel;
    private JPanel reportssearchpanel;
    private JLabel reportsledger;
	private JComboBox<String> reportscombo;
	private JComboBox<String> reportscombo1;
	private JComboBox<String>reportssourcecombo;
	private JLabel reportssource;
	private JLabel reportsfrom;
	private JLabel reportsto;
    private JFormattedTextField reportsfromdate;
    private JFormattedTextField reportstodate;
    private JButton reportsview;
    private JButton reportsprint;
    private JDialog reportdialog;
    private JTable reportstable ;
    private JScrollPane jScrollPane4 ;
    private JLabel entrychooselabel;
    private JButton entryuploadbtn;
    private JLabel piclabel;
    private JPanel alertscrollpanel;
    private JLabel scrolltext;
    private JTextField homebalance;
    private JTextField homebalance1;
    private JTextField homebalance2;
    private JTextField homebalance3;
    private JLabel homecredit;
    private JLabel homecredit1;
    private JLabel homecredit2;
    private JLabel homecredit3;
    private JLabel homedeb;
    private JLabel homedeb1;
    private JLabel homedeb2;
    private JLabel homedeb3;
    private JTextField homecredamt;
    private JTextField homecredamt1;
    private JTextField homecredamt2;
    private JTextField homecredamt3;
    private JTextField homedebamt;
    private JTextField homedebamt1;
    private JTextField homedebamt2;
    private JTextField homedebamt3;
    private DecimalFormat dc;
    private JFileChooser chooser;
    String s;
    String selectedname = null;
    private Mainframe m ;
    private DefaultTableModel model1;
    private DefaultTableModel modelledger;
    private DefaultTableModel modelledgersub;
    private DefaultTableModel modeledit;
    private SimpleDateFormat frmt1;
    private ArrayList <Data> phoneLists;
    private JPanel alertpanel;
    private JTable alerttable;
    private JScrollPane jScrollPane5;
    private DefaultTableModel model5;
    int notificationcount;
    private JLabel alertlabel;
    private JLabel ledgerlb;
    private JLabel reportslabel;
    private JLabel editlabel;
    private JLabel entrylabel;
    private JTable printtable;
    private DefaultTableModel modelprint;
    private JScrollPane jScrollPane6;
    private JLabel interestname;
    private JTextField interestbox;
    //editsearch
    
    String searchtext = "";
	String empty = "";
	String ledgerdata = "";
	String sourcedata = null;
	String subledger = "";
	String ef = null;
	String et = null;
	String from = null;
	String to = null;
	String mask = "##/##/####";
    
    public Dashboard()
	{
		super ("VR TECHNO CORP");
		
		Addentry = new JButton();
		dashboard = new JButton();
		editentry = new JButton();
		interestname = new javax.swing.JLabel();
        interestbox = new javax.swing.JTextField();
		ledger = new JButton();
		alert = new JButton();
		reports = new JButton();
		leftpanel = new JPanel();
		leftlabel = new JLabel();
		rightpanel = new JPanel();
		rightlabel = new JLabel();
		welcome = new JLabel();
		ext = new JButton();
		logout = new JButton();
		toppanel = new JPanel();
		Ledger = new JLabel();
		source = new JLabel();
		jScrollPane5 = new JScrollPane();
		sourceselector = new JComboBox();
		subledgercombo = new JComboBox<>();
		Header = new JTextField();
		home = new JPanel();
		Separatorup = new JSeparator();
		Separatordown = new JSeparator() ;
		scrollpanel = new JPanel();
		housepanel = new JPanel();
		house = new JLabel();
		tab1 = new JLabel();
		estatepanel = new JPanel();
        estate = new JLabel();
        financepanel = new JPanel();
        finance = new JLabel();
        vehiclepanel = new JPanel();
        vehicle = new JLabel();
        userlabel = new JLabel();
        Welcomeuser = new JTextField();
        notification = new JPanel();
        countshow = new JTextField();
        Entrypanel = new JPanel();
        ledgerlabel = new JLabel();
        addledgersubtable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        credit = new JLabel();
        creditamt = new JTextField();
        ledgercombo = new JComboBox<String>();
        date = new JLabel();
        acdate = new JLabel();
        datebox = new JFormattedTextField(createFormatter(mask));
        accountdatebox = new JFormattedTextField(createFormatter(mask));
        desclabel = new JLabel();
        descriptionbox = new JTextField();
        sourcecombo = new JComboBox<String>();
        debit = new JLabel();
        debitamt = new JTextField();
        validity = new JLabel();
        validdatebox = new JFormattedTextField(createFormatter(mask));
		searchtable = new JTable();
		jScrollPane1 = new JScrollPane();
		searchpanel = new JPanel();
        searchlabel = new JLabel();
        searchbox = new JTextField();
        viewbtn = new JButton();
        submitbtn = new JButton();
        updatebtn = new JButton();
        deletebtn = new JButton();
        addbtn = new JButton();
        backbtn = new JButton();
        editpanel = new JPanel();
        editsearchpanel = new JPanel();
        editledger = new JLabel();
        editledgercombo = new JComboBox<String>();
        editsubledgercombo = new JComboBox<String>();
        editfrom = new JLabel();
        editto = new JLabel();
        editsource1 = new JLabel();
        editsourcecombo = new JComboBox<String>();
        editfromdate = new JFormattedTextField(createFormatter(mask));
        edittodate = new JFormattedTextField(createFormatter(mask));
        editsubmit = new JButton();
        editsearchtable = new JTable();
        jScrollPane2 = new JScrollPane();
        ledgerpanel = new JPanel();
        ledgername = new JLabel();
        addledgerbox = new JTextField();
        addledgersubbox = new JTextField();
        addledgerviewtable = new JTable();
        jScrollPane3 = new JScrollPane();
        ledgersubmitbtn = new JButton();
        ledgerupdatebtn = new JButton();
        ledgerdeletebtn = new JButton();
        ledgeraddbtn = new JButton();
        ledgerbackbtn = new JButton();
        reportspanel = new JPanel();
        reportssearchpanel = new JPanel();
        alertpanel = new JPanel();
        alerttable = new JTable();
        reportsledger = new JLabel();
        reportscombo = new JComboBox<String>();
        reportscombo1 = new JComboBox<String>();
        reportssourcecombo = new JComboBox<String>();
        reportssource = new JLabel();
        reportsfrom = new JLabel();
        reportsto = new JLabel();
        reportsfromdate = new JFormattedTextField(createFormatter(mask));
        reportstodate = new JFormattedTextField(createFormatter(mask));
        reportsview = new JButton();
        reportsprint = new JButton();
        reportdialog = new JDialog();
        reportstable = new JTable();
        jScrollPane4 = new JScrollPane();
        entrychooselabel = new JLabel();
        entryuploadbtn = new JButton();
        piclabel = new JLabel();
        dashrefresh = new JButton();
        alertscrollpanel = new JPanel();
        scrolltext = new JLabel();
        homebalance = new JTextField();
        homebalance1 = new JTextField();
        homebalance2 = new JTextField();
        homebalance3 = new JTextField();
        homecredit = new JLabel();
        homecredit1 = new JLabel();
        homecredit2 = new JLabel();
        homecredit3 = new JLabel() ;
        homedeb = new JLabel() ;
        homedeb1 = new JLabel() ;
        homedeb2 = new JLabel() ;
        homedeb3 = new JLabel() ;
        homecredamt = new JTextField () ;
        homecredamt1 = new JTextField();
        homecredamt2 = new JTextField();
        homecredamt3 = new JTextField();
        homedebamt = new JTextField();
        homedebamt1 = new JTextField();
        homedebamt2 = new JTextField();
        homedebamt3 = new JTextField();
        alertlabel = new JLabel();
        ledgerlb = new JLabel();
        reportslabel = new JLabel();
        editlabel = new JLabel();
        entrylabel = new JLabel();
        printtable = new JTable();
        ledgersourcecombo = new javax.swing.JComboBox<>();
        jScrollPane6 = new JScrollPane();
        modelprint = new DefaultTableModel();
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
        	            
        	           /*public Class getColumnClass(int column) {
        	                if (column==8) 
        	                	{
        	                	return ImageIcon.class;
        	                	}
        	                else
        	                {
        	                	return getValueAt(0, column).getClass();
        	                }
        	                
        	            }*/
        	        };

        	       
        	        
        modelledger = new DefaultTableModel(
        		
	            new Object [][] {
	            },
	            new String [] {
	                
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        };	 
	        modelledgersub = new DefaultTableModel(
	        		
		            new Object [][] {
		            },
		            new String [] {
		                
		            }
		        ) {
		            boolean[] canEdit = new boolean [] {
		                false, false, false, false
		            };

		            public boolean isCellEditable(int rowIndex, int columnIndex) {
		                return canEdit [columnIndex];
		            }
		        };
	        modeledit = new DefaultTableModel(
	        		
		            new Object [][] {
		            },
		            new String [] {
		                
		            }
		        ) {
		            boolean[] canEdit = new boolean [] {
		                false, false, false, false,false,false, false, false,false
		            };

		            public boolean isCellEditable(int rowIndex, int columnIndex) {
		                return canEdit [columnIndex];
		            }
		        };	        
        dc = new DecimalFormat("0.00");

        reportdialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        reportdialog.setPreferredSize(new Dimension(900,700));
        reportstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reportstable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(reportstable);

        javax.swing.GroupLayout reportdialogLayout = new javax.swing.GroupLayout(reportdialog.getContentPane());
        reportdialog.getContentPane().setLayout(reportdialogLayout);
        reportdialogLayout.setHorizontalGroup(
            reportdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportdialogLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        reportdialogLayout.setVerticalGroup(
            reportdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportdialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        setVisible(true);
		ImageIcon img = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
		this.setIconImage(img.getImage());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        rightpanel.setBackground(new java.awt.Color(16, 60, 16));
        rightpanel.setForeground(new java.awt.Color(17, 68, 30));
        rightpanel.setLayout(new java.awt.CardLayout());

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        housepanel.setBackground(new java.awt.Color(153, 153, 255));
        housepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        housepanel.add(tab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 11, 210, 67));

        house.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        house.setForeground(new java.awt.Color(255, 255, 255));
        house.setText("        HOUSE");
        housepanel.add(house, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 59));

        homebalance.setEditable(false);
        homebalance.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        homebalance.setForeground(new java.awt.Color(255, 255, 255));
        homebalance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        //homebalance.setText("42435673.00");
        homebalance.setBorder(null);
        homebalance.setOpaque(false);
        housepanel.add(homebalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 22, 188, 37));

        homecredit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        homecredit.setForeground(new java.awt.Color(0, 0, 153));
        homecredit.setText("Cr :");
        housepanel.add(homecredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, -1, -1));

        homecredamt.setEditable(false);
        homecredamt.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        //homecredamt.setText("458623562.00");
        homecredamt.setBorder(null);
        homecredamt.setOpaque(false);
        housepanel.add(homecredamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 76, 126, -1));

        homedeb.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        homedeb.setForeground(new java.awt.Color(0, 0, 153));
        homedeb.setText("Dr :");
        housepanel.add(homedeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 76, -1, -1));

        homedebamt.setEditable(false);
        homedebamt.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        //homedebamt.setText("458623562.00");
        homedebamt.setBorder(null);
        homedebamt.setOpaque(false);
        housepanel.add(homedebamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 76, 126, -1));

        home.add(housepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 107, 383, -1));

        estatepanel.setBackground(new java.awt.Color(255, 153, 153));
        estatepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        estate.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        estate.setForeground(new java.awt.Color(255, 255, 255));
        estate.setText("ESTATE");
        estatepanel.add(estate, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 11, -1, 50));

        homebalance2.setEditable(false);
        homebalance2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        homebalance2.setForeground(new java.awt.Color(255, 255, 255));
        homebalance2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        //homebalance2.setText("42435673.00");
        homebalance2.setBorder(null);
        homebalance2.setOpaque(false);
        estatepanel.add(homebalance2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 18, 188, 37));

        homecredit2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        homecredit2.setForeground(new java.awt.Color(255, 102, 102));
        homecredit2.setText("Cr :");
        estatepanel.add(homecredit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        homecredamt2.setEditable(false);
        homecredamt2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        //homecredamt2.setText("458623562.00");
        homecredamt2.setBorder(null);
        homecredamt2.setOpaque(false);
        estatepanel.add(homecredamt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 126, -1));

        homedeb2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        homedeb2.setForeground(new java.awt.Color(255, 102, 102));
        homedeb2.setText("Dr :");
        estatepanel.add(homedeb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        homedebamt2.setEditable(false);
        homedebamt2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        //homedebamt2.setText("458623562.00");
        homedebamt2.setBorder(null);
        homedebamt2.setOpaque(false);
        estatepanel.add(homedebamt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 126, -1));

        home.add(estatepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 328, 383, -1));

        financepanel.setBackground(new java.awt.Color(153, 255, 102));
        financepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        finance.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        finance.setForeground(new java.awt.Color(255, 255, 255));
        finance.setText("FINANCE");
        financepanel.add(finance, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 11, 113, 59));

        homebalance1.setEditable(false);
        homebalance1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        homebalance1.setForeground(new java.awt.Color(255, 255, 255));
        homebalance1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
       // homebalance1.setText("42435673.00");
        homebalance1.setBorder(null);
        homebalance1.setOpaque(false);
        financepanel.add(homebalance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 22, 188, 37));

        homecredit1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        homecredit1.setForeground(new java.awt.Color(0, 153, 0));
        homecredit1.setText("Cr :");
        financepanel.add(homecredit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, -1, -1));

        homecredamt1.setEditable(false);
        homecredamt1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        //homecredamt1.setText("458623562.00");
        homecredamt1.setBorder(null);
        homecredamt1.setOpaque(false);
        financepanel.add(homecredamt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 76, 126, -1));

        homedeb1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        homedeb1.setForeground(new java.awt.Color(0, 153, 0));
        homedeb1.setText("Dr :");
        financepanel.add(homedeb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 76, -1, -1));

        homedebamt1.setEditable(false);
        homedebamt1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
       // homedebamt1.setText("458623562.00");
        homedebamt1.setBorder(null);
        homedebamt1.setOpaque(false);
        financepanel.add(homedebamt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 76, 126, -1));

        home.add(financepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 107, -1, -1));

        vehiclepanel.setBackground(new java.awt.Color(255, 102, 102));
        vehiclepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vehicle.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        vehicle.setForeground(new java.awt.Color(255, 255, 255));
        vehicle.setText("VEHICLE");
        vehiclepanel.add(vehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 11, -1, 49));

        homebalance3.setEditable(false);
        homebalance3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        homebalance3.setForeground(new java.awt.Color(255, 255, 255));
        homebalance3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        //homebalance3.setText("42435673.00");
        homebalance3.setBorder(null);
        homebalance3.setOpaque(false);
        vehiclepanel.add(homebalance3, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 17, 188, 37));

        homecredit3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        homecredit3.setForeground(new java.awt.Color(255, 204, 204));
        homecredit3.setText("Cr :");
        vehiclepanel.add(homecredit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        homecredamt3.setEditable(false);
        homecredamt3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
       // homecredamt3.setText("458623562.00");
        homecredamt3.setBorder(null);
        homecredamt3.setOpaque(false);
        vehiclepanel.add(homecredamt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 126, 20));

        homedeb3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        homedeb3.setForeground(new java.awt.Color(255, 204, 204));
        homedeb3.setText("Dr :");
        vehiclepanel.add(homedeb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, 20));

        homedebamt3.setEditable(false);
        homedebamt3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
       // homedebamt3.setText(" 458623562.00");
        homedebamt3.setBorder(null);
        homedebamt3.setOpaque(false);
       
        vehiclepanel.add(homedebamt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 126, 20));
        home.add(vehiclepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 328, 364, 110));
        alertscrollpanel.setBackground(new java.awt.Color(255, 255, 255));
        alertscrollpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        alertscrollpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrolltext.setBackground(new java.awt.Color(255, 255, 255));
        scrolltext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scrolltext.setFont(new java.awt.Font("Calibri", 1, 24));
        //scrolltext.setText("VIVEK WELCOMES YOU !!!!!!!!!!!!!!!!!");
        alertscrollpanel.add(scrolltext, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1090, 80));

        //home.add(alertscrollpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 492, -1, -1));

        rightlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/rightlabel.png"))); // NOI18N
        home.add(rightlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 630));
        
        rightpanel.add(home, "card2");
        
        
        double debamt = 0;
		double  credamt = 0;
		double rem = 0;
		try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String sql = "Select SUM(debitamount) AS amt, SUM(creditamount) AS amt1, source from accounts where source IN ('house','vehicle','estate', 'finance') group by source"; 
			ResultSet Rs = stmt.executeQuery(sql);
			System.out.println("query exec"+sql);
			
			while (Rs.next()) {
				
				debamt = Rs.getDouble("amt");
				credamt = Rs.getDouble("amt1");
			    rem = (credamt - debamt);
                String source = Rs.getString("source");
				
				if ( source .equals("House"))
				{
				homecredamt.setText(dc.format(credamt));
				homedebamt.setText(dc.format(debamt));
				
				homebalance.setText(dc.format(rem));
			    
				}
				else if (source .equals("Estate"))
				{
					homecredamt2.setText(dc.format(credamt));
					homedebamt2.setText(dc.format(debamt));

					homebalance2.setText(dc.format(rem));
					
				}
				else if (source .equals("Finance"))
				{
					homecredamt1.setText(dc.format(credamt));
					homedebamt1.setText(dc.format(debamt));

					homebalance1.setText(dc.format(rem));
				}
				else if (source .equals( "Vehicle"))
				{
					homecredamt3.setText(dc.format(credamt));
					homedebamt3.setText(dc.format(debamt));

					homebalance3.setText(dc.format(rem));
				}
				else
				{
					System.out.println("no data found");
				}
			} 
			con.close();
		       
		              
		}
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
		
		notificationcount();
        //ADD ENTRY START
        
        Date d = new Date();
        SimpleDateFormat frmt = new SimpleDateFormat("dd/MM/yyyy");
        frmt1 = new SimpleDateFormat("dd/MM/yyyy");
        Entrypanel.setBackground(new java.awt.Color(255, 255, 255));
        Entrypanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        Entrypanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ledgerlabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgerlabel.setText("LEDGER    ");
        Entrypanel.add(ledgerlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 120, 40));

        credit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        credit.setText("CREDIT");
        Entrypanel.add(credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 135, 100, 30));

        creditamt.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        creditamt.setForeground(new java.awt.Color(255, 51, 51));
        creditamt.setText("0.00");

        Entrypanel.add(creditamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 130, 150, 39));
        
        String formattedText = dc.format(Double.parseDouble(creditamt.getText()));
        creditamt.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				
			}

			public void focusGained(FocusEvent e) {
				creditamt.selectAll();
			}
		});
        
        creditamt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitamt.requestFocusInWindow();
			}
		});
        ledgercombo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ledgercombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        ledgercombo.insertItemAt("", 0);
        Entrypanel.add(ledgercombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 360, 30));
        ledgercombo.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				ledgercombo.setBackground(new java.awt.Color(255, 255, 255));
			}
			
			public void focusGained(final FocusEvent e) {
				
				ledgercombo.setBackground(new java.awt.Color(255, 204, 204));
				//ledgercombo.showPopup();
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select ledgername from ledger where source = '"+sourcecombo.getSelectedItem()+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec");
					ledgercombo.removeAllItems();
					ledgercombo.insertItemAt("", 0);
					ledgercombo.setSelectedIndex(0);
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
        ledgercombo.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	subledgercombo.requestFocusInWindow();
                	subledgercombo.showPopup();
                	
			}}
		});
        
        date.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("PAID DATE ");
        Entrypanel.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 238, -1, 50));
        
        acdate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        acdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acdate.setText("A/C DATE");
        Entrypanel.add(acdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 110, 50));
        
        interestname.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        interestname.setText("INT PAID  ");
        Entrypanel.add(interestname, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 90, 20));

        interestbox.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        interestbox.setForeground(new java.awt.Color(255, 51, 51));
        interestbox.setText("0.00");
        Entrypanel.add(interestbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 150, 39));
        
        
        String formattedinterest = dc.format(Double.parseDouble(interestbox.getText()));
        interestbox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				
			}

			public void focusGained(FocusEvent e) {
				interestbox.selectAll();
			}
		});
        
        interestbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountdatebox.requestFocusInWindow();
			}
		});

        datebox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		datebox.setText(frmt1.format(d));
        datebox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        
        Entrypanel.add(datebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 244, 130, 40));
        
        datebox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
}

			public void focusGained(FocusEvent e) {
				datebox.selectAll();
			}
		});
        
        datebox.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	validdatebox.requestFocusInWindow();
			}}
		});

        
        accountdatebox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        accountdatebox.setText(frmt1.format(d));
        accountdatebox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Entrypanel.add(accountdatebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 244, 140, 40));
        
        
        accountdatebox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
}

			public void focusGained(FocusEvent e) {
				accountdatebox.selectAll();
			}
		});
        
        accountdatebox.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	datebox.requestFocusInWindow();
			}}
		});

        desclabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        desclabel.setText("  DESCRIPTION");
        Entrypanel.add(desclabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 355, 130, 30));

        descriptionbox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        descriptionbox.setText("Enter your description for the expenses here.");
        descriptionbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Entrypanel.add(descriptionbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 355, 361, 30));

        descriptionbox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				
			}

			public void focusGained(FocusEvent e) {
				descriptionbox.selectAll();
			}
		});
        
        descriptionbox.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	entryuploadbtn.requestFocusInWindow();
                	
			}}
		});
        source.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        source.setText("SOURCE");
        Entrypanel.add(source, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 12, 120, 40));

        sourcecombo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        sourcecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "House", "Estate", "Finance", "Vehicle" }));
        sourcecombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        sourcecombo.insertItemAt("", 0);
        Entrypanel.add(sourcecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 12, 180, -1));

        sourcecombo.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				sourcecombo.setBackground(new java.awt.Color(255, 255, 255));
			}
			
			public void focusGained(final FocusEvent e) {
				
				sourcecombo.setBackground(new java.awt.Color(255, 204, 204));
			}
		});

        sourcecombo.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
				ledgercombo.requestFocusInWindow();
				ledgercombo.showPopup();
			}}
		});
        
        debit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        debit.setText("DEBIT");
        Entrypanel.add(debit, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 193, 100, 30));

        debitamt.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        debitamt.setForeground(new java.awt.Color(255, 51, 51));
        debitamt.setText("0.00");
      
        Entrypanel.add(debitamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 188, 150, 39));
        
        debitamt.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				
			}
			
			public void focusGained(final FocusEvent e) {
				
				debitamt.selectAll();
			}
		});
        debitamt.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	interestbox.requestFocusInWindow();
			}}
		});

        validity.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        validity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        validity.setText("     VALID DATE");
        Entrypanel.add(validity, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 294, 110, 50));

        validdatebox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        validdatebox.setText("00/00/0000");
        validdatebox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
       
        Entrypanel.add(validdatebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 300, 150, 40));
        validdatebox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				
			}

			public void focusGained(FocusEvent e) {
				validdatebox.selectAll();
			}
		});
        validdatebox.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	descriptionbox.requestFocusInWindow();
			}}
		});

        searchtable.setRowHeight(100);
        searchtable.setModel(model1);
        model1.addColumn("Entry ID");
        model1.addColumn("Source");
        model1.addColumn("Ledger");
        model1.addColumn("Sub ledger");
        model1.addColumn("Paid Date");
        model1.addColumn("A/C Date");
        model1.addColumn("Valid Date");
        model1.addColumn("Description");
        model1.addColumn("Debit");
        model1.addColumn("Credit");
        model1.addColumn("Interest paid");
        model1.addColumn("Bill");
        searchtable.getTableHeader().setFont(new Font("Calibri", 1, 14));
        searchtable.setFont(new Font("Calibri", 1, 14));
        searchtable.getTableHeader().setOpaque(false);
        searchtable.getTableHeader().setBackground(new Color(32,136,203));
        searchtable.getTableHeader().setForeground(new Color(255,255,255));
        searchtable.getColumnModel().getColumn(0).setPreferredWidth(1);
        searchtable.getColumnModel().getColumn(1).setPreferredWidth(50);
        searchtable.getColumnModel().getColumn(2).setPreferredWidth(100);
        searchtable.getColumnModel().getColumn(3).setPreferredWidth(100);
        searchtable.getColumnModel().getColumn(4).setPreferredWidth(30);
        searchtable.getColumnModel().getColumn(5).setPreferredWidth(30);
        searchtable.getColumnModel().getColumn(6).setPreferredWidth(30);
        searchtable.getColumnModel().getColumn(7).setPreferredWidth(150);
        searchtable.getColumnModel().getColumn(8).setPreferredWidth(30);
        searchtable.getColumnModel().getColumn(9).setPreferredWidth(30);
        searchtable.getColumnModel().getColumn(10).setPreferredWidth(50);
        searchtable.getColumnModel().getColumn(11).setPreferredWidth(5);
        
        jScrollPane1.setViewportView(searchtable);
        
        searchtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	if (evt.getClickCount() == 2) {
            		
            	try {
            		
            		int rowcount = searchtable.getSelectedRow();
    				String cell = searchtable.getModel().getValueAt(rowcount, 0).toString();
    				
            		int index = searchtable.getSelectedRow();
            		String id = model1.getValueAt(index, 0).toString();
            		String sourcedisp = model1.getValueAt(index, 1).toString();
            		String ledgerdisp = model1.getValueAt(index, 2).toString();
            		String subledgerdisp = model1.getValueAt(index, 3).toString();
            		String creditdisp = model1.getValueAt(index, 9).toString();
            		String debitdisp = model1.getValueAt(index, 8).toString();
            		String interestdisp = model1.getValueAt(index, 10).toString();
            		String paiddate = "00/00/0000";
            		try
            		{
            			paiddate = model1.getValueAt(index, 4 ).toString();
            		}
            		catch (Exception e)
            		{
            			System.out.println("exception"+e);
            		}
            		
            		String datedisp = model1.getValueAt(index, 5).toString();
            		String validdatedisp = model1.getValueAt(index, 6).toString();
            		String descdisp = model1.getValueAt(index, 7).toString();
            		//ImageIcon img = (ImageIcon) model1.getValueAt(index, 8);
            	
            		new Showdata().setDatacpy(cell ,sourcedisp, ledgerdisp, creditdisp, debitdisp, datedisp, validdatedisp, descdisp, searchtable, paiddate, interestdisp,subledgerdisp);
				} catch (SQLException e) {
					e.printStackTrace();
				}};
            	
            }});
        
        Entrypanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 490, 1034, 108));

        searchpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        searchpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchlabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        searchlabel.setText("SEARCH");
        searchpanel.add(searchlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 1, 140, 36));

        searchbox.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        searchbox.setText(" ");
        searchpanel.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 8, 325, -1));

        searchbox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				
			}

			public void focusGained(FocusEvent e) {
				searchbox.selectAll();
			}
		});
        searchbox.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {  
                	viewbtn.requestFocusInWindow();
			}}
		});
        
        viewbtn.setBackground(new java.awt.Color(255, 255, 255));
        viewbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        viewbtn.setText("View");
        searchpanel.add(viewbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 3, 119, -1));

        Entrypanel.add(searchpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 446, -1, -1));
        viewbtn.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				viewbtn.setBackground(new java.awt.Color(242,241,239));
			}
			
			public void focusGained(final FocusEvent e) {
				
				viewbtn.setBackground(new java.awt.Color(255, 204, 204));
			}
		});
        viewbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
              
				String searchtext = searchbox.getText(); 
				System.out.println("searchtext is " +searchtext);
				try
	               {
	               	Class.forName("com.mysql.jdbc.Driver");
	       			System.out.println("before connection");
	       			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
	       			System.out.println("conneted sql");
	       			Statement stmt = con.createStatement();
	       			String wheredate = frmt1.format(d);
	       			String sql = null;
	       			System.out.println("searchtext is" +searchtext);
	       			sql = "Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where ledger like '%"+searchtext+"%' or description like '%"+searchtext+"%' or source like '%"+searchtext+"%' or date like '%"+searchtext+"%' or subledger like '%"+searchtext+"%' order by id DESC";
	       			ResultSet Rs = stmt.executeQuery(sql);
	       			System.out.println("query exec"+sql);
	       			model1.setRowCount(0);
	       			Object[]fila = new Object[4];
	       			while (Rs.next()) {
	       				String debitformat = dc.format(Rs.getDouble(4));
	       				String creditformat = dc.format(Rs.getDouble(6));
	       				String interestformat = dc.format(Rs.getDouble(11));
	       				//System.out.println("query exec 22222222222222");
	       	        // System.out.println("query exec 444444");
	       	      //fila [1] = new ImageIcon(new ImageIcon(Rs.getBytes("pic")).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
	       	       //  System.out.println("query exec 66666666"+fila [1] );
	       				model1.addRow(new Object[] {Rs.getInt(1),Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,interestformat, Rs.getBytes("pic")} ); 
	       			} 
	       			con.close();
	       		}
	       		catch (Exception e1)
	       		{
	       			System.out.println("sql exception" +e1);
	       		}
				}
			
		});
        
        viewbtn.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {  
                	String searchtext = searchbox.getText(); 
    				System.out.println("searchtext is " +searchtext);
    				try
    	               {
    	               	Class.forName("com.mysql.jdbc.Driver");
    	       			System.out.println("before connection");
    	       			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
    	       			System.out.println("conneted sql");
    	       			Statement stmt = con.createStatement();
    	       			String wheredate = frmt1.format(d);
    	       			String sql = null;
    	       			System.out.println("searchtext is" +searchtext);
    	       			sql = "Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where ledger like '%"+searchtext+"%' or description like '%"+searchtext+"%' or source like '%"+searchtext+"%' or date like '%"+searchtext+"%' or subledger like '%"+searchtext+"%' order by id DESC";
    	       			ResultSet Rs = stmt.executeQuery(sql);
    	       			System.out.println("query exec"+sql);
    	       			model1.setRowCount(0);
    	       			Object[]fila = new Object[4];
    	       			while (Rs.next()) {
    	       				String debitformat = dc.format(Rs.getDouble(4));
    	       				String creditformat = dc.format(Rs.getDouble(6)); 
    	       				String interestformat = dc.format(Rs.getDouble(11));
    	       				//System.out.println("query exec 22222222222222");
    	       	        // System.out.println("query exec 444444");
    	       	      //fila [1] = new ImageIcon(new ImageIcon(Rs.getBytes("pic")).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
    	       	         //System.out.println("query exec 66666666"+fila [1] );
    	       				model1.addRow(new Object[] {Rs.getInt(1),Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat, interestformat, Rs.getBytes("pic")} ); 
    	       			} 
    	       			con.close();
    	       		}
    	       		catch (Exception e1)
    	       		{
    	       			System.out.println("sql exception" +e1);
    	       		}
			}}
		});
        
        submitbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        submitbtn.setText("Submit");
        Entrypanel.add(submitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(957, 120, 103, 36));

        submitbtn.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {  
                	Double creditamount = Double.parseDouble(creditamt.getText());
                	Double debitamount = Double.parseDouble(debitamt.getText());
                	Double intpaid = Double.parseDouble(interestbox.getText());
                	String ledger = (String) ledgercombo.getSelectedItem();
                	String source = (String) sourcecombo.getSelectedItem();
                	String date = datebox.getText();
                	String paiddate = accountdatebox.getText();
                	String validdate = validdatebox.getText();
                	String description = descriptionbox.getText();
                	String subledger = (String)subledgercombo.getSelectedItem();
                    FileInputStream input = null;
                	if(s != null)
                	{
                	try {
    					 input = new FileInputStream(new File (s));
    				} catch (FileNotFoundException e1) {
    					e1.printStackTrace();
    				}}
                	else
                	{
                		System.out.println("no picture selected");
                	}
                    //System.out.println(creditamount +"   "+debitamount+"   "+ledger+"   "+source+"   "+date+"   "+validdate+"   "+description+"   "+input);
                	
    			//new Db().insertTable(ledger, description, debitamount,date,creditamount, source,validdate, input);
    			
    			//insert db
                    
                    if (source .equals("Select Source") )
                    {
                    	JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY");
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
            			String sql = null;
            			if(input != null)
            			{
            			sql = "Insert into  accounts (ledger,description,debitamount,date,creditamount,source,validdate,pic,paiddate,interestpaid,subledger) values ('" + ledger +"','" + description +"','" + debitamount +"','" + date +"','" + creditamount +"','"+source+"','"+validdate+"','"+input+"','"+paiddate+"','"+intpaid+"','"+subledger+"')";
            			System.out.println("inside if submit");
            			}
            			else
            			{
            				sql = "Insert into  accounts (ledger,description,debitamount,date,creditamount,source,validdate,pic,paiddate,interestpaid,subledger) values ('" + ledger +"','" + description +"','" + debitamount +"','" + date +"','" + creditamount +"','"+source+"','"+validdate+"','"+null+"','"+paiddate+"','"+intpaid+"','"+subledger+"')";
            			System.out.println("inside else submit");
            			}
            			int count = stmt.executeUpdate(sql);
            			if (count > 0)
            			{
            				JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY :)");
            			}
            			System.out.println("query exec");
            			con.close();   
            			notificationinsert(source, ledger, date, validdate, description);
            			notificationcount();
            			countshow.setText(Integer.toString(notificationcount));
            		}
                   
            		catch (Exception e1)
            		{
            			System.out.println("sql exception" +e1);
            		}
                    
    			
                    
    			}
                    phoneLists = new ArrayList <Data>();
                	Data data;
                   try
                   {
                   	Class.forName("com.mysql.jdbc.Driver");
           			System.out.println("before connection");
           			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
           			System.out.println("conneted sql");
           			Statement stmt = con.createStatement();
           			String wheredate = frmt1.format(d);
           			String sql = "Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts order by id desc";
           			ResultSet Rs = stmt.executeQuery(sql);
           			System.out.println("query exec"+sql);
           			//model1.setRowCount(0);
           			while (Rs.next()) {
           				
           				data = new Data(Rs.getInt(1), Rs.getString(8), Rs.getString(2), Rs.getString(5),Rs.getString(10), Rs.getString(7), Rs.getDouble(4), Rs.getDouble(6), Rs.getString(3), Rs.getBytes(9), Rs.getDouble(11), Rs.getString(12));
                        phoneLists.add(data);
           				//System.out.println("phonelists output is "+a);
           				//String debitformat = dc.format(Rs.getDouble(4));
           				//String creditformat = dc.format(Rs.getDouble(6));
           				//System.out.println("inside try in current date"+data.getId()+"  "+data.getLedger()+"  "+data.getSource()+"  "+data.getDate()+"  "+data.getValiddate()+"  "+data.getCredit()+"   "+data.getDebit()+"   "+data.getDescription()+"   "+data.getImage());
           				//model1.addRow(new Object[] {Rs.getInt(1),Rs.getString(8),Rs.getString(2),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,Rs.getBytes(9)} ); 
           				
           			} 
           			System.out.println("after execution of before populate");
           			con.close();
           			populateTable();
           		}
           		catch (Exception e1)
           		{
           			System.out.println("sql exception" +e1);
           		}
                    
    			
			}}
		});
        
        submitbtn.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				//submitbtn.setBackground(new java.awt.Color(242,241,239));
				submitbtn.setBackground(UIManager.getColor("Button.background"));
			}
			
			public void focusGained(final FocusEvent e) {
				
				submitbtn.setBackground(new java.awt.Color(255, 204, 204));
			}
		});
        
        submitbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Double creditamount = Double.parseDouble(creditamt.getText());
            	Double debitamount = Double.parseDouble(debitamt.getText());
            	Double intpaid = Double.parseDouble(interestbox.getText());
            	String ledger = (String) ledgercombo.getSelectedItem();
            	String source = (String) sourcecombo.getSelectedItem();
            	String date = datebox.getText();
            	String paiddate = accountdatebox.getText();
            	String validdate = validdatebox.getText();
            	String description = descriptionbox.getText();
            	String subledger = (String)subledgercombo.getSelectedItem();
                FileInputStream input = null;
            	if(s != null)
            	{
            	try {
					 input = new FileInputStream(new File (s));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}}
            	else
            	{
            		System.out.println("no picture selected");
            	}
                System.out.println(creditamount +"   "+debitamount+"   "+ledger+"   "+source+"   "+date+"   "+validdate+"   "+description+"   "+input);
            	
			//new Db().insertTable(ledger, description, debitamount,date,creditamount, source,validdate, input);
			
			//insert db
                
                if (source .equals("Select Source"))
                {
                	JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY");            
                }
                else
                {
                	if(isDateValid(date) && isDateValid1(validdate))
                	{
               try
                {
                	Class.forName("com.mysql.jdbc.Driver");
        			System.out.println("before connection");
        			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
        			System.out.println("conneted sql");
        			Statement stmt = con.createStatement();
        			String sql = null;
        			if(input != null)
        			{
        			sql = "Insert into  accounts (ledger,description,debitamount,date,creditamount,source,validdate,pic,paiddate,interestpaid,subledger) values ('" + ledger +"','" + description +"','" + debitamount +"','" + date +"','" + creditamount +"','"+source+"','"+validdate+"','"+input+"','"+paiddate+"','"+intpaid+"','"+subledger+"')";
        			System.out.println("inside if submit");
        			}
        			else
        			{
        				sql = "Insert into  accounts (ledger,description,debitamount,date,creditamount,source,validdate,pic,paiddate,interestpaid, subledger) values ('" + ledger +"','" + description +"','" + debitamount +"','" + date +"','" + creditamount +"','"+source+"','"+validdate+"','"+null+"','"+paiddate+"','"+intpaid+"','"+subledger+"')";
        			System.out.println("inside else submit");
        			}
        			int count = stmt.executeUpdate(sql);
        			if (count > 0)
        			{
        				JOptionPane.showMessageDialog(null, "DATA INSERTED SUCCESSFULLY :)");
        			}
        			System.out.println("query exec");
        			con.close();   
        			notificationinsert(source, ledger, date, validdate, description);
        			notificationcount();
        			countshow.setText(Integer.toString(notificationcount));
        		}
               
        		catch (Exception e1)
        		{
        			System.out.println("sql exception" +e1);
        		}
                
			}else
            {
            	JOptionPane.showMessageDialog(null, "DATE FORMAT IS NOT VALID (dd/MM/yyyy)");
            }
                }
			
                
                phoneLists = new ArrayList <Data>();
            	Data data;
               try
               {
               	Class.forName("com.mysql.jdbc.Driver");
       			System.out.println("before connection");
       			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
       			System.out.println("conneted sql");
       			Statement stmt = con.createStatement();
       			String wheredate = frmt1.format(d);
       			String sql = "Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts order by id desc";
       			ResultSet Rs = stmt.executeQuery(sql);
       			System.out.println("query exec"+sql);
       			//model1.setRowCount(0);
       			while (Rs.next()) {
       				
       				data = new Data(Rs.getInt(1), Rs.getString(8), Rs.getString(2), Rs.getString(5),Rs.getString(10), Rs.getString(7), Rs.getDouble(4), Rs.getDouble(6), Rs.getString(3), Rs.getBytes(9), Rs.getDouble(11),Rs.getString(12));
                    phoneLists.add(data);
       				//System.out.println("phonelists output is "+a);
       				//String debitformat = dc.format(Rs.getDouble(4));
       				//String creditformat = dc.format(Rs.getDouble(6));
       				//System.out.println("inside try in current date"+data.getId()+"  "+data.getLedger()+"  "+data.getSource()+"  "+data.getDate()+"  "+data.getValiddate()+"  "+data.getCredit()+"   "+data.getDebit()+"   "+data.getDescription()+"   "+data.getImage());
       				//model1.addRow(new Object[] {Rs.getInt(1),Rs.getString(8),Rs.getString(2),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,Rs.getBytes(9)} ); 
       				
       			} 
       			System.out.println("after execution of before populate");
       			con.close();
       			populateTable();
       		}
       		catch (Exception e1)
       		{
       			System.out.println("sql exception" +e1);
       		}
                
			}
		});
        updatebtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        updatebtn.setText("update");
        //Entrypanel.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(957, 162, 103, 30));

        deletebtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        deletebtn.setText("Delete");
        //Entrypanel.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(957, 198, 103, -1));

        addbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        addbtn.setText("Add new");
        Entrypanel.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(957, 235, 103, -1));
        
        addbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sourcecombo.requestFocusInWindow();
				sourcecombo.setSelectedIndex(0);
				ledgercombo.setSelectedIndex(0);
                creditamt.setText("0.00");
                debitamt.setText("0.00");
                datebox.setText(frmt1.format(d));
                accountdatebox.setText(frmt1.format(d));
                validdatebox.setText("00/00/0000");
                interestbox.setText("0.00");
                descriptionbox.setText("Enter the description");
				model1.setRowCount(0);
			}
		});

        backbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        backbtn.setText("Back");
        Entrypanel.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(957, 272, 103, 32));

        backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	home.setVisible(true);
                Entrypanel.setVisible(false);
                editpanel.setVisible(false);
                ledgerpanel.setVisible(false);
                Header.setText("HOME");
                reportspanel.setVisible(false);
                }});
        entrychooselabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        entrychooselabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entrychooselabel.setText("                 Choose pic");
        Entrypanel.add(entrychooselabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 396, 151, 32));

        entryuploadbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        entryuploadbtn.setText("Upload");
        Entrypanel.add(entryuploadbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 396, 150, 32));
        
        entryuploadbtn.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	submitbtn.requestFocusInWindow();
			}}
		});
        
        entryuploadbtn.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				//entryuploadbtn.setBackground(new java.awt.Color(242,241,239));
				entryuploadbtn.setBackground(UIManager.getColor("Button.background"));
				
			}
			
			public void focusGained(final FocusEvent e) {
				
				entryuploadbtn.setBackground(new java.awt.Color(255, 204, 204));
			}
		});
 
        entryuploadbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                chooser = new JFileChooser("E:\\BACKUPS\\Photo");
                String imagefilename = null;
                String filename = null;
                File f = null;
               int imagechooser = chooser.showOpenDialog(null);
               if (imagechooser == JFileChooser.APPROVE_OPTION)
               {
				 f = chooser.getSelectedFile();
				imagefilename = f.getName();
				 filename = f.getAbsolutePath();
               }
				
				ImageIcon imgicon = new ImageIcon(filename);
				Image dimg = imgicon.getImage().getScaledInstance(piclabel.getWidth(), piclabel.getHeight(),
				        Image.SCALE_SMOOTH);
				
				piclabel.setIcon(new ImageIcon(dimg));
				entrychooselabel.setForeground(new Color(255 , 102 , 102));
				entrychooselabel.setText("   "+imagefilename);
				s = filename;
			}
		});

        subledgercombo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        subledgercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        subledgercombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        subledgercombo.insertItemAt("", 0);
        subledgercombo.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				subledgercombo.setBackground(new java.awt.Color(255, 255, 255));
			}
			
			public void focusGained(final FocusEvent e) {
				
				subledgercombo.setBackground(new java.awt.Color(255, 204, 204));
				subledgercombo.showPopup();
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select subledgername from subledger where ledgername = '"+ledgercombo.getSelectedItem()+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec"+sql);
					subledgercombo.removeAllItems();
					 subledgercombo.insertItemAt("", 0);
					 subledgercombo.setSelectedIndex(0);
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
        subledgercombo.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	creditamt.requestFocusInWindow();
			}}
		});
        Entrypanel.add(subledgercombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 360, 30));
        
        piclabel.setBackground(new java.awt.Color(102, 102, 102));
        piclabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        piclabel.setMaximumSize(new java.awt.Dimension(208, 212));
        piclabel.setMinimumSize(new java.awt.Dimension(208, 212));
        piclabel.setText("                                     NO IMAGE");
        Entrypanel.add(piclabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 33, 277, 386));

        entrylabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/alertlabel (2).jpg"))); // NOI18N
        Entrypanel.add(entrylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 1360, 630));
        
       

        rightpanel.add(Entrypanel, "card3");
        
      //ADD ENTRY END
        
      //EDIT ENTRY START
        
        editpanel.setBackground(new java.awt.Color(255, 255, 255));
        editpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editsearchpanel.setBackground(new java.awt.Color(0, 102, 102));
        editsearchpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        editsearchpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editledger.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        editledger.setForeground(new Color (255 , 255, 255));
        editledger.setText("Ledger");
        editsearchpanel.add(editledger, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 124, 26));

        editledgercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        editsearchpanel.add(editledgercombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 284, 20));
        editledgercombo.setFont(new java.awt.Font("Calibri", 1, 18));
        editledgercombo.insertItemAt("", 0);
        
        editledgercombo.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
		
			}
			
			public void focusGained(final FocusEvent e) {
				
				editledgercombo.setBackground(new java.awt.Color(255, 204, 204));
				
				//String ledger = (String) editledgercombo.getSelectedItem();
				String source = (String) editsourcecombo.getSelectedItem();
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select ledgername from ledger where source ='"+source+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec");
					editledgercombo.removeAllItems();
					editledgercombo.insertItemAt("", 0);
					editledgercombo.setSelectedIndex(0);
					while (Rs.next()) {
						
						editledgercombo.addItem(Rs.getString(1));
				         
				      } 
				       
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
			}
		});
       
        editledgercombo.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	editsubledgercombo.requestFocusInWindow();
                	
			}}
		});
        
        editsubledgercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        editsubledgercombo.setFont(new java.awt.Font("Calibri", 1, 18));
        editsearchpanel.add(editsubledgercombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 284, 20));
        editsubledgercombo.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				editsubledgercombo.setBackground(new java.awt.Color(255, 255, 255));
			}
			
			public void focusGained(final FocusEvent e) {
				
				editsubledgercombo.setBackground(new java.awt.Color(255, 204, 204));
				
				String ledger = (String) editledgercombo.getSelectedItem();
				//String source = (String) editsourcecombo.getSelectedItem();
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select subledgername from subledger where ledgername = '"+ledger+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec"+sql);
					editsubledgercombo.removeAllItems();
					editsubledgercombo.insertItemAt("", 0);
					editsubledgercombo.setSelectedIndex(0);
					while (Rs.next()) {
						
						editsubledgercombo.addItem(Rs.getString(1));
				         
				      } 
				       
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
			}
		});
       
        editsubledgercombo.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	editfromdate.requestFocusInWindow();
                	
			}}
		});
        
        
        editfrom.setFont(new java.awt.Font("Calibri", 1, 18)); 
        editfrom.setForeground(new Color (255 , 255, 255));
        editfrom.setText("From");
        editsearchpanel.add(editfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 124, 26));

        editsourcecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "House", "Estate", "Finance", "Vehicle" }));
        editsearchpanel.add(editsourcecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 143, 43));
        editsourcecombo.insertItemAt("", 0);
        
        editsourcecombo.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	editledgercombo.requestFocusInWindow();
                	editledgercombo.showPopup();
                	
			}}
		});
        
        
        
        editsource1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        editsource1.setForeground(new Color (255 , 255, 255));
        editsource1.setText("Source");
        editsearchpanel.add(editsource1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 124, 26));

        editfromdate.setText(frmt1.format(d));
        editfromdate.setFont(new java.awt.Font("Calibri", 1, 18));
        editfromdate.setCaretPosition(10);
        editfromdate.setCaretColor(Color.RED);
        editsearchpanel.add(editfromdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 169, 43));

        editfromdate.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	edittodate.requestFocusInWindow();
                	
			}}
		});
        editfromdate.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				editfromdate.setValue(null);
				
			}
		});
        editto.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        editto.setForeground(new Color (255 , 255, 255));
        editto.setText("To");
        editsearchpanel.add(editto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 124, 26));

        edittodate.setText(frmt1.format(d));
        edittodate.setFont(new java.awt.Font("Calibri", 1, 18));
        edittodate.setCaretPosition(10);
        edittodate.setCaretColor(Color.RED);
        editsearchpanel.add(edittodate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 169, 43));

        edittodate.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	editsubmit.requestFocusInWindow();
                	
			}}
		});
        edittodate.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				edittodate.setValue(null);
				
			}
		});
        editsubmit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        editsubmit.setOpaque(false);
        editsubmit.setBackground(new Color (0 , 102 , 102));
        editsubmit.setForeground(new Color (255,255,255));
        editsubmit.setText("View");
        editsearchpanel.add(editsubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, 143, 43));

        editpanel.add(editsearchpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1110, 90));

        editsubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
              
				editsearchtable.setShowGrid(false);
				editsearchtable.setIntercellSpacing(new Dimension(10, 10));
				searchtext = "";
				empty = "";
				ledgerdata = (String) editledgercombo.getSelectedItem();
				sourcedata = (String) editsourcecombo.getSelectedItem();
				String subledger = (String) editsubledgercombo.getSelectedItem();
                System.out.println("edit subledger before conditions ----------->1111"+subledger);
				String efc = editfromdate.getText();
				String etc = edittodate.getText();
				if(efc.equals("  /  /    ") || etc.equals("  /  /    "))
				{
					ef = "";
					et = "";
				}
				else
				{
					ef = editfromdate.getText();
					et = edittodate.getText();
				}
				if(isDateValidedit(efc) && isDateValidedit(etc))
				{
				try
	               {
	               	Class.forName("com.mysql.jdbc.Driver");
	       			System.out.println("before connection");
	       			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
	       			System.out.println("conneted sql");
	       			Statement stmt = con.createStatement();
	       			StringBuffer sql = new StringBuffer();
	       			
	       			sql.append("Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where ");
	       			
	       			if(sourcedata != empty)
	       			{   
	       				sql.append("source = '"+sourcedata+"'");
	       			}
	       			
	       			if (ledgerdata != empty)
	       			{
	       				sql.append("and ");
	       				sql.append("ledger = '"+ledgerdata+"'");
	       				System.out.println("edit entry subledger---------->1"+subledger);
	       				if(subledger != empty)
	       				{
	       					System.out.println("edit entry subledger---------->2"+subledger);
	       					sql.append("and ");
	       					sql.append("subledger ='"+subledger+"'");
	       					}
	       				
	       				
	       			}
	       			//System.out.println("from date:" +ef+"to date" +et);  	
	       			
	       			if (sourcedata!= empty )
	       			{
	       			if (ef.isEmpty() && et.isEmpty())
	       			{
	       				
	       			}
	       			else
	       			{
	       				sql.append("and ");
	       			}
	       			}
	       			
	       			if (ef.isEmpty() && et.isEmpty())
	       			{
	       				
	       			}
	       			else
	       			{
	       				sql.append("(date between '"+ef+"' and '"+et+"')");
	       			}
	       			//sql.append(")");
	       			sql.append("order by date ");
	       			System.out.println("query before exec edit search"+sql);
	       			ResultSet Rs = stmt.executeQuery(sql.toString());
	       			System.out.println("query exec edit search"+sql);
	       			modeledit.setRowCount(0);
	       			while (Rs.next()) {
	       				//System.out.println("inside resultset modeledit");
	       				String debitformat = dc.format(Rs.getDouble(4));
	       				String creditformat = dc.format(Rs.getDouble(6));
	       				String interestformat = dc.format(Rs.getDouble(11));
	       				modeledit.addRow(new Object[] {Rs.getInt(1),Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,interestformat,Rs.getBlob(9)} ); 
	       			} 
	       			con.close();
	       		}
	       		catch (Exception e1)
	       		{
	       			System.out.println("sql exception" +e1);
	       		}
				}
				else
				{
					 JOptionPane.showMessageDialog(null, "DATE FORMAT IS NOT VALID (dd/MM/yyyy)");
				}
				
				
			}
		});
        
        editsubmit.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	editsearchtable.setShowGrid(false);
    				editsearchtable.setIntercellSpacing(new Dimension(10, 10));
    				String searchtext = "";
    				String empty = "";
    				String ledgerdata = (String) editledgercombo.getSelectedItem();
    				String sourcedata = (String) editsourcecombo.getSelectedItem();
    				String subledger = (String) editsubledgercombo.getSelectedItem();
    				String ef = editfromdate.getText();
    				String et = edittodate.getText();
    				String from = editfromdate.getText();
    				String to = edittodate.getText();
    				String efc = editfromdate.getText();
    				String etc = edittodate.getText();
    				if(efc.equals("  /  /    ") || etc.equals("  /  /    "))
    				{
    					ef = "";
    					et = "";
    				}
    				else
    				{
    					ef = editfromdate.getText();
    					et = edittodate.getText();
    				}
    				if(isDateValidedit(efc) && isDateValidedit(etc))
    				{
    				try
    	               {
    	               	Class.forName("com.mysql.jdbc.Driver");
    	       			System.out.println("before connection");
    	       			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
    	       			System.out.println("conneted sql");
    	       			Statement stmt = con.createStatement();
    	       			StringBuffer sql = new StringBuffer();
    	       			
    	       			sql.append("Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate,interestpaid,subledger from accounts where ");
    	       			
    	       			if(sourcedata != empty)
    	       			{   
    	       				sql.append("source = '"+sourcedata+"'");
    	       			}
    	       			
    	       			if (ledgerdata != empty && ledgerdata != "null")
    	       			{
    	       				sql.append("and ");
    	       				sql.append("ledger = '"+ledgerdata+"'");
    	       				System.out.println("edit entry subledger---------->1"+subledger);
    	       				if(subledger != empty && subledger != "null")
    	       				{
    	       					System.out.println("edit entry subledger---------->2"+subledger);
    	       					sql.append("and ");
    	       					sql.append("subledger ='"+subledger+"'");
    	       					}
    	       				
    	       				
    	       			}
    	       			//System.out.println("from date:" +ef+"to date" +et);  	
    	       			
    	       			if (sourcedata!= empty )
    	       			{
    	       			if (ef.isEmpty() && et.isEmpty())
    	       			{
    	       				
    	       			}
    	       			else
    	       			{
    	       				sql.append("and ");
    	       			}
    	       			}
    	       			
    	       			if (ef.isEmpty() && et.isEmpty())
    	       			{
    	       				
    	       			}
    	       			else
    	       			{
    	       				sql.append("(date between '"+ef+"' and '"+et+"')");
    	       			}
    	       			//sql.append(")");
    	       			sql.append("order by date ");
    	       			System.out.println("query before exec edit search"+sql);
    	       			ResultSet Rs = stmt.executeQuery(sql.toString());
    	       			System.out.println("query exec edit search"+sql);
    	       			modeledit.setRowCount(0);
    	       			while (Rs.next()) {
    	       				//System.out.println("inside resultset modeledit");
    	       				String debitformat = dc.format(Rs.getDouble(4));
    	       				String creditformat = dc.format(Rs.getDouble(6));
    	       				String interestformat = dc.format(Rs.getDouble(11));
    	       				modeledit.addRow(new Object[] {Rs.getInt(1),Rs.getString(8),Rs.getString(2),Rs.getString(12),Rs.getString(10),Rs.getString(5),Rs.getString(7),Rs.getString(3),debitformat,creditformat,interestformat,Rs.getBlob(9)} ); 
    	       			} 
    	       			con.close();
    	       		}
    	       		catch (Exception e1)
    	       		{
    	       			System.out.println("sql exception" +e1);
    	       		}
    				}
    				else
    				{
    					 JOptionPane.showMessageDialog(null, "DATE FORMAT IS NOT VALID (dd/MM/yyyy)");
    				}
                	
			}}
		});
        editsearchtable.setFont(new Font("Calibri", 1, 16)); // NOI18N
        editsearchtable.setRowHeight(40);
        editsearchtable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        editsearchtable.setSelectionForeground(new java.awt.Color(255 , 255 , 255));
        editsearchtable.setModel(modeledit);
        modeledit.addColumn("Entry ID");
        modeledit.addColumn("Source");
        modeledit.addColumn("Ledger");
        modeledit.addColumn("Subledger");
        modeledit.addColumn("Paid Date");
        modeledit.addColumn("A/C Date");
        modeledit.addColumn("Valid Date");
        modeledit.addColumn("Description");
        modeledit.addColumn("Debit");
        modeledit.addColumn("Credit");
        modeledit.addColumn("Interest paid");
        modeledit.addColumn("Receipt");
        editsearchtable.getTableHeader().setFont(new Font("Calibri", 0, 14));
        editsearchtable.getTableHeader().setOpaque(false);
        editsearchtable.getTableHeader().setBackground(new Color(32,136,203));
        editsearchtable.getTableHeader().setForeground(new Color(255,255,255));
        editsearchtable.getColumnModel().getColumn(0).setPreferredWidth(1);
        editsearchtable.getColumnModel().getColumn(1).setPreferredWidth(20);
        editsearchtable.getColumnModel().getColumn(2).setPreferredWidth(35);
        editsearchtable.getColumnModel().getColumn(3).setPreferredWidth(35);
        editsearchtable.getColumnModel().getColumn(4).setPreferredWidth(30);
        editsearchtable.getColumnModel().getColumn(5).setPreferredWidth(30);
        editsearchtable.getColumnModel().getColumn(6).setPreferredWidth(30);
        editsearchtable.getColumnModel().getColumn(7).setPreferredWidth(240);
        editsearchtable.getColumnModel().getColumn(8).setPreferredWidth(30);
        editsearchtable.getColumnModel().getColumn(9).setPreferredWidth(30);
        editsearchtable.getColumnModel().getColumn(10).setPreferredWidth(30);
        editsearchtable.getColumnModel().getColumn(11).setPreferredWidth(5);
        editsearchtable.setShowHorizontalLines(false);
        editsearchtable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(editsearchtable);

        editsearchtable.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                        	
                        	ImageIcon img = null;
                        	if (evt.getClickCount() == 2) {
                        		
                        	try {
                        		
                        		int rowcount = editsearchtable.getSelectedRow();
                				String cell = editsearchtable.getModel().getValueAt(rowcount, 0).toString();
                        		int index = editsearchtable.getSelectedRow();
                        		String id = modeledit.getValueAt(index, 0).toString();
                        		String sourcedisp = modeledit.getValueAt(index, 1).toString();
                        		String ledgerdisp = modeledit.getValueAt(index, 2).toString();
                        		String subledgerdisp = modeledit.getValueAt(index, 3).toString();
                        		String creditdisp = modeledit.getValueAt(index, 9).toString();
                        		String debitdisp = modeledit.getValueAt(index, 8).toString();
                        		String datedisp = modeledit.getValueAt(index, 5).toString();
                        		String paiddate = modeledit.getValueAt(index, 4).toString();
                        		String interest = modeledit.getValueAt(index, 10).toString();
                        		String validdatedisp = null;
                        		try
                        		{
                        		validdatedisp = modeledit.getValueAt(index, 6).toString();
                        	    img = (ImageIcon)  modeledit.getValueAt(index, 11);
                        		}
                        		catch (Exception e)
                        		{
                        			System.out.println(e);
                        		}
                        		String descdisp = modeledit.getValueAt(index, 7).toString();
                        		new Showdata().setDatacpyedit(cell,sourcedisp, ledgerdisp, creditdisp, debitdisp, datedisp, validdatedisp, descdisp, editsearchtable, searchtext , empty ,ledgerdata, sourcedata, ef,et ,paiddate, interest, subledgerdisp);
            				} catch (SQLException e) {
            					e.printStackTrace();
            				}};
                        	
                        }});

        editpanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1110, 460));
        editlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/alertlabel (2).jpg"))); // NOI18N
        editpanel.add(editlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 1360, 630));

        rightpanel.add(editpanel, "card4");

        ledgerpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        ledgersourcecombo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgersourcecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "House", "Estate", "Finance", "Vehicle" }));
        ledgersourcecombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        ledgerpanel.add(ledgersourcecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 40));
        
        ledgersourcecombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String source = (String)ledgersourcecombo.getSelectedItem();
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select ledgername from ledger where source = '"+source +"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec"+sql);
					modelledger.setRowCount(0);
					modelledger.addRow(new Object[] {""} );
					while (Rs.next()) {
						
						modelledger.addRow(new Object[] {Rs.getString(1)} ); 
				          } 
				       
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
				
			}
		});
        
        addledgersubbox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        addledgersubbox.setText("");
        addledgersubbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ledgerpanel.add(addledgersubbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 410, 30));
        
        ledgerpanel.setBackground(new Color(255 , 255 , 255));

        ledgername.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgername.setText("Ledger :");

       // ledgerpanel.add(ledgername, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 43, 61, 32));

        addledgerbox.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        addledgerbox.setText("");
        addledgerbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ledgerpanel.add(addledgerbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 450, 32));

        addledgerbox.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				
			}

			public void focusGained(FocusEvent e) {
				addledgerbox.selectAll();
			}
		});
        
        addledgerviewtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	if (evt.getClickCount() == 1) {
                int index = addledgerviewtable.getSelectedRow();
				selectedname = modelledger.getValueAt(index, 0).toString();};
				addledgerbox.setText(selectedname);

				 String ledgername = addledgerbox.getText();
	             String subledgername = addledgersubbox.getText();
	             String ledgersource = (String) ledgersourcecombo.getSelectedItem();
	            
	            	 		try
	            	 	    {
	            	 	    	Class.forName("com.mysql.jdbc.Driver");
	            	 			System.out.println("before connection");
	            	 			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
	            	 			Statement stmt = con1.createStatement();
	            	 			System.out.println("conneted sql");
	            	 			//String sql1 = "select subledgername from subledger where ledgername = '"+ledgername +"' and source = '"+ledgersource +"' ";
	            	 			String sql1 = "select subledgername from subledger where ledgername IN (select ledgername from ledger where ledgername = '"+ ledgername+"' and source = '"+ledgersource+"')" ;
	            	 			ResultSet Rs = stmt.executeQuery(sql1);
	            	 			modelledgersub.setRowCount(0);
	        					while (Rs.next()) {        						
	        						modelledgersub.addRow(new Object[] {Rs.getString(1)} ); 
	        				          } 
	            	 			System.out.println("query exec"+sql1);
	            	 			
	            	 			con1.close();      
	            	 		}
	            	 		catch (Exception e1)
	            	 		{
	            	 			System.out.println("sql exception" +e1);
	            	 		}
	            	 		
            }});
        addledgerviewtable.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        addledgerviewtable.setModel(modelledger);
        modelledger.addColumn("Head");
        addledgerviewtable.setRowHeight(28);
        addledgerviewtable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        addledgerviewtable.setSelectionForeground(new java.awt.Color(255 , 255 , 255));
        addledgerviewtable.getTableHeader().setBackground(new Color(32,136,203));
        addledgerviewtable.getTableHeader().setForeground(new Color(255,255,255));
        addledgerviewtable.getTableHeader().setFont(new Font("Calibri", 1, 20));
        addledgerviewtable.setToolTipText("");
        addledgerviewtable.setGridColor(new java.awt.Color(204, 204, 204));
        addledgerviewtable.setShowVerticalLines(false);
        addledgerviewtable.setShowHorizontalLines(false);
        addledgerviewtable.getTableHeader().setResizingAllowed(false);
        addledgerviewtable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(addledgerviewtable);

        ledgerpanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 415));
        
        addledgerviewtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	if (evt.getClickCount() == 2) {
                int index = addledgerviewtable.getSelectedRow();
				String selectedname = modelledger.getValueAt(index, 0).toString();
				
				new Reportslist().showledgerReport1(selectedname);
				
            	};
	            
	            	 		
	            	 		
            }});

        addledgersubtable.setModel(modelledgersub);
        addledgersubtable.setFont(new java.awt.Font("Calibri", 1, 20));
        modelledgersub.addColumn("Subhead");
        addledgersubtable.setRowHeight(28);
        addledgersubtable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        addledgersubtable.setSelectionForeground(new java.awt.Color(255 , 255 , 255));
        addledgersubtable.getTableHeader().setBackground(new Color(32,136,203));
        addledgersubtable.getTableHeader().setForeground(new Color(255,255,255));
        addledgersubtable.getTableHeader().setFont(new Font("Calibri", 1, 20));
        addledgersubtable.setToolTipText("");
        addledgersubtable.setGridColor(new java.awt.Color(204, 204, 204));
        addledgersubtable.setShowVerticalLines(false);
        addledgersubtable.setShowHorizontalLines(false);
        addledgersubtable.getTableHeader().setResizingAllowed(false);
        addledgersubtable.getTableHeader().setReorderingAllowed(false);
            jScrollPane7.setViewportView(addledgersubtable);

            ledgerpanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 410, 415));
            
            addledgersubtable.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                	if (evt.getClickCount() == 1) {
                    int index = addledgersubtable.getSelectedRow();
    				selectedname = modelledgersub.getValueAt(index, 0).toString();};
    				addledgersubbox.setText(selectedname);
                	
                }});
            
            addledgersubtable.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                	if (evt.getClickCount() == 2) {
                    int index = addledgersubtable.getSelectedRow();
    				String selectedname1 = modelledgersub.getValueAt(index, 0).toString();};
    				new Reportslist().showledgerReport(selectedname);
                	
                }});
            
            addledgersubbox.addFocusListener(new FocusListener() {

    			public void focusLost(FocusEvent e) {

    				
    			}

    			public void focusGained(FocusEvent e) {
    				addledgersubbox.selectAll();
    			}
    		});
        
        ledgersubmitbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgersubmitbtn.setText("Submit");
        ledgerpanel.add(ledgersubmitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 159, 103, 36));
        
       ledgersubmitbtn.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
		
             String ledgername = addledgerbox.getText();
             String subledgername = addledgersubbox.getText();
             String ledgersource = (String) ledgersourcecombo.getSelectedItem();
             Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
             
             if (ledgername .equals("") || ledgername .equals("Enter new Ledger"))
             {
            	 JOptionPane.showMessageDialog(null,"LEDGER FIELD IS EMPTY");
             }
             else
             {
            	 try
            	 {
            	 	Class.forName("com.mysql.jdbc.Driver");
            	 	System.out.println("before connection");
            	 	System.out.println("conneted sql");
            	 	Statement stmt = con.createStatement();
            	 	String sql = "select ledgername from ledger where ledgername = '"+ledgername +"'";
            	 	ResultSet Rs = stmt.executeQuery(sql);
            	 	System.out.println("query exec");
            	 	if (Rs.next()) {
            	 		//JOptionPane.showMessageDialog(null, "DATA ALREADY EXIST"+"  "+"("+ledgername+")"); 
            	 		insertledgersub(subledgername,ledgername);
            	       } 
            	 	else
            	 	{
            	 		try
            	 	    {
            	 	    	Class.forName("com.mysql.jdbc.Driver");
            	 			System.out.println("before connection");
            	 			//Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            	 			System.out.println("conneted sql");
            	 			Statement stmt1 = con.createStatement();
            	 			String sql1 = "Insert into  ledger (ledgername,source) values ('" + ledgername +"' ,'" + ledgersource +"' )";
            	 			stmt1.executeUpdate(sql1);
            	 			System.out.println("query exec"+sql1);
            	 			JOptionPane.showMessageDialog(null, "DATA SAVED SUCCESSFULLY"+"  "+"("+ledgername+" "+ledgersource+")");
            	 			refreshLedger();
            	 			insertledgersub(subledgername,ledgername);
            	 			
            	 			con.close();      
            	 		
            	 	    }
            	 		catch (Exception e1)
            	 		{
            	 			System.out.println("sql exception" +e1);
            	 		}
            	 		
     
            	 }
            	 }
            	 catch (Exception e1)
            	 {
            	 	System.out.println("sql exception" +e1);
            	 }
             }
			
		}
	});
        
      
        ledgerupdatebtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgerupdatebtn.setText("update");
     
        //ledgerpanel.add(ledgerupdatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 201, 103, 30));

        ledgerdeletebtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgerdeletebtn.setText("Delete");
        ledgerpanel.add(ledgerdeletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 237, 103, -1));
        
        ledgerdeletebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ledgername = addledgerbox.getText();
	             String subledgername = addledgersubbox.getText();
	             String ledgersource = (String) ledgersourcecombo.getSelectedItem();
	             
	             if (ledgername .equals(""))
	             {
	            	 JOptionPane.showMessageDialog(null,"LEDGER FIELD IS EMPTY");
	            	 deleteledgersub(subledgername,ledgername);
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
	            	 	String sql = "select ledgername from ledger where ledgername = '"+ledgername+"'and source ='"+ledgersource+"'";
	            	 	ResultSet Rs = stmt.executeQuery(sql);
	            	 	System.out.println("query exec");
	            	 	if (Rs.next()) {
	            	 		
	            	 		try
	            	 	    {
	            	 	    	Class.forName("com.mysql.jdbc.Driver");
	            	 			System.out.println("before connection");
	            	 			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
	            	 			System.out.println("conneted sql");
	            	 			Statement stmt1 = con.createStatement();
	            	 			String sql1 = "Delete from ledger where ledgername = '"+ledgername+"'and source ='"+ledgersource+"'";
	            	 			stmt.executeUpdate(sql1);
	            	 			System.out.println("query exec"+sql1);
	            	 			JOptionPane.showMessageDialog(null, "DATA DELETED SUCCESSFULLY"+"  "+"("+ledgername+")");
	            	 			deleteledgersub(subledgername,ledgername);
	            	 			refreshLedger();
	            	 			con.close();      
	            	 		}
	            	 		catch (Exception e1)
	            	 		{
	            	 			System.out.println("sql exception" +e1);
	            	 		}
	            	 		
	            	       } 
	            	 	else
	            	 	{
	            	 		JOptionPane.showMessageDialog(null, "DATA NOT EXIST IN DATABASE"+"  "+"("+ledgername+")"); 
	            	 	}
	     
	            	 }
	            	 catch (Exception e1)
	            	 {
	            	 	System.out.println("sql exception" +e1);
	            	 }
	             }
				
			
				
			}
		});

        ledgeraddbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgeraddbtn.setText("Add new");
        ledgerpanel.add(ledgeraddbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 274, 103, -1));
        
        ledgeraddbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				addledgerbox.setText("");
				addledgersubbox.setText("");
				addledgerbox.requestFocusInWindow();
				
			}
		});
        
        ledgersubmitbtn.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	String ledgername = addledgerbox.getText();
                    String subledgername = addledgersubbox.getText();
                    String ledgersource = (String) ledgersourcecombo.getSelectedItem();
                    Connection con = null;
       			try {
       				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
       			} catch (SQLException e2) {
       				// TODO Auto-generated catch block
       				e2.printStackTrace();
       			}
                    
                    if (ledgername .equals("") || ledgername .equals("Enter new Ledger"))
                    {
                   	 JOptionPane.showMessageDialog(null,"LEDGER FIELD IS EMPTY");
                    }
                    else
                    {
                   	 try
                   	 {
                   	 	Class.forName("com.mysql.jdbc.Driver");
                   	 	System.out.println("before connection");
                   	 	System.out.println("conneted sql");
                   	 	Statement stmt = con.createStatement();
                   	 	String sql = "select ledgername from ledger where ledgername = '"+ledgername +"'";
                   	 	ResultSet Rs = stmt.executeQuery(sql);
                   	 	System.out.println("query exec");
                   	 	if (Rs.next()) {
                   	 		//JOptionPane.showMessageDialog(null, "DATA ALREADY EXIST"+"  "+"("+ledgername+")"); 
                   	 		insertledgersub(subledgername,ledgername);
                   	       } 
                   	 	else
                   	 	{
                   	 		try
                   	 	    {
                   	 	    	Class.forName("com.mysql.jdbc.Driver");
                   	 			System.out.println("before connection");
                   	 			//Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
                   	 			System.out.println("conneted sql");
                   	 			Statement stmt1 = con.createStatement();
                   	 			String sql1 = "Insert into  ledger (ledgername,source) values ('" + ledgername +"' ,'" + ledgersource +"' )";
                   	 			stmt1.executeUpdate(sql1);
                   	 			System.out.println("query exec"+sql1);
                   	 			JOptionPane.showMessageDialog(null, "DATA SAVED SUCCESSFULLY"+"  "+"("+ledgername+" "+ledgersource+")");
                   	 			insertledgersub(subledgername,ledgername);
                   	 			refreshLedger();
                   	 			con.close();      
                   	 		
                   	 	    }
                   	 		catch (Exception e1)
                   	 		{
                   	 			System.out.println("sql exception" +e1);
                   	 		}
                   	 		
            
                   	 }
                   	 }
                   	 catch (Exception e1)
                   	 {
                   	 	System.out.println("sql exception" +e1);
                   	 }
                    }
        			
        		
                }} 
        	
		});
        
        ledgersubmitbtn.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

				ledgersubmitbtn.setOpaque(true);
				ledgersubmitbtn.setBackground(new java.awt.Color(255, 255, 255));
			}

			public void focusGained(FocusEvent e) {
				
				ledgersubmitbtn.setBackground(new java.awt.Color(255, 204, 204));
				
			}
		});
        
        addledgerbox.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                  ledgersubmitbtn.requestFocusInWindow();
        		
                }}     	
			
		});

        ledgerbackbtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledgerbackbtn.setText("Back");
        ledgerpanel.add(ledgerbackbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 311, 103, 32));

        ledgerlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/alertlabel (2).jpg"))); // NOI18N
        ledgerpanel.add(ledgerlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 1360, 630));
        
        rightpanel.add(ledgerpanel, "card5");
        
        ledgerbackbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	home.setVisible(true);
                Entrypanel.setVisible(false);
                editpanel.setVisible(false);
                ledgerpanel.setVisible(false);
                Header.setText("HOME");
                reportspanel.setVisible(false);
                }});

        reportspanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reportssearchpanel.setBackground(new java.awt.Color(0, 102, 102));
        reportssearchpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        reportssearchpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reportsledger.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        reportsledger.setForeground(new Color (255,255,255));
        reportsledger.setText("Ledger");
        reportssearchpanel.add(reportsledger, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 124, 26));

        reportscombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        reportscombo1.insertItemAt("", 0);
        reportscombo1.setFont(new java.awt.Font("Calibri", 1, 18));
        reportssearchpanel.add(reportscombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 284, 20));
        
        reportscombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        reportscombo.insertItemAt("", 0);
        reportscombo.setFont(new java.awt.Font("Calibri", 1, 18));
        reportssearchpanel.add(reportscombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 284, 20));
        
       

        reportscombo.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				reportscombo.setBackground(new java.awt.Color(255, 255, 255));
			}
			
			public void focusGained(final FocusEvent e) {
				
				reportscombo.setBackground(new java.awt.Color(255, 204, 204));
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select ledgername from ledger where source = '"+reportssourcecombo.getSelectedItem()+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec");
					reportscombo.removeAllItems();
					reportscombo.insertItemAt("", 0);
					reportscombo.setSelectedIndex(0);
					while (Rs.next()) {
						
						reportscombo.addItem(Rs.getString(1));
				         
				      } 
				       
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
			}
		});
        reportscombo.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	reportscombo1.requestFocusInWindow();
			}}
		});
        
      reportscombo1.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				reportscombo1.setBackground(new java.awt.Color(255, 255, 255));
			}
			
			public void focusGained(final FocusEvent e) {
				
				reportscombo1.setBackground(new java.awt.Color(255, 204, 204));
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select subledgername from subledger where ledgername = '"+reportscombo.getSelectedItem()+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec");
					reportscombo1.removeAllItems();
					reportscombo1.insertItemAt("", 0);
					reportscombo1.setSelectedIndex(0);
					while (Rs.next()) {
						
						reportscombo1.addItem(Rs.getString(1));
				         
				      } 
				       
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
			}
		});
        reportscombo1.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	reportsfromdate.requestFocusInWindow();
			}}
		});
        
        reportsfrom.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        reportsfrom.setText("From");
        reportsfrom.setForeground(new Color (255,255,255));
        reportssearchpanel.add(reportsfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 140, 26));

        reportssourcecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "House","Estate","Finance","Vehicle" }));
        reportssourcecombo.setFont(new java.awt.Font("Calibri", 1, 18));
        reportssourcecombo.insertItemAt("", 0);
        reportssearchpanel.add(reportssourcecombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 143, 40));
        
        reportssourcecombo.addFocusListener(new FocusListener() {
			

			public void focusLost(FocusEvent e) {

				reportssourcecombo.setBackground(new java.awt.Color(255, 255, 255));
			}
			
	
			public void focusGained(FocusEvent e) {
			
				reportssourcecombo.setBackground(new java.awt.Color(255, 204, 204));
			}
		});
        reportssourcecombo.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	reportscombo.requestFocusInWindow();
			}}
		});
        reportssource.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        reportssource.setText(" Source");
        reportssource.setForeground(new Color (255,255,255));
        reportssearchpanel.add(reportssource, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 26));

        reportsfromdate.setText(frmt1.format(d));
        reportsfromdate.setFont(new java.awt.Font("Calibri", 1, 18));
        reportsfromdate.setCaretColor(Color.RED);
        reportssearchpanel.add(reportsfromdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 169, 40));
        
        reportsfromdate.addFocusListener(new FocusListener() {
			

			public void focusLost(FocusEvent e) {

				
			}
			
	
			public void focusGained(FocusEvent e) {
			
				reportsfromdate.setValue(null);
			}
		});
        reportsfromdate.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	reportstodate.requestFocusInWindow();
			}}
		});

        reportsto.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        reportsto.setText("To");
        reportsto.setForeground(new Color (255,255,255));
        reportssearchpanel.add(reportsto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 124, 26));

        reportstodate.setText(frmt1.format(d));
        reportstodate.setCaretColor(Color.RED);
        reportstodate.setFont(new java.awt.Font("Calibri", 1, 18));
        reportssearchpanel.add(reportstodate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 169, 40));
        
        reportstodate.addFocusListener(new FocusListener() {
			

			public void focusLost(FocusEvent e) {

				
			}
			
	
			public void focusGained(FocusEvent e) {
			
				reportstodate.setValue(null);
			}
		});
        reportstodate.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	reportsview.requestFocusInWindow();
			}}
		});

        reportsview.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        reportsview.setText("View");
        reportsview.setBackground(new Color (0 , 102 , 102));
        reportsview.setForeground(new Color (255 , 255 , 255));
        reportsview.setOpaque(false);
        reportsview.setFocusable(true);
        reportssearchpanel.add(reportsview, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 143, 40));
        
        reportsview.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String ledger = (String) reportscombo.getSelectedItem();
				String source = (String) reportssourcecombo.getSelectedItem();
				String subledger = (String) reportscombo1.getSelectedItem();
				String from = "";
				String to = "";
				
				String efc = reportsfromdate.getText();
				String etc = reportstodate.getText();
				if(efc.equals("  /  /    ") || etc.equals("  /  /    "))
				{
					from = "";
					to = "";
				}
				else
				{
					from = reportsfromdate.getText();
					to = reportstodate.getText();
				}
				
				new Reportslist().showReport(ledger,subledger, source, from, to);
				
			}
		});
        reportsview.addFocusListener(new FocusListener() {
			

			public void focusLost(FocusEvent e) {

				reportsview.setBackground(new java.awt.Color(255, 255, 255));
			}
			
	
			public void focusGained(FocusEvent e) {
			
				reportsview.setBackground(new java.awt.Color(255, 204, 204));
			}
		});
        reportsview.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	String ledger = (String) reportscombo.getSelectedItem();
    				String source = (String) reportssourcecombo.getSelectedItem();
    				String subledger = (String) reportscombo1.getSelectedItem();
    				String from = "";
    				String to = "";
    				
    				String efc = reportsfromdate.getText();
    				String etc = reportstodate.getText();
    				if(efc.equals("  /  /    ") || etc.equals("  /  /    "))
    				{
    					from = "";
    					to = "";
    				}
    				else
    				{
    					from = reportsfromdate.getText();
    					to = reportstodate.getText();
    				}
    				new Reportslist().showReport(ledger,subledger, source, from, to);
    				
			}}
		});


        reportspanel.add(reportssearchpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1000, 120));
               
        reportslabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/alertlabel (2).jpg"))); // NOI18N
        reportspanel.add(reportslabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 1360, 630));

        rightpanel.add(reportspanel, "card6");
        
        alertpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

       
        model5 = new DefaultTableModel();
     
        alerttable.setModel(model5);
        alerttable.setRowHeight(30);
        alerttable.getTableHeader().setFont(new Font("Calibri", 0, 18));
        alerttable.setFont(new Font("Calibri", 0, 18));
        alerttable.getTableHeader().setBackground(new Color(255 , 255,255));
        alerttable.getTableHeader().setForeground(new Color(0,102,102));
        alerttable.setForeground(new Color(0 , 102 , 51));
        alerttable.getTableHeader().setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        alerttable.setSelectionBackground(new java.awt.Color(255, 102, 102));
        alerttable.setSelectionForeground(new java.awt.Color(255 , 255 , 255));
        alerttable.setShowHorizontalLines(false);
        alerttable.setShowVerticalLines(false);
       // TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        //alerttable.getColumn(6).setCellRenderer(buttonRenderer);
        model5.addColumn("Id");
        model5.addColumn("Source");
        model5.addColumn("Ledger");
        model5.addColumn("Date");
        model5.addColumn("Validdate");
        model5.addColumn("Description");
        model5.addColumn("Option");
        alerttable.getColumn("Option").setCellRenderer(new ButtonRenderer());
        alerttable.getColumn("Option").setCellEditor(
            new ButtonEditor(new JCheckBox() , countshow));
        alerttable.setFont(new Font("Calibri", 1, 14));
        alerttable.getTableHeader().setOpaque(false);
        alerttable.getColumnModel().getColumn(0).setPreferredWidth(1);
        alerttable.getColumnModel().getColumn(1).setPreferredWidth(50);
        alerttable.getColumnModel().getColumn(2).setPreferredWidth(100);
        alerttable.getColumnModel().getColumn(5).setPreferredWidth(200);
        alerttable.getColumnModel().getColumn(3).setPreferredWidth(20);
        alerttable.getColumnModel().getColumn(4).setPreferredWidth(20);
        alerttable.getColumnModel().getColumn(6).setPreferredWidth(5);
        jScrollPane5.setViewportView(alerttable);

        alertpanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 1010, 490));

        alertlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/alertlabel (2).jpg"))); // NOI18N
        alertpanel.add(alertlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 1360, 630));
        
        rightpanel.add(alertpanel, "card7");

        getContentPane().add(rightpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 1450, 720));
        
        
        alerttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	if (evt.getClickCount() == 1) {
            		
            		int rowcount = alerttable.getSelectedRow();
    				String cell = alerttable.getModel().getValueAt(rowcount, 0).toString();
    				
				};
            	
            }});        

        leftpanel.setBackground(new java.awt.Color(83, 88, 83));
        leftpanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leftpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notification.setBackground(new java.awt.Color(1, 113, 1));

        countshow.setEditable(false);
        countshow.setBackground(new java.awt.Color(0, 255, 51));
        countshow.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        countshow.setForeground(new java.awt.Color(255, 255, 255));
        countshow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        countshow.setText(Integer.toString(notificationcount));
        countshow.setBorder(null);
        countshow.setOpaque(false);

        javax.swing.GroupLayout notificationLayout = new javax.swing.GroupLayout(notification);
        notification.setLayout(notificationLayout);
        notificationLayout.setHorizontalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(countshow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        notificationLayout.setVerticalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(countshow, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        leftpanel.add(notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, -1, -1));
        
        
        alert.setBackground(new java.awt.Color(45, 164, 29));
        alert.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        alert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/icons8-google-alerts-50.png"))); // NOI18N
        alert.setText("      Alerts       ");
        alert.setBorder(null);
        alert.setFocusable(false);
        alert.setForeground(new java.awt.Color(255, 255, 255));
        alert.setOpaque(false);
    
        leftpanel.add(alert, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 220, 50));
        alert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	home.setVisible(false);
                Entrypanel.setVisible(false);
                editpanel.setVisible(false);
                ledgerpanel.setVisible(false);
                alertpanel.setVisible(true);
                reportspanel.setVisible(false);
                model5.setRowCount(0);
                notificationrefresh();
                Header.setText("ALERTS");
                notificationcount();
                countshow.setText(Integer.toString(notificationcount));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	alert.setBackground(new java.awt.Color(204,204,204));
            	alert.setForeground(new java.awt.Color(0, 0, 0));
            	alert.setOpaque(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	alert.setForeground(new java.awt.Color(255, 255, 255));
            	alert.setOpaque(false);
            }
        });
        
        
        
		/*
		 * welcome.setBackground(new java.awt.Color(32, 123, 35)); welcome.setFont(new
		 * java.awt.Font("Calibri", 1, 24)); // NOI18N welcome.setForeground(new
		 * java.awt.Color(204, 204, 204));
		 * welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		 * welcome.setText("DASHBOARD");
		 * welcome.setBorder(javax.swing.BorderFactory.createLineBorder(new
		 * java.awt.Color(12, 14, 12))); leftpanel.add(welcome, new
		 * org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 220, 50));
		 */

        Addentry.setBackground(new java.awt.Color(35, 159, 18));
        Addentry.setForeground(new java.awt.Color(255, 255, 255));
        Addentry.setBorder(null);
        Addentry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Addentry.setOpaque(false);
        Addentry.setFocusable(false);
        Addentry.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Addentry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/add.png"))); // NOI18N
        Addentry.setText("      Add Entry  ");
        leftpanel.add(Addentry, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 220, 50));
        
        Addentry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	home.setVisible(false);
                Entrypanel.setVisible(true);
                editpanel.setVisible(false);
                ledgerpanel.setVisible(false);
                alertpanel.setVisible(false);
                Header.setText("ADD ENTRY");
                reportspanel.setVisible(false);
                sourcecombo.requestFocusInWindow();
                sourcecombo.setSelectedIndex(0);
                ledgercombo.setSelectedIndex(0);
                subledgercombo.setSelectedIndex(0);
                creditamt.setText("0.00");
                debitamt.setText("0.00");
                interestbox.setText("0.00");
                datebox.setText(frmt1.format(d));
                accountdatebox.setText(frmt1.format(d));
                validdatebox.setText("00/00/0000");
                descriptionbox.setText("Enter your description for the expenses here");
                model1.setRowCount(0);
               
               
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	Addentry.setBackground(new java.awt.Color(204,204,204));
                Addentry.setForeground(new java.awt.Color(0, 0, 0));
                Addentry.setOpaque(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	Addentry.setForeground(new java.awt.Color(255, 255, 255));
            	Addentry.setOpaque(false);
            }
        });
        
        Addentry.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 
                 
			}
		});
        
        editentry.setBackground(new java.awt.Color(35, 159, 18));
        editentry.setForeground(new java.awt.Color(255, 255, 255));
        editentry.setBorder(null);
        editentry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editentry.setOpaque(false);
        editentry.setFocusable(false);
        editentry.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        editentry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/edit.png"))); // NOI18N
        editentry.setText("     Edit Entry ");
        
        leftpanel.add(editentry, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 220, 50));
        
        editentry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home.setVisible(false);
                Entrypanel.setVisible(false);
                editpanel.setVisible(true);
                ledgerpanel.setVisible(false);
                alertpanel.setVisible(false);
                Header.setText("EDIT ENTRY");
                reportspanel.setVisible(false);
                editsourcecombo.setSelectedIndex(0);
                editledgercombo.setSelectedIndex(0);
                editsourcecombo.requestFocusInWindow();
                editsourcecombo.showPopup();
                editfromdate.setText(frmt1.format(d));
                edittodate.setText(frmt1.format(d));
                modeledit.setRowCount(0);
                
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	editentry.setBackground(new java.awt.Color(204,204,204));
            	editentry.setForeground(new java.awt.Color(0, 0, 0));
            	editentry.setOpaque(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	editentry.setForeground(new java.awt.Color(255, 255, 255));
            	editentry.setOpaque(false);
            }
        });

        reports.setBackground(new java.awt.Color(35, 159, 18));
        reports.setForeground(new java.awt.Color(255, 255, 255));
        reports.setBorder(null);
        reports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports.setOpaque(false);
        reports.setFocusable(false);
        reports.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/reports.png"))); // NOI18N
        reports.setText("      Reports     ");
        
        leftpanel.add(reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 220, 50));
        
        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
        home.setVisible(false);
        Entrypanel.setVisible(false);
        Header.setText("REPORTS");
        editpanel.setVisible(false);
        ledgerpanel.setVisible(false);
        alertpanel.setVisible(false);
        reportspanel.setVisible(true);
        reportssourcecombo.requestFocusInWindow();
        reportscombo.setSelectedIndex(0);
        reportssourcecombo.setSelectedIndex(0);
        reportsfromdate.setText(frmt1.format(d));
        reportstodate.setText(frmt1.format(d));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	reports.setBackground(new java.awt.Color(204,204,204));
            	reports.setForeground(new java.awt.Color(0, 0, 0));
            	reports.setOpaque(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	reports.setForeground(new java.awt.Color(255, 255, 255));
            	reports.setOpaque(false);
            }
        });

        ledger.setBackground(new java.awt.Color(35, 159, 18));
        ledger.setForeground(new java.awt.Color(255, 255, 255));
        ledger.setBorder(null);
        ledger.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ledger.setOpaque(false);
        ledger.setFocusable(false);
        ledger.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ledger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/ledger.png"))); // NOI18N
        ledger.setText("     Ledger     ");
        
        leftpanel.add(ledger, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 220, 50));
        
        ledger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home.setVisible(false);
                Entrypanel.setVisible(false);
                editpanel.setVisible(false);
                Header.setText("LEDGER VIEW");
                ledgerpanel.setVisible(true);
                reportspanel.setVisible(false);
                alertpanel.setVisible(false);
                ledgersourcecombo.requestFocusInWindow();
                ledgersourcecombo.insertItemAt("", 0);
                ledgersourcecombo.setSelectedIndex(0);
                ledgersourcecombo.showPopup();
                addledgerbox.setText("");
                addledgersubbox.setText("");
                
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	ledger.setBackground(new java.awt.Color(204,204,204));
            	ledger.setForeground(new java.awt.Color(0, 0, 0));
            	ledger.setOpaque(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	ledger.setForeground(new java.awt.Color(255, 255, 255));
            	ledger.setOpaque(false);
            }
        });
        /*ledger.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
               
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					Statement stmt = con.createStatement();
					String sql = "select ledgername from ledger";
					ResultSet Rs = stmt.executeQuery(sql);
					modelledger.setRowCount(0);
					while (Rs.next()) {
						
						modelledger.addRow(new Object[] {Rs.getString(1)});
				         
				      } 
					con.close();
				       
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
				} 
				
			}
		);*/

        dashboard.setBackground(new java.awt.Color(35, 159, 18));
        dashboard.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/home.png"))); // NOI18N
        dashboard.setText("      Home        ");
        dashboard.setBorder(null);
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.setOpaque(false);
        dashboard.setFocusable(false);
        leftpanel.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 220, 50));
        
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home.setVisible(true);
                Entrypanel.setVisible(false);
                Header.setText("HOME");
                editpanel.setVisible(false);
                ledgerpanel.setVisible(false);
                reportspanel.setVisible(false);
                alertpanel.setVisible(false);

            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	dashboard.setBackground(new java.awt.Color(204,204,204));
            	dashboard.setForeground(new java.awt.Color(0, 0, 0));
            	dashboard.setOpaque(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	dashboard.setForeground(new java.awt.Color(255, 255, 255));
            	dashboard.setOpaque(false);
            }
        });
        
        dashboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double debamt = 0;
				double  credamt = 0;
				double rem = 0;
				try
		        {
		        	Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "Select SUM(debitamount) AS amt, SUM(creditamount) AS amt1, source from accounts where source IN ('house','vehicle','estate', 'finance') group by source"; 
					ResultSet Rs = stmt.executeQuery(sql);
					System.out.println("query exec"+sql);
					
					while (Rs.next()) {
						
						debamt = Rs.getDouble("amt");
						credamt = Rs.getDouble("amt1");
					    rem = (credamt - debamt);
		                String source = Rs.getString("source");
						
						if ( source .equals("House"))
						{
						homecredamt.setText(dc.format(credamt));
						homedebamt.setText(dc.format(debamt));
						
						homebalance.setText(dc.format(rem));
					    
						}
						else if (source .equals("Estate"))
						{
							homecredamt2.setText(dc.format(credamt));
							homedebamt2.setText(dc.format(debamt));

							homebalance2.setText(dc.format(rem));
							
						}
						else if (source .equals("Finance"))
						{
							homecredamt1.setText(dc.format(credamt));
							homedebamt1.setText(dc.format(debamt));

							homebalance1.setText(dc.format(rem));
						}
						else if (source .equals( "Vehicle"))
						{
							homecredamt3.setText(dc.format(credamt));
							homedebamt3.setText(dc.format(debamt));

							homebalance3.setText(dc.format(rem));
						}
						else
						{
							System.out.println("no data found");
						}
					} 
					con.close();
				       
				              
				}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
				
			}
		});

        Separatorup.setBackground(new java.awt.Color(255, 255, 255));
        leftpanel.add(Separatorup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 148, 240, -1));
        
        Separatordown.setBackground(new java.awt.Color(255, 255, 255));
        leftpanel.add(Separatordown, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 240, -1));
        
        dashrefresh.setBackground(new java.awt.Color(35, 159, 18));
        dashrefresh.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        dashrefresh.setForeground(new java.awt.Color(204, 204, 204));
        dashrefresh.setText("DASHBOARD");
        dashrefresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dashrefresh.setOpaque(false);
        dashrefresh.setFocusable(false);
        leftpanel.add(dashrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 220, 50));
        
        logout.setBackground(new java.awt.Color(102, 102, 102));
        logout.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        logout.setText("    Logout   ");
        logout.setBorder(null);
        logout.setOpaque(false);
        logout.setForeground(new java.awt.Color(204, 204, 204));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/logout.png")));
        logout.setFocusable(false);
        leftpanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 220, 50));

        
        leftlabel.setIcon(new ImageIcon(getClass().getResource("/picts/leftpanelrednewcpy.jpg"))); // NOI18N
        leftpanel.add(leftlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 730));
        
        getContentPane().add(leftpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 890));

        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               dispose();
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	logout.setBackground(new java.awt.Color(204,204,204));
            	logout.setForeground(new java.awt.Color(0, 0, 0));
            	logout.setOpaque(true);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	logout.setForeground(new java.awt.Color(255, 255, 255));
            	logout.setOpaque(false);
            }
        });
        
        toppanel.setBackground(new java.awt.Color(255, 255, 255));
        toppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
        Header.setForeground(new java.awt.Color(102, 102, 102));
        Header.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Header.setText("HOME");
        Header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Header.setOpaque(false);
        Header.setEditable(false);
        toppanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 28, 258, 40));

        userlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/icons8-male-user-50.png"))); // NOI18N
        userlabel.setText("jLabel1");
        toppanel.add(userlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 51, 68));

        Welcomeuser.setEditable(false);
        Welcomeuser.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        Welcomeuser.setForeground(new java.awt.Color(51, 51, 51));
        Welcomeuser.setText("WELCOME MANIKANDAN !!!");
        Welcomeuser.setBorder(null);
        Welcomeuser.setOpaque(false);
        
        toppanel.add(Welcomeuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 342, 50));

        getContentPane().add(toppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1450, 70));

        scrollpanel.setBackground(new java.awt.Color(83,88,83));

        javax.swing.GroupLayout scrollpanelLayout = new javax.swing.GroupLayout(scrollpanel);
        scrollpanel.setLayout(scrollpanelLayout);
        scrollpanelLayout.setHorizontalGroup(
            scrollpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1450, Short.MAX_VALUE)
        );
        scrollpanelLayout.setVerticalGroup(
            scrollpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(scrollpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 1450, 30));

        pack();

}
    /*public ArrayList<Phone> phoneLists()
    {
    	ArrayList <Phone> phoneLists = new ArrayList <Phone>();
    	Phone phone = new Phone();
    	try
    	{
    	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			String wheredate = frmt1.format(new Date());
			String sql = "Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic from accounts order by id DESC";
			ResultSet Rs = stmt.executeQuery(sql);
			
			while (Rs.next())
			{
				phone.setId(Rs.getInt("id"));
				phone.setLedger(Rs.getString("ledger"));
				phone.setSource(Rs.getString("source"));
				phone.setDate(Rs.getString("date"));
				phone.setValiddate(Rs.getString("validdate"));
				phone.setCredit(Rs.getDouble("credit"));
				phone.setDebit(Rs.getDouble("debit"));
				phone.setDescription(Rs.getString("description"));
			    phone.setImage(Rs.getBytes("pic"));
			    phoneLists.add(phone);
			}
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	return phoneLists();
    }*/
  
    protected static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
          formatter = new MaskFormatter(s);
        } catch (ParseException ex) {
          System.err.println("formatter is bad: " + ex.getMessage());
        }
        return formatter;
      }
    
    public void populateTable()
    {
    	//System.out.println("inside populate method");
    	model1 = (DefaultTableModel) searchtable.getModel();
    	Object [] rows = new Object[12];
    	model1.setRowCount(0);
    	//System.out.println("inside populate method-size---------------->  2"+phoneLists.size());
    	for (int i = 0 ; i< phoneLists.size(); i++)
    	{
    		//System.out.println("value of i---------------------------------------------------->"+i);
    		//System.out.println("inside populate method----------------->  3");
    		rows [0] = phoneLists.get(i).getId();
    		//System.out.println("inside populate method first id----------------->  4"+""+""+rows[0]);
    		rows [1] = phoneLists.get(i).getSource();
    		//System.out.println("inside populate method----------------->  5"+" "+rows[1]);
    		rows [2] = phoneLists.get(i).getLedger();
    		//System.out.println("inside populate method----------------->  6"+""+rows[2]);
    		rows [3] = phoneLists.get(i).getSubledger();
    		rows [4] = phoneLists.get(i).getPaidDate();
     		//System.out.println("inside populate method----------------->  7"+""+rows[3]);
    		rows [5] = phoneLists.get(i).getDate();
    		rows [6] = phoneLists.get(i).getValiddate();
    		//System.out.println("inside populate method----------------->  8"+""+rows[4]);
    		rows [7] = phoneLists.get(i).getDescription();
    		//System.out.println("inside populate method----------------->  9"+""+rows[5]);
    		rows [8] = phoneLists.get(i).getDebit();
    		//System.out.println("inside populate method----------------->  10"+""+rows[6]);
    		rows [9] = phoneLists.get(i).getCredit();
    		//System.out.println("inside populate method----------------->  11"+""+rows[7]);
    		rows [10] = phoneLists.get(i).getInterest();
    		if (phoneLists.get(i).getImage() != null)
    		{
    			ImageIcon imag  = new ImageIcon(new ImageIcon(phoneLists.get(i).getImage()).getImage().getScaledInstance(10, 80, Image.SCALE_SMOOTH));
    		rows[11] = imag;
    		}
    		else
    		{
    			rows [11] = null;	
    		}
    		//System.out.println("inside populate method----------------->  12"+"   "+rows[8]);
    	model1.addRow(rows);
    	//System.out.println("inside populate method----------------->  13");
    	}
    	
    }
    
    public void refreshLedger()
    {
    	//String ledgername = addledgerbox.getText();
        //String subledgername = addledgersubbox.getText();
        String ledgersource = (String) ledgersourcecombo.getSelectedItem();
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	System.out.println("before connection");
    	Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
    	System.out.println("conneted sql");
    	Statement stmt = con2.createStatement();
    	String sql1 = "select ledgername from ledger where source = '"+ledgersource+"'";
    	ResultSet Rs1 = stmt.executeQuery(sql1);
    	System.out.println("query exec");
    	modelledger.setRowCount(0);
    	while (Rs1.next()) {
    		
    		modelledger.addRow(new Object[] {Rs1.getString(1)});
             
          } 
    	con2.close();
    }
    
    catch (Exception e1)
    {
    	
    	System.out.println("sql exception" +e1);
    }
    }
    
    public void refreshsubLedger()
    {
    	String ledgername = addledgerbox.getText();
        String subledgername = addledgersubbox.getText();
        //String ledgersource = (String) ledgersourcecombo.getSelectedItem();
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	System.out.println("before connection");
    	Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
    	System.out.println("conneted sql");
    	Statement stmt = con2.createStatement();
    	String sql2 = "select subledgername from subledger where ledgername = '"+ledgername+"'";
    	ResultSet Rs2= stmt.executeQuery(sql2);
    	System.out.println("query exec");
    	modelledgersub.setRowCount(0);
	   while (Rs2.next()) {
    		
    		modelledgersub.addRow(new Object[] {Rs2.getString(1)});
          }        
    }
    
    catch (Exception e1)
    {
    	
    	System.out.println("sql exception" +e1);
    }
    }
    
    public void insertledgersub(String subledgername , String ledgername)
    {
    	if (subledgername.equals(""))
			{
 			JOptionPane.showMessageDialog(null,"LEDGER FIELD IS EMPTY");
			}
			else
			{
				try
        	 {
        	 	Class.forName("com.mysql.jdbc.Driver");
        	 	System.out.println("before connection");
        	 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
        	 	System.out.println("conneted sql");
        	 	Statement stmt2 = con.createStatement();
        	 	String sql2 = "select subledgername from subledger where subledgername = '"+subledgername +"' and ledgername = '" + ledgername +"'";
        	 	ResultSet Rs2 = stmt2.executeQuery(sql2);
        	 	System.out.println("query exec");
        	 	if (Rs2.next()) {
        	 		JOptionPane.showMessageDialog(null, "DATA ALREADY EXIST"+"  "+"("+subledgername+")"); 
        	       }
        	 	else
        	 	{
        	 		try
        	 	    {
        	 	    	Class.forName("com.mysql.jdbc.Driver");
        	 			System.out.println("before connection");
        	 			//Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
        	 			System.out.println("conneted sql");
        	 			Statement stmt4 = con.createStatement();
        	 			String sql4 = "Insert into  subledger (ledgername,subledgername) values ('" + ledgername +"' ,'" + subledgername +"' )";
        	 			stmt4.executeUpdate(sql4);
        	 			System.out.println("query exec"+sql4);
        	 			JOptionPane.showMessageDialog(null, "DATA SAVED SUCCESSFULLY"+"  "+"("+subledgername+") ");
        	 			refreshsubLedger();
        	 			refreshLedger();
        	 			
        	 			
        	 	}
        	 		catch (Exception e1)
	                	 {
	                	 	System.out.println("sql exception" +e1);
	                	 }
        	 	 
			}}
				catch (Exception e1)
       	 {
       	 	System.out.println("sql exception" +e1);
       	 }
 	}
    }
    
    public void deleteledgersub (String subledgername , String ledgername)
    {
    	
        
        if (subledgername .equals(""))
        {
       	 JOptionPane.showMessageDialog(null,"SUBHEAD FIELD IS EMPTY");
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
       	 String sql  = null;
       	 	if (ledgername.equals(""))
       	 	{
       	 	sql = "select * from subledger where subledgername = '"+subledgername+"'";
       	 	}
       	 	else
       	 	{
       	 	sql = "select * from subledger where ledgername = '"+ledgername +"'and subledgername = '"+subledgername+"'";
       	 	}
       	 	ResultSet Rs = stmt.executeQuery(sql);
       	 	System.out.println("query exec"+sql);
       	 	if (Rs.next()) {
       	 		
       	 		try
       	 	    {
       	 	    	Class.forName("com.mysql.jdbc.Driver");
       	 			System.out.println("before connection");
       	 			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
       	 			System.out.println("conneted sql");
       	 			Statement stmt1 = con1.createStatement();
       	 			String sql1 = null;
       	 		if (ledgername.equals(""))
           	 	{
       	 		sql1 = "Delete from subledger where subledgername = '"+subledgername+"'";
           	 	}
           	 	else
           	 	{
           	 	sql1 = "Delete from subledger where ledgername = '"+ledgername+"'and subledgername = '"+subledgername+"'";
           	 	}
       	 			stmt1.executeUpdate(sql1);
       	 			System.out.println("query exec"+sql1);
       	 		    refreshLedger();
       	 		    refreshsubLedger();
       	 			JOptionPane.showMessageDialog(null, "DATA DELETED SUCCESSFULLY"+"  "+"("+subledgername+")");
       	 			con1.close();      
       	 		}
       	 		catch (Exception e1)
       	 		{
       	 			System.out.println("sql exception" +e1);
       	 		}
       	 		
       	       } 
       	 	else
       	 	{
       	 		JOptionPane.showMessageDialog(null, "DATA NOT EXIST IN DATABASE"+"  "+"("+subledgername+")"); 
       	 	}

       	 }
       	 catch (Exception e1)
       	 {
       	 	System.out.println("sql exception" +e1);
       	 }
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
   public void notificationrefresh()
   {
	   //System.out.println("inside notification insert table method");
		
	   Connection con = null;
	   try
      {
      	Class.forName("com.mysql.jdbc.Driver");
      	System.out.println("inside notref-------------------->1");
			System.out.println("before connection");
			//System.out.println("inside notref-------------------->2");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			//System.out.println("inside notref-------------------->3");
			//System.out.println("conneted sql");
			//System.out.println("inside notref-------------------->4");
			Statement stmt = con.createStatement();
			//System.out.println("inside notref-------------------->5");
			String sql5 = "select * from notification order by validdate";
			//System.out.println("inside notref-------------------->6");
			ResultSet rs6 = stmt.executeQuery(sql5);
			//System.out.println("inside notref-------------------->7");
			model5.setRowCount(0);
			Icon icon = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
			while (rs6.next())
			{
				String validdate =  rs6.getString(5);
				model5.addRow(new Object[] {rs6.getInt(1), rs6.getString(2), rs6.getString(3), rs6.getString(4), validdate, rs6.getString(6), "END"} );
			}
			con.close();
		}
		
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	   
   }
  
   public void notificationcount()
   {
	   //System.out.println("inside notification count table method");
		
	   Connection con = null;
	   try
      {
      	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("before connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			System.out.println("conneted sql");
			Statement stmt = con.createStatement();
			
			String sql5 = "select count(*) from notification";
			ResultSet rs6 = stmt.executeQuery(sql5);
			System.out.println("query exec"+sql5);
            
			if (rs6.next())
			{
				notificationcount = rs6.getInt(1);
			}
			else
			{
				notificationcount = 0;
			}
			con.close();
		}
		
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
	   
		
		
   }
   public static boolean isDateValid(String date) 
	  {
	          try {
	              DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	              df.setLenient(false);
	              df.parse(date);
	              return true;
	          } catch (ParseException e) {
	              return false;
	          }
	  }
   
   public static boolean isDateValid1(String date) 
	  {
	   if(date.equals("00/00/0000"))
	   {
		  return true; 
	   }
	   else
		   {
		   try {
	              DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	              df.setLenient(false);
	              df.parse(date);
	              return true;
	          } catch (ParseException e) {
	              return false;
	          }
		   }
	  }
   public static boolean isDateValidedit(String date) 
	  {
	   if(date.equals("00/00/0000") || date.equals("  /  /    "))
	   {
		  return true; 
	   }
	   else
		   {
		   try {
	              DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	              df.setLenient(false);
	              df.parse(date);
	              return true;
	          } catch (ParseException e) {
	              return false;
	          }
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
			sql.append("Select id,ledger,description,debitamount,date,creditamount,validdate,source,pic,paiddate from accounts where ");
			
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
              modelprint.addRow(new Object[] {i++,Rs.getString(8),Rs.getString(2),Rs.getString(5),Rs.getString(3),debitformat,creditformat,rem} ); 
 
       }
		
       }
		
		catch (Exception e1)
		{
			System.out.println("sql exception" +e1);
		}
   
	
}
}
class ButtonRenderer extends JButton implements TableCellRenderer {
	
	private int row;
	private String cell;

	  public ButtonRenderer() {
	    setOpaque(true);

	  }

	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
	    if (isSelected) {
	    	
	      setForeground(table.getSelectionForeground());
	      setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(UIManager.getColor("Button.background"));
	      

	    }
	    setText((value == null) ? "" : value.toString());
	    return this;
	  }

	public Component getTableCellRendererComponent1(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
	}





	/**
	 * @version 1.0 11/09/98
	 */

	class ButtonEditor extends DefaultCellEditor {

	protected JButton button;

	  private String label;
	  private boolean isPushed;
	  private String cell;
      private int row, col;
	  private JTable table;
	  private JTextField countshow;
	  
	  public ButtonEditor(JCheckBox checkBox, JTextField count) {
	    super(checkBox);
	    this.countshow = count;
	    Icon icon = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
	    button = new JButton(icon);
	    button.setOpaque(true);
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
	        Connection con = null;
		 	//Connection con1 = null;
	 	   try
	       {
	       	Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("before connection");	
	 	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
	 		System.out.println("conneted sql");
	 		Statement stmt = con.createStatement();
	 		String sql5 = "select * from notification order by validdate";
	 		ResultSet rs6 = stmt.executeQuery(sql5);
	 		model1.setRowCount(0);
				while (rs6.next())
	 			{
	 				
	 				model1.addRow(new Object[] {rs6.getInt(1), rs6.getString(2), rs6.getString(3), rs6.getString(4), rs6.getString(5), rs6.getString(6), "Done"} );
	 			}
	 			//con.close();
	 		}
	 		
	 		catch (Exception e1)
	 		{
	 			System.out.println("sql exception" +e1);
	 		}
	 	  int notificationcount = 0;
	 	  try
	      {
	      	Class.forName("com.mysql.jdbc.Driver");
				System.out.println("before connection");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
				System.out.println("conneted sql");
				Statement stmt = con.createStatement();
				
				String sql5 = "select count(*) from notification";
				ResultSet rs6 = stmt.executeQuery(sql5);
				System.out.println("query exec"+sql5);
	            
				if (rs6.next())
				{
					notificationcount = rs6.getInt(1);
				}
				else
				{
					notificationcount = 0;
				}
				countshow.setText(Integer.toString(notificationcount));
				con.close();
			}
	 	  
			catch (Exception e1)
			{
				System.out.println("sql exception" +e1);
			}
	      }
	    });
	  }

	  public Component getTableCellEditorComponent(JTable table, Object value,
	      boolean isSelected, int row, int column) {
		  
		  this.table = table;
	      this.row = row;
	      this.col = column;
	    if (isSelected) {
	      button.setForeground(table.getSelectionForeground());
	      button.setBackground(table.getSelectionBackground());
	    } else {
	      button.setForeground(table.getForeground());
	      button.setBackground(table.getBackground());
	    }
	    label = (value == null) ? "" : value.toString();
	    button.setText(label);
	    isPushed = true;
	    return button;
	  }

	  public Object getCellEditorValue() {
	    if (isPushed) {
	    	 int row1 = table.getSelectedRow();
		     String cell1 = table.getModel().getValueAt(row, 0).toString();
	    	System.out.println("the selected row and cell inside table button method  is "+":"+row+""+"cell"+":"+cell);

	    	Connection con = null;
	 	   try
	       {
	       	Class.forName("com.mysql.jdbc.Driver");
	 			System.out.println("before connection");
	 			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
	 			System.out.println("conneted sql");
	 			Statement stmt = con.createStatement();
	 			String sql7 = "delete from notification where id IN ('"+cell1+"')";
	 		    stmt.execute(sql7);
	 			System.out.println("query exec"+sql7);
	 			JOptionPane.showMessageDialog(button, "ALERT IS UPDATED AND REMOVED SUCCESSFULLY");
	 			 
                con.close();
                            
                
	 		}
	 		
	 		catch (Exception e1)
	 		{
	 			System.out.println("sql exception" +e1);
	 		}
	    	
	      
	    }
	    isPushed = false;
	    return new String(label);
	  }

	  public boolean stopCellEditing() {
	    isPushed = false;
	    return super.stopCellEditing();
	  }

	  protected void fireEditingStopped() {
	    super.fireEditingStopped();
	  }
	  
	}







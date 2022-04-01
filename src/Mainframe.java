import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Mainframe extends JFrame {
	
	private JLabel username;
	private JLabel password;
	private JTextField usernamefield;
	private JPasswordField  passwordfield;
	private JButton btn;
	private JLabel message;
	private Dashboard dashboard;
	private JLabel heading;
	private JLabel background;
	private JLabel logolabel;
	private JPanel comppanel;
	private JLabel credits;
	private JLabel logopic ;
	private JLabel copyrights;
	
	
	public Mainframe()
	{
		super("VR TECHNO CORP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Dimension dim = new Dimension();
		 //setSize(getMaximumSize());
		 //setPreferredSize(new java.awt.Dimension(706, 320));
		 setSize(866, 349);
		 setVisible(true);
		 setResizable(false);
		 //setExtendedState(JFrame.MAXIMIZED_BOTH);
		 Toolkit toolkit = getToolkit();
		 dim = toolkit.getScreenSize();
		 setLocation(dim.width/2 - getWidth()/2 , dim.height/2 - getHeight()/2);
		 ImageIcon img = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
		 this.setIconImage(img.getImage());
		 
		btn = new JButton ("ENTER");
		username = new JLabel("username : ");
		password = new JLabel("password : ");
		message = new JLabel();
		usernamefield = new JTextField(10);
		passwordfield = new JPasswordField(10);
		heading = new JLabel();
		background = new JLabel();
		logolabel = new JLabel();
		comppanel = new JPanel();
		credits = new JLabel();
		logopic = new JLabel();
		copyrights = new JLabel();
		
		
		
		getContentPane().setLayout(new AbsoluteLayout());
		
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comppanel.setBackground(new java.awt.Color(8, 0, 34));
        comppanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logolabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        logolabel.setForeground(new java.awt.Color(204, 204, 204));
        logolabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logolabel.setText("   VR TECHNO CORP  ");
        logolabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        comppanel.add(logolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 210, 40));

        credits.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        credits.setForeground(new java.awt.Color(204, 204, 204));
        credits.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credits.setText("CREDITS");
        comppanel.add(credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 210, -1));

        logopic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/vrcolor_R2t_icon-5.png"))); // NOI18N
        comppanel.add(logopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 120));

        copyrights.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        copyrights.setForeground(new java.awt.Color(204, 204, 204));
        copyrights.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrights.setText("All copyrights @ VR Tech corp");
        comppanel.add(copyrights, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 220, 17));

        getContentPane().add(comppanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 300));

		btn.setBackground(new java.awt.Color(0, 0, 0));
		btn.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		btn.setForeground(new Color(102, 102, 102));
		btn.setText("LOGIN");
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		btn.setOpaque(false);
		btn.setFocusable(true);
		
        add(btn, new AbsoluteConstraints(720, 260, 130, 30));
        
        usernamefield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				passwordfield.requestFocusInWindow();
		}
		});
        
        passwordfield.setBackground(new java.awt.Color(204, 204, 204));
        passwordfield.setCaretColor(Color.RED);
        passwordfield.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        passwordfield.setForeground(new java.awt.Color(204, 204, 204));
        passwordfield.setOpaque(false);
        passwordfield.setText("Enter Password");
        
        
        add(passwordfield, new AbsoluteConstraints(440, 210, 280, 30));

        passwordfield.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
			}
			
			public void focusGained(final FocusEvent e) {
				passwordfield.selectAll();
			}
		});
        passwordfield.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
                	btn.requestFocusInWindow();
			}}
		});
        usernamefield.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        usernamefield.setForeground(new java.awt.Color(204, 204, 204));
        usernamefield.setCaretColor(Color.RED);
        usernamefield.setText("Enter Username");
        usernamefield.setOpaque(false);
        
        add(usernamefield, new AbsoluteConstraints(440, 100, 280, 30));
        
        
        usernamefield.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				usernamefield.setOpaque(false);
			}
			
			public void focusGained(final FocusEvent e) {
				//usernamefield.setOpaque(true);
				//usernamefield.setBackground(new java.awt.Color(255, 255, 255));
				usernamefield.selectAll();
			}
		});

        password.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(204, 204, 204));
        password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        password.setText("Password.");
        add(password, new AbsoluteConstraints(410, 150, 130, 40));

        username.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(204, 204, 204));
        username.setText("Username");
        add(username, new AbsoluteConstraints(440, 50, 180, 40));

		/*
		 * heading.setFont(new java.awt.Font("Berlin Sans FB", 0, 56)); // NOI18N
		 * heading.setForeground(new java.awt.Color(255, 255, 255));
		 * heading.setText("MANIKANDAN HOME ACCOUNTS"); add(heading, new
		 * AbsoluteConstraints(450, 0, 860, 190));
		 */

        background.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/hiring-an-ios-developer-for-your-mobile-apps.jpg"))); // NOI18N
        add(background, new AbsoluteConstraints(0, 0, 860, 320));



       // add(message);
		
	    btn.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				String username = usernamefield.getText();
				String password = passwordfield.getText();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select * from customerinfo where username = '"+username+"' and password = '"+password+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					if (Rs.next()) {
						passwordfield.setText("Enter Password");
						dashboard = new Dashboard();
				      } else {
				         message.setText(" Invalid user.. ");
				         JOptionPane.showMessageDialog(btn, "Invalid user...");}
					con.close();
					}
				
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
				
			      }
	
			});
		
           btn.addFocusListener(new FocusListener() {
			
			
			public void focusLost(final FocusEvent e) {
				btn.setOpaque(false);
			}
			
			public void focusGained(final FocusEvent e) {
				btn.setOpaque(true);
				btn.setBackground(new java.awt.Color(255, 204, 204));
			}
		}); 
	btn.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent evt) {
            if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            {
            	String username = usernamefield.getText();
				String password = passwordfield.getText();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("before connection");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
					System.out.println("conneted sql");
					Statement stmt = con.createStatement();
					String sql = "select * from customerinfo where username = '"+username+"' and password = '"+password+"'";
					ResultSet Rs = stmt.executeQuery(sql);
					if (Rs.next()) {
						passwordfield.setText("Enter Password");
				         dashboard = new Dashboard();
				      } else {
				         message.setText(" Invalid user.. ");
				         JOptionPane.showMessageDialog(btn, "Invalid user...");
				         con.close();
				}
					}
				catch (Exception e1)
				{
					System.out.println("sql exception" +e1);
				}
				
			      }
        }
	});
	

	
	}

	

}

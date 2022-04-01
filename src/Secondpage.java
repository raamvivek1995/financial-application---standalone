import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Secondpage extends JFrame {
	
	private JLabel background;
	private JButton accbtn;
	private JButton misc;
	private JButton finbtn;
	private JButton estate;
	private Houseexpense houseexpense;
	private Estateaccounts estate1;
	private Vehicleaccounts vehicleacc;

	public Secondpage()
	{
		super ("Accounts page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(getMaximumSize());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon img = new ImageIcon(getClass().getResource("/picts/vrlogonew.jpg"));
		this.setIconImage(img.getImage());
		accbtn = new JButton("ACCOUNTS");
		misc = new JButton("MISC");
		finbtn = new JButton("FINANCE");
		estate = new JButton("ESTATE");
		background = new JLabel();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        
        estate.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        estate.setText("ESTATE A/C");
        getContentPane().add(estate, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, 270, 60));

        estate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 estate1 = new Estateaccounts();
				
			}
		});
        misc.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        misc.setText("VEHICLE A/C");
        getContentPane().add(misc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 280, 60));

        misc.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
			vehicleacc = new Vehicleaccounts();	
			}
		});
        
        finbtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        finbtn.setText("FINANCE A/C");
        getContentPane().add(finbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 270, 60));

        finbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Financeaccounts finacct = new Financeaccounts();
				
			}
		});
        accbtn.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        accbtn.setText("HOME EXPENSE");
        accbtn.setOpaque(false);
        
        getContentPane().add(accbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 270, 60));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picts/second page.jpg"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-81, 0, 1940, -1));


        pack();
        
        accbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				houseexpense = new Houseexpense();
				
			}
		});  
	}
}

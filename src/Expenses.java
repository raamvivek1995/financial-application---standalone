import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Expenses extends JPanel {
	
	private JLabel source;
	private JLabel ledger;
	private JLabel date;
	private JLabel debit;
	private JLabel credit;
	private JLabel description;
	private JComboBox<String> sourcebox;
	private JComboBox<String> ledgerbox;
	private JFormattedTextField dateset;
	private JFormattedTextField creditbox;
	private JFormattedTextField debitbox;
	private JTextField descriptionbox;
	private JButton save;
	private JPanel rightpanel;
	private JPanel toppanel;
	private JPanel jpanel ;
	
	
	public Expenses ()
	{
		
		setVisible(true);
		
		
		
		source = new JLabel();
		ledger = new JLabel();
		date = new JLabel();
		debit = new JLabel();
		credit = new JLabel();
		description = new JLabel();
		sourcebox = new JComboBox<String>();
		ledgerbox = new JComboBox<String>();
		dateset = new JFormattedTextField();
		creditbox = new JFormattedTextField();
		debitbox = new JFormattedTextField();
		descriptionbox = new JTextField();
		save = new JButton();
		rightpanel = new JPanel();
		toppanel = new JPanel();
		jpanel = new JPanel();
		
		
		
		setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

      
		jpanel.setPreferredSize(new java.awt.Dimension(20, 510));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        add(jpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        rightpanel.setForeground(new java.awt.Color(49, 149, 12));
        rightpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
	    
	    
		source.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        source.setForeground(new java.awt.Color(255, 255, 255));
        source.setText("SOURCE");
       rightpanel.add(source, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 120, 40));

        sourcebox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sourcebox.setForeground(new java.awt.Color(255, 255, 255));
        sourcebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sourcebox.setOpaque(false);
       rightpanel.add(sourcebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 360, 40));

        debit.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        debit.setForeground(new java.awt.Color(255, 255, 255));
        debit.setText("DEBIT");
       rightpanel.add(debit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 100, 30));

        debitbox.setBackground(new java.awt.Color(204, 204, 204));
        debitbox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        debitbox.setForeground(new java.awt.Color(255, 255, 255));
        debitbox.setText(" amount.");
        debitbox.setOpaque(false);
       rightpanel.add(debitbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 150, 40));

        date.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("DATE ");
       rightpanel.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 50));

        dateset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dateset.setForeground(new java.awt.Color(255, 255, 255));
        dateset.setText("jTextField2");
        dateset.setOpaque(false);
       rightpanel.add(dateset, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 150, 40));

        credit.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        credit.setForeground(new java.awt.Color(255, 255, 255));
        credit.setText("CREDIT");
       rightpanel.add(credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 110, 50));

        creditbox.setForeground(new java.awt.Color(255, 255, 255));
        creditbox.setText("jFormattedTextField1");
        creditbox.setOpaque(false);
       rightpanel.add(creditbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 150, 40));

        description.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        description.setForeground(new java.awt.Color(255, 255, 255));
        description.setText("DESCRIPTION");
       rightpanel.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 130, 30));

        descriptionbox.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        descriptionbox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descriptionbox.setOpaque(false);
       rightpanel.add(descriptionbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 510, 50));

        ledger.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        ledger.setForeground(new java.awt.Color(255, 255, 255));
        ledger.setText("LEDGER    ");
       rightpanel.add(ledger, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 120, 40));

        ledgerbox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ledgerbox.setForeground(new java.awt.Color(255, 255, 255));
        ledgerbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ledgerbox.setOpaque(false);
       rightpanel.add(ledgerbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 360, 40));
        
        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vivek Mani\\Desktop\\save.png")); // NOI18N
        save.setText("    SAVE  ");
        save.setOpaque(false);
       rightpanel.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 180, 50));

        add(rightpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1450, 820));
		
	}

}

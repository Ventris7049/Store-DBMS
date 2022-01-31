/*
 * Cody Smith, Nwamaka Chidozie, David Ventris
 * COSC-4415.001 Database Systems
 * Final Project
 * 12/02/2021
 * This program is a Database Management Systems (DBMS) for a female clothing store. 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.*;

public class Main implements ActionListener {

	private JFrame frame;
	private static JTextField CIDTextCus;
	private static JTextField FnameTextCus;
	private static JTextField MnameTextCus;
	private static JTextField LnameTextCus;
	private static JTextField PhoneTextCus;
	private static JTextField EmailTextCus;
	private static JTextField StreetTextCus;
	private static JTextField CityTextCus;
	private static JTextField StateTextCus;
	private static JTextField ZipTextCus;
	private static TextArea textArea;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JButton InsertBtnCus;
	private JButton UpdateBtnCus;
	private JButton DeleteBtnCus;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private static JTextArea textArea_1;
	private JPanel panel_1;
	private static JTextArea textArea_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_13;
	private static JTextField PIDTextPro;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private static JTextField NameTextPro;
	private static JTextField DescriptionTextPro;
	private JLabel lblNewLabel_16;
	private static JTextField PriceTextPro;
	private JButton InsertBtnPro;
	private JButton UpdateBtnPro;
	private JButton DeleteBtnPro;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JSplitPane SupTab;
	private static JTextArea textArea_3;
	private JPanel panel_3;
	private JLabel lblNewLabel_17;
	private static JTextField SIDTextSup;
	private static JTextField CNameTextSup;
	private static JTextField PhoneTextSup;
	private static JTextField EmailTextSup;
	private static JTextField StreetTextSup;
	private static JTextField CityTextSup;
	private static JTextField StateTextSup;
	private static JTextField ZipTextSup;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_24;
	private JButton InsertBtnSup;
	private JButton UpdateBtnSup;
	private JButton DeleteBtnSup;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel lblNewLabel_25;
	private static JTextField ONumTextOrd;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private static JTextField ODateTextOrd;
	private static JTextField StatusTextOrd;
	private static JTextField TotalTextOrd;
	private JButton InsertBtnOrd;
	private JButton UpdateBtnOrd;
	private JButton DeleteBtnOrd;
	private JLabel label_27;
	private static JTextArea textArea_4;
	private JLabel label_35;
	private JLabel label_36;
	private JLabel label_37;
	private JLabel label_38;
	private JLabel label_39;
	private JLabel label_40;
	private static String cArea="";
	private static String pArea="";
	private static String oArea="";
	private static String shArea="";
	private static String suArea="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dbconnect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1179, 869);
		frame.getContentPane().add(tabbedPane);
		
		JSplitPane CusTab = new JSplitPane();
		CusTab.setResizeWeight(0.3);
		tabbedPane.addTab("Customer", null, CusTab, null);
		
		textArea = new TextArea();
		CusTab.setRightComponent(textArea);
		
		JPanel panel = new JPanel();
		CusTab.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		textArea.setText(cArea);
		
		label_9 = new JLabel("   ");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.gridwidth = 6;
		gbc_label_9.insets = new Insets(0, 0, 5, 0);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 0;
		panel.add(label_9, gbc_label_9);
		
		lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		CIDTextCus = new JTextField();
		GridBagConstraints gbc_CIDTextCus = new GridBagConstraints();
		gbc_CIDTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_CIDTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_CIDTextCus.gridx = 5;
		gbc_CIDTextCus.gridy = 1;
		panel.add(CIDTextCus, gbc_CIDTextCus);
		CIDTextCus.setColumns(10);
		
		label_8 = new JLabel("  ");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.gridwidth = 6;
		gbc_label_8.insets = new Insets(0, 0, 5, 0);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 2;
		panel.add(label_8, gbc_label_8);
		
		lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		FnameTextCus = new JTextField();
		GridBagConstraints gbc_FnameTextCus = new GridBagConstraints();
		gbc_FnameTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_FnameTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_FnameTextCus.gridx = 5;
		gbc_FnameTextCus.gridy = 3;
		panel.add(FnameTextCus, gbc_FnameTextCus);
		FnameTextCus.setColumns(10);
		
		label_7 = new JLabel("   ");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.gridwidth = 6;
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 4;
		panel.add(label_7, gbc_label_7);
		
		lblNewLabel_2 = new JLabel("Middle Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		MnameTextCus = new JTextField();
		GridBagConstraints gbc_MnameTextCus = new GridBagConstraints();
		gbc_MnameTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_MnameTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_MnameTextCus.gridx = 5;
		gbc_MnameTextCus.gridy = 5;
		panel.add(MnameTextCus, gbc_MnameTextCus);
		MnameTextCus.setColumns(10);
		
		label_6 = new JLabel("   ");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.gridwidth = 6;
		gbc_label_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 6;
		panel.add(label_6, gbc_label_6);
		
		lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 7;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		LnameTextCus = new JTextField();
		GridBagConstraints gbc_LnameTextCus = new GridBagConstraints();
		gbc_LnameTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_LnameTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_LnameTextCus.gridx = 5;
		gbc_LnameTextCus.gridy = 7;
		panel.add(LnameTextCus, gbc_LnameTextCus);
		LnameTextCus.setColumns(10);
		
		label_5 = new JLabel("   ");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.gridwidth = 6;
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 8;
		panel.add(label_5, gbc_label_5);
		
		lblNewLabel_4 = new JLabel("Phone ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 9;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		PhoneTextCus = new JTextField();
		GridBagConstraints gbc_PhoneTextCus = new GridBagConstraints();
		gbc_PhoneTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_PhoneTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_PhoneTextCus.gridx = 5;
		gbc_PhoneTextCus.gridy = 9;
		panel.add(PhoneTextCus, gbc_PhoneTextCus);
		PhoneTextCus.setColumns(10);
		
		label_4 = new JLabel("   ");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.gridwidth = 6;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 10;
		panel.add(label_4, gbc_label_4);
		
		lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 11;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		EmailTextCus = new JTextField();
		GridBagConstraints gbc_EmailTextCus = new GridBagConstraints();
		gbc_EmailTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_EmailTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_EmailTextCus.gridx = 5;
		gbc_EmailTextCus.gridy = 11;
		panel.add(EmailTextCus, gbc_EmailTextCus);
		EmailTextCus.setColumns(10);
		
		label_3 = new JLabel("   ");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.gridwidth = 6;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 12;
		panel.add(label_3, gbc_label_3);
		
		lblNewLabel_6 = new JLabel("Street");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 13;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		StreetTextCus = new JTextField();
		GridBagConstraints gbc_StreetTextCus = new GridBagConstraints();
		gbc_StreetTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_StreetTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_StreetTextCus.gridx = 5;
		gbc_StreetTextCus.gridy = 13;
		panel.add(StreetTextCus, gbc_StreetTextCus);
		StreetTextCus.setColumns(10);
		
		label_2 = new JLabel("   ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.gridwidth = 6;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 14;
		panel.add(label_2, gbc_label_2);
		
		lblNewLabel_7 = new JLabel("City");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 15;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		CityTextCus = new JTextField();
		GridBagConstraints gbc_CityTextCus = new GridBagConstraints();
		gbc_CityTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_CityTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_CityTextCus.gridx = 5;
		gbc_CityTextCus.gridy = 15;
		panel.add(CityTextCus, gbc_CityTextCus);
		CityTextCus.setColumns(10);
		
		label_1 = new JLabel("   ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 6;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 16;
		panel.add(label_1, gbc_label_1);
		
		lblNewLabel_8 = new JLabel("State");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 17;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		StateTextCus = new JTextField();
		GridBagConstraints gbc_StateTextCus = new GridBagConstraints();
		gbc_StateTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_StateTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_StateTextCus.gridx = 5;
		gbc_StateTextCus.gridy = 17;
		panel.add(StateTextCus, gbc_StateTextCus);
		StateTextCus.setColumns(10);
		
		label = new JLabel("   ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 6;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 18;
		panel.add(label, gbc_label);
		
		lblNewLabel_9 = new JLabel("Zip");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 19;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		ZipTextCus = new JTextField();
		GridBagConstraints gbc_ZipTextCus = new GridBagConstraints();
		gbc_ZipTextCus.insets = new Insets(0, 0, 5, 0);
		gbc_ZipTextCus.fill = GridBagConstraints.HORIZONTAL;
		gbc_ZipTextCus.gridx = 5;
		gbc_ZipTextCus.gridy = 19;
		panel.add(ZipTextCus, gbc_ZipTextCus);
		ZipTextCus.setColumns(10);
		
		lblNewLabel_12 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.gridwidth = 6;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 21;
		panel.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		InsertBtnCus = new JButton("Insert");
		InsertBtnCus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_InsertBtnCus = new GridBagConstraints();
		gbc_InsertBtnCus.insets = new Insets(0, 0, 5, 0);
		gbc_InsertBtnCus.gridwidth = 6;
		gbc_InsertBtnCus.gridx = 0;
		gbc_InsertBtnCus.gridy = 22;
		panel.add(InsertBtnCus, gbc_InsertBtnCus);
		InsertBtnCus.addActionListener(this);
		
		lblNewLabel_10 = new JLabel("    ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.gridwidth = 6;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 23;
		panel.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		UpdateBtnCus = new JButton("Update");
		UpdateBtnCus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_UpdateBtnCus = new GridBagConstraints();
		gbc_UpdateBtnCus.insets = new Insets(0, 0, 5, 0);
		gbc_UpdateBtnCus.gridwidth = 6;
		gbc_UpdateBtnCus.gridx = 0;
		gbc_UpdateBtnCus.gridy = 24;
		panel.add(UpdateBtnCus, gbc_UpdateBtnCus);
		UpdateBtnCus.addActionListener(this);
		
		lblNewLabel_11 = new JLabel("    ");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.gridwidth = 6;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 25;
		panel.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		DeleteBtnCus = new JButton("Delete");
		DeleteBtnCus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_DeleteBtnCus = new GridBagConstraints();
		gbc_DeleteBtnCus.gridwidth = 6;
		gbc_DeleteBtnCus.gridx = 0;
		gbc_DeleteBtnCus.gridy = 26;
		panel.add(DeleteBtnCus, gbc_DeleteBtnCus);
		DeleteBtnCus.addActionListener(this);
		
		JSplitPane ProTab = new JSplitPane();
		ProTab.setResizeWeight(0.12);
		tabbedPane.addTab("Products", null, ProTab, null);
		
		textArea_2 = new JTextArea();
		ProTab.setRightComponent(textArea_2);
		
		panel_2 = new JPanel();
		ProTab.setLeftComponent(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		textArea_2.setText(pArea);
		
		label_16 = new JLabel("   ");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.gridwidth = 6;
		gbc_label_16.insets = new Insets(0, 0, 5, 0);
		gbc_label_16.gridx = 0;
		gbc_label_16.gridy = 0;
		panel_2.add(label_16, gbc_label_16);
		
		lblNewLabel_13 = new JLabel("Product ID");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 2;
		gbc_lblNewLabel_13.gridy = 1;
		panel_2.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		PIDTextPro = new JTextField();
		GridBagConstraints gbc_PIDTextPro = new GridBagConstraints();
		gbc_PIDTextPro.insets = new Insets(0, 0, 5, 0);
		gbc_PIDTextPro.fill = GridBagConstraints.HORIZONTAL;
		gbc_PIDTextPro.gridx = 5;
		gbc_PIDTextPro.gridy = 1;
		panel_2.add(PIDTextPro, gbc_PIDTextPro);
		PIDTextPro.setColumns(10);
		
		label_10 = new JLabel("   ");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.gridwidth = 6;
		gbc_label_10.insets = new Insets(0, 0, 5, 0);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 2;
		panel_2.add(label_10, gbc_label_10);
		
		lblNewLabel_14 = new JLabel("Name");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 2;
		gbc_lblNewLabel_14.gridy = 3;
		panel_2.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		NameTextPro = new JTextField();
		GridBagConstraints gbc_NameTextPro = new GridBagConstraints();
		gbc_NameTextPro.insets = new Insets(0, 0, 5, 0);
		gbc_NameTextPro.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameTextPro.gridx = 5;
		gbc_NameTextPro.gridy = 3;
		panel_2.add(NameTextPro, gbc_NameTextPro);
		NameTextPro.setColumns(10);
		
		label_11 = new JLabel("   ");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.gridwidth = 6;
		gbc_label_11.insets = new Insets(0, 0, 5, 0);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 4;
		panel_2.add(label_11, gbc_label_11);
		
		lblNewLabel_15 = new JLabel("Description");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 2;
		gbc_lblNewLabel_15.gridy = 5;
		panel_2.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		DescriptionTextPro = new JTextField();
		GridBagConstraints gbc_DescriptionTextPro = new GridBagConstraints();
		gbc_DescriptionTextPro.insets = new Insets(0, 0, 5, 0);
		gbc_DescriptionTextPro.fill = GridBagConstraints.HORIZONTAL;
		gbc_DescriptionTextPro.gridx = 5;
		gbc_DescriptionTextPro.gridy = 5;
		panel_2.add(DescriptionTextPro, gbc_DescriptionTextPro);
		DescriptionTextPro.setColumns(10);
		
		label_12 = new JLabel("   ");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.gridwidth = 6;
		gbc_label_12.insets = new Insets(0, 0, 5, 0);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 6;
		panel_2.add(label_12, gbc_label_12);
		
		lblNewLabel_16 = new JLabel("Price");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 2;
		gbc_lblNewLabel_16.gridy = 7;
		panel_2.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		PriceTextPro = new JTextField();
		GridBagConstraints gbc_PriceTextPro = new GridBagConstraints();
		gbc_PriceTextPro.insets = new Insets(0, 0, 5, 0);
		gbc_PriceTextPro.fill = GridBagConstraints.HORIZONTAL;
		gbc_PriceTextPro.gridx = 5;
		gbc_PriceTextPro.gridy = 7;
		panel_2.add(PriceTextPro, gbc_PriceTextPro);
		PriceTextPro.setColumns(10);
		
		label_13 = new JLabel("   ");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.gridwidth = 6;
		gbc_label_13.insets = new Insets(0, 0, 5, 0);
		gbc_label_13.gridx = 0;
		gbc_label_13.gridy = 8;
		panel_2.add(label_13, gbc_label_13);
		
		InsertBtnPro = new JButton("Insert");
		InsertBtnPro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_InsertBtnPro = new GridBagConstraints();
		gbc_InsertBtnPro.insets = new Insets(0, 0, 5, 0);
		gbc_InsertBtnPro.gridwidth = 6;
		gbc_InsertBtnPro.gridx = 0;
		gbc_InsertBtnPro.gridy = 10;
		panel_2.add(InsertBtnPro, gbc_InsertBtnPro);
		InsertBtnPro.addActionListener(this);
		
		label_14 = new JLabel("   ");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.gridwidth = 6;
		gbc_label_14.insets = new Insets(0, 0, 5, 0);
		gbc_label_14.gridx = 0;
		gbc_label_14.gridy = 11;
		panel_2.add(label_14, gbc_label_14);
		
		UpdateBtnPro = new JButton("Update");
		UpdateBtnPro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_UpdateBtnPro = new GridBagConstraints();
		gbc_UpdateBtnPro.insets = new Insets(0, 0, 5, 0);
		gbc_UpdateBtnPro.gridwidth = 6;
		gbc_UpdateBtnPro.gridx = 0;
		gbc_UpdateBtnPro.gridy = 13;
		panel_2.add(UpdateBtnPro, gbc_UpdateBtnPro);
		UpdateBtnPro.addActionListener(this);
		
		label_15 = new JLabel("    ");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.gridwidth = 6;
		gbc_label_15.insets = new Insets(0, 0, 5, 0);
		gbc_label_15.gridx = 0;
		gbc_label_15.gridy = 14;
		panel_2.add(label_15, gbc_label_15);
		
		DeleteBtnPro = new JButton("Delete");
		DeleteBtnPro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_DeleteBtnPro = new GridBagConstraints();
		gbc_DeleteBtnPro.gridwidth = 6;
		gbc_DeleteBtnPro.gridx = 0;
		gbc_DeleteBtnPro.gridy = 16;
		panel_2.add(DeleteBtnPro, gbc_DeleteBtnPro);
		DeleteBtnPro.addActionListener(this);
		
		JSplitPane OrderTab = new JSplitPane();
		OrderTab.setResizeWeight(0.1);
		tabbedPane.addTab("Orders", null, OrderTab, null);
		
		textArea_1 = new JTextArea();
		OrderTab.setRightComponent(textArea_1);
		
		panel_1 = new JPanel();
		OrderTab.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		textArea_1.setText(oArea);
		
		label_35 = new JLabel("   ");
		GridBagConstraints gbc_label_35 = new GridBagConstraints();
		gbc_label_35.gridwidth = 6;
		gbc_label_35.insets = new Insets(0, 0, 5, 0);
		gbc_label_35.gridx = 0;
		gbc_label_35.gridy = 0;
		panel_1.add(label_35, gbc_label_35);
		
		lblNewLabel_25 = new JLabel("Order Number");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
		gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_25.gridx = 2;
		gbc_lblNewLabel_25.gridy = 1;
		panel_1.add(lblNewLabel_25, gbc_lblNewLabel_25);
		
		ONumTextOrd = new JTextField();
		GridBagConstraints gbc_ONumTextOrd = new GridBagConstraints();
		gbc_ONumTextOrd.insets = new Insets(0, 0, 5, 0);
		gbc_ONumTextOrd.fill = GridBagConstraints.HORIZONTAL;
		gbc_ONumTextOrd.gridx = 5;
		gbc_ONumTextOrd.gridy = 1;
		panel_1.add(ONumTextOrd, gbc_ONumTextOrd);
		ONumTextOrd.setColumns(10);
		
		label_36 = new JLabel("   ");
		GridBagConstraints gbc_label_36 = new GridBagConstraints();
		gbc_label_36.gridwidth = 6;
		gbc_label_36.insets = new Insets(0, 0, 5, 0);
		gbc_label_36.gridx = 0;
		gbc_label_36.gridy = 2;
		panel_1.add(label_36, gbc_label_36);
		
		lblNewLabel_26 = new JLabel("Order Date");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_26 = new GridBagConstraints();
		gbc_lblNewLabel_26.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_26.gridx = 2;
		gbc_lblNewLabel_26.gridy = 3;
		panel_1.add(lblNewLabel_26, gbc_lblNewLabel_26);
		
		ODateTextOrd = new JTextField();
		GridBagConstraints gbc_ODateTextOrd = new GridBagConstraints();
		gbc_ODateTextOrd.insets = new Insets(0, 0, 5, 0);
		gbc_ODateTextOrd.fill = GridBagConstraints.HORIZONTAL;
		gbc_ODateTextOrd.gridx = 5;
		gbc_ODateTextOrd.gridy = 3;
		panel_1.add(ODateTextOrd, gbc_ODateTextOrd);
		ODateTextOrd.setColumns(10);
		
		label_37 = new JLabel("   ");
		GridBagConstraints gbc_label_37 = new GridBagConstraints();
		gbc_label_37.gridwidth = 6;
		gbc_label_37.insets = new Insets(0, 0, 5, 0);
		gbc_label_37.gridx = 0;
		gbc_label_37.gridy = 4;
		panel_1.add(label_37, gbc_label_37);
		
		lblNewLabel_27 = new JLabel("Status");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
		gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_27.gridx = 2;
		gbc_lblNewLabel_27.gridy = 5;
		panel_1.add(lblNewLabel_27, gbc_lblNewLabel_27);
		
		StatusTextOrd = new JTextField();
		GridBagConstraints gbc_StatusTextOrd = new GridBagConstraints();
		gbc_StatusTextOrd.insets = new Insets(0, 0, 5, 0);
		gbc_StatusTextOrd.fill = GridBagConstraints.HORIZONTAL;
		gbc_StatusTextOrd.gridx = 5;
		gbc_StatusTextOrd.gridy = 5;
		panel_1.add(StatusTextOrd, gbc_StatusTextOrd);
		StatusTextOrd.setColumns(10);
		
		label_38 = new JLabel("   ");
		GridBagConstraints gbc_label_38 = new GridBagConstraints();
		gbc_label_38.gridwidth = 6;
		gbc_label_38.insets = new Insets(0, 0, 5, 0);
		gbc_label_38.gridx = 0;
		gbc_label_38.gridy = 6;
		panel_1.add(label_38, gbc_label_38);
		
		lblNewLabel_28 = new JLabel("Total");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
		gbc_lblNewLabel_28.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_28.gridx = 2;
		gbc_lblNewLabel_28.gridy = 7;
		panel_1.add(lblNewLabel_28, gbc_lblNewLabel_28);
		
		TotalTextOrd = new JTextField();
		GridBagConstraints gbc_TotalTextOrd = new GridBagConstraints();
		gbc_TotalTextOrd.insets = new Insets(0, 0, 5, 0);
		gbc_TotalTextOrd.fill = GridBagConstraints.HORIZONTAL;
		gbc_TotalTextOrd.gridx = 5;
		gbc_TotalTextOrd.gridy = 7;
		panel_1.add(TotalTextOrd, gbc_TotalTextOrd);
		TotalTextOrd.setColumns(10);
		
		lblNewLabel_29 = new JLabel("   ");
		GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
		gbc_lblNewLabel_29.gridwidth = 6;
		gbc_lblNewLabel_29.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_29.gridx = 0;
		gbc_lblNewLabel_29.gridy = 9;
		panel_1.add(lblNewLabel_29, gbc_lblNewLabel_29);
		
		label_27 = new JLabel("   ");
		GridBagConstraints gbc_label_27 = new GridBagConstraints();
		gbc_label_27.gridwidth = 6;
		gbc_label_27.insets = new Insets(0, 0, 5, 0);
		gbc_label_27.gridx = 0;
		gbc_label_27.gridy = 10;
		panel_1.add(label_27, gbc_label_27);
		
		InsertBtnOrd = new JButton("Insert");
		InsertBtnOrd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_InsertBtnOrd = new GridBagConstraints();
		gbc_InsertBtnOrd.gridwidth = 6;
		gbc_InsertBtnOrd.insets = new Insets(0, 0, 5, 0);
		gbc_InsertBtnOrd.gridx = 0;
		gbc_InsertBtnOrd.gridy = 11;
		panel_1.add(InsertBtnOrd, gbc_InsertBtnOrd);
		InsertBtnOrd.addActionListener(this);
		
		label_39 = new JLabel("   ");
		GridBagConstraints gbc_label_39 = new GridBagConstraints();
		gbc_label_39.gridwidth = 6;
		gbc_label_39.insets = new Insets(0, 0, 5, 0);
		gbc_label_39.gridx = 0;
		gbc_label_39.gridy = 12;
		panel_1.add(label_39, gbc_label_39);
		
		UpdateBtnOrd = new JButton("Update");
		UpdateBtnOrd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_UpdateBtnOrd = new GridBagConstraints();
		gbc_UpdateBtnOrd.gridwidth = 6;
		gbc_UpdateBtnOrd.insets = new Insets(0, 0, 5, 0);
		gbc_UpdateBtnOrd.gridx = 0;
		gbc_UpdateBtnOrd.gridy = 13;
		panel_1.add(UpdateBtnOrd, gbc_UpdateBtnOrd);
		UpdateBtnOrd.addActionListener(this);
		
		label_40 = new JLabel("   ");
		GridBagConstraints gbc_label_40 = new GridBagConstraints();
		gbc_label_40.gridwidth = 6;
		gbc_label_40.insets = new Insets(0, 0, 5, 0);
		gbc_label_40.gridx = 0;
		gbc_label_40.gridy = 14;
		panel_1.add(label_40, gbc_label_40);
		
		DeleteBtnOrd = new JButton("Delete");
		DeleteBtnOrd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_DeleteBtnOrd = new GridBagConstraints();
		gbc_DeleteBtnOrd.gridwidth = 6;
		gbc_DeleteBtnOrd.gridx = 0;
		gbc_DeleteBtnOrd.gridy = 15;
		panel_1.add(DeleteBtnOrd, gbc_DeleteBtnOrd);
		DeleteBtnOrd.addActionListener(this);
		
		textArea_4 = new JTextArea();
		
		SupTab = new JSplitPane();
		SupTab.setResizeWeight(0.1);
		tabbedPane.addTab("Suppliers", null, SupTab, null);
		textArea_4.setText(shArea);
		
		textArea_3 = new JTextArea();
		SupTab.setRightComponent(textArea_3);
		
		panel_3 = new JPanel();
		SupTab.setLeftComponent(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		textArea_3.setText(suArea);
		
		lblNewLabel_17 = new JLabel("Supplier ID");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridx = 2;
		gbc_lblNewLabel_17.gridy = 1;
		panel_3.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		SIDTextSup = new JTextField();
		GridBagConstraints gbc_SIDTextSup = new GridBagConstraints();
		gbc_SIDTextSup.insets = new Insets(0, 0, 5, 0);
		gbc_SIDTextSup.fill = GridBagConstraints.HORIZONTAL;
		gbc_SIDTextSup.gridx = 5;
		gbc_SIDTextSup.gridy = 1;
		panel_3.add(SIDTextSup, gbc_SIDTextSup);
		SIDTextSup.setColumns(10);
		
		label_17 = new JLabel("   ");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.gridwidth = 6;
		gbc_label_17.insets = new Insets(0, 0, 5, 0);
		gbc_label_17.gridx = 0;
		gbc_label_17.gridy = 2;
		panel_3.add(label_17, gbc_label_17);
		
		lblNewLabel_18 = new JLabel("Company Name");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 2;
		gbc_lblNewLabel_18.gridy = 3;
		panel_3.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		CNameTextSup = new JTextField();
		GridBagConstraints gbc_CNameTextSup = new GridBagConstraints();
		gbc_CNameTextSup.insets = new Insets(0, 0, 5, 0);
		gbc_CNameTextSup.fill = GridBagConstraints.HORIZONTAL;
		gbc_CNameTextSup.gridx = 5;
		gbc_CNameTextSup.gridy = 3;
		panel_3.add(CNameTextSup, gbc_CNameTextSup);
		CNameTextSup.setColumns(10);
		
		label_18 = new JLabel("   ");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.gridwidth = 6;
		gbc_label_18.insets = new Insets(0, 0, 5, 0);
		gbc_label_18.gridx = 0;
		gbc_label_18.gridy = 4;
		panel_3.add(label_18, gbc_label_18);
		
		lblNewLabel_19 = new JLabel("Phone");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 2;
		gbc_lblNewLabel_19.gridy = 5;
		panel_3.add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		PhoneTextSup = new JTextField();
		GridBagConstraints gbc_PhoneTextSup = new GridBagConstraints();
		gbc_PhoneTextSup.insets = new Insets(0, 0, 5, 0);
		gbc_PhoneTextSup.fill = GridBagConstraints.HORIZONTAL;
		gbc_PhoneTextSup.gridx = 5;
		gbc_PhoneTextSup.gridy = 5;
		panel_3.add(PhoneTextSup, gbc_PhoneTextSup);
		PhoneTextSup.setColumns(10);
		
		label_19 = new JLabel("   ");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.gridwidth = 6;
		gbc_label_19.insets = new Insets(0, 0, 5, 0);
		gbc_label_19.gridx = 0;
		gbc_label_19.gridy = 6;
		panel_3.add(label_19, gbc_label_19);
		
		lblNewLabel_20 = new JLabel("Email");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20.gridx = 2;
		gbc_lblNewLabel_20.gridy = 7;
		panel_3.add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		EmailTextSup = new JTextField();
		GridBagConstraints gbc_EmailTextSup = new GridBagConstraints();
		gbc_EmailTextSup.insets = new Insets(0, 0, 5, 0);
		gbc_EmailTextSup.fill = GridBagConstraints.HORIZONTAL;
		gbc_EmailTextSup.gridx = 5;
		gbc_EmailTextSup.gridy = 7;
		panel_3.add(EmailTextSup, gbc_EmailTextSup);
		EmailTextSup.setColumns(10);
		
		label_20 = new JLabel("    ");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.gridwidth = 6;
		gbc_label_20.insets = new Insets(0, 0, 5, 0);
		gbc_label_20.gridx = 0;
		gbc_label_20.gridy = 8;
		panel_3.add(label_20, gbc_label_20);
		
		lblNewLabel_21 = new JLabel("Street");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_21.gridx = 2;
		gbc_lblNewLabel_21.gridy = 9;
		panel_3.add(lblNewLabel_21, gbc_lblNewLabel_21);
		
		StreetTextSup = new JTextField();
		GridBagConstraints gbc_StreetTextSup = new GridBagConstraints();
		gbc_StreetTextSup.insets = new Insets(0, 0, 5, 0);
		gbc_StreetTextSup.fill = GridBagConstraints.HORIZONTAL;
		gbc_StreetTextSup.gridx = 5;
		gbc_StreetTextSup.gridy = 9;
		panel_3.add(StreetTextSup, gbc_StreetTextSup);
		StreetTextSup.setColumns(10);
		
		label_21 = new JLabel("    ");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.gridwidth = 6;
		gbc_label_21.insets = new Insets(0, 0, 5, 0);
		gbc_label_21.gridx = 0;
		gbc_label_21.gridy = 10;
		panel_3.add(label_21, gbc_label_21);
		
		lblNewLabel_22 = new JLabel("City");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_22.gridx = 2;
		gbc_lblNewLabel_22.gridy = 11;
		panel_3.add(lblNewLabel_22, gbc_lblNewLabel_22);
		
		CityTextSup = new JTextField();
		GridBagConstraints gbc_CityTextSup = new GridBagConstraints();
		gbc_CityTextSup.insets = new Insets(0, 0, 5, 0);
		gbc_CityTextSup.fill = GridBagConstraints.HORIZONTAL;
		gbc_CityTextSup.gridx = 5;
		gbc_CityTextSup.gridy = 11;
		panel_3.add(CityTextSup, gbc_CityTextSup);
		CityTextSup.setColumns(10);
		
		label_22 = new JLabel("    ");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.gridwidth = 6;
		gbc_label_22.insets = new Insets(0, 0, 5, 0);
		gbc_label_22.gridx = 0;
		gbc_label_22.gridy = 12;
		panel_3.add(label_22, gbc_label_22);
		
		lblNewLabel_23 = new JLabel("State");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_23.gridx = 2;
		gbc_lblNewLabel_23.gridy = 13;
		panel_3.add(lblNewLabel_23, gbc_lblNewLabel_23);
		
		StateTextSup = new JTextField();
		GridBagConstraints gbc_StateTextSup = new GridBagConstraints();
		gbc_StateTextSup.insets = new Insets(0, 0, 5, 0);
		gbc_StateTextSup.fill = GridBagConstraints.HORIZONTAL;
		gbc_StateTextSup.gridx = 5;
		gbc_StateTextSup.gridy = 13;
		panel_3.add(StateTextSup, gbc_StateTextSup);
		StateTextSup.setColumns(10);
		
		label_23 = new JLabel("    ");
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.gridwidth = 6;
		gbc_label_23.insets = new Insets(0, 0, 5, 0);
		gbc_label_23.gridx = 0;
		gbc_label_23.gridy = 14;
		panel_3.add(label_23, gbc_label_23);
		
		lblNewLabel_24 = new JLabel("Zip");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_24.gridx = 2;
		gbc_lblNewLabel_24.gridy = 15;
		panel_3.add(lblNewLabel_24, gbc_lblNewLabel_24);
		
		ZipTextSup = new JTextField();
		GridBagConstraints gbc_ZipTextSup = new GridBagConstraints();
		gbc_ZipTextSup.insets = new Insets(0, 0, 5, 0);
		gbc_ZipTextSup.fill = GridBagConstraints.HORIZONTAL;
		gbc_ZipTextSup.gridx = 5;
		gbc_ZipTextSup.gridy = 15;
		panel_3.add(ZipTextSup, gbc_ZipTextSup);
		ZipTextSup.setColumns(10);
		
		label_24 = new JLabel("    ");
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.gridwidth = 6;
		gbc_label_24.insets = new Insets(0, 0, 5, 0);
		gbc_label_24.gridx = 0;
		gbc_label_24.gridy = 16;
		panel_3.add(label_24, gbc_label_24);
		
		InsertBtnSup = new JButton("Insert");
		InsertBtnSup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_InsertBtnSup = new GridBagConstraints();
		gbc_InsertBtnSup.gridwidth = 6;
		gbc_InsertBtnSup.insets = new Insets(0, 0, 5, 0);
		gbc_InsertBtnSup.gridx = 0;
		gbc_InsertBtnSup.gridy = 18;
		panel_3.add(InsertBtnSup, gbc_InsertBtnSup);
		InsertBtnSup.addActionListener(this);
		
		label_25 = new JLabel("    ");
		GridBagConstraints gbc_label_25 = new GridBagConstraints();
		gbc_label_25.gridwidth = 6;
		gbc_label_25.insets = new Insets(0, 0, 5, 0);
		gbc_label_25.gridx = 0;
		gbc_label_25.gridy = 19;
		panel_3.add(label_25, gbc_label_25);
		
		UpdateBtnSup = new JButton("Update");
		UpdateBtnSup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_UpdateBtnSup = new GridBagConstraints();
		gbc_UpdateBtnSup.gridwidth = 6;
		gbc_UpdateBtnSup.insets = new Insets(0, 0, 5, 0);
		gbc_UpdateBtnSup.gridx = 0;
		gbc_UpdateBtnSup.gridy = 20;
		panel_3.add(UpdateBtnSup, gbc_UpdateBtnSup);
		UpdateBtnSup.addActionListener(this);
		
		label_26 = new JLabel("    ");
		GridBagConstraints gbc_label_26 = new GridBagConstraints();
		gbc_label_26.gridwidth = 6;
		gbc_label_26.insets = new Insets(0, 0, 5, 0);
		gbc_label_26.gridx = 0;
		gbc_label_26.gridy = 21;
		panel_3.add(label_26, gbc_label_26);
		
		DeleteBtnSup = new JButton("Delete");
		DeleteBtnSup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_DeleteBtnSup = new GridBagConstraints();
		gbc_DeleteBtnSup.gridwidth = 6;
		gbc_DeleteBtnSup.gridx = 0;
		gbc_DeleteBtnSup.gridy = 22;
		panel_3.add(DeleteBtnSup, gbc_DeleteBtnSup);
		frame.setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1201, 925);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DeleteBtnSup.addActionListener(this);
	}
	//This method connects to the database and propagates the table information in the JTextArea for each table.
	public static void dbconnect() {
		try {
			String jdbcUrl = "jdbc:sqlite:/C:\\Users\\ventr\\eclipse-workspace\\DB_Project\\db.db";
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT * FROM customer";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			cArea="";
			cArea+= "Customer ID |           Name            |    Phone    |    Email    |    Address    |    City    |    State    |    Zipcode \n" ;
			while (result.next()) {
				String cust_id = result.getString("cust_id");
				String f_name = result.getString("f_name");
				String m_name = result.getString("m_name");
				String l_name = result.getString("l_name");
				String phone = result.getString("phone");
				String email = result.getString("email");
				String address = result.getString("address");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				cArea+="         "+cust_id +"             | "+ f_name +" " + m_name +" " +l_name 
						+" | " + phone +" | " + email +" | " + address +" | " + city 
						+" | " + state +" | " + zip + "\n";
				
			}
			
			sql = "SELECT * FROM product";
			
			statement = connection.createStatement();
			
			result = statement.executeQuery(sql);
			pArea="";
			pArea+= " Product ID |      Name       |    Description    |  Price \n";
			while (result.next()) {
				String prod_id = result.getString("prod_id");
				String description = result.getString("description");
				String name = result.getString("name");
				String price = result.getString("price");
				pArea+="         "+prod_id +"             |   "+name 
						+"  |   " + description +"   | " + price + "\n";
				
			}
			
			sql = "SELECT * FROM orders";
			
			statement = connection.createStatement();
			
			result = statement.executeQuery(sql);
			oArea="";
			oArea+= " Order Number |      Order Date     |    Total    |   Status \n" ;
			while (result.next()) {
				String order_num = result.getString("order_num");
				String order_date = result.getString("order_date");
				String total = result.getString("total");
				String status = result.getString("status");
				oArea+="         "+order_num +"             | "+ order_date 
						+" | " + order_date +" | " + total +" | " + status+ "\n";
			}

			sql = "SELECT * FROM supplier";
			
			statement = connection.createStatement();
			
			result = statement.executeQuery(sql);
			suArea="";
			suArea+= "Supplier ID |    Company Name      |    Phone    |    Email    |    Address    |    City    |    State    |    Zipcode \n" ;
			while (result.next()) {
				String sup_id = result.getString("sup_id");
				String company_name = result.getString("company_name");
				String phone = result.getString("phone");
				String email = result.getString("email");
				String address = result.getString("address");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				suArea+="         "+sup_id +"             | "+ company_name 
						+" | " + phone +" | " + email +" | " + address +" | " + city 
						+" | " + state +" | " + zip + "\n";
			}
			
		}
		catch(SQLException e) {
			System.out.println("Error connection to SQLite database");
			e.printStackTrace();
		}
		
	}
	//This method is used to insert tuples into a table.
	public static void insert() {
		try {
		String jdbcUrl = "jdbc:sqlite:/C:\\Users\\ventr\\eclipse-workspace\\DB_Project\\db.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		String inString="";
		String sql="";
		
		if(!LnameTextCus.getText().isEmpty()) {

			inString= Long.valueOf(PhoneTextCus.getText()) + ",'" + EmailTextCus.getText() + "','"+ FnameTextCus.getText() 
			+ "','" + MnameTextCus.getText()+ "','" + LnameTextCus.getText()
			+ "','" + StreetTextCus.getText() + "','" + CityTextCus.getText() + "','" + 
			StateTextCus.getText() + "'," + Integer.valueOf(ZipTextCus.getText());
			sql = "Insert into customer (phone, email, f_name, m_name,l_name,address,city,state,zip)" + "Values (" + inString + ")";
		}
			
		if(!NameTextPro.getText().isEmpty()) {
			inString= "'"+DescriptionTextPro.getText() + "','"+ NameTextPro.getText() + "',"+Double.valueOf(PriceTextPro.getText());
			sql = "Insert into product (description, name, price)" + "Values (" + inString + ")";
		}
		
		if(!ODateTextOrd.getText().isEmpty()) {
			inString= "'" + ODateTextOrd.getText() + "',"+Double.valueOf(TotalTextOrd.getText()) + ",'" + StatusTextOrd.getText() +"'";
			sql = "Insert into orders (order_date, total, status)" + "Values (" + inString + ")";
		}
		
		if(!CNameTextSup.getText().isEmpty()) {

			inString= Long.valueOf(PhoneTextSup.getText())+ ",'" + EmailTextSup.getText() 
			+ "','" + CNameTextSup.getText() + "','" + StreetTextSup.getText() 
			+ "','" + CityTextSup.getText() + "','" + StateTextSup.getText() 
			+ "'," + Integer.valueOf(ZipTextSup.getText());
			sql = "Insert into supplier (phone, email, company_name,address,city,state,zip)" + "Values (" + inString + ")";
		}
		
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		}
		
		catch(SQLException e) {
			System.out.println("Error connection to SQLite database");
			e.printStackTrace();
		}
		
	}
	//This method is used to reset the JTextFields.
	public void clearTextFields() {
		CIDTextCus.setText("");
		FnameTextCus.setText("");
		MnameTextCus.setText("");
		LnameTextCus.setText("");
		PhoneTextCus.setText("");
		EmailTextCus.setText("");
		StreetTextCus.setText("");
		CityTextCus.setText("");
		StateTextCus.setText("");
		ZipTextCus.setText("");
		PIDTextPro.setText("");
		NameTextPro.setText("");
		DescriptionTextPro.setText("");
		PriceTextPro.setText("");
		SIDTextSup.setText("");
		CNameTextSup.setText("");
		PhoneTextSup.setText("");
		EmailTextSup.setText("");
		StreetTextSup.setText("");
		CityTextSup.setText("");
		StateTextSup.setText("");
		ZipTextSup.setText("");
		ONumTextOrd.setText("");
		ODateTextOrd.setText("");
		StatusTextOrd.setText("");
		TotalTextOrd.setText("");
	}
	//This method is used to update a tuple in a table.
	public static void update() {
		try {
		String jdbcUrl = "jdbc:sqlite:/C:\\Users\\ventr\\eclipse-workspace\\DB_Project\\db.db";
		Connection connection = DriverManager.getConnection(jdbcUrl);
		String inString="";
		String sql="";
		
		if(!CIDTextCus.getText().isEmpty()) {
			if(!PhoneTextCus.getText().isEmpty()) {
				inString+="phone = " + Long.valueOf(PhoneTextCus.getText()) + ",";
			}
			if(!EmailTextCus.getText().isEmpty()) {
				inString+="email = '" + EmailTextCus.getText() + "',";		
			}
			if(!FnameTextCus.getText().isEmpty()) {
				inString+="f_name = '" + FnameTextCus.getText() + "',";
			}
			if(!MnameTextCus.getText().isEmpty()) {
				inString+="m_name = '" + MnameTextCus.getText() + "',";
			}
			if(!LnameTextCus.getText().isEmpty()) {
				inString+="l_name = '" + LnameTextCus.getText() + "',";
			}
			if(!StreetTextCus.getText().isEmpty()) {
				inString+="address = '" + StreetTextCus.getText() + "',";
			}
			if(!CityTextCus.getText().isEmpty()) {
				inString+="city = '" + CityTextCus.getText() + "',";
			}
			if(!StateTextCus.getText().isEmpty()) {
				inString+="state = '" + StateTextCus.getText() + "',";
			}
			if(!ZipTextCus.getText().isEmpty()) {
				inString+="zip = " + Integer.valueOf(ZipTextCus.getText()) + ",";
			}
			inString=inString.substring(0, inString.length()-1);
			sql = "UPDATE customer " + "SET " + inString + " WHERE cust_id = " + Integer.valueOf(CIDTextCus.getText()) ;
		}
		
		if(!PIDTextPro.getText().isEmpty()) {
			if(!NameTextPro.getText().isEmpty()) {
				inString+="name = '" + NameTextPro.getText() + "',";
			}
			if(!DescriptionTextPro.getText().isEmpty()) {
				inString+="description = '" + DescriptionTextPro.getText() + "',";		
			}
			if(!PriceTextPro.getText().isEmpty()) {
				inString+="price = " + Double.valueOf(PriceTextPro.getText()) + ",";
			}
			inString=inString.substring(0, inString.length()-1);
			sql = "UPDATE product " + "SET " + inString + " WHERE prod_id = " + Integer.valueOf(PIDTextPro.getText()) ;
		}
		
		if(!ONumTextOrd.getText().isEmpty()) {
			if(!ODateTextOrd.getText().isEmpty()) {
				inString+="order_date = " + Long.valueOf(ODateTextOrd.getText()) + ",";
			}
			if(!StatusTextOrd.getText().isEmpty()) {
				inString+="status = '" + StatusTextOrd.getText() + "',";		
			}
			if(!TotalTextOrd.getText().isEmpty()) {
				inString+="total = " + Double.valueOf(TotalTextOrd.getText()) + ",";
			}
			inString=inString.substring(0, inString.length()-1);
			System.out.println(inString);
			sql = "UPDATE orders " + "SET " + inString + " WHERE order_num = " + Integer.valueOf(ONumTextOrd.getText()) ;
		}
		
		if(!SIDTextSup.getText().isEmpty()) {
			if(!PhoneTextSup.getText().isEmpty()) {
				inString+="phone = " + Long.valueOf(PhoneTextSup.getText()) + ",";
			}
			if(!EmailTextSup.getText().isEmpty()) {
				inString+="email = '" + EmailTextSup.getText() + "',";		
			}
			if(!CNameTextSup.getText().isEmpty()) {
				inString+="company_name = '" + CNameTextSup.getText() + "',";
			}
			if(!StreetTextSup.getText().isEmpty()) {
				inString+="address = '" + StreetTextSup.getText() + "',";
			}
			if(!CityTextSup.getText().isEmpty()) {
				inString+="city = '" + CityTextSup.getText() + "',";
			}
			if(!StateTextSup.getText().isEmpty()) {
				inString+="state = '" + StateTextSup.getText() + "',";
			}
			if(!ZipTextSup.getText().isEmpty()) {
				inString+="zip = " + Integer.valueOf(ZipTextSup.getText()) + ",";
			}
			inString=inString.substring(0, inString.length()-1);
			sql = "UPDATE supplier " + "SET " + inString + " WHERE sup_id = " + Integer.valueOf(SIDTextSup.getText()) ;
		}
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		}
		
		catch(SQLException e) {
			System.out.println("Error connection to SQLite database");
			e.printStackTrace();
		}
		
	}
	//This method is used to delete a tuple from the table.
	public static void delete() {
		try {
			String jdbcUrl = "jdbc:sqlite:/C:\\Users\\ventr\\eclipse-workspace\\DB_Project\\db.db";
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql="";
			
			if(!CIDTextCus.getText().isEmpty()) {
				
				sql = "DELETE FROM customer WHERE cust_id =" + Integer.valueOf(CIDTextCus.getText());
			}
			
			if(!PIDTextPro.getText().isEmpty()) {
				sql = "DELETE FROM product WHERE prod_id =" + Integer.valueOf(PIDTextPro.getText());
			}
			
			if(!ONumTextOrd.getText().isEmpty()) {
				sql = "DELETE FROM orders WHERE order_num =" + Integer.valueOf(ONumTextOrd.getText());
			}
			
			if(!SIDTextSup.getText().isEmpty()) {
				sql = "DELETE FROM supplier WHERE sup_id =" + Integer.valueOf(SIDTextSup.getText());
			}
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			}
			
			catch(SQLException e) {
				System.out.println("Error connection to SQLite database");
				e.printStackTrace();
			}
			
	}
	//This method is used to catch actions like clicking the buttons.
	public void actionPerformed(ActionEvent e) { 
		
		if(e.getActionCommand().equals("Insert")){
			insert();
			dbconnect();
			textArea.setText(cArea);
			textArea_2.setText(pArea);
			textArea_1.setText(oArea);
			textArea_3.setText(suArea);
			clearTextFields();
		}
		
		if(e.getActionCommand().equals("Update")){
			update();
			dbconnect();
			textArea.setText(cArea);
			textArea_2.setText(pArea);
			textArea_1.setText(oArea);
			textArea_3.setText(suArea);
			clearTextFields();
		}
		
		if(e.getActionCommand().equals("Delete")){
			delete();
			dbconnect();
			textArea.setText(cArea);
			textArea_2.setText(pArea);
			textArea_1.setText(oArea);
			textArea_3.setText(suArea);
			clearTextFields();
		}
	
	}
	
}

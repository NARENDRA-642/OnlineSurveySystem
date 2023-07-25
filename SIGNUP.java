package Db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class SIGNUP extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField email_1;
	private JTextField city_2;
	protected Component frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIGNUP frame = new SIGNUP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SIGNUP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 773);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username = new JLabel("USERNAME");
		username.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\username.png"));
		username.setForeground(new Color(0, 0, 0));
		username.setFont(new Font("Times New Roman", Font.BOLD, 18));
		username.setBounds(175, 155, 175, 35);
		contentPane.add(username);
		
		textField = new JTextField();
		textField.setBounds(116, 202, 289, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel password = new JLabel("PASSWORD");
		password.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\password.png"));
		password.setFont(new Font("Times New Roman", Font.BOLD, 18));
		password.setBounds(172, 247, 175, 55);
		contentPane.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 304, 289, 41);
		contentPane.add(passwordField);
		
		JButton create = new JButton("CREATE");
		create.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				
				
				String user=textField.getText();
				String Email=email_1.getText();
				String pass=passwordField.getText();
				String city=city_2.getText();
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("driver class loaded successfully");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_db", "root", "Babloo_k@123");
					
					if(user.equals("") || Email.equals("") || pass.equals("") || city.equals("") ) {
						JOptionPane.showMessageDialog(frame, "Please Enter All Details!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
					}
					else {
						PreparedStatement ps=con.prepareStatement("insert into cred values(?,?,?,?)");
					ps.setString(1,textField.getText() );
					ps.setString(2,email_1.getText());
					ps.setString(3,passwordField.getText());
					ps.setString(4,city_2.getText());
					JOptionPane.showMessageDialog(null, "YOUR ACCOUNT IS SUCCESSFULLY CREATED");
//					UserLogin ob=new UserLogin();
//					ob.setVisible(true);
					dispose();
					
					int i=ps.executeUpdate();
					if(i>0) {
						System.out.println("successfull");
					}
					else {
						System.out.println("FAIL");
					}
					}
					
					
					
						
					

				
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		create.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		create.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\sign in.png"));
		create.setBounds(136, 603, 243, 66);
		contentPane.add(create);
		
		JLabel email = new JLabel("EMAIL");
		email.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\email.png"));
		email.setFont(new Font("Times New Roman", Font.BOLD, 18));
		email.setBounds(175, 355, 138, 41);
		contentPane.add(email);
		
		email_1 = new JTextField();
		email_1.setBounds(116, 396, 289, 28);
		contentPane.add(email_1);
		email_1.setColumns(10);
		
		JLabel city = new JLabel("CITY");
		city.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\city.png"));
		city.setFont(new Font("Times New Roman", Font.BOLD, 18));
		city.setBounds(174, 434, 110, 35);
		contentPane.add(city);
		
		city_2 = new JTextField();
		city_2.setBounds(116, 479, 289, 28);
		contentPane.add(city_2);
		city_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\surveysignin.png"));
		lblNewLabel.setBounds(210, 24, 103, 100);
		contentPane.add(lblNewLabel);
	}
}

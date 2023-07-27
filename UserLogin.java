//This is the Home page which has both admin Login and attend as guest
//1.I Used Java Swings For GUI and For backend i used MySql
//2.I basically created a database crud_db with cred table wihich stores admin credentials like username,password,email and city
//3.So when admin tries to login i have implemented a login which compares the password and username which is stored in cred table and if it matches login successfull
//otherwise login unsuccessful warning message will shown 
//if login is successful it will transferred to HomePage.java where the admin can create questions for survey 

package Db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	protected Component frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return  
	 */
	
	
	public UserLogin() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\user.jpeg"));
		setTitle("USER 👤 LOGIN AND SIGN UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1406, 726);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 255));
		contentPane.setForeground(new Color(153, 153, 255));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel User = new JLabel("USERNAME");
		User.setForeground(new Color(0, 0, 0));
		User.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		User.setBounds(810, 116, 161, 27);
		contentPane.add(User);
		
		JLabel lbl2 = new JLabel("PASSWORD");
		lbl2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lbl2.setBounds(810, 200, 139, 33);
		contentPane.add(lbl2);
		
		textField = new JTextField();
		textField.setBounds(959, 117, 217, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(959, 202, 217, 33);
		contentPane.add(passwordField);
		
		JButton LOGIN = new JButton("LOGIN");
		LOGIN.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\login.png"));
		LOGIN.setFont(new Font("Times New Roman", Font.BOLD, 24));
		LOGIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner sc=new Scanner(System.in);
					int flag=0;
					String pass=passwordField.getText();
					String na=textField.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("driver class loaded successfully");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_db", "root", "Babloo_k@123");
					PreparedStatement pst=con.prepareStatement("Select *from cred");
					ResultSet rs=pst.executeQuery();
					if(na.equals("") && pass.equals("")) {
						JOptionPane.showMessageDialog(frame, "Please Enter All Details!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
						JOptionPane.showMessageDialog(frame, "It's Only For developer", "Warning Message", JOptionPane.WARNING_MESSAGE);
					}
					else { 
					while(rs.next()) {
					if(pass.equals(rs.getString("password")) && na.equals(rs.getString("name")) ) {
						flag=1;
						break;
					}
					
				}
					if(flag==1) {
						JOptionPane.showMessageDialog(null, "Login Successfull....");
						HomePage obj1=new HomePage();
						obj1.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Login Failed. Please Try Again...... OR Create New Account");
						
					}
					
					}
				}
			catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
}
		});
		LOGIN.setBounds(804, 323, 161, 42);
		contentPane.add(LOGIN);
		
		JButton Sign_up = new JButton("REGISTER");
		Sign_up.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\register.png"));
		Sign_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				SIGNUP obj=new SIGNUP();
				obj.setVisible(true);
				
				
			}
		});
		Sign_up.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Sign_up.setBackground(new Color(102, 255, 255));
		Sign_up.setForeground(new Color(0, 0, 0));
		Sign_up.setBounds(1083, 323, 203, 42);
		contentPane.add(Sign_up);
		
		JButton GUEST = new JButton("ATTEND AS A GUEST");
		GUEST.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\guest2.png"));
		GUEST.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttendSurvey obja=new AttendSurvey();
				obja.setVisible(true);
				dispose();
			}
		});
		GUEST.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GUEST.setBounds(804, 435, 482, 58);
		contentPane.add(GUEST);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(153, 153, 255));
		lblNewLabel.setBackground(new Color(153, 153, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\HomePage.png"));
		lblNewLabel.setBounds(0, 0, 692, 690);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 255));
		panel.setBounds(0, 540, 637, 150);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}

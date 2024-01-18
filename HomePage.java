package Db;

import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1Q;
	private JTextField textField_option1;
	private JTextField textField_option2;
	private JTextField textField_option3;
	private JTextField textField_option4;
	protected Component frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setTitle("HOME  PAGE 📟 ");
		setFont(new Font("Dialog", Font.BOLD, 22));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\home-page-icon-2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 255));
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(204, 51, 255)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE A SURVEY");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(372, 10, 407, 85);
		contentPane.add(lblNewLabel);
		
		JButton addSurvey = new JButton("ADD SURVEY");
		addSurvey.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\addsurvey.png"));
		addSurvey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				surveyname ob=new surveyname();
				ob.setVisible(true);
				dispose();
				
			}
		});
		addSurvey.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		addSurvey.setBounds(42, 136, 282, 59);
		contentPane.add(addSurvey);
		
		JButton logut = new JButton("LOGOUT");
		logut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserLogin obju=new UserLogin();
					obju.setVisible(true);
					JOptionPane.showMessageDialog(null, "YOU HAVE LOGGED OUT SUCCESSFULLY");
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		logut.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		logut.setBounds(42, 633, 282, 51);
		contentPane.add(logut);
		
		JLabel question = new JLabel("Question: ");
		question.setFont(new Font("Times New Roman", Font.BOLD, 22));
		question.setBounds(474, 105, 116, 34);
		contentPane.add(question);
		
		textField_1Q = new JTextField();
		textField_1Q.setBounds(474, 136, 561, 34);
		contentPane.add(textField_1Q);
		textField_1Q.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Option 1:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(474, 185, 100, 32);
		contentPane.add(lblNewLabel_1);
		
		textField_option1 = new JTextField();
		textField_option1.setBounds(474, 218, 382, 34);
		contentPane.add(textField_option1);
		textField_option1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Option 2:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(474, 262, 100, 32);
		contentPane.add(lblNewLabel_2);
		
		textField_option2 = new JTextField();
		textField_option2.setBounds(474, 301, 382, 34);
		contentPane.add(textField_option2);
		textField_option2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Option 3:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(474, 345, 100, 32);
		contentPane.add(lblNewLabel_3);
		
		textField_option3 = new JTextField();
		textField_option3.setBounds(474, 387, 382, 34);
		contentPane.add(textField_option3);
		textField_option3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Option 4:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_4.setBounds(474, 431, 100, 32);
		contentPane.add(lblNewLabel_4);
		
		textField_option4 = new JTextField();
		textField_option4.setBounds(474, 473, 382, 34);
		contentPane.add(textField_option4);
		textField_option4.setColumns(10);
		
		JButton addquestionbtn = new JButton("ADD QUESTION>");
		addquestionbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String qn=textField_1Q.getText();
				String op1=textField_option1.getText();;
				String op2=textField_option2.getText();
				String op3=textField_option3.getText();
				String op4=textField_option4.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("driver class loaded successfully");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "Babloo_k@123");
					if(qn.equals("") || op1.equals("") || op2.equals("") || op3.equals("") || op4.equals("")) {
						JOptionPane.showMessageDialog(frame, "Please Enter All Details!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
					}
					else {
						PreparedStatement pst=con.prepareStatement("insert into questions(question,option1,option2,option3,option4)values(?,?,?,?,?)");
						pst.setString(1,textField_1Q.getText() );
						pst.setString(2,textField_option1.getText());
						pst.setString(3,textField_option2.getText());
						pst.setString(4,textField_option3.getText());
						pst.setString(5,textField_option4.getText());
						JOptionPane.showMessageDialog(null, "Question is Added successfully");
						int i=pst.executeUpdate();
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
		addquestionbtn.setFont(new Font("Times New Roman", Font.BOLD, 22));
		addquestionbtn.setBounds(474, 548, 595, 65);
		contentPane.add(addquestionbtn);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_1Q.setText("");
				textField_option1.setText("");
				textField_option2.setText("");
				textField_option3.setText("");
				textField_option4.setText("");
				
				
				
			}
		});
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cancelButton.setBounds(871, 647, 198, 65);
		contentPane.add(cancelButton);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String qn=textField_1Q.getText();
				String op1=textField_option1.getText();
				String op2=textField_option2.getText();
				String op3=textField_option3.getText();
				String op4=textField_option4.getText();
				if(!(qn.equals("") && op1.equals("") && op2.equals("") && op3.equals("") && op4.equals(""))) {
					JOptionPane.showMessageDialog(frame, "Last details are not added. If not required, Please clear the fields!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		submit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		submit.setBounds(474, 648, 258, 65);
		contentPane.add(submit);
		
		JButton btnNewButton = new JButton("DELETE SURVEY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("driver class loaded successfully");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "Babloo_k@123");
					PreparedStatement pst=con.prepareStatement("delete from questions values(?,?,?,?,?)");
					
//					ResultSet rs=pst.executeQuery();
					JOptionPane.showMessageDialog(null, "SURVEY IS DELETED SUCCESSFULLY");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\deletesurvey (3).png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		btnNewButton.setBounds(42, 341, 282, 59);
		contentPane.add(btnNewButton);
	}
}

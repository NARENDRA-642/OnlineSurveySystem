package Db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;

public class AttendSurvey extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendSurvey frame = new AttendSurvey();
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
	 ResultSet rs;
		PreparedStatement pst;
		java.sql.Statement st;
		Connection con;
		protected Component frame;
	public AttendSurvey() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 772);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TOPIC = new JLabel("ATTENDING THE SURVEY");
		TOPIC.setFont(new Font("Times New Roman", Font.BOLD, 28));
		TOPIC.setBounds(388, 41, 518, 37);
		contentPane.add(TOPIC);
		
		JRadioButton radioButton1 = new JRadioButton("radio button1");
		
		radioButton1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		radioButton1.setBounds(164, 232, 240, 37);
		contentPane.add(radioButton1);
		
		JLabel qlabel = new JLabel("QUESTION");
		qlabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		qlabel.setBounds(184, 137, 909, 26);
		contentPane.add(qlabel);
		
		JRadioButton radioButton2 = new JRadioButton(" radio button2");
		
		radioButton2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		radioButton2.setBounds(164, 324, 240, 37);
		contentPane.add(radioButton2);
		
		JRadioButton radioButton3 = new JRadioButton(" radio button3");
		radioButton3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		radioButton3.setBounds(164, 412, 240, 37);
		contentPane.add(radioButton3);
		
		JRadioButton radioButton4 = new JRadioButton("radio button4");
		radioButton4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		radioButton4.setBounds(164, 503, 240, 37);
		contentPane.add(radioButton4);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		buttonGroup.add(radioButton4);
		
		
//		JButton btnNewButton_1 = new JButton("NEXT");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				try {
//					if(!rs.isLast()) {
//						
//						rs.next();
//						qlabel.setText(rs.getString(1));
//					         radioButton1.setText(rs.getString(2));
//					         radioButton2.setText(rs.getString(3));
//					         radioButton3.setText(rs.getString(4));
//					         radioButton4.setText(rs.getString(5));
//					        
//						
//						}
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});

		
//		
//		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
//		btnNewButton_1.setBounds(413, 642, 159, 43);
//		contentPane.add(btnNewButton_1);
//	
		
		
		JButton btnNewButton_2 = new JButton("SUBMIT");
		 getContentPane().add(qlabel);
	        getContentPane().add(radioButton1);
	        getContentPane().add(radioButton2);
	        getContentPane().add(radioButton3);
	        getContentPane().add( btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String r1=radioButton1.getText();
				String r2=radioButton2.getText();;
				String r3=radioButton3.getText();
				String r4=radioButton4.getText();
				
				
			
				try {
		    		
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("driver class loaded successfully");
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "Babloo_k@123");
					pst=con.prepareStatement("insert into survey_responses(questions,answers) values(?,?)");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
			
				}
				
			    if (e.getSource() == btnNewButton_2) {
			    	try {
			    		
			    		if(r1.equals("") && r2.equals("") && r3.equals("") && r4.equals("")) {
							JOptionPane.showMessageDialog(frame, "Please Select an Option", "Warning Message", JOptionPane.WARNING_MESSAGE);
						}
			    		
			    		
						String answers = getSelectedOption();
						saveResponseToDatabase(qlabel.getText(), answers);
						
					buttonGroup.clearSelection(); // Clear selected option after submission
					if(!rs.isLast()) {
						moveToNextQuestion();
						JOptionPane.showMessageDialog(null, "submitted succssesfully Attend Next Question");
					}
					else {
						JOptionPane.showMessageDialog(null, "YOUR RESPONSE IS RECORDED SUCCESSFULLY THANK YOU!!!");
						dispose();
						
					}
						
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			    	
			    
				
				
				
				
			}

			private void moveToNextQuestion() {
				// TODO Auto-generated method stub
				try {
					if(!rs.isLast()) {
				
					rs.next();
					qlabel.setText(rs.getString(1));
			             radioButton1.setText(rs.getString(2));
			             radioButton2.setText(rs.getString(3));
			             radioButton3.setText(rs.getString(4));
			             radioButton4.setText(rs.getString(5));
			            
					
					}
				
				
				}
		 catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
//
			private String getSelectedOption() {
				// TODO Auto-generated method stub
				  if (radioButton1.isSelected()) {
			            return radioButton1.getText();
			        } else if (radioButton2.isSelected()) {
			        	
			            return radioButton2.getText();
			        } else if (radioButton3.isSelected()) {
			        	
			        	
			            return radioButton3.getText();
			        }
			        else if(radioButton4.isSelected()){
			        
			        	
			        	return radioButton4.getText();
			        }
			        return "";
				
			}
			
			private void saveResponseToDatabase(String questions, String answers) {
			 try {
		            pst.setString(1, questions);
		            pst.setString(2, answers);
		            pst.executeUpdate();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			}
		});
	
				
				
			
		
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_2.setBounds(897, 642, 159, 43);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\K NARENDRA\\OneDrive\\Desktop\\spongebob.gif"));
		lblNewLabel.setBounds(581, 104, 491, 465);
		contentPane.add(lblNewLabel);
		
//		JButton btnNewButton = new JButton("LAST");
//		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				try {
//					rs.last();
//					
//					qlabel.setText(rs.getString(1));
//			         radioButton1.setText(rs.getString(2));
//			         radioButton2.setText(rs.getString(3));
//			         radioButton3.setText(rs.getString(4));
//			         radioButton4.setText(rs.getString(5));
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
//				
//				
//			}
//		});
//		btnNewButton.setBounds(618, 642, 194, 45);
//		contentPane.add(btnNewButton);
//		
//		JButton btnNewButton_21 = new JButton("PREV");
//		btnNewButton_21.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		btnNewButton_21.setBounds(151, 640, 194, 37);
//		contentPane.add(btnNewButton_21);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver class loaded successfully");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "Babloo_k@123");
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			   rs=st.executeQuery("select *from questions");
			if(rs.next()) {
             qlabel.setText(rs.getString(1));
             radioButton1.setText(rs.getString(2));
             radioButton2.setText(rs.getString(3));
             radioButton3.setText(rs.getString(4));
             radioButton4.setText(rs.getString(5));
             
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}

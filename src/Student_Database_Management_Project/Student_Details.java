package Student_Database_Management_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Student_Details extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	JLabel lblNewLabel_2;
	String Id;
	String Roll_no;
	String Email_Id;
	String Mobile;
	Connection conn= new Database_Connection().dbconnect();  // Creating database connection class object
	
	/**
	 * Launch the application.
	 * @return 
	 */
	// parseFloat method is created for not return any null value
	
	Float ParseFloat(String value) {
		try {
		if(value!=null && value.length()>0) {
			
				return Float.valueOf(value);
			
		}
		else
		{			
			return 0.0f;
	}
		}catch(Exception e5) {
			e5.printStackTrace();
		}
		return 0.0f;
	}// PraseFloat Method is ended
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Details frame = new Student_Details();
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
	public Student_Details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(289, 18, 145, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name*");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(53, 98, 86, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setForeground(new Color(30, 144, 255));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(349, 98, 86, 31);
		contentPane.add(lblLastName);
		
		JLabel lblRollNo = new JLabel("Department*");
		lblRollNo.setForeground(new Color(30, 144, 255));
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRollNo.setBounds(349, 151, 93, 31);
		contentPane.add(lblRollNo);
		
		JLabel lblCourse = new JLabel("Course *");
		lblCourse.setForeground(new Color(30, 144, 255));
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse.setBounds(53, 151, 86, 31);
		contentPane.add(lblCourse);
		
		JLabel lblYear = new JLabel("Year*");
		lblYear.setForeground(new Color(30, 144, 255));
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYear.setBounds(53, 218, 76, 31);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester*");
		lblSemester.setForeground(new Color(30, 144, 255));
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSemester.setBounds(349, 218, 86, 31);
		contentPane.add(lblSemester);
		
		JLabel lblth = new JLabel("10th %");
		lblth.setForeground(new Color(30, 144, 255));
		lblth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblth.setBounds(53, 275, 86, 31);
		contentPane.add(lblth);
		
		JLabel lblth_1 = new JLabel("12th %");
		lblth_1.setForeground(new Color(30, 144, 255));
		lblth_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblth_1.setBounds(349, 275, 86, 31);
		contentPane.add(lblth_1);
		
		JLabel lblSem = new JLabel("Sem 1 %");
		lblSem.setForeground(new Color(30, 144, 255));
		lblSem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSem.setBounds(53, 325, 59, 31);
		contentPane.add(lblSem);
		
		JLabel lblSem_1 = new JLabel("Sem 2 %");
		lblSem_1.setForeground(new Color(30, 144, 255));
		lblSem_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSem_1.setBounds(133, 325, 59, 31);
		contentPane.add(lblSem_1);
		
		JLabel lblSem_2 = new JLabel("Sem 3 %");
		lblSem_2.setForeground(new Color(30, 144, 255));
		lblSem_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSem_2.setBounds(216, 325, 59, 31);
		contentPane.add(lblSem_2);
		
		JLabel lblSem_3 = new JLabel("Sem 4 %");
		lblSem_3.setForeground(new Color(30, 144, 255));
		lblSem_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSem_3.setBounds(289, 325, 59, 31);
		contentPane.add(lblSem_3);
		
		JLabel lblSem_4 = new JLabel("Sem 5 %");
		lblSem_4.setForeground(new Color(30, 144, 255));
		lblSem_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSem_4.setBounds(371, 325, 59, 31);
		contentPane.add(lblSem_4);
		
		JLabel lblSem_5 = new JLabel("Sem 6 %");
		lblSem_5.setForeground(new Color(30, 144, 255));
		lblSem_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSem_5.setBounds(455, 325, 59, 31);
		contentPane.add(lblSem_5);
		
		JLabel lblSem_6 = new JLabel("Sem 7 %");
		lblSem_6.setForeground(new Color(30, 144, 255));
		lblSem_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSem_6.setBounds(546, 325, 59, 31);
		contentPane.add(lblSem_6);
		
		JLabel lblSem_7 = new JLabel("Sem 8  %");
		lblSem_7.setForeground(new Color(30, 144, 255));
		lblSem_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSem_7.setBounds(640, 325, 76, 31);
		contentPane.add(lblSem_7);
		
		firstname = new JTextField();
		firstname.setBounds(139, 99, 110, 31);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(430, 98, 116, 31);
		contentPane.add(lastname);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 275, 116, 31);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(430, 276, 116, 31);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(53, 366, 64, 31);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(128, 366, 64, 31);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(202, 366, 64, 31);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(284, 366, 64, 31);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(366, 366, 64, 31);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(450, 366, 64, 31);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(541, 366, 64, 31);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(640, 366, 64, 31);
		contentPane.add(textField_11);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(133, 161, 116, 21);
		comboBox.addItem("");
		comboBox.addItem("BCA");
		comboBox.addItem("Diploma");
		comboBox.addItem("B.Tech");
		comboBox.addItem("M.Tech");
		comboBox.addItem("MCA");
		contentPane.add(comboBox);
		
	   final JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(440, 157, 106, 21);
		comboBox_1.addItem("");
		comboBox_1.addItem("CSE");
		comboBox_1.addItem("IT");
		comboBox_1.addItem("ECE");
		comboBox_1.addItem("FT");
		comboBox_1.addItem("EEE");
		contentPane.add(comboBox_1);
		
		final JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(133, 224, 116, 21);
		comboBox_2.addItem("");
		comboBox_2.addItem("1st");
		comboBox_2.addItem("2nd");
		comboBox_2.addItem("3rd");
		comboBox_2.addItem("4th");
		contentPane.add(comboBox_2);
		
		final JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setBounds(430, 218, 116, 21);
		comboBox_3.addItem("");
		comboBox_3.addItem("1st");
		comboBox_3.addItem("2nd");
		comboBox_3.addItem("3rd");
		comboBox_3.addItem("4th");
		comboBox_3.addItem("5th");
		comboBox_3.addItem("6th");
		comboBox_3.addItem("7th");
		comboBox_3.addItem("8th");
		contentPane.add(comboBox_3);
		
		// below code is used for add Data
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(firstname.getText().equals("") || lastname.getText().equals("") || comboBox.getSelectedItem().equals("") 
					|| comboBox_1.getSelectedItem().equals("") || comboBox_2.getSelectedItem().equals("")
					|| comboBox_3.getSelectedItem().equals("")) {
				// it checks whether all * fields are filled or not
				JOptionPane.showMessageDialog(null," Please Fill All * Fileds.");
			}
				
			else {
				
				// if all fields * are filed then below code will be execued
				try {
				
				String FirstName,LastName,Course,Year,Department,Semester;
				FirstName=firstname.getText();
				LastName=lastname.getText();
				Course=(String) comboBox.getSelectedItem();        // getSelecteditem is used for taking user choice
				Year=(String) comboBox_1.getSelectedItem();          // getSelecteditem is used for taking user choice
				Department=(String) comboBox_2.getSelectedItem();   // getSelecteditem is used for taking user choice
				Semester=(String) comboBox_3.getSelectedItem();     // getSelecteditem is used for taking user choice
				float Per_10,Per_12,Sem_1,Sem_2,Sem_3,Sem_4,Sem_5,Sem_6,Sem_7,Sem_8;
				
				// takin input of marks from user
				Per_10= ParseFloat(textField_2.getText());
				Per_12=ParseFloat(textField_3.getText());
				Sem_1=ParseFloat(textField_4.getText());
				Sem_2=ParseFloat(textField_5.getText());
				Sem_3=ParseFloat(textField_6.getText());
				Sem_4=ParseFloat(textField_7.getText());
				Sem_5=ParseFloat(textField_8.getText());
				Sem_6=ParseFloat(textField_9.getText());
				Sem_7=ParseFloat(textField_10.getText());
				Sem_8=ParseFloat(textField_11.getText());
				
				
				
					Id=lblNewLabel_2.getText(); //taking login roll no 
					
				Statement	stmt = conn.createStatement();   
				 
				// query for serach data from database to get login user Roll,email,Mobile
				String Query="SELECT Roll_No,Email_ID,Mobile_no FROM studentlogindetails WHERE Roll_No ="+Id;

				
				ResultSet rs = stmt.executeQuery(Query);
				while(rs.next()){
					 Roll_no = rs.getString("Roll_No");
					Email_Id = rs.getString("Email_ID");
				     Mobile=rs.getString("Mobile_No");
				     
				
				}
				
				// query for insert data
				
				String Query2 = "INSERT INTO studentdetails " +
						" (Roll_No,Email_ID,Mobile_No,FirstName,LastName,Course,Department,Year,Semester,Tenth,Twelve,Sem1,Sem2,Sem3,"
						+ "Sem4,Sem5,Sem6,Sem7,Sem8)"
						+ "  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pstmt=conn.prepareStatement(Query2);
						 pstmt.setString(1,Roll_no);
						 pstmt.setString(2,Email_Id);
						 pstmt.setString(3,Mobile);
						 pstmt.setString(4,FirstName);
						 pstmt.setString(5,LastName);
						 pstmt.setString(6,Course);
						 pstmt.setString(7,Department);
						 pstmt.setString(8,Year);
						 pstmt.setString(9,Semester);
						 pstmt.setFloat(10,Per_10);
						 pstmt.setFloat(11,Per_12);
						 pstmt.setFloat(12,Sem_1);
						 pstmt.setFloat(13,Sem_2);
						 pstmt.setFloat(14,Sem_3);
						 pstmt.setFloat(15,Sem_4);
						 pstmt.setFloat(16,Sem_5);
						 pstmt.setFloat(17,Sem_6);
						 pstmt.setFloat(18,Sem_7);
						 pstmt.setFloat(19,Sem_8);
						 
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data Added Successfuly.");
						
				}catch(Exception e2) {
				e2.printStackTrace();
				}
			}
				}
			
		});
		btnNewButton.setForeground(new Color(138, 43, 226));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(289, 430, 141, 21);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for viewing student Page
				Student_Page studentPage=new Student_Page();
				studentPage.label.setText(lblNewLabel_2.getText());
				studentPage.setVisible(true);
				dispose();	
				try {
				conn.close();
				}catch(Exception e3) {
			e3.printStackTrace();		
				}
			}
		});
		btnBack.setForeground(new Color(138, 43, 226));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(640, 10, 94, 21);
		contentPane.add(btnBack);
		
		// code for viewing home page
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home_Page().setVisible(true);
				dispose();
				try {
					conn.close();
					}catch(Exception e4) {
				e4.printStackTrace();		
					}
			}
		});
		btnLogOut.setForeground(new Color(138, 43, 226));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogOut.setBounds(640, 33, 94, 21);
		contentPane.add(btnLogOut);
		
		 lblNewLabel_2 = new JLabel("");
		 lblNewLabel_2.setForeground(new Color(0, 0, 205));
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(87, 10, 162, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(new Color(0, 0, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(10, 10, 67, 26);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 799, 509);
		contentPane.add(lblNewLabel_3);
		// code for set image on jlabel
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photo/photo14.jpg")));
		Image img1=myimage.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel_3.getWidth(),lblNewLabel_3.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		lblNewLabel_3.setIcon(i);
	}
}

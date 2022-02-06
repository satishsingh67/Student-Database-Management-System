package Student_Database_Management_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Student_Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	JLabel label;
	Connection conn= new Database_Connection().dbconnect(); // Creating database connection class object
	private JTextField textField_1;
	String captcha;
	CaptchVerification cv=new CaptchVerification();// Creating object of Captcha Class 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Login frame = new Student_Login();
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
	public Student_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBackground(new Color(245, 255, 250));
		lblNewLabel.setBounds(284, 0, 179, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Id*");
		lblNewLabel_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(149, 132, 64, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setForeground(new Color(75, 0, 130));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(149, 177, 91, 35);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(250, 130, 190, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 177, 190, 35);
		contentPane.add(passwordField);
		
		// Here code is for Login 
		
		JButton btnNewButton = new JButton(" Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				String Roll_No=textField.getText();          // Taking Roll_No from user
				String Password=passwordField.getText();     // Taking password from user
				String captcha=textField_1.getText();        // Taking captcha from user
			String captchavalue=label.getText(); 
			
			// Checking whether all fileds are filled up or not, if not then a message is shown to user using JotionPane
			
			if(textField.getText().equals("") && passwordField.getText().equals("") && textField_1.getText().equals(""))
			{
				
				JOptionPane.showMessageDialog(null,"Please Fill All * Fields.");
			}
			else if(textField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please Fill User Id.");
			}
			else if(passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please Fill Password.");
			}
			else if(textField_1.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please Fill Captcha.");
			}
			else {
			
				//If all fileds are filled up then it cheks wheter captcha is right or wrong
				
			if(captcha.equals(captchavalue)) {
				
				//Prepared Statement is used for parametrized query
				PreparedStatement pstmt=conn.prepareStatement("Select * from studentlogindetails where Roll_No=?"
						+ " and Password=?");
				pstmt.setString(1,Roll_No);   // Setting dynamically value for PreparedStatement
				pstmt.setString(2,Password);  // Setting dynamically value for PreparedStatement
				ResultSet rst=pstmt.executeQuery(); // for serach query
				if(rst.next()) {
					// if query is true means roll no and password is matched then login is approved
					Student_Page sd=new Student_Page();
					sd.label.setText(Roll_No);
					
					sd.setVisible(true);
					dispose();
				}else {
					// If Password and Roll no is not matched then it will shows there is no account
					
					JOptionPane.showMessageDialog(null,"No Account Is Found.");
				}
			}else {
				//If captcha is wrong then it will show wrong captcha
				
				JOptionPane.showMessageDialog(null,"Wrong Captcha.");
			}
			}
				
				}catch(Exception e2) {
				e2.printStackTrace();
				}
				
				}
			
			// Here Sql code is ended
		});
		btnNewButton.setForeground(new Color(65, 105, 225));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(298, 267, 142, 33);
		contentPane.add(btnNewButton);
		
		// Click here is used for viewing Student_Registration
		
		JButton btnClickHere = new JButton("New User");
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Student_Registration().setVisible(true); 
				dispose();
			}
		});
		btnClickHere.setForeground(new Color(65, 105, 225));
		btnClickHere.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClickHere.setBounds(298, 388, 142, 25);
		contentPane.add(btnClickHere);
		
		// Home is used for viewing Home Page
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home_Page().setVisible(true);
				dispose();
			}
		});
		btnHomePage.setForeground(new Color(65, 105, 225));
		btnHomePage.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHomePage.setBounds(10, 49, 116, 21);
		contentPane.add(btnHomePage);
		
		
		JLabel lblCaptcha = new JLabel("Enter Captcha");
		lblCaptcha.setForeground(new Color(75,0,130));
		lblCaptcha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCaptcha.setBounds(146, 222, 96, 35);
		contentPane.add(lblCaptcha);
		
		 label = new JLabel("");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(250, 222, 70, 35);
		
		captcha=String.valueOf(cv.captcha(6));
		label.setText(captcha);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(318, 216, 122, 35);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Refresh Captcha");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				captcha=String.valueOf(cv.captcha(6));   // Calling captcha method of Captcha class 
				label.setText(captcha);                  // Setting captcha value on label
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(0, 0, 139));
		btnNewButton_1.setBounds(450, 215, 141, 35);
		contentPane.add(btnNewButton_1);
		
		// Beleow Logic is used for recovering account
		
		JButton btnClickHere_1 = new JButton("Forget Password");
		btnClickHere_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Forget_Password().setVisible(true);
				dispose();
			}
		});
		btnClickHere_1.setForeground(new Color(65, 105, 225));
		btnClickHere_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClickHere_1.setBounds(298, 310, 142, 35);
		contentPane.add(btnClickHere_1);
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Don't Have Account Click  Below");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(250, 355, 234, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(0, 0, 799, 509);
		
		//Below code is used for Set icon on Jlabel
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photo/photo2.jpg")));
		Image img1=myimage.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel_4.getWidth(),lblNewLabel_4.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		lblNewLabel_4.setIcon(i);
		contentPane.add(lblNewLabel_4);
	}
}

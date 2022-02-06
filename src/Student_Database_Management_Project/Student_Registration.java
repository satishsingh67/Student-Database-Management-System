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
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Student_Registration extends JFrame {

	private JPanel contentPane;
	private JTextField Email;
	private JTextField Mobile;
	private JPasswordField password;
	JLabel label;
	JTextField textField_1;
	Connection conn= new Database_Connection().dbconnect(); //Creating dataabse object
	private JTextField Roll_No;
	String captcha;
	CaptchVerification cv=new CaptchVerification(); // Creating captcha class object
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Registration frame = new Student_Registration();
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
	public Student_Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  813, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setForeground(new Color(51, 0, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(258, 35, 169, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email ID*");
		lblNewLabel_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(132, 168, 96, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMobileNo = new JLabel("Mobile No*");
		lblMobileNo.setForeground(new Color(148, 0, 211));
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMobileNo.setBounds(132, 237, 96, 29);
		contentPane.add(lblMobileNo);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setForeground(new Color(148, 0, 211));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(132, 292, 96, 29);
		contentPane.add(lblPassword);
		
		Email = new JTextField();
		Email.setBounds(258, 165, 169, 40);
		contentPane.add(Email);
		Email.setColumns(10);
		
		Mobile = new JTextField();
		Mobile.setColumns(10);
		Mobile.setBounds(258, 226, 169, 40);
		contentPane.add(Mobile);
		
		password = new JPasswordField();
		password.setBounds(258, 288, 169, 42);
		contentPane.add(password);
		
		// code for sign up
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to check whether all fileds are filed or not
				if(Roll_No.getText().equals("") || Email.getText().equals("") || Mobile.getText().equals("") || 
						password.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill All * Fields.");
				}
				else if(textField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill Captcha.");
				}
				else {
			try {
			String Student_Roll_No=(Roll_No.getText());
			String email=Email.getText();
			String  mobile=(Mobile.getText());
			String Password=password.getText();

			String captcha=textField_1.getText();
			String captchavalue=label.getText();
			if(captcha.equals(captchavalue)) {
			
				// code to create student account
             String sql = "INSERT INTO StudentLoginDetails " +
                           " (Roll_No,Email_ID,Mobile_No,Password)  VALUES (?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,Student_Roll_No);
            pstmt.setString(2,email);
            pstmt.setString(3,mobile);
            pstmt.setString(4,Password);
            pstmt.executeUpdate();
            conn.close();
             JOptionPane.showMessageDialog(null,"Account Created Successfuly"+"\n"+"Click Back To Login.");
			}else {
				JOptionPane.showMessageDialog(null,"Wrong Captcha.");
			}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
			}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(287, 397, 102, 21);
		contentPane.add(btnNewButton);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to view Home Page
			new Home_Page().setVisible(true);
			dispose();
			}
			
		});
		btnHomePage.setForeground(new Color(165, 42, 42));
		btnHomePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHomePage.setBounds(10, 35, 129, 29);
		contentPane.add(btnHomePage);
		
		Roll_No = new JTextField();
		Roll_No.setColumns(10);
		Roll_No.setBounds(258, 101, 169, 40);
		contentPane.add(Roll_No);
		
		JLabel lblName = new JLabel("Roll No*");
		lblName.setForeground(new Color(148, 0, 211));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(132, 112, 80, 29);
		contentPane.add(lblName);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to View Login Page
				new Student_Login().setVisible(true);
				dispose();
				
			}
		});
		btnBack.setForeground(new Color(0, 0, 128));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(611, 35, 102, 21);
		contentPane.add(btnBack);
		
		
		JLabel lblCaptcha = new JLabel("Enter Captcha");
		lblCaptcha.setForeground(new Color(148, 0, 211));
		lblCaptcha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCaptcha.setBounds(132, 341, 96, 35);
		contentPane.add(lblCaptcha);
		
		 label = new JLabel("");
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(258, 340, 84, 35);
		
		captcha=String.valueOf(cv.captcha(6));
		label.setText(captcha);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(331, 340, 96, 35);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Refresh Captcha");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				captcha=String.valueOf(cv.captcha(6));
				label.setText(captcha);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(0, 0, 139));
		btnNewButton_1.setBounds(437, 342, 141, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 799, 509);
		// code to set Image on Jlabel
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photo/photo7.jpg")));
		Image img1=myimage.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		lblNewLabel_2.setIcon(i);
		contentPane.add(lblNewLabel_2);
		
		
	}
}

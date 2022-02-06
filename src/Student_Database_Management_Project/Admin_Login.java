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

import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Admin_Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	Connection conn= new Database_Connection().dbconnect(); // creating object of Databse Class
	JLabel label;
	JTextField textField_1;
	String captcha;
	CaptchVerification cv=new CaptchVerification();  // Creating object of captcha Class
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login frame = new Admin_Login();
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
	public Admin_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  813, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(276, 10, 121, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Id*");
		lblNewLabel_1.setForeground(new Color(138, 43, 226));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(128, 137, 81, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setForeground(new Color(138, 43, 226));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(128, 209, 100, 38);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 212, 185, 38);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserId=textField.getText();          // Taking Roll_No from user
				String Password=passwordField.getText();     // Taking password from user
				String captcha=textField_1.getText();        // Taking Capcha from user
				String captchavalue=label.getText();         // Taking Captcha from label
			
				// checking whether all fields are filled or not
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
				try {
				if(captcha.equals(captchavalue)) {
			
				
				//Prepared Statement is used for parametrized query
				PreparedStatement pstmt=conn.prepareStatement("Select * from adminlogin where userid=?"
						+ " and password=?");
				pstmt.setString(1,UserId);   
				pstmt.setString(2,Password);
				ResultSet rst=pstmt.executeQuery(); // for serach query
				if(rst.next()) {
					// if query is true means roll no and password is matched then login is approved
					new Admin_View().setVisible(true);
					dispose();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Wrong Details");
				}
			}
				else {
				JOptionPane.showMessageDialog(null,"Wrong Captcha");
			}
				}
				catch(Exception e2) {
				e2.printStackTrace();
				}
				}
				
			}
		});
		btnNewButton.setForeground(new Color(138, 43, 226));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(276, 323, 94, 38);
		contentPane.add(btnNewButton);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for viewing Home Page
				Home_Page home=new Home_Page();
				home.setVisible(true);
				dispose();
			}
		});
		btnHomePage.setForeground(new Color(153, 50, 204));
		btnHomePage.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHomePage.setBounds(10, 55, 114, 25);
		contentPane.add(btnHomePage);
		
		textField = new JTextField();
		textField.setBounds(238, 140, 185, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCaptcha = new JLabel("Enter Captcha");
		lblCaptcha.setForeground(new Color(148, 0, 211));
		lblCaptcha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCaptcha.setBounds(128, 277, 96, 35);
		contentPane.add(lblCaptcha);
		
		 label = new JLabel("");
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(238, 276, 84, 35);
		
		captcha=String.valueOf(cv.captcha(6));
		label.setText(captcha);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(327, 278, 96, 35);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Refresh Captcha");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				captcha=String.valueOf(cv.captcha(6)); // Calling captcha method from captcha Class
				label.setText(captcha);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(0, 0, 139));
		btnNewButton_1.setBounds(433, 277, 141, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 799, 509);
		contentPane.add(lblNewLabel_2);
		// code for set image on Jlabel
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photo/photo11.jpg")));
		Image img1=myimage.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		lblNewLabel_2.setIcon(i);
		
	}
}

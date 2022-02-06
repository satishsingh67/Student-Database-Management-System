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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Forget_Password extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
String Roll_No;
String Mobile_No;
Connection conn= new Database_Connection().dbconnect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forget_Password frame = new Forget_Password();
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
	public Forget_Password() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recover Account");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(296, 63, 182, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Roll No*");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(161, 143, 125, 35);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(296, 145, 167, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterMobileNo = new JLabel("Enter Mobile No*");
		lblEnterMobileNo.setForeground(new Color(0, 0, 128));
		lblEnterMobileNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterMobileNo.setBounds(161, 188, 133, 35);
		contentPane.add(lblEnterMobileNo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(296, 190, 167, 35);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Recover Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roll_No=textField.getText();
				Mobile_No=textField_1.getText();
				try {
					if(textField.getText().equals("")  && textField_1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Fill All * Fields.");
					}
					else if(textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Please Fill Roll No.");
					}
					else if(textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Please Fill Mobile No.");
					}
					else {
				String query="Select Password from studentlogindetails where Roll_No="+Roll_No+" and Mobile_No="+Mobile_No;
				PreparedStatement pstmt=conn.prepareStatement(query);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					String password=rs.getString("Password");
					JOptionPane.showMessageDialog(null,"Your Account is Recovered Successfully."+"\n"+"Your Password is:"+password+"\n"+"Click Back To Login.");
				}
				else {
					JOptionPane.showMessageDialog(null,"Account Doesn't Exixt.");
				}
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(153, 50, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(296, 252, 167, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Student_Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(22, 20, 84, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 799, 509);
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photo/photo6.jpg")));
		Image img1=myimage.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		lblNewLabel_2.setIcon(i);
		contentPane.add(lblNewLabel_2);
	}
}

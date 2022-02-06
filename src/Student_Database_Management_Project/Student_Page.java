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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.sql.*;

public class Student_Page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JTable table_1;
	JTable table;
	JLabel label;
String ID;
Connection conn= new Database_Connection().dbconnect(); // creating database connection object
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Page frame = new Student_Page();
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
	public Student_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome ");
		lblNewLabel.setForeground(new Color(138, 43, 226));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(220, 83, 123, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Details");
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(220, 177, 102, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblViewData = new JLabel("View Details");
		lblViewData.setForeground(new Color(128, 0, 128));
		lblViewData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblViewData.setBounds(220, 229, 102, 28);
		contentPane.add(lblViewData);
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for viewing student details page
				Student_Details	sd=new Student_Details();
				sd.setVisible(true);
				sd.lblNewLabel_2.setText( label.getText());
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(332, 190, 109, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Roll No");
		lblNewLabel_2.setForeground(new Color(128, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(220, 278, 102, 21);
		contentPane.add(lblNewLabel_2);
		
		 label = new JLabel("");
			label.setForeground(new Color(138, 43, 226));
			label.setFont(new Font("Tahoma", Font.BOLD, 20));
			label.setBounds(345, 83, 160, 37);
			contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(332, 272, 124, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// code for fetech data from database
		JButton btnViewDetails = new JButton("View Details");
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int column;
				ID=textField.getText();
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter Roll No.");
				}
				else {
				
Statement	stmt = conn.createStatement();
				
PreparedStatement pstmt	=conn.prepareStatement("Select * from studentdetails where Roll_No=?");
pstmt.setString(1,ID);   

ResultSet rst=pstmt.executeQuery(); // for serach query
if(rst.next()) {

			String Query="SELECT FirstName,LastName,Email_ID,Mobile_No,Roll_No,Tenth,Twelve,Course,Department,Year,Semester FROM studentdetails WHERE Roll_No ="+ID;
			PreparedStatement pstmt1=conn.prepareStatement(Query);
				ResultSet rs=pstmt1.executeQuery();
				ResultSetMetaData rd=rs.getMetaData();// getMetaData is used for getting information about table in database
				column=rd.getColumnCount();  // geting total no of column in table
				DefaultTableModel df=(DefaultTableModel) table.getModel(); //getting the information about table  
				df.setRowCount(0);  
				while(rs.next()) {
					// belwo code is used for set the value in table after fetching data from database 
					Vector<String> v1=new Vector<String>();  //Vector is used for creating dynamic array
					for(int i=1;i<=column;i++) {
						v1.add(rs.getString("FirstName"));    //getstring method is used for getting 'FirstName' Column of table value from database
						v1.add(rs.getString("LastName"));
						v1.add(rs.getString("Email_ID"));
						v1.add(rs.getString("Mobile_No"));
						v1.add(rs.getString("Roll_No"));
						v1.add(rs.getString("Tenth"));
						v1.add(rs.getString("Twelve"));
						v1.add(rs.getString("Course"));
						v1.add(rs.getString("Department"));
						v1.add(rs.getString("Year"));
						v1.add(rs.getString("Semester"));
					}
					df.addRow(v1);
				}
				
				String Query1="SELECT Sem1,Sem2,Sem3,Sem4,Sem5,Sem6,Sem7,Sem8 FROM studentdetails WHERE Roll_No ="+ID;
				PreparedStatement pstmt2=conn.prepareStatement(Query1);
					ResultSet rs1=pstmt2.executeQuery();
					ResultSetMetaData rd1=rs1.getMetaData();
					int column1=rd1.getColumnCount();
					DefaultTableModel df1=(DefaultTableModel) table_1.getModel();
					df1.setRowCount(0);
					while(rs1.next()) {
						Vector<String> v2=new Vector<String>();
						for(int i=1;i<=column;i++) {
							v2.add(rs1.getString("Sem1"));
							v2.add(rs1.getString("Sem2"));
							v2.add(rs1.getString("Sem3"));
							v2.add(rs1.getString("Sem4"));
							v2.add(rs1.getString("Sem5"));
							v2.add(rs1.getString("Sem6"));
							v2.add(rs1.getString("Sem7"));
							v2.add(rs1.getString("Sem8"));
						
						}
						df1.addRow(v2);
					}
				
					JOptionPane.showMessageDialog(null,"Data Fetech Successfuly.");
}else {
	JOptionPane.showMessageDialog(null,"No Data Is Found.");
}
				}
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnViewDetails.setForeground(new Color(139, 0, 0));
		btnViewDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewDetails.setBounds(476, 275, 124, 21);
		contentPane.add(btnViewDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 327, 768, 59);
		contentPane.add(scrollPane);
		
		 table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"FirstName","LastName", "Email_ID", "Mobile_No", "Roll_No", "Tenth", "Twelve", "Course", "Department" ,"Year", "Semester"
			}
		));
		table.setToolTipText("");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 396, 768, 59);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Sem1", "Sem2", "Sem3", "Sem4", "Sem5", "Sem6", "Sem7", "Sem8"
			}
		));
		table_1.setToolTipText("");
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for viewing Home_Page
				Home_Page hm=new Home_Page();
				hm.setVisible(true);
				dispose();
				try {
					conn.close();
					}catch(Exception e4) {
				e4.printStackTrace();		
					}
			}
		});
		btnLogOut.setForeground(new Color(139, 0, 0));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogOut.setBounds(578, 22, 124, 21);
		contentPane.add(btnLogOut);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 799, 509);
		contentPane.add(lblNewLabel_3);
		// code for set image on Jlabel
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photo/photo8.jpg")));
		Image img1=myimage.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel_3.getWidth(),lblNewLabel_3.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		lblNewLabel_3.setIcon(i);
		
	}
}

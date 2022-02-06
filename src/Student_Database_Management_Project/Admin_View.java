package Student_Database_Management_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin_View extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
String ID;
String columnName;
String UpdatedValue;
	String Roll_No;
	int column;
	Connection conn= new Database_Connection().dbconnect(); // Creating oject of database class
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_View frame = new Admin_View();
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
	public Admin_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  813, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin ");
		lblNewLabel.setForeground(new Color(153, 50, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(308, 36, 156, 51);
		contentPane.add(lblNewLabel);
		
		// code for view Data of student
		
		JButton btnNewButton = new JButton("View Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter Roll No.");
				}
				else {
				try {
					
				ID=textField.getText();  //geting Student Roll No 
                Statement	stmt = conn.createStatement();
				
                PreparedStatement pstmt=conn.prepareStatement("Select * from studentdetails where Roll_No=?");
                pstmt.setString(1,ID);   

                ResultSet rst=pstmt.executeQuery(); // for serach query
                if(rst.next()) {
			    String Query="SELECT FirstName,LastName,Email_ID,Mobile_No,Roll_No,Tenth,Twelve,Course,Department,Year,Semester FROM studentdetails WHERE Roll_No ="+ID;
			    PreparedStatement pstmt2=conn.prepareStatement(Query);
				ResultSet rs=pstmt2.executeQuery();
	
				ResultSetMetaData rd=rs.getMetaData(); //getMetadata is used for getting information about table of database
				column=rd.getColumnCount();            // getting table column count
				DefaultTableModel df=(DefaultTableModel) table_1.getModel(); // getModel is used to get Table infomation
				df.setRowCount(0);
				while(rs.next()) {
					Vector<String> v1=new Vector<String>();   //Vector is used for creating dynamic array
					for(int i=1;i<=column;i++) {
						v1.add(rs.getString("FirstName"));     //getstring method is used for getting 'FirstName' Column of table value from database
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
				PreparedStatement pstmt1=conn.prepareStatement(Query1);
					ResultSet rs1=pstmt1.executeQuery();
					ResultSetMetaData rd1=rs1.getMetaData();
					int column1=rd1.getColumnCount();
					DefaultTableModel df1=(DefaultTableModel) table.getModel();
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
		}
		else {
		
			DefaultTableModel df=(DefaultTableModel) table_1.getModel();
			df.setRowCount(0);
			Vector<String> v1=new Vector<String>();
			for(int i=1;i<=column;i++) {
				v1.add((" "));
			}
			DefaultTableModel df1=(DefaultTableModel) table.getModel();
			df1.setRowCount(0);
			Vector<String> v2=new Vector<String>();
			for(int i=1;i<=column;i++) {
				v2.add((" "));
				
			}
					JOptionPane.showMessageDialog(null,"No data is Found.");
		}
				
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(139, 0, 139));
		btnNewButton.setBounds(236, 139, 138, 42);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter Roll No.");
				}
				else if( textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter A Specific Column Value To Update.");
				}
				else {
					
				
				UpdatedValue=textField_1.getText();  //Getting the value of updateded value of selected column
				try {
					String query="update studentdetails set "+columnName+"=? WHERE Roll_No ="+ID;
					PreparedStatement pstmt1=conn.prepareStatement(query);
					pstmt1.setString(1,UpdatedValue);
					pstmt1.executeUpdate();
					
					String Query="SELECT FirstName,LastName,Email_ID,Mobile_No,Roll_No,Tenth,Twelve,Course,Department,Year,Semester FROM studentdetails WHERE Roll_No ="+ID;
					PreparedStatement pstmt=conn.prepareStatement(Query);
						ResultSet rs=pstmt.executeQuery();
						ResultSetMetaData rd=rs.getMetaData();
						column=rd.getColumnCount();
						DefaultTableModel df=(DefaultTableModel) table_1.getModel();
						df.setRowCount(0);
						while(rs.next()) {
							Vector<String> v1=new Vector<String>();
							for(int i=1;i<=column;i++) {
								v1.add(rs.getString("FirstName"));
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
							DefaultTableModel df1=(DefaultTableModel) table.getModel();
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
						
					
					JOptionPane.showMessageDialog(null, "Data Updated Successfully.");
					textField_1.setText("");
				}catch(Exception e5) {
					e5.printStackTrace();
				}
				}
				
			}
		});
		btnUpdateDetails.setForeground(new Color(139, 0, 139));
		btnUpdateDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateDetails.setBounds(404, 139, 156, 42);
		contentPane.add(btnUpdateDetails);
		
		JButton btnDeleteDetails = new JButton("Delete Details");
		btnDeleteDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter Roll No.");
				}
				else {
			try {
				String query="SELECT Sem1,Sem2,Sem3,Sem4,Sem5,Sem6,Sem7,Sem8 FROM studentdetails WHERE Roll_No ="+ID;
				String query1 = "Select * FROM studentlogindetails " +"WHERE Roll_No ="+ID;
				PreparedStatement pstmt1=conn.prepareStatement(query);
				PreparedStatement pstmt2=conn.prepareStatement(query1);
					ResultSet rs1=pstmt1.executeQuery();
					ResultSet rs2=pstmt2.executeQuery();
				if(rs1.next() && rs2.next()) {
				
				Statement	stmt = conn.createStatement();
				String sql = "DELETE FROM studentdetails " +"WHERE Roll_No ="+ID;
				String sql1 = "DELETE FROM studentlogindetails " +"WHERE Roll_No ="+ID;
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql1);
				DefaultTableModel df=(DefaultTableModel) table_1.getModel();
				df.setRowCount(0);
				Vector<String> v1=new Vector<String>();
				for(int i=1;i<=column;i++) {
					v1.add((" "));
				}
				DefaultTableModel df1=(DefaultTableModel) table.getModel();
				df1.setRowCount(0);
				Vector<String> v2=new Vector<String>();
				for(int i=1;i<=column;i++) {
					v2.add((" "));	
				}
				JOptionPane.showMessageDialog(null, "Data Deleted Successfully.");
				}
				else {
					JOptionPane.showMessageDialog(null,"No Record Is Found To Delete.");
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
				}
			}
		});
		btnDeleteDetails.setForeground(new Color(139, 0, 139));
		btnDeleteDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteDetails.setBounds(581, 139, 138, 42);
		contentPane.add(btnDeleteDetails);
		
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
		btnLogOut.setForeground(new Color(139, 0, 139));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogOut.setBounds(606, 10, 113, 35);
		contentPane.add(btnLogOut);
		
		textField = new JTextField();
		textField.setBounds(76, 139, 135, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Roll No");
		lblNewLabel_1.setForeground(new Color(106, 90, 205));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(90, 108, 94, 21);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 356, 766, 95);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df=(DefaultTableModel) table.getModel();
			    int row=table.getSelectedRow();           //getting the row no after mouse click
			   int column=table.getSelectedColumn();      //getting the column no after mouse click
			   columnName=table.getColumnName(column);     // getting the column name of selected column
			  textField_1.setText( df.getValueAt(row,column).toString());  // getting the value of selected column
			 	
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sem1", "Sem2", "Sem3", "Sem4", "Sem5", "Sem6", "Sem7", "Sem8"
			}
		));
		table.setToolTipText("");
			table.setToolTipText("");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 240, 766, 95);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df=(DefaultTableModel) table_1.getModel();
			    int row=table_1.getSelectedRow();               //getting the row no after mouse click
			   int column=table_1.getSelectedColumn();          //getting the column no after mouse click
			   columnName=table_1.getColumnName(column);          // getting the column name of selected column
			  textField_1.setText( df.getValueAt(row,column).toString());  // getting the value of selected column
			} 
		});
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"FirstName","LastName", "Email_ID", "Mobile_No", "Roll_No", "Tenth", "Twelve", "Course", "Department" ,"Year", "Semester"
				}
			));
		
		textField_1 = new JTextField();
		textField_1.setBounds(414, 191, 128, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 799, 509);
		contentPane.add(lblNewLabel_2);
		// code to set Image on Jlabel
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photo/photo13.jpg")));
		Image img1=myimage.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		lblNewLabel_2.setIcon(i);
	}
}

package Student_Database_Management_Project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home_Page extends JFrame {
	private static final int BOLD = 0;
	 JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 // Here a and b are the values for string transition
	 int a=750;   
	    int b=70;
	   
	// Here paint method is used for String transition
	 public void paint(Graphics  gp)
	    {
		 
	        super.paint(gp);
	        Graphics2D g2d= (Graphics2D) gp;
	        g2d.setColor(Color.BLUE);
	        g2d.setFont(new Font("BOLD"+"ITALIC", BOLD, 25));   // This Line is used for set font gexture
	             
	        g2d.drawString("Welcome TO Guru Nanak Institute of Technology.Student DataBase Management System Project Made By Satish Singh", a,b);
	      
	        try {
	            Thread.sleep(50);
	           
	            a-=5;
	          
	            if(a<-1300)
	        {
	       
	            a=750;
	        }
	        repaint();
	        
	               
	        } catch (InterruptedException ex) {
	            JOptionPane.showMessageDialog(this, ex);
	        }
	            
	    }// Here paint method is ended
	    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Page frame = new Home_Page();
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
	public Home_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,  813, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(295, 72, 140, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdminPanel = new JLabel("Admin Login");
		lblAdminPanel.setForeground(new Color(248, 248, 255));
		lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdminPanel.setBackground(Color.WHITE);
		lblAdminPanel.setBounds(490, 137, 155, 79);
		contentPane.add(lblAdminPanel);
		
		// Here Click button is used for view Student_Login Page
		
		JButton btnNewButton = new JButton("Click Here");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Student_Login().setVisible(true); // anonymous object is created for viewing student login page
				dispose(); // dispose() method is used for close the current frame
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(126, 218, 132, 21);
		contentPane.add(btnNewButton);
		
		// Here Click button is used for view Admin_Login Page
		
		JButton button = new JButton("Click Here");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_Login().setVisible(true); // anonymous object is created for viewing admin login page
				dispose(); // dispose() method is used for close the current frame
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.setBounds(490, 218, 132, 21);
		contentPane.add(button);
		
		JLabel lblStudentLogin = new JLabel("Student Login");
		lblStudentLogin.setForeground(new Color(248, 248, 255));
		lblStudentLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentLogin.setBackground(Color.WHITE);
		lblStudentLogin.setBounds(126, 137, 155, 79);
		contentPane.add(lblStudentLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0,  799, 509);
		contentPane.add(lblNewLabel_1);
		
		// Below code is used for set Icon on Jlabel 
		
		ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photo/photo1.jpg")));
		Image img1=myimage.getImage();
		Image img2=img1.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		lblNewLabel_1.setIcon(i);
		
		
	}
}

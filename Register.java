package ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.*;
import java.sql.*;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Register {
	static SQLService service=null;
	static Button b1=null;
	static TextField t1=null;
	static TextField t2=null;
	
	public static void main(String[] args) throws Exception {
		try {
		service=new SQLService();
		service.getConnection();
		}catch(Exception e) {
			System.out.println(e);
		}
		 
		Frame frame=createFrame();
		initListeners(frame);
		
	
		
		
	}
	
	public static Frame createFrame() {
		Frame frame=new Frame("Register");
		frame.setLayout(null);
		b1=new Button("Register");
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		Label l1=new Label("Mobile Number: ");
		Label l2=new Label("PIN : ");
		
		t1=new TextField();
		 t2=new TextField();
		t2.setEchoChar('*');
		t1.setBounds(185,137,100,25);
		b1.setSize(50,30 );
		b1.setBounds(160, 262, 80, 25);
		l1.setBounds(75,137,110,25);
		l1.setBackground(new Color(0,11,34));
		l1.setForeground(new Color(137, 207, 240));
		l1.setFont(new Font("Roboto", Font.BOLD, 13));;
		t2.setBounds(185,192,100,25);
		l2.setBounds(75,192,60,25);
		l2.setFont(new Font("Roboto", Font.BOLD, 14));
		l2.setBackground(new Color(0,11,34));
		l2.setForeground(new Color(137, 207, 240));
		frame.add(b1);
		frame.add(t1);
		frame.add(l2);
		frame.add(t2);
		frame.add(l1);
		frame.setVisible(true);
		frame.setBackground(new Color(0,11,34));
		frame.setSize(400, 400);
		frame.setResizable(false);
		frame.setLocation(200, 200);
		frame.setLocationRelativeTo(null);
		return frame;
	}
	
	public static void initListeners(Frame frame) {
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		t1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t2.requestFocus();
				
			}
		});
			t2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
				login();
				
			}
		});
		b1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				login();
			}
				
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				t2.requestFocus();
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void login() {
		try {
			String mobileNumber=t1.getText();
			String pin=t2.getText();

			if(mobileNumber.length()!=10) {
				JOptionPane.showMessageDialog(null, "Enter a valid mobile number","Error", JOptionPane.ERROR_MESSAGE, null);
				return;
			}else if(pin.length()<6 || pin.length()>8) {
				JOptionPane.showMessageDialog(null, "PIN number must be of 6 to 8 characters","Error", JOptionPane.ERROR_MESSAGE, null);
				return;
			}
			String query="SELECT * from student where mobile_number="+mobileNumber+" AND "+"pin="+pin;

			ResultSet rs=service.executeQuery(query);

			if(rs.next()) {
				System.out.println("Successfully Logged in");
			}else {
				System.out.println("Login failed ");
			}
			}catch(Exception ex){
				System.out.println("Error while loggin in"+ex);
			}
	}
}

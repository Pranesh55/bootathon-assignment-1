package ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Dashboard extends Frame {
	static SQLService service=new SQLService();
	static UserDetails user=new UserDetails();
	public Dashboard(UserDetails user) {
		this.user=user;
	}
	Graphics g=null;
	Button profileBtn=null;
	Button editProfileBtn=null;
	Button deleteBtn=null;
	public static void main(String[] args) {
		Dashboard obj=new Dashboard(user);
		obj.createUI();
		obj.initListeners();
		service.getConnection();
	}


private  void createUI(){  
	setTitle("Dashboard");
	g=getGraphics();
	setVisible(true);
	setBackground(new Color(0,11,34));
	setSize(400, 400);
	setResizable(false);
	setLayout(null);
	setLocationRelativeTo(null);
	Label welcome=new Label("Welcome , "+user.firstName+" "+user.lastName);
	welcome.setSize(100,25);
	welcome.setBounds(100, 50, 200, 25);
	welcome.setBackground(new Color(0,11,34));
	welcome.setForeground(Color.white);
	welcome.setFont(new Font("Roboto", Font.BOLD, 14));
	profileBtn=new Button("Profile");
	profileBtn.setBounds(75, 100, 100, 100);

	profileBtn.paint(g);
	add(profileBtn);	
	 editProfileBtn=new Button("Edit Profile");
	editProfileBtn.setBounds(225, 100, 100, 100);
	add(editProfileBtn);
	
	deleteBtn=new Button("Delete Account");
	deleteBtn.setBounds(75, 250, 100, 100);
	add(deleteBtn);
	
	add(welcome);
	
   
}

public void initListeners() {
	
	addWindowListener(new WindowAdapter(){
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	});
	
	editProfileBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String [] s={"1"};
			try {
			new EditProfile(user).main(s);;
			dispose();
			}catch(Exception e1) {
				
			}
			
		}
	});
	
	deleteBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String query="DELETE FROM student where roll_no="+"\'"+user.rollNo+"\'";
			QueryResponse res=service.executeUpdate(query);
			if(res.statusCode==1) {
				dispose();
			}
		}
	});
	profileBtn.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			String [] s={"1"};
			try {
			new ProfilePage(user).main(s);;
			dispose();
			}catch(Exception e1) {
				
			}
			
		
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
			
			// TODO Auto-generated method stub
			
		}
	});
	
	

	
}
}

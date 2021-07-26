package ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;

public class ProfilePage {
	static UserDetails user=new UserDetails();
	public ProfilePage(UserDetails user) {
		
		this.user=user;
	}
		static SQLService service=null;
		static Button b1=null;
		static Label tvRollNo=null;
		static Label tvFirstName=null;
		static Label tvLastName=null;
		static Label tvEmail=null;
		static Label tvMovileNumber=null;
		static Label tvAge=null;
		static Label cbGender=null;
		Button backBtn=null;
//		static Label tvPin=null;
//		static TextField tvConfirmPIN=null;
		static String genderList[]= {"Male","Female","Transgender"};
		
		
		
		public static void main(String[] args) throws Exception {
			try {
			service=new SQLService();
			service.getConnection();
			}catch(Exception e) {
				System.out.println(e);
			}
			 
			ProfilePage obj=new ProfilePage(user);
			Frame frame=obj.createFrame();
			obj.initListeners(frame);
			
			
		}
		
		public  Frame createFrame() {
			Frame frame=new Frame("Profile");
			frame.setLayout(null);
			
		
			b1=new Button("Register");
			b1.setBackground(Color.BLUE);
			b1.setForeground(Color.WHITE);
			
			Label l1=new Label("Roll No: ");
			Label l2=new Label("First Name: ");
			Label l3=new Label("Last Name : ");
			Label l4=new Label("Email : ");
			Label l5=new Label("Mobile Number: ");
			Label l6=new Label("age: ");
			Label l7=new Label("Gender: ");
			
			backBtn=new Button("Back");
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.white);;
			backBtn.setBounds(10, 30, 50, 20);
						
	
			
			tvRollNo=new Label();
			tvFirstName=new Label();
			tvLastName=new Label();
			tvEmail=new Label();
			tvMovileNumber=new Label();
			tvAge=new Label();
			cbGender=new Label();
			
			tvRollNo.setText(user.rollNo);
			tvFirstName.setText(user.firstName);
			tvLastName.setText(user.lastName);
			tvEmail.setText(user.email);
			tvMovileNumber.setText(user.mobileNumber);
			tvAge.setText(String.valueOf(user.age));
			cbGender.setText(user.gender);
		
			
			tvRollNo.setBackground(new Color(0,11,34));
			tvRollNo.setForeground(ColorUIResource.WHITE);
			tvRollNo.setFont(new Font("Roboto", Font.BOLD, 13));
			
			tvFirstName.setBackground(new Color(0,11,34));
			tvFirstName.setForeground(Color.WHITE);
			tvFirstName.setFont(new Font("Roboto", Font.BOLD, 13));
			
			tvLastName.setBackground(new Color(0,11,34));
			tvLastName.setForeground(Color.WHITE);
			tvLastName.setFont(new Font("Roboto", Font.BOLD, 13));
			
			tvEmail.setBackground(new Color(0,11,34));
			tvEmail.setForeground(Color.WHITE);
			tvEmail.setFont(new Font("Roboto", Font.BOLD, 13));
			
			tvMovileNumber.setBackground(new Color(0,11,34));
			tvMovileNumber.setForeground(Color.WHITE);
			tvMovileNumber.setFont(new Font("Roboto", Font.BOLD, 13));
			
			tvAge.setBackground(new Color(0,11,34));
			tvAge.setForeground(Color.WHITE);
			tvAge.setFont(new Font("Roboto", Font.BOLD, 13));
			
			cbGender.setBackground(new Color(0,11,34));
			cbGender.setForeground(Color.WHITE);
			cbGender.setFont(new Font("Roboto", Font.BOLD, 13));


			
			l1.setBounds(75,74,110,25);
			l1.setBackground(new Color(0,11,34));
			l1.setForeground(Color.BLUE);
			l1.setFont(new Font("Roboto", Font.BOLD, 13));
			tvRollNo.setBounds(185,74,100,25);
			
			l2.setBounds(75,129,110,25);
			l2.setBackground(new Color(0,11,34));
			l2.setForeground(Color.BLUE);
			l2.setFont(new Font("Roboto", Font.BOLD, 13));
			tvFirstName.setBounds(185,129,100,25);
			
			l3.setBounds(75,184,110,25);
			l3.setBackground(new Color(0,11,34));
			l3.setForeground(Color.BLUE);
			l3.setFont(new Font("Roboto", Font.BOLD, 13));
			tvLastName.setBounds(185,184,100,25);
			
			l4.setBounds(75,239,110,25);
			l4.setBackground(new Color(0,11,34));
			l4.setForeground(Color.BLUE);
			l4.setFont(new Font("Roboto", Font.BOLD, 13));
			tvEmail.setBounds(185,239,100,25);
			
			l5.setBounds(75,294,110,25);
			l5.setBackground(new Color(0,11,34));
			l5.setForeground(Color.BLUE);
			l5.setFont(new Font("Roboto", Font.BOLD, 13));
			tvMovileNumber.setBounds(185,294,100,25);
			
			l6.setBounds(75,349,110,25);
			l6.setBackground(new Color(0,11,34));
			l6.setForeground(Color.BLUE);
			l6.setFont(new Font("Roboto", Font.BOLD, 13));
			tvAge.setBounds(185,349,100,25);
			
			l7.setBounds(75,404,110,25);
			l7.setBackground(new Color(0,11,34));
			l7.setForeground(Color.BLUE);
			l7.setFont(new Font("Roboto", Font.BOLD, 13));
			cbGender.setBounds(185,404,100,25);
			
		
			
			b1.setSize(50,30 );
			b1.setBounds(160, 632, 80, 25);


			frame.add(l1);
			frame.add(l2);
			frame.add(l3);
			frame.add(l4);
			frame.add(l5);
			frame.add(l6);
			frame.add(l7);
			
			frame.add(tvRollNo);
			frame.add(tvFirstName);
			frame.add(tvLastName);
			frame.add(tvEmail);
			frame.add(tvMovileNumber);
			frame.add(tvAge);
			frame.add(cbGender);
		frame.add(backBtn);
			frame.setVisible(true);
			frame.setBackground(new Color(0,11,34));
			frame.setSize(400, 500);
			frame.setResizable(false);
			frame.setLocation(200, 200);
			frame.setLocationRelativeTo(null);
			return frame;
		}
		
			
		
		
		public  void initListeners(Frame frame) {
			frame.addWindowListener(new WindowAdapter(){
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});
			backBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new Dashboard(user).main(new String[] {"1"});
						frame.dispose();
					}catch(Exception ex) {
						
					}
					
				}
			});
			
			
			b1.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
					
//					regiter();;
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
//					t2.requestFocus();
					// TODO Auto-generated method stub
					
				}
			});
		}
		
//		public  void regiter() {
//			try {
//				String rollNo=tvRollNo.getText();
//				String firstName=tvFirstName.getText();
//				String lastName=tvLastName.getText();
//				String email=tvEmail.getText();
//				String mobileNumber=tvMovileNumber.getText();
//				int age=Integer.parseInt(tvAge.getText());
//				String gender=(String)cbGender.getSelectedItem();
//			
//
//				if(validateRollNo(rollNo) && validateFirstName(firstName)&&validateLastName(lastName) && validateEmail(email) && validateAge(age) && validateGender(gender) && validatePIN(pin) && validateConfirmPIN(confirmPin, pin)) {
//					String query="INSERT INTO student values("+"\'"+rollNo+"\'"+","+"\'"+firstName+"\'"+","+"\'"+lastName+"\'"+","+"\'"+email+"\'"+","+"\'"+mobileNumber+"\'"+","+"\'"+pin+"\'"+","+age+","+"\'"+gender+"\'"+")";
//					System.out.println(query);
//					QueryResponse res=service.executeUpdate(query);
//					if(res.statusCode==1)
//					System.out.println("Registered success");
//					else {
//						JOptionPane.showMessageDialog(null, res.message,"Error", JOptionPane.ERROR_MESSAGE, null);
//					}
//				}
////				String query="SELECT * from student where mobile_number="+mobileNumber+" AND "+"pin="+pin;
//	//
////				ResultSet rs=service.executeQuery(query);
//	//
////				if(rs.next()) {
////					System.out.println("Successfully Logged in");
////				}else {
////					System.out.println("Login failed ");
////				}
//				}catch(Exception ex){
//					System.out.println("Error while Registration"+ex);
//				}
//		}
		
		public boolean validateRollNo(String rollNo) {
			Pattern p=Pattern.compile("([0-9]{2}([a-zA-z]){4}[0-9]{3})");
			Boolean isMatches=p.matcher(rollNo).matches();		
			if(!isMatches) {
				System.out.println("Failed at roll no");
			}
			return isMatches;
		}
		public boolean validateFirstName(String name) {
			boolean isMatches=true;
			if(name.length()==0) {
				System.out.println("Failed at first name");
				isMatches=false;
			}
			return isMatches;
		}
		
		public boolean validateLastName(String name) {
			boolean isMatches=true;
			if(name.length()==0) {
				System.out.println("Failed at last name");
				isMatches=false;
			}
			return isMatches;
		}
		public boolean validateEmail(String email) {
			Pattern p=Pattern.compile("\\S+@\\S+\\.\\S+");
			Boolean isMatches=p.matcher(email).matches();		
			if(!isMatches) {
				System.out.println("Failed at email");
			}
			return isMatches;
		}
		
		public boolean validateMobileNumber(String mobile) {
			Pattern p=Pattern.compile("^([0-9]{10})$");
			Boolean isMatches=p.matcher(mobile).matches();		
			return isMatches;
		}
		public boolean validateAge(int age) {
			if(age>18) {
				return true;
			}
			System.out.println("Failed at age");
			return false;
		}
		public boolean validateGender(String gender) {
			if(gender!= " ") {
				return true;
			}
			System.out.println("Failed at gender");
			return false;
		}
		public boolean validatePIN(String pin) {
			if(pin.length()>=6 && pin.length()<=8) {
				return true;
			}else {
				System.out.println("Failed at pin");
			return false;
			}
		}
		public boolean validateConfirmPIN(String pinConfirmation,String pin) {
			if(pinConfirmation.equals(pin)) {
				return true;
			}
			System.out.println("Failed at confirmPIN");
			return false;
		}
		
		
	}



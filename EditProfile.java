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
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EditProfile implements ActionListener {
	static UserDetails user=new UserDetails();
	public EditProfile(UserDetails user) {
		this.user=user;
	}
	static SQLService service=null;
	static Button b1=null;
	static Button backBtn=null;
	static TextField tvRollNo=null;
	static TextField tvFirstName=null;
	static TextField tvLastName=null;
	static TextField tvEmail=null;
	static TextField tvMovileNumber=null;
	static TextField tvAge=null;
	static JComboBox<String> cbGender=null;
	static TextField tvPin=null;
	static TextField tvConfirmPIN=null;
	static ArrayList<String> genderList= null;
	static String genderList1[]= {"Male","Female","Transgender"};
	static Frame frame=null;
	
	
	public static void main(String[] args) throws Exception {
		try {
		service=new SQLService();
		service.getConnection();
		}catch(Exception e) {
			System.out.println(e);
		}
		genderList=new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Transgender");
		 
		EditProfile obj=new EditProfile(user);
		Frame frame=obj.createFrame();
		obj.initListeners(frame);
		
		
	}
	
	public  Frame createFrame() {
		 frame=new Frame("Edit Profile");
		frame.setLayout(null);
		backBtn=new Button("Back");
		backBtn.setBackground(Color.BLUE);
		backBtn.setForeground(Color.white);;
		backBtn.setBounds(105, 632, 80, 25);
	
		b1=new Button("Save");
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		
		Label l1=new Label("Roll No: ");
		Label l2=new Label("First Name: ");
		Label l3=new Label("Last Name : ");
		Label l4=new Label("Email : ");
		Label l5=new Label("Mobile Number: ");
		Label l6=new Label("age: ");
		Label l7=new Label("Gender: ");
		Label l8=new Label("PIN :");
		Label l9=new Label("Confirm PIN : ");
		
		tvRollNo=new TextField();
		tvRollNo.setEditable(false);
		tvFirstName=new TextField();
		tvLastName=new TextField();
		tvEmail=new TextField();
		tvMovileNumber=new TextField();
		tvMovileNumber.setEditable(false);
		tvAge=new TextField();
		cbGender=new JComboBox<>(genderList1);
		tvPin=new TextField();
		tvConfirmPIN=new TextField();
		
		tvRollNo.setText(user.rollNo);
		tvFirstName.setText(user.firstName);
		tvLastName.setText(user.lastName);
		tvEmail.setText(user.email);
		tvMovileNumber.setText(user.mobileNumber);
		tvAge.setText(String.valueOf(user.age));
		cbGender.setSelectedIndex(genderList.indexOf(user.gender));
		
		tvRollNo.addActionListener(this);
		tvFirstName.addActionListener(this);
		tvLastName.addActionListener(this);
		tvEmail.addActionListener(this);
		tvMovileNumber.addActionListener(this);
		tvAge.addActionListener(this);
		cbGender.addActionListener(this);
		tvPin.addActionListener(this);
		tvConfirmPIN.addActionListener(this);	
		
		l1.setBounds(75,137,110,25);
		l1.setBackground(new Color(0,11,34));
		l1.setForeground(new Color(137, 207, 240));
		l1.setFont(new Font("Roboto", Font.BOLD, 13));
		tvRollNo.setBounds(185,137,100,25);
		
		l2.setBounds(75,192,110,25);
		l2.setBackground(new Color(0,11,34));
		l2.setForeground(new Color(137, 207, 240));
		l2.setFont(new Font("Roboto", Font.BOLD, 13));
		tvFirstName.setBounds(185,192,100,25);
		
		l3.setBounds(75,247,110,25);
		l3.setBackground(new Color(0,11,34));
		l3.setForeground(new Color(137, 207, 240));
		l3.setFont(new Font("Roboto", Font.BOLD, 13));
		tvLastName.setBounds(185,247,100,25);
		
		l4.setBounds(75,302,110,25);
		l4.setBackground(new Color(0,11,34));
		l4.setForeground(new Color(137, 207, 240));
		l4.setFont(new Font("Roboto", Font.BOLD, 13));
		tvEmail.setBounds(185,302,100,25);
		
		l5.setBounds(75,357,110,25);
		l5.setBackground(new Color(0,11,34));
		l5.setForeground(new Color(137, 207, 240));
		l5.setFont(new Font("Roboto", Font.BOLD, 13));
		tvMovileNumber.setBounds(185,357,100,25);
		
		l6.setBounds(75,412,110,25);
		l6.setBackground(new Color(0,11,34));
		l6.setForeground(new Color(137, 207, 240));
		l6.setFont(new Font("Roboto", Font.BOLD, 13));
		tvAge.setBounds(185,412,100,25);
		
		l7.setBounds(75,467,110,25);
		l7.setBackground(new Color(0,11,34));
		l7.setForeground(new Color(137, 207, 240));
		l7.setFont(new Font("Roboto", Font.BOLD, 13));
		cbGender.setBounds(185,467,100,25);
		
		
		l8.setBounds(75,522,110,25);
		l8.setBackground(new Color(0,11,34));
		l8.setForeground(new Color(137, 207, 240));
		l8.setFont(new Font("Roboto", Font.BOLD, 13));
		tvPin.setBounds(185,522,100,25);
		tvPin.setEchoChar('*');
		
		l9.setBounds(75,577,110,25);
		l9.setBackground(new Color(0,11,34));
		l9.setForeground(new Color(137, 207, 240));
		l9.setFont(new Font("Roboto", Font.BOLD, 13));
		tvConfirmPIN.setBounds(185,577,100,25);
		tvConfirmPIN.setEchoChar('*');
		
		
		b1.setSize(50,30 );
		b1.setBounds(215, 632, 80, 25);


		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(l6);
		frame.add(l7);
	frame.add(backBtn);
		frame.add(tvRollNo);
		frame.add(tvFirstName);
		frame.add(tvLastName);
		frame.add(tvEmail);
		frame.add(tvMovileNumber);
		frame.add(tvAge);
		frame.add(cbGender);
		frame.add(b1);
		frame.setVisible(true);
		frame.setBackground(new Color(0,11,34));
		frame.setSize(400, 700);
		frame.setResizable(false);
		frame.setLocation(200, 200);
		frame.setLocationRelativeTo(null);
		return frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed"+" source is "+e.getSource());
		if(e.getSource()==tvRollNo)
			tvFirstName.requestFocus();
		else if(e.getSource()==tvFirstName)
			tvLastName.requestFocus();
		else if(e.getSource()==tvLastName)
			tvEmail.requestFocus();
		else if(e.getSource()==tvEmail)
			tvMovileNumber.requestFocus();
		else if(e.getSource()==tvMovileNumber)
			tvAge.requestFocus();
		else if(e.getSource()==tvAge)
			cbGender.requestFocus();
		else if(e.getSource()==cbGender)
			tvPin.requestFocus();
		else if(e.getSource()==tvPin)
			tvConfirmPIN.requestFocus();
		else if(e.getSource()==tvConfirmPIN)
			regiter();
			
	
			
	}
	
	public  void initListeners(Frame frame) {
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		cbGender.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
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
				
				
				regiter();;
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
//				t2.requestFocus();
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public  void regiter() {
		try {
			String rollNo=tvRollNo.getText();
			String firstName=tvFirstName.getText();
			String lastName=tvLastName.getText();
			String email=tvEmail.getText();
			String mobileNumber=tvMovileNumber.getText();
			int age=Integer.parseInt(tvAge.getText());
			String gender=(String)cbGender.getSelectedItem();
			

			if(validateRollNo(rollNo) && validateFirstName(firstName)&&validateLastName(lastName) && validateEmail(email) && validateAge(age) && validateGender(gender)) {
				String query="UPDATE student set "+"roll_no="+"\'"+rollNo+"\'"+",first_name="+"\'"+firstName+"\'"+",last_name="+"\'"+lastName+"\'"+",email="+"\'"+email+"\'"+",mobile_number="+"\'"+mobileNumber+"\'"+",age="+age+",gender="+"\'"+gender+"\'"+"WHERE roll_no="+"\'"+rollNo+"\'";
				
				System.out.println(query);
				QueryResponse res=service.executeUpdate(query);
				if(res.statusCode==1) {
				System.out.println("Registered success");
				user.firstName=firstName;
				user.rollNo=rollNo;
				user.lastName=lastName;
				user.email=email;
				user.mobileNumber=mobileNumber;
				user.age=age;
				user.gender=gender;
				try {
					new Dashboard(user).main(new String[] {"1"});
					frame.dispose();
				}catch(Exception ex) {
					
				}
				}
				else {
					JOptionPane.showMessageDialog(null, res.message,"Error", JOptionPane.ERROR_MESSAGE, null);
				}
			}
//			String query="SELECT * from student where mobile_number="+mobileNumber+" AND "+"pin="+pin;
//
//			ResultSet rs=service.executeQuery(query);
//
//			if(rs.next()) {
//				System.out.println("Successfully Logged in");
//			}else {
//				System.out.println("Login failed ");
//			}
			}catch(Exception ex){
				System.out.println("Error while Registration"+ex);
			}
	}
	
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

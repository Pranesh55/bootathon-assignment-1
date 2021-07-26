package ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

class Sample extends Frame{
	Label l1,l2;
    TextField t1,t2;
    Button b1;
    Sample(){
        setLayout(null);

        l1=new Label("Username");
        l2=new Label("Password");

        t1=new TextField();
        t2=new TextField();

        t2.setEchoChar('*');

        b1=new Button("SUBMIT");


        l1.setBounds(100,100,100,25);
        l2.setBounds(100,150,100,25);

        t1.setBounds(230,100,100,25);
        t2.setBounds(230,150,100,25);
        b1.setBounds(100,200,80,25);

        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(b1);

        setSize(400,300);
        setBackground(Color.ORANGE);
        setResizable(false);
        setVisible(true);
    }
   public static void main(String args[]){
       new Sample();
   }
   
}
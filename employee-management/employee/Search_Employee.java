package Employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Search_Employee implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l,l5;
    JButton b1,b2;

    Search_Employee(){
        f=new JFrame("Search");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
       /* ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employeee/icons/view.jpg"));
        l5.setIcon(img);*/


        l=new JLabel("Employee Id : ");
        l.setVisible(true);
        l.setBounds(50,60,250,30);
        l.setForeground(Color.black);
        Font F1=new Font("serif",Font.PLAIN,23);
        l.setFont(F1); 
        l5.add(l);
        f.add(l5);

        t=new JTextField();
        t.setBounds(240,60,220,30);
        l5.add(t);

        b1=new JButton("Search");
        b1.setBounds(240,150,100,30);
        b1.addActionListener(this);
        l5.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        f.setSize(600,300);
        //f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b1){
        //  new Update_Employee(t.getText());
            f.setVisible(false);
            Update_Employee u = new Update_Employee(t.getText());
        }

    }
    
    public static void main(String[]ar){
        new Search_Employee();
    } 	
}
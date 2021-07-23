package Employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Update_Employee extends Add_Employee implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3; 
    String id_emp;

    Update_Employee(String idaa){
        super(0);
        f=new JFrame("Update Employee details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);

        id_emp=idaa;    
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
       /* ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employeee/icons/add_employee.jpg"));
        id15.setIcon(img);*/

        id8 = new JLabel("Update Employee Details");
        id8.setBounds(200,10,580,60);
        id8.setFont(new Font("serif",Font.PLAIN,30));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);


        id1 = new JLabel("First Name");  
        id1.setBounds(50,100,150,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(220,100,150,30);
        id15.add(t1);

        id2 = new JLabel("Last Name");
        id2.setBounds(420,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);

        id3= new JLabel("Date of Birth");
        id3.setBounds(50,150,150,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(220,150,150,30);
        id15.add(t3);

        id4= new JLabel("Address");
        id4.setBounds(420,150,150,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);   
        id15.add(t4);

        id5= new JLabel("Phone");
        id5.setBounds(50,200,150,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(220,200,150,30);
        id15.add(t5);

        id6= new JLabel("Email Id");
        id6.setBounds(420,200,150,30);
        id6.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        id15.add(t6);

        id7= new JLabel("Education");
        id7.setBounds(50,250,150,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(220,250,150,30);
        id15.add(t7);

        id9= new JLabel("Job Post");
        id9.setBounds(420,250,150,30);  
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        id15.add(t8);

        id10= new JLabel("Employee Id");
        id10.setBounds(50,300,150,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);
        f.setVisible(false);
        t9=new JTextField();
        t9.setBounds(220,300,150,30);
        id15.add(t9);

        b=new JButton("Update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        id15.add(b1);

        showData(idaa);  //show database in the textfields
    }

    int i=0;
    String age,dat;

    void showData(String s){
        try{
            conn con = new conn();
            String str = "select * from employee where ID = '"+s+"'";
            ResultSet rs = con.s.executeQuery(str); //whole row in database stored in rs

            if(rs.next()){
                f.setVisible(true);
                i=1;

                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(4));
                t4.setText(rs.getString(5));
                t5.setText(rs.getString(6));
                t6.setText(rs.getString(7));
                t7.setText(rs.getString(8));
                t8.setText(rs.getString(9));
                t9.setText(rs.getString(10));

                age=rs.getString(3);
               // dat=rs.getString(4);
            }
            if(i==0)
                JOptionPane.showMessageDialog(null,"Id not found");
            new Search_Employee();
        }catch(Exception ex){}
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
            //  String str = "update employee set fname='"+t1.getText()+"',lname='"+t2.getText()+"',age='"+age+"',dob='"+dat+"',address='"+t3.getText()+"',phone='"+t4.getText()+"',email='"+t5.getText()+"',education='"+t6.getText()+"',post='"+t7.getText()+"',aadhar='"+t8.getText()+"',ID='"+t9.getText()+"' where ID='"+id_emp+"'";
               
                String str = "update employee set fname='"+t1.getText()+"',lname='"+t2.getText()+"',age='"+age+"',dob='"+t3.getText()+"',address='"+t4.getText()+"',phone='"+t5.getText()+"',email='"+t6.getText()+"',qualification='"+t7.getText()+"',post='"+t8.getText()+"',ID='"+t9.getText()+"' where ID='"+id_emp+"'";

                
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Successfully updated");
                f.setVisible(false);
                //new Search_Employee();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false); 
            details d=new details();
        }
    }

    public static void main(String[] arg){
        new Update_Employee("Update Employee");
    }
}

package employee.management.system;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname,tfadd, tfsalary, tfphone, tfemail;
    JDateChooser dcdob;
    JComboBox cbdesignation;
    JLabel lblempid;
    JButton add,back;
    
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(180,150,150,30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's name");
        labelfname.setBounds(400,150,170,30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(620,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(180,200,150,30);
        add(dcdob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,170,30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(620,200,150,30);
        add(tfsalary);
        
        JLabel labeladd = new JLabel("Address");
        labeladd.setBounds(50,250,150,30);
        labeladd.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladd);
        
        tfadd = new JTextField();
        tfadd.setBounds(180,250,150,30);
        add(tfadd);
        
        JLabel labelphone = new JLabel("Phone number");
        labelphone.setBounds(400,250,170,30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(620,250,150,30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("E-mail");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(180,300,150,30);
        add(tfemail);
        
        JLabel labeljob = new JLabel("Designation");
        labeljob.setBounds(400,300,170,30);
        labeljob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeljob);
        
        String courses[] = {"Operator","Supervisor","Sales associate","Broker","Production Manager","Textile engineer"};
        cbdesignation = new JComboBox(courses);
        cbdesignation.setBackground(Color.WHITE);
        cbdesignation.setBounds(620,300,150,30);
        add(cbdesignation);
        
        JLabel labelempid = new JLabel("Employee ID");
        labelempid.setBounds(50,350,170,30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);
        
        lblempid = new JLabel("" + number);
        lblempid.setBounds(200,350,170,30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);
        
        add = new JButton("Add Details");
        add.setBounds(250,500,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,500,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfadd.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String designation = (String)cbdesignation.getSelectedItem();
            String empid = lblempid.getText();
            
        try{
            Conn conn = new Conn();
            String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+designation+"','"+empid+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details added successfully!");
            setVisible(false);
            new Home();
        }catch(Exception e){
            e.printStackTrace();
        }
            
        }else{
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String[] args){
        new AddEmployee();
    }
    
}

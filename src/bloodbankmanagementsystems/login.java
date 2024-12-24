package bloodbankmanagementsystems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class login extends JFrame {
 JButton login;
 JLabel username;
 JLabel password;
 JPasswordField passfield;
 JTextField textField;
 GridBagLayout grid;
 GridBagConstraints constraint;
 Font font1;
 Font font2;
 Dimension dimension;
 JLabel title;
 JPanel panel;
 
 public login(){
    title=new JLabel("Login");
    title.setFont(new Font("arial",Font.BOLD,45));
    panel=new JPanel();
    panel.add(title);
    panel.setPreferredSize(new Dimension(340,60));
    panel.setBackground(Color.gray);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   dimension=new Dimension(210,30);
    font2=new  Font("arial", Font.PLAIN, 20);

    setTitle("bloodbank");

    login=new JButton("Login");
    login.setPreferredSize(dimension);
    username=new JLabel("username");
    username.setFont(font2);
    password=new JLabel("password");
    password.setFont(font2);
    passfield=new JPasswordField();
    passfield.setFont(font2);
    passfield.setPreferredSize(dimension);
    textField =new JTextField();
    textField.setFont(font2);
    textField.setPreferredSize(dimension);
    grid=new GridBagLayout();
    constraint=new GridBagConstraints();
    font1 =new Font("Segoe UI",1,14);
    setLayout(grid);
    login.setFont(font1 );
    login.addActionListener(new listenerlogin());
    
      login.setBackground(new Color(0, 153, 204));
      login.setFocusable(false);
    constraint.gridx=0;
    constraint.gridy=0;
    constraint.gridwidth=2;
   constraint.insets=new Insets(0, 0, 10, 10); 
   
    add(panel,constraint);
    
    constraint.gridx=0;
    constraint.gridy=1;
    constraint.gridwidth=1;
    constraint.insets=new Insets(0, 0, 0, 10);
   add(username,constraint);
   constraint.gridx=0;
    constraint.gridy=2;
    constraint.gridwidth=1;
    constraint.insets=new Insets(0, 0, 0, 10);
    add(password,constraint);
    constraint.gridx=1;
    constraint.gridy=1;
    constraint.gridwidth=2;
    constraint.insets=new Insets(0, 0, 10, 0);
    add(textField,constraint);
    constraint.gridx=1;
    constraint.gridy=2;
    constraint.gridwidth=2;
    constraint.insets=new Insets(0, 0, 10, 0);
   add(passfield,constraint);
    constraint.gridx=1;
    constraint.gridy=3;
    constraint.gridwidth=1;
    constraint.insets=new Insets(0, 0, 0, 0);
    add(login,constraint);
    //setLocationRelativeTo(null);
    
    setSize(450,500);
    setVisible(true);
  
 }
 public static void main(String[] args) {
    new login();
 }
   
 private class listenerlogin implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
       Loginbutton(e);
 }
}
 private void Loginbutton(ActionEvent evt) {                                         

    
    if(textField.getText().equals("admin")&& passfield.getText().equals("1234")){
        setVisible(false);
        new home().setVisible(true);
    }
    else
    {
        JOptionPane.showMessageDialog(null,"Incorrect username or password");
    }
}     

}

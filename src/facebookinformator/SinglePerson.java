/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Uživatel
 */
public class SinglePerson
{
     public JFrame fS = new JFrame("Facebook Informator");
     public JButton bSubmit = new JButton("Hledej");
     public JButton bNext = new JButton("Další");
     public Person pom = null;
     SinglePerson ()
     {
        
        fS.setLayout(null);
        fS.setSize(800,600);
        fS.setResizable(false);
        fS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try {
            fS.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture2.png")))));
        } catch (IOException e) {
        }
        
        
        JLabel lTitle = new JLabel("Jednotlivec");
        lTitle.setFont(new Font("Serif", Font.PLAIN, 44));
        lTitle.setForeground(Color.WHITE);
        lTitle.setBounds(40, 2, 300, 44);
        
        JLabel lFirstN = new JLabel("Jméno:");
        JTextField txtFirstN = new JTextField("");
        lFirstN.setBounds(50, 70, 50, 25);
        lFirstN.setForeground(Color.WHITE);
        txtFirstN.setBounds(100, 70, 100, 25);

        JLabel lLastN = new JLabel("Příjmení:");
        JTextField txtLastN = new JTextField("");
        lLastN.setBounds(50, 120, 50, 25);
        lLastN.setForeground(Color.WHITE);
        txtLastN.setBounds(100, 120, 100, 25);

        JLabel lAge = new JLabel("Věk:");
        JTextField txtAge = new JTextField("");
        lAge.setBounds(50, 170, 50, 25);
        lAge.setForeground(Color.WHITE);
        txtAge.setBounds(100, 170, 40, 25);

        JTextField txtAge2 = new JTextField("");
        txtAge2.setBounds(160, 170, 40, 25);
        
        
        JLabel lEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField("");
        lEmail.setBounds(50, 220, 50, 25);
        lEmail.setForeground(Color.WHITE);
        txtEmail.setBounds(100, 220, 100, 25);  
        
        JLabel lGender = new JLabel("Pohlaví:");
        JTextField txtGender = new JTextField("");
        lGender.setBounds(50, 270, 50, 25);
        lGender.setForeground(Color.WHITE);
        txtGender.setBounds(100, 270, 100, 25);  
        
        JLabel lCity = new JLabel("Město:");
        JTextField txtCity = new JTextField("");
        lCity.setBounds(230, 70, 50, 25);
        lCity.setForeground(Color.WHITE);
        txtCity.setBounds(280, 70, 100, 25);
        
        JLabel lCountry = new JLabel("Země:");
        JTextField txtCountry = new JTextField("");
        lCountry.setBounds(230, 120, 50, 25);
        lCountry.setForeground(Color.WHITE);
        txtCountry.setBounds(280, 120, 100, 25);
        
        JLabel lIP = new JLabel("IP adresa:");
        JTextField txtIP = new JTextField("");
        lIP.setBounds(210, 170, 100, 25);
        lIP.setForeground(Color.WHITE);
        txtIP.setBounds(280, 170, 100, 25); 
        
        JLabel lPhone = new JLabel("Telefon:");
        JTextField txtPhone = new JTextField("");
        lPhone.setBounds(220, 220, 50, 25);
        lPhone.setForeground(Color.WHITE);
        txtPhone.setBounds(280, 220, 100, 25);
        
        JLabel lUniversity = new JLabel("Univerzita:");
        JTextField txtUniversity = new JTextField("");
        lUniversity.setBounds(210, 270, 100, 25);
        lUniversity.setForeground(Color.WHITE);
        txtUniversity.setBounds(280, 270, 100, 25); 
        
        bSubmit.setBounds(130, 320, 100, 50);
        bNext.setBounds(250, 320, 100, 50);
        
        bSubmit.addActionListener(new ActionListener()
               {
                    public void actionPerformed(ActionEvent e) 
                    {
                     //if(!txtFirstN.getText().equals("") || !txtLastN.getText().equals("") || (!txtAge.getText().equals("") && !txtAge2.getText().equals("") ))
                        //new SingleResult(txtFirstN.getText(), txtLastN.getText(), txtAge.getText(), txtAge2.getText()); 
                    //check(txtFirstN.getText(), txtLastN.getText(), txtAge.getText(), 
                       //     txtEmail.getText(), txtGender.getText(), txtCity.getText(), txtCountry.getText(),
                         //   txtIP.getText(), txtPhone.getText(), txtUniversity.getText());
                    Database var = new Database();
                    ArrayList<Person> persons = var.getDB();

                    for(Person pom : persons)
                        {
                          if((txtFirstN.getText().equals(pom.getFirstName()) && (!txtFirstN.getText().equals(""))
                                    && (txtLastN.getText().equals(pom.getLastName()))) && (!txtLastN.getText().equals(""))
                                  && (txtAge.getText().equals(pom.getBirthDate())) && (!txtAge.getText().equals(""))
                                  && (txtEmail.getText().equals(pom.getEmail())) && (!txtEmail.getText().equals("")))
                            {
                            txtGender.setText(pom.getGender());
                            txtCity.setText(pom.getCity());
                            txtCountry.setText(pom.getCountry());
                            txtIP.setText(pom.getIP());
                            txtPhone.setText(pom.getTelephone());
                            txtUniversity.setText(pom.getUniversity());
                             break;
                            } 
                          if((txtFirstN.getText().equals(pom.getFirstName()) && (!txtFirstN.getText().equals(""))
                                    && (txtLastN.getText().equals(pom.getLastName()))) && (!txtLastN.getText().equals(""))
                                  && (txtAge.getText().equals(pom.getBirthDate())) && (!txtAge.getText().equals("")))
                            {
                            txtEmail.setText(pom.getEmail());
                            txtGender.setText(pom.getGender());
                            txtCity.setText(pom.getCity());
                            txtCountry.setText(pom.getCountry());
                            txtIP.setText(pom.getIP());
                            txtPhone.setText(pom.getTelephone());
                            txtUniversity.setText(pom.getUniversity());
                             break;
                            } 
                            else if((txtFirstN.getText().equals(pom.getFirstName()) && (!txtFirstN.getText().equals(""))
                                    && (txtLastN.getText().equals(pom.getLastName()))) && (!txtLastN.getText().equals("")))
                            {
                            txtAge.setText(pom.getBirthDate());
                            txtEmail.setText(pom.getEmail());
                            txtGender.setText(pom.getGender());
                            txtCity.setText(pom.getCity());
                            txtCountry.setText(pom.getCountry());
                            txtIP.setText(pom.getIP());
                            txtPhone.setText(pom.getTelephone());
                            txtUniversity.setText(pom.getUniversity());
                             break;
                            } 
                            else if((txtFirstN.getText().equals(pom.getFirstName()) && (!txtFirstN.getText().equals(""))))
                            {
                            txtLastN.setText(pom.getLastName());
                            txtAge.setText(pom.getBirthDate());
                            txtEmail.setText(pom.getEmail());
                            txtGender.setText(pom.getGender());
                            txtCity.setText(pom.getCity());
                            txtCountry.setText(pom.getCountry());
                            txtIP.setText(pom.getIP());
                            txtPhone.setText(pom.getTelephone());
                            txtUniversity.setText(pom.getUniversity());
                             break;
                            }  

                        }
                    }
                });
        
        fS.add(lFirstN);
        fS.add(txtFirstN);
        fS.add(lLastN);
        fS.add(txtLastN);
        fS.add(lAge);
        fS.add(txtAge);   
        fS.add(lEmail);
        fS.add(txtEmail);
        fS.add(bSubmit);
        fS.add(lTitle);
        fS.add(txtAge2);
        fS.add(lGender);
        fS.add(txtGender);
        fS.add(lCity);
        fS.add(txtCity);
        fS.add(lCountry);
        fS.add(txtCountry);
        fS.add(lIP);
        fS.add(txtIP);
        fS.add(lPhone);
        fS.add(txtPhone);
        fS.add(lUniversity);
        fS.add(txtUniversity);
        fS.add(bNext);
        
        fS.setVisible(true);
     }
}

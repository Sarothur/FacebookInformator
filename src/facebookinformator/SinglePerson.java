/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
        lTitle.setBounds(40, 2, 300, 44);
        
        JLabel lFirstN = new JLabel("Jméno:");
        JTextField txtFirstN = new JTextField("");
        lFirstN.setBounds(50, 50, 50, 25);
        txtFirstN.setBounds(100, 50, 100, 25);

        JLabel lLastN = new JLabel("Příjmení:");
        JTextField txtLastN = new JTextField("");
        lLastN.setBounds(50, 100, 50, 25);
        txtLastN.setBounds(100, 100, 100, 25);

        JLabel lAge = new JLabel("Věk:");
        JTextField txtAge = new JTextField("");
        lAge.setBounds(50, 150, 50, 25);
        txtAge.setBounds(100, 150, 40, 25);

        JTextField txtAge2 = new JTextField("");
        txtAge2.setBounds(160, 150, 40, 25);
        
        JLabel lEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField("");
        lEmail.setBounds(50, 200, 50, 25);
        txtEmail.setBounds(100, 200, 100, 25);  
        
        JLabel lGender = new JLabel("Gender:");
        JTextField txtGender = new JTextField("");
        lGender.setBounds(50, 250, 50, 25);
        txtGender.setBounds(100, 250, 100, 25);  
        
        JLabel lCity = new JLabel("Město:");
        JTextField txtCity = new JTextField("");
        lCity.setBounds(230, 50, 50, 25);
        txtCity.setBounds(280, 50, 100, 25);
        
        JLabel lCountry = new JLabel("Země:");
        JTextField txtCountry = new JTextField("");
        lCountry.setBounds(230, 100, 50, 25);
        txtCountry.setBounds(280, 100, 100, 25);
        
        JLabel lIP = new JLabel("IP adresa:");
        JTextField txtIP = new JTextField("");
        lIP.setBounds(210, 150, 100, 25);
        txtIP.setBounds(280, 150, 100, 25); 
        
        JLabel lPhone = new JLabel("Telefon:");
        JTextField txtPhone = new JTextField("");
        lPhone.setBounds(220, 200, 50, 25);
        txtPhone.setBounds(280, 200, 100, 25);
        
        JLabel lUniversity = new JLabel("Univerzita:");
        JTextField txtUniversity = new JTextField("");
        lUniversity.setBounds(210, 250, 100, 25);
        txtUniversity.setBounds(280, 250, 100, 25); 
        
        bSubmit.setBounds(130, 300, 100, 50);
        bNext.setBounds(250, 300, 100, 50);
        
        bSubmit.addActionListener(new ActionListener()
               {
                    public void actionPerformed(ActionEvent e) 
                    {
                     //if(!txtFirstN.getText().equals("") || !txtLastN.getText().equals("") || (!txtAge.getText().equals("") && !txtAge2.getText().equals("") ))
                        new SingleResult(txtFirstN.getText(), txtLastN.getText(), txtAge.getText(), txtAge2.getText());  
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

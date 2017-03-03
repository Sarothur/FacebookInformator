/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.BorderLayout;
import java.awt.Font;
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
     
     SinglePerson ()
     {
        
        fS.setLayout(null);
        fS.setSize(800,600);
        fS.setResizable(false);
        fS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try {
            fS.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture.png")))));
        } catch (IOException e) {
        }
        
        /*JRadioButton option1 = new JRadioButton("Pomocí HTML", false);
        JRadioButton option2 = new JRadioButton("Parametry", true);
        option1.setBounds(50, 25, 125, 20);
        option2.setBounds(185, 25, 100, 20);
        
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
       
        fS.add(option1);
        fS.add(option2);*/
        JLabel lTitle = new JLabel("Jednotlivec");
        lTitle.setFont(new Font("Serif", Font.PLAIN, 44));
        lTitle.setBounds(40, 5, 300, 44);
        
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
        txtAge.setBounds(100, 150, 100, 25);

        JLabel lHTML = new JLabel("HTML:");
        JTextField txtHTML = new JTextField("");
        lHTML.setBounds(50, 200, 50, 25);
        txtHTML.setBounds(100, 200, 100, 25);  
        
        bSubmit.setBounds(50, 350, 200, 50);
        
        fS.add(lFirstN);
        fS.add(txtFirstN);
        fS.add(lLastN);
        fS.add(txtLastN);
        fS.add(lAge);
        fS.add(txtAge);   
        fS.add(lHTML);
        fS.add(txtHTML);
        fS.add(bSubmit);
        fS.add(lTitle);
        
        fS.setVisible(true);
     }
}

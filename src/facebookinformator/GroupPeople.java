/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Uživatel
 */
public class GroupPeople
{
    public JFrame fG = new JFrame("Facebook Informator");
    public JButton bSubmit = new JButton("Hledej");
     
     GroupPeople ()
     {
        
        fG.setLayout(null);
        fG.setSize(800,600);
        fG.setResizable(false);
        fG.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try {
            fG.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture.png")))));
        } catch (IOException e) {
        }
        JLabel lTitle = new JLabel("Skupina lidí");
        lTitle.setFont(new Font("Serif", Font.PLAIN, 44));
        lTitle.setBounds(40, 5, 400, 44);
        
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
        
        bSubmit.setBounds(50, 350, 200, 50);
        
        fG.add(lFirstN);
        fG.add(txtFirstN);
        fG.add(lLastN);
        fG.add(txtLastN);
        fG.add(lAge);
        fG.add(txtAge);   
        fG.add(bSubmit);
        fG.add(lTitle);
        
        fG.setVisible(true);
     
     }
}

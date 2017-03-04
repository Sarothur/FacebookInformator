/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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
            fG.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture2.png")))));
        } catch (IOException e) {
        }
        JLabel lTitle = new JLabel("Statistika lidí");
        lTitle.setFont(new Font("Serif", Font.PLAIN, 60));
        lTitle.setForeground(Color.WHITE);
        lTitle.setBounds(40, 2, 400, 60);
        
        JRadioButton bFirstN = new JRadioButton("Jméno");
        bFirstN.setSelected(true);
        bFirstN.setForeground(Color.WHITE);
        bFirstN.setActionCommand("1");
        
        JRadioButton bLastN = new JRadioButton("Příjmení");
        bLastN.setSelected(false);
        bLastN.setForeground(Color.WHITE);
        bLastN.setActionCommand("2");
        
        JRadioButton bAge = new JRadioButton("Věk");
        bAge.setSelected(false);
        bAge.setForeground(Color.WHITE);
        bAge.setActionCommand("3");
        
        ButtonGroup group = new ButtonGroup();
        group.add(bFirstN);
        group.add(bLastN);
        group.add(bAge);
        
        bFirstN.setBounds(55, 100, 100, 25); bFirstN.setOpaque(false);
        bLastN.setBounds(55, 130, 100, 25); bLastN.setOpaque(false);
        bAge.setBounds(55, 165, 100, 25); bAge.setOpaque(false);
        
        JRadioButton bCountry = new JRadioButton("Země");
        bCountry.setSelected(true);
        bCountry.setForeground(Color.WHITE);
        bCountry.setActionCommand("1");
        
        JRadioButton bCity = new JRadioButton("Město");
        bCity.setSelected(false);
        bCity.setForeground(Color.WHITE);
        bCity.setActionCommand("2");
        
        JRadioButton bUniversity = new JRadioButton("Univerzita");
        bUniversity.setSelected(false);
        bUniversity.setForeground(Color.WHITE);
        bUniversity.setActionCommand("3");
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(bCountry);
        group2.add(bCity);
        group2.add(bUniversity);
        
        bCountry.setBounds(250, 100, 100, 25); bCountry.setOpaque(false);
        bCity.setBounds(250, 130, 100, 25); bCity.setOpaque(false);
        bUniversity.setBounds(250, 165, 100, 25); bUniversity.setOpaque(false);
        
        JTextField txtLeft = new JTextField("");
        txtLeft.setBounds(40, 200, 100, 25);
        JTextField txtRight = new JTextField("");
        txtRight.setBounds(240, 200, 100, 25);
        
       
        bSubmit.setBounds(90, 250, 200, 50);
        
        bSubmit.addActionListener(new ActionListener()
               {
                    public void actionPerformed(ActionEvent e) 
                    {
                     if((!txtLeft.getText().equals("") && txtRight.getText().equals(""))
                       || (!txtRight.getText().equals("") && txtLeft.getText().equals("")))
                        new GroupResult(txtLeft.getText(), txtRight.getText(), group.getSelection().getActionCommand(), group2.getSelection().getActionCommand());  
                    }
                });
        
       
        
        fG.add(bSubmit);
        fG.add(lTitle);
        fG.add(bFirstN);
        fG.add(bLastN);
        fG.add(bAge);
        fG.add(txtLeft);
        
        fG.add(bCountry);
        fG.add(bCity);
        fG.add(bUniversity);
        fG.add(txtRight);
        
        fG.setVisible(true);
     
     }
}

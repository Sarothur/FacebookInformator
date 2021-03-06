/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
/**
 *
 * @author Uživatel
 */
public class MainGUI 
{
    public JFrame f = new JFrame("Facebook Informator");
    public JButton bSingle = new JButton("Vyhledej jednotlivce");
    public JButton bPeople = new JButton("Statistika skupiny lidi");
    public JButton bNet = new JButton("Síť měst");
    
    MainGUI()
    {
        
       f.setLayout(null);
       f.setSize(800,600);
       f.setResizable(false);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture.png")))));
        } catch (IOException e) {
        }
      
       bSingle.setBounds(500, 80, 200, 50);
       bPeople.setBounds(500, 180, 200, 50);
       bNet.setBounds(500, 280, 200, 50);
       
 
       bSingle.addActionListener(new ActionListener()
               {
                    public void actionPerformed(ActionEvent e) 
                    {
                     new SinglePerson();  
                    }
                });

       bPeople.addActionListener(new ActionListener()
               {
                    public void actionPerformed(ActionEvent e) 
                    {
                     new GroupPeople();  
                    }
                });
       
       bNet.addActionListener(new ActionListener()
               {
                    public void actionPerformed(ActionEvent e) 
                    {
                     new Net();  
                    }
                });
       
       f.add(bSingle);
       f.add(bPeople);
       f.add(bNet);
       f.setVisible(true);    
    }
}
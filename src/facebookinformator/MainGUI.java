/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;
import java.awt.FlowLayout;
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
    
    MainGUI()
    {
        
       f.setLayout(null);
       f.setSize(800,600);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture.png")))));
        } catch (IOException e) {
        }
       
       bSingle.setLayout(null);
       bPeople.setLayout(null);
       bSingle.setBounds(50, 50, 200, 50);
       bPeople.setBounds(50, 110, 200, 50);
       bSingle.setActionCommand("Jednotlivec");
       bPeople.setActionCommand("Skupina");
       bSingle.setMnemonic(KeyEvent.VK_D);
       bPeople.setMnemonic(KeyEvent.VK_M);
      
       bSingle.addActionListener(new ActionListener()
               {
                    public void actionPerformed(ActionEvent e) 
                    {
                     System.out.println("Jednotlivec");   
                    }
                });
           
  
       bPeople.addActionListener(new ActionListener()
               {
                    public void actionPerformed(ActionEvent e) 
                    {
                     System.out.println("Skupina lidi");   
                    }
                });
       
       f.add(bSingle);
       f.add(bPeople);
       f.setVisible(true);    
    }
}
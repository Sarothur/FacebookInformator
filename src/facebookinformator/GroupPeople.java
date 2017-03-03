/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Uživatel
 */
public class GroupPeople
{
    public JFrame fS = new JFrame("Facebook Informator - Skupina lidí");
     
     GroupPeople ()
     {
        
        fS.setLayout(null);
        fS.setSize(800,600);
        fS.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try {
            fS.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture.png")))));
        } catch (IOException e) {
        }
        fS.setVisible(true);
     }
}

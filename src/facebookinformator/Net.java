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
public class Net 
{
    public JFrame fN = new JFrame("Facebook Informator");
    Net ()
    {
        fN.setLayout(null);
        fN.setSize(800,600);
        fN.setResizable(false);
        fN.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try {
            fN.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture2.png")))));
        } catch (IOException e) {
        }
        
        fN.setVisible(true);
    }
}

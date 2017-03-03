/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Uživatel
 */
public class SingleResult
{
     public JFrame fSR = new JFrame("Facebook Informator");
     public static String firstName, lastName, age, age2;
     SingleResult(String firstName, String lastName, String age, String age2)
     {
     this.firstName = firstName;
     this.lastName = lastName;
     this.age = age;
     this.age2 = age2;  
     
     String[] columnNames = {"ID","Jméno","Příjmení","Email","Gender", "Město", "Země", "IP adresa", "Telefon", "Univerzita"};
     int headerCount = 10;
     
     Object[][] data = {
    {0, "Kathy", "Smith", "Kathy@seznam.cz", "žena", "Ostrava", "CZ", "172.162.157.4", "457142547", "bradavice"}};
     
     
     
     createUI();
     
     JTable table = new JTable(data, columnNames);
     
     table.setBounds(50,50,700,500);
     
     fSR.setLayout(new BorderLayout());
     fSR.add(table.getTableHeader(), BorderLayout.NORTH);
     fSR.add(table, BorderLayout.CENTER);
     
     
     fSR.setVisible(true);
     }
    public void createUI()
    {
      fSR.setLayout(null);
      fSR.setSize(800,600);
      fSR.setResizable(false);
      fSR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      try {
            fSR.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture.png")))));
        } catch (IOException e) {
        }
    }
}

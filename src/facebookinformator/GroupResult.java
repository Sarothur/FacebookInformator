/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Uživatel
 */
public class GroupResult
{
    public JFrame fGR = new JFrame("Facebook Informator");
    public static String firstName, lastName, age, age2;
    static HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();  
    static Collection dataChart = new HashSet();
            
            
    GroupResult(String firstName, String lastName, String age, String age2)
    {
     this.firstName = firstName;
     this.lastName = lastName;
     this.age = age;
     this.age2 = age2;
     
     createUI();
     /*
     napojeni na fb, vypocty
     */
     fillHashMap();
     checkHashMap();
     
     fGR.setContentPane(createDemoPanel());  
     fGR.setVisible(true);
     
     dataChart.clear();
    }
    
    
    public void createUI()
    {
      fGR.setLayout(null);
      fGR.setSize(800,600);
      fGR.setResizable(false);
      fGR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      try {
            fGR.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("picture.png")))));
        } catch (IOException e) {
        }
    }
    
    private static PieDataset createDataset() 
    {
    DefaultPieDataset dataset = new DefaultPieDataset();
    
    for(Object var : dataChart)
            {
              String i = var.toString();
              dataset.setValue(i, new Double(hm.get(var)));
              //System.out.println("Vek: " + var + ", pocet: " + hm.get(var));  
            }
    
    /*dataset.setValue("Java", new Double(40));
    dataset.setValue("C++", new Double(30));
    dataset.setValue("C", new Double(20));
    dataset.setValue("Pascal", new Double(10));*/
    return dataset;
    }
    
    private static JFreeChart createChart(PieDataset dataset)
    {
    JFreeChart chart = ChartFactory.createPieChart(
    "Chart title", // chart title
    dataset, // data
    true, // include legend
    true,//tooltips
    false);

    return chart;
    }
    
    public static JPanel createDemoPanel()
    {
    JFreeChart chart = createChart(createDataset());
    return new ChartPanel(chart);
    }
    
    public static void checkHashMap()
    {
        int start = Integer.parseInt(age);
        int end = Integer.parseInt(age2);
        
        Collection<?> keys = hm.keySet();
        for(Object key : keys)
        {
          if((int)key >= start && (int)key <= end)
          {
          dataChart.add(key);
         // System.out.println("Vek: " + key + ", pocet: " + hm.get(key)); 
          }
        }
        
       /* for(Object var : dataChart)
            {
              System.out.println("Vek: " + var + ", pocet: " + hm.get(var));  
            }*/
    }
    
    public static void fillHashMap()
    {
        int j = 0; 
        for(int i=10; i <= 100; i++)
        {
        j = i % 10;
        hm.put(i,j);               
        }
    }
    
}

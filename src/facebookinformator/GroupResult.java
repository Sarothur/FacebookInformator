/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public static String txtLeft, txtRight, group, group2;
    static ArrayList<Person> finalPerson = new ArrayList<Person>();
    static Collection dataChart = new HashSet();
    static String title = "";        
            
    GroupResult(String txtLeft, String txtRight, String group, String group2)
    {
     this.txtLeft = txtLeft;
     this.txtRight = txtRight;
     this.group = group;
     this.group2 = group2;
     
     if(!txtLeft.equals(""))
        title += " Levé";
     
     createUI();
     /*
     napojeni na fb, vypocty
     */
     
     checkHashMap(txtLeft, txtRight, group, group2);
     
     
     fGR.setVisible(true);
     fGR.setContentPane(createDemoPanel());  
     dataChart.clear();
     title = "";
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
              String j = hm.get(var).toString();
              if(j.equals("0")){}
              else dataset.setValue(i, new Double(hm.get(var)));
              //System.out.println("Vek: " + var + ", pocet: " + hm.get(var));  
            }
    
    /*dataset.setValue("Pascal", new Double(10));*/
    return dataset;
    }
    
    private static JFreeChart createChart(PieDataset dataset)
    {
    JFreeChart chart = ChartFactory.createPieChart3D(
    "Statistika dle" + title, // chart title
    dataset, // data
    true, // include legend
    true,//tooltips
    false);

    return chart;
    }
    
    public static JPanel createDemoPanel()
    {
    JFreeChart chart = createChart(createDataset());
    final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
    plot.setStartAngle( 270 );             
    plot.setForegroundAlpha( 0.60f );             
    plot.setInteriorGap( 0.02 ); 
    chart.getPlot().setBackgroundPaint(Color.WHITE);
    ChartPanel Panel = new ChartPanel(chart);
    Panel.setBackground(Color.WHITE);
    return Panel;
    }
    
    public static void checkHashMap(String l, String r, String g, String g2)
    {
        Database var = new Database();
        ArrayList<Person> persons = var.getDB();
        
        for(Person pom : persons)
        {
            if(g.equals("1"))
                    {
                    String first = pom.getFirstName();
                    if(first.equals(l))
                        {
                        finalPerson.add(pom);
                        }
                    }
            if(g.equals("2"))
                    {
                    String last = pom.getLastName();
                    if(last.equals(l))
                        {
                        finalPerson.add(pom);
                        }
                    }
            if(g.equals("3"))
                    {
                    String age = pom.getBirthDate();
                    if(age.equals(l))
                        {
                        finalPerson.add(pom);
                        }
                    }
        } 
            
        /*if(!age.equals("") && !age2.equals(""))
        {
            Collection<?> keys = hm.keySet();
            for(Object key : keys)
            {
            if((int)key >= start && (int)key <= end)
                {
                dataChart.add(key);
               // System.out.println("Vek: " + key + ", pocet: " + hm.get(key)); 
                }
            }
        }*/
        
        
       /* for(Object var : dataChart)
            {
              System.out.println("Vek: " + var + ", pocet: " + hm.get(var));  
            }*/
    }
}

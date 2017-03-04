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
    static HashMap<String, Integer> hm = new HashMap<String, Integer>();
    static Collection dataChart = new HashSet();
    static String title = "";        
            
    GroupResult(String txtLeft, String txtRight, String group, String group2)
    {
     this.txtLeft = txtLeft;
     this.txtRight = txtRight;
     this.group = group;
     this.group2 = group2;
     
     if(!txtLeft.equals(""))
        {
            if(group.equals("1")) title += " Jména";
            if(group.equals("2")) title += " Příjmení";
            if(group.equals("3")) title += " Věku";
        }
     
        
     if(!txtRight.equals(""))
        {
            if(group2.equals("1")) title += " Země";
            if(group2.equals("2")) title += " Města";
            if(group2.equals("3")) title += " Univerzity";
        }
     createUI();
     /*
     napojeni na fb, vypocty
     */
     
     check(txtLeft, txtRight, group, group2);
     
     
     fGR.setVisible(true);
     fGR.setContentPane(createDemoPanel());  
     dataChart.clear();
     hm.clear();
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
    String i = "", j = "";
    String var2 = "";
    if(hm.isEmpty()) dataset.setValue("Žaden neexistuje", 1);
    for(String var : hm.keySet())
            {  
              if(var.equals("")) dataset.setValue("Žaden neexistuje", 1);
              dataset.setValue(var, new Double(hm.get(var)));
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
    
    public static void check(String l, String r, String g, String g2)
    {
        Database var = new Database();
        ArrayList<Person> persons = var.getDB();
        String right = "", left = "";
        
        if (!r.equals("") && !l.equals(""))
        {
                
        }
        else if(!l.equals(""))
        {
        for(Person pom : persons)
        {
            if(g.equals("1"))
                    {
                    String first = pom.getFirstName();
                    if(first.equals(l))
                        {
                        if(g2.equals("1")) right = pom.getCountry();
                        if(g2.equals("2")) right = pom.getCity();
                        if(g2.equals("3")) right = pom.getUniversity();
                        finalPerson.add(pom);
                        Integer i = hm.get(right);
                        if(i == null) hm.put(right, 1);
                        else hm.put(right, i +1);
                        }
                    }
            if(g.equals("2"))
                    {
                    String last = pom.getLastName();
                    if(last.equals(l))
                        {
                        if(g2.equals("1")) right = pom.getCountry();
                        if(g2.equals("2")) right = pom.getCity();
                        if(g2.equals("3")) right = pom.getUniversity();
                        finalPerson.add(pom);
                        Integer i = hm.get(right);
                        if(i == null) hm.put(right, 1);
                        else hm.put(right, i +1);
                        }
                    }
            if(g.equals("3"))
                    {
                    String age = pom.getBirthDate();
                    if(age.equals(l))
                        {
                        if(g2.equals("1")) right = pom.getCountry();
                        if(g2.equals("2")) right = pom.getCity();
                        if(g2.equals("3")) right = pom.getUniversity();
                        finalPerson.add(pom);
                        Integer i = hm.get(right);
                        if(i == null) hm.put(right, 1);
                        else hm.put(right, i +1);
                        }
                    }
        } 
        }else if(!r.equals(""))
        {
        for(Person pom : persons)
            {
            
            if(g2.equals("1"))
                    {
                    String first = pom.getCountry();
                    if(first.equals(r))
                        {
                        if(g.equals("1")) left = pom.getFirstName();
                        if(g.equals("2")) left = pom.getLastName();
                        if(g.equals("3")) left = pom.getBirthDate();
                        finalPerson.add(pom);
                        Integer i = hm.get(left);
                        if(i == null) hm.put(left, 1);
                        else hm.put(left, i +1);
                        }
                    }
            if(g2.equals("2"))
                    {
                    String first = pom.getCity();
                    if(first.equals(r))
                        {
                        if(g.equals("1")) left = pom.getFirstName();
                        if(g.equals("2")) left = pom.getLastName();
                        if(g.equals("3")) left = pom.getBirthDate();
                        finalPerson.add(pom);
                        Integer i = hm.get(left);
                        if(i == null) hm.put(left, 1);
                        else hm.put(left, i +1);
                        }
                    }
            if(g2.equals("3"))
                    {
                    String first = pom.getUniversity();
                    if(first.equals(r))
                        {
                        if(g.equals("1")) left = pom.getFirstName();
                        if(g.equals("2")) left = pom.getLastName();
                        if(g.equals("3")) left = pom.getBirthDate();
                        finalPerson.add(pom);
                        Integer i = hm.get(left);
                        if(i == null) hm.put(left, 1);
                        else hm.put(left, i +1);
                        }
                    }
            }
        }
    }
}

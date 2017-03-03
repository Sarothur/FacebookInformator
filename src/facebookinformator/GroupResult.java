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
    GroupResult(String firstName, String lastName, String age)
    {
     createUI();
     fGR.setContentPane(createDemoPanel());  
     fGR.setVisible(true);
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
    dataset.setValue("Java", new Double(40));
    dataset.setValue("C++", new Double(30));
    dataset.setValue("C", new Double(20));
    dataset.setValue("Pascal", new Double(10));
    return dataset;
    }
    
    private static JFreeChart createChart(PieDataset dataset)
    {
    JFreeChart chart = ChartFactory.createPieChart(
    "Programming Language Popularity", // chart title
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
    
}

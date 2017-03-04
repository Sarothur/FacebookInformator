/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.util.MouseManager;

/**
 *
 * @author Uživatel
 */
public class Net 
{
    
    Net ()
    {
        Graph graph = new SingleGraph("Tutorial 1");
        Database db = new Database();
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < db.getDB().size(); i+=50)
        {
          set.add(db.getDB().get(i).getCity());
        }   
        for(String p : set)
        {
            graph.addNode(p);
        }    
        
        ArrayList<String> mesta = new ArrayList<String>();
        for(String s : set)
        {
            mesta.add(s);
        }    
        
        for(int i = 0; i < mesta.size() - 1; i+=1)
        {
            graph.addEdge(mesta.get(i) + mesta.get(i+1), mesta.get(i), mesta.get(i+1));
            if(i == 0) {graph.addEdge(mesta.get(0) + mesta.get(mesta.size()-1), mesta.get(0), mesta.get(mesta.size()-1));}
        }    
       for (Node node : graph) {
        node.addAttribute("ui.label", node.getId());
        }
       
       /* graph.addNode("AB" );
	graph.addNode("CD" );
	graph.addNode("EF" );
	graph.addEdge("ABCD", "AB", "CD");
	graph.addEdge("CDEF", "CD", "EF");
	graph.addEdge("EFAB", "EF", "AB");*/
       //graph.display().setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
       graph.addAttribute("ui.stylesheet", "graph { fill-color: blue; }");
       graph.addAttribute("ui.stylesheet", "node { fill-color: blue;text-mode: normal;shape: cross;} edge{shape: blob;}");
       graph.addAttribute("ui.antialiasing");
       
     
       Viewer viewer = graph.display();
       
       
       viewer.enableXYZfeedback(true);
       
        //graph.display().setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        
        
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Uživatel
 */
public class Database
{
    int age;
    String firstName, lastName, email, gender, city, country;
    Image img;
    
    static ArrayList<Database> individual = new ArrayList<Database>();
    
    Database()
    {
        
    }
    
}

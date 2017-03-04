/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Uživatel
 */
public class Database
{   
    private ArrayList<Person> everyone = new ArrayList<Person>();
    
    Database()
    {
        
        String csvFile = "MOCK_DATA2.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
         try {

            br = new BufferedReader(new FileReader(csvFile));
            //int i = 0;
            ImageReader ir = new ImageReader();
            
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] onePerson = line.split(cvsSplitBy);

                everyone.add(new Person(onePerson[1],onePerson[2],onePerson[3],onePerson[4],onePerson[5],onePerson[6],onePerson[7],onePerson[8],onePerson[9], onePerson[10]));
                //System.out.println(everyone.get(i).getFirstName() + " " + everyone.get(i).getLastName() + " " + everyone.get(i).getEmail() + " " + everyone.get(i).getGender() + " " + everyone.get(i).getCity() + " " + everyone.get(i).getCountry() + " " + everyone.get(i).getIP() + " " + everyone.get(i).getTelephone() + " " + everyone.get(i).getUniversity() + " " + everyone.get(i).getBirthDate());

                
                
                

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
    }
    
    public ArrayList<Person> getDB(){
        return everyone;
    }        
    
}

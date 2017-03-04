/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookinformator;

import java.awt.Image;

/**
 *
 * @author Xanash
 */
public class Person {
    
    private String firstName, lastName, email, gender, city, country, ipAddress, telephone, university, birthdate;
    private Image img = null;
    
    Person(String pfirstName,String plastName, String pemail, String pgender, String pcity,String pcountry, String pipAddress,String ptelephone, String puniversity, String pbirthdate){
        firstName = pfirstName; 
        lastName = plastName;
        email = pemail;
        gender = pgender;
        city = pcity;
        country = pcountry;
        ipAddress = pipAddress;
        telephone = ptelephone;
        university = puniversity; 
        birthdate = pbirthdate;
    }
    void setImage(Image i){
        img = i;
    }   
    String getFirstName(){
        return firstName;
    }
    String getLastName(){
        return lastName;
    }
    String getEmail(){
        return email;
    }
    String getGender(){
        return gender;
    }
    String getCity(){
        return city;
    }
    String getCountry(){
        return country;
    }
    String getIP(){
        return ipAddress;
    }
    String getTelephone(){
        return telephone;
    }
    String getUniversity(){
        return university;
    }
    String getBirthDate(){
        return birthdate;
    }
            
                    
    void setFirstName(String param){
        firstName = param;
    }
    void setLastName(String param){
        lastName = param;
    }
    void setEmail(String param){
        email = param;
    }
    void setGender(String param){
        gender = param;
    }
    void setCity(String param){
       city = param;
    }
    void setCountry(String param){
        country = param;
    }
    void setIP(String param){
        ipAddress = param;
    }
    void setTelephone(String param){
        telephone = param;
    }
    void setUniversity(String param){
        university = param;
    }
    void setBirthDate(String param){
        birthdate = param;
    }
            
    
}

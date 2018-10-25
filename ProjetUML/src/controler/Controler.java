/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.*;

import model.Coureur;

import utilitaire.Connexion;
import utilitaire.Auth;
import utilitaire.DataExtractor;
import vue.*;

/**
 *
 * @author caoyang
 */
public class Controler {
    
    DataExtractor dataExtractor;
    Connexion conn;
    
    public Controler(){
        this.conn = new Connexion();
        this.dataExtractor = new DataExtractor();
    }
    
    public void ConnValider( String em, String mdp){
        if(this.conn.checkConn(em, mdp)){
            if(this.conn.getAuth(em).equals(Auth.USER)){
                VueInscriptions vInscr = new VueInscriptions(em);
                vInscr.setVisible(true);          
            } else {
                System.err.println("ATTENTE!!!");
            }
        } else {
            VueConnexion vConn = new VueConnexion(true);
            vConn.setVisible(true);
        };
    }
    
    public void InscrireCompte(){
        VueInscrireCompte vIC = new VueInscrireCompte();
        vIC.setVisible(true);
    }
    
    public void Deconnecter(){
        VueConnexion vConn = new VueConnexion(false);
        vConn.setVisible(true);
    }
    
    public void SaveInscrireCompte(String em, String mdp,String nom, String prenom, String sexe, String dateNaissance, String groupeS, String nationalite){
        PrintWriter pw;
        
        //save connxion
        String filepathConn = "./data/Connexion.csv";
        try{
            pw = new PrintWriter(new FileOutputStream(filepathConn,true));
            pw.println(em+";"+mdp+";"+Auth.USER);
            pw.flush();
            pw.close();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        //save coureur
        String filepathC = "./data/Coureurs.csv";
        try{            
            pw = new PrintWriter(new FileOutputStream(filepathC,true));
            pw.println(nom+";"+prenom+";"+sexe+";"+dateNaissance+";"+groupeS+";"+nationalite);
            pw.flush();
            pw.close();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        VueConnexion vConn = new VueConnexion(false);
        vConn.setVisible(true);
    }
    
    // 
   
}

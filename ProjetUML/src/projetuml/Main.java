/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetuml;
import vue.*;
import controler.*;

/**
 *
 * @author caoyang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VueConnexion vConn = new VueConnexion(false);
        vConn.setVisible(true);
    }
    
}

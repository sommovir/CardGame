/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame;

import it.lule.cardgame.broker.MQTTBroker;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            System.out.println("[CardGame]Initializing..");
            //preloads data
            System.out.println("[CardGame]Initializing.. [OK]");
            //insert loading GUI
            System.out.println("[CardGame] bye");
            
            MQTTBroker b= new MQTTBroker();
            b.start();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

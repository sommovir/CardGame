/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.mqtt;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author lele
 */
public class MainServerX01 {

    public static void main(String[] args) throws IOException {
        MQTTServer mQTTServer = new MQTTServer();
        
        try {
            mQTTServer.start();
        }catch (MqttException ex) {
            Logger.getLogger(MainServerX01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

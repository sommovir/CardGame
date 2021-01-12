/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.event;

import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author lele
 */
public interface ConnectionEvent {

    public void userConnected(String nickName);
    public void messageArrived(String topic, MqttMessage mqttMessage);
    public void ackReceided(int error);
}

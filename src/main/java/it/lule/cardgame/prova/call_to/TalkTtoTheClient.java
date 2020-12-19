/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.call_to;

import it.lule.cardgame.prova.generic.ChannelEnum;
import it.lule.cardgame.prova.mqtt.MQTTClient;
import org.eclipse.paho.client.mqttv3.MqttException;


/**
 *
 * @author lele
 */
public class TalkTtoTheClient extends MQTTClient{

    public void init() throws MqttException{
        myPersonalChannel();
        topicSubscribe(subscribeMyChannel);
        publish(ChannelEnum.FIRST_CONNECTION.getChannelEnum(), subscribeMyChannel);
    }
    
    /**
     * Add listen to my personal channel
     * @throws MqttException 
     */
    public void myPersonalChannel() {
        subscribeMyChannel = user + clientID;
    }    
    
    public void setLogin(String user){
        
    }    
}

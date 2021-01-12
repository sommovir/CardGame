/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.callToThe;


import it.lule.cardgame.prova.enumname.ChannelEnum;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author lele
 */
public class TalkTtoTheClient extends TalkTtoThe {

    public TalkTtoTheClient() throws MqttException {
        
    }
    
    public void init001() throws MqttException{
        String subscribeMyChannel = mQTTClient.getSubscribeMyChannel();
        
        mQTTClient.publish(ChannelEnum.FIRST_CONNECTION.getChannelEnum(), 
                subscribeMyChannel);
        
    }

  
    
}

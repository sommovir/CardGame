/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.call_to;


import it.lule.cardgame.prova.generic.ChannelEnum;
import it.lule.cardgame.prova.mqtt.MQTTClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author lele
 */
public class TalkTtoTheServer extends MQTTClient {
    
    
    public TalkTtoTheServer() {
    }

    @Override
    public void messageArrived(String topic, MqttMessage mm) throws Exception {
        if (topic.equals(ChannelEnum.FIRST_CONNECTION.getChannelEnum())){
            String message = new String(mm.getPayload());
            System.out.println("TalkTtoTheServer > messageArrived " + message );
            topicSubscribe(message);
        }
    }
    
    
    
    
    public void getInfoFromCLient(){

    }
    
    
    
    public void createRegistration(String nickName, String password) {

    }
}
/*

*/
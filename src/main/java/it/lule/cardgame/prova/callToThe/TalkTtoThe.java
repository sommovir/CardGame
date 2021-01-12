/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.callToThe;

import it.lule.cardgame.prova.event.ConnectionEvent;
import it.lule.cardgame.prova.event.EventManager;
import it.lule.cardgame.prova.mqtt.MQTTClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author lele
 */
public class TalkTtoThe implements ConnectionEvent {

    protected MQTTClient mQTTClient;
    private String topic;
    private MqttMessage mqttMessage;

    public TalkTtoThe() throws MqttException {
        mQTTClient = MQTTClient.getInstance();
        EventManager.getInstance().addConnectionEvents(this);

    }

    /**
     * First Connection
     *
     * @param topic
     * @param mm
     */
    public void firstConnection() {
        System.out.println("TOPIC: " + topic);
        System.out.println("MESSAGE: " + new String(mqttMessage.getPayload()));
    }

    @Override
    public void messageArrived(String _topic, MqttMessage _mqttMessage) {
        this.topic = _topic;
        this.mqttMessage = _mqttMessage;

        switch (topic) {
            case "firstConnection":
                firstConnection();
                break;
        }
    }

    @Override
    public void userConnected(String nickName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ackReceided(int error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

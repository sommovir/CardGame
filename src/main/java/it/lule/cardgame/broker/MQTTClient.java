/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.broker;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Luca
 */
public class MQTTClient implements MqttCallback {
    public static final String LOGIN_TOPIC = "loginTopic";
    private static MQTTClient _instance = null;
    private final int qos = 2;
    private MqttClient sampleClient = null;

    String content = "Visit www.hascode.com! :D";

    String broker = "tcp://0.0.0.0:1883";

    String clientId = "paho-java-client"+new Date().getTime();

    public static MQTTClient getInstance() {
        if (_instance == null) {
            _instance = new MQTTClient();
            return _instance;
        } else {
            return _instance;
        }
    }

    private MQTTClient() {
        super();
    }

    public void connect() {
        String topic = "news";

        try {
            sampleClient = new MqttClient(broker, clientId, new MemoryPersistence());
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("paho-client connecting to broker: " + broker);
            sampleClient.connect(connOpts);

            /* subscribe section */
            sampleClient.subscribe("UserConnected");
            sampleClient.setCallback(this);

            System.out.println("paho-client connected to broker");
            System.out.println("paho-client publishing message: " + content);

            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("paho-client message published");

//            sampleClient.disconnect();
//            System.out.println("paho-client disconnected");
        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

    public void publish(String topic, String message) {
        try {
            MqttMessage mx = new MqttMessage(message.getBytes());
            mx.setQos(qos);
            if (sampleClient.isConnected()) {
                System.out.println("CONNESSOOOO");
            } else {
                sampleClient = new MqttClient(broker, clientId, new MemoryPersistence());
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setCleanSession(true);
                System.out.println("paho-client connecting to broker: " + broker);
                sampleClient.connect(connOpts);
                System.out.println("NOT CONNESSO");
            }
            sampleClient.publish(topic, mx);
        } catch (MqttException ex) {
            Logger.getLogger(MQTTClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        
    }

    @Override
    public void messageArrived(String topic, MqttMessage mm) throws Exception {
        System.out.println("TOPIC: "+topic);
        System.out.println("MESSAGE: "+new String(mm.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        
    }

}

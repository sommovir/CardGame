/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.broker;

import static com.hazelcast.client.impl.protocol.util.UnsafeBuffer.UTF_8;
import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.messages.InterceptConnectMessage;
import io.moquette.interception.messages.InterceptConnectionLostMessage;
import io.moquette.interception.messages.InterceptDisconnectMessage;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.moquette.server.Server;
import io.moquette.server.config.ClasspathResourceLoader;
import io.moquette.server.config.ResourceLoaderConfig;
import io.netty.buffer.ByteBufUtil;
import it.lule.cardgame.db.DBException;
import it.lule.cardgame.db.DBManager;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class MQTTBroker {
    public static final String LOGIN_TOPIC = "loginTopic";
    
    private List<String> ON_LINE = new LinkedList<>();

    public void start() throws IOException {

        // we create the MQTT broker..
        final Server mqtt_broker = new Server();

        // we start the MQTT broker..
        mqtt_broker.startServer(new ResourceLoaderConfig(new ClasspathResourceLoader()),
                Collections.singletonList(new AbstractInterceptHandler() {

                    @Override
                    public String getID() {
                        return "EmbeddedLauncherPublishListener";
                    }

                    @Override
                    public void onDisconnect(InterceptDisconnectMessage idm) {
                        ON_LINE.remove(idm.getClientID());
                    }

                    @Override
                    public void onConnectionLost(InterceptConnectionLostMessage iclm) {
                        ON_LINE.remove(iclm.getClientID());
                    }

                    @Override
                    public void onConnect(InterceptConnectMessage icm) {
                        ON_LINE.add(icm.getClientID());
                    }

                    @Override
                    public void onPublish(InterceptPublishMessage msg) {
                        final String decodedPayload = new String(ByteBufUtil.getBytes(msg.getPayload()), UTF_8);
                        System.out.println("Received on topic: " + msg.getTopicName() + " content: " + decodedPayload);
                        String topic = msg.getTopicName();
                        
                        if ( topic.equals(LOGIN_TOPIC)){
                            String[] split = decodedPayload.split(",");
                            String nickname = split[0];
                            String password = split[1];
                            try {
                                DBManager.getInstance().login(nickname, password);
                            } catch (DBException ex) {
                                Logger.getLogger(MQTTBroker.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                    }
                }));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //app.stop();
            mqtt_broker.stopServer();
            //EMF.close();
        }));

    }
}

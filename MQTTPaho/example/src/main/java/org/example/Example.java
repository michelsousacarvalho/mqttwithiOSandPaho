package org.example;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnect;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Example {

	public static void main(String[] args) {
		String topic = "test/mqttAndiOS";
		String content =  "MESSAGE FROM MQTT PUBLISHSAmpleteste2 Test";
		int qos = 2;
		String broker = "tcp://iot.eclipse.org:1883";
		String clientID = "MichelSousaCarvalho";
		MemoryPersistence persistence = new MemoryPersistence();
		
		try {
			MqttClient sampleClient = new MqttClient(broker, clientID, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(false);
			System.out.println("Connection to broker "+broker);
			sampleClient.connect(connOpts);
			System.out.println("Connect");
			System.out.println("Publishing message " + content);
			MqttMessage message =  new MqttMessage(content.getBytes());
			message.setQos(qos);
			sampleClient.publish(topic, message);
			System.out.println("Message Published");
//			sampleClient.disconnect();
//			System.out.println("Disconnect");
			System.exit(0);
		} catch (MqttException me) {
			 System.out.println("reason "+me.getReasonCode());
	            System.out.println("msg "+me.getMessage());
	            System.out.println("loc "+me.getLocalizedMessage());
	            System.out.println("cause "+me.getCause());
	            System.out.println("excep "+me);
	            me.printStackTrace();
		}
	}
	
	
}

package org.example;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Subcribe {

	
	
	public static void main(String[] args) throws MqttException {
		String topic = "test/mqtt";
		String content =  "MESSAGE FROM MQTT PUBLISHSAmple";
		int qos = 2;
		String broker = "tcp://iot.eclipse.org:1883";
		String clientID = "MichelSousaCarvalho1";
		MemoryPersistence persistence = new MemoryPersistence();
		MqttClient client = new MqttClient(broker, clientID);
		client.setCallback(new SubcribeCallBack());
		client.connect();
		client.subscribe(topic);
		
		
	}
}

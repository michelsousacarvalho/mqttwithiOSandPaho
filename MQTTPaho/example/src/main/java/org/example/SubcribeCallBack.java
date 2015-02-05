package org.example;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;



public class SubcribeCallBack implements  MqttCallback {

	public void connectionLost(Throwable arg0) {
		 	System.out.println("connectionLost");
		
	}

	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("deliveryComplete");
		
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Message arrived. Topic: " + topic + "  Message: " + message.toString());
	}



}

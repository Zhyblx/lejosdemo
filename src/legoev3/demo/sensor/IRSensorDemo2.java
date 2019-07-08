package legoev3.demo.sensor;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

public class IRSensorDemo2 {

	public static void main(String[] args) {
		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);
		SensorMode sensorMode = iRSensor.getDistanceMode();// EV3红外线传感器探测距离模式，测量距传感器前方物体的距离。
		float[] floatSensorMode = new float[sensorMode.sampleSize()]; // sampleSize()返回样本中元素的数量;即，看做是数组的长度
		System.out.println(floatSensorMode.length);// 采集到1个元素，那么数组的长度就为1

		sensorMode.fetchSample(floatSensorMode, 0);//从传感器将采集到的样本取出
		for (int i = 0; i < floatSensorMode.length; i++) {
			System.out.println("探测距离是：" + floatSensorMode[i]);

		}

//		System.out.println(floatSensorMode[0]);
//
//		for (float floatNum : floatSensorMode) {
//			System.out.println(floatNum);
//
//		}

		Delay.msDelay(10000);

	}

}

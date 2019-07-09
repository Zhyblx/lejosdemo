package legoev3.demo.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 类：IRSensorDemo  作用：通过EV3提供的红外传感器，完成测量与前方物体的距离
 * 
 * @author zhangyibin
 *
 */

public class IRSensorDemo {

	public static void main(String[] args) {
		
		/*
		 * EV3IRSensor(类):EV3红外线传感器实现类；构造方法中的参数是代表“端口号” 
		 * SensorPort(接口):EV3传感器端口的基本接口；示例：S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
		 * SensorMode(接口):该接口抽象了“传感器”模式的实现；
		 * 
		 */
		
		@SuppressWarnings("resource")
		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);//EV3红外线传感器实现类；构造方法中的参数是代表“端口号” 
		SensorMode sensorMode = iRSensor.getDistanceMode();// 调用getDistanceMode()方法表示开启“外线传感器距离模式”；并且测量距传感器与前方物体的距离；该方法返回的数据类型为SensorMode
		float[] floatSensorMode = new float[sensorMode.sampleSize()]; // 通过sampleSize()方法，返回传感器采集到的“测量距离”个数；每个采集到的“距离”通过数组的方式进行存储
		System.out.println(floatSensorMode.length);

		sensorMode.fetchSample(floatSensorMode, 0);// 从数组中取出采集的"距离"数
		/*
		 * 每一个采集的“距离”数都通过数组元素输出的方式呈现
		 */
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

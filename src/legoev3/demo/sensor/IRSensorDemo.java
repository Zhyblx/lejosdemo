package legoev3.demo.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 距离传感器
 * 
 * 类：IRSensorDemo  作用：通过EV3提供的红外传感器，完成测量与前方物体的距离
 * 
 * API地址：
 * 	EV3IRSensor(类):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3IRSensor.html
 * 	SensorMode(接口):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/SensorMode.html
 * 	SensorPort(接口):http://www.lejos.org/ev3/docs/lejos/hardware/port/SensorPort.html
 * 	SensorMode(接口)继承了SampleProvider(接口)；所以SensorMode可以直接调用fetchSample()和sampleSize()方法
 * 	SampleProvider(接口):http://www.lejos.org/ev3/docs/lejos/robotics/SampleProvider.html
 * 
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
		 * 注意：如果“距离”太远，超过了0~50cm的采集范围，那么距离数的返回值是Infinity
		 */
		for (int i = 0; i < floatSensorMode.length; i++) {
			System.out.println("distance:" + floatSensorMode[i]+"cm");

		}
		iRSensor.close();// 关闭传感器

//		System.out.println(floatSensorMode[0]);
//
//		for (float floatNum : floatSensorMode) {
//			System.out.println(floatNum);
//
//		}
		Delay.msDelay(10000);

	}
}

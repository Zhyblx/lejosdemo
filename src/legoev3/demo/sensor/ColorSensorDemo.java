package legoev3.demo.sensor;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 颜色传感器 
 * 
 * 类：ColorSensorDemo 作用：通过EV3提供的颜色传感器，完成测量前方物体颜色的探测
 * API地址：
 * 	EV3ColorSensor(类):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3ColorSensor.html
 * 	SensorMode(接口):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/SensorMode.html
 * 	SensorPort(接口):http://www.lejos.org/ev3/docs/lejos/hardware/port/SensorPort.html
 * 	SensorMode(接口)继承了SampleProvider(接口)；所以SensorMode可以直接调用fetchSample()和sampleSize()方法
 * 	SampleProvider(接口):http://www.lejos.org/ev3/docs/lejos/robotics/SampleProvider.html
 * 
 * @author zhangyibin
 *
 */

public class ColorSensorDemo {

	public static void main(String[] args) {

		/*
		 * EV3ColorSensor(类):EV3颜色传感器实现类；构造方法中的参数是代表“端口号” 
		 * SensorPort(接口):EV3传感器端口的基本接口；示例：S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
		 * SensorMode(接口):该接口抽象了“传感器”模式的实现；
		 * 
		 */
		
		EV3ColorSensor eV3ColorSensor = new EV3ColorSensor(SensorPort.S2);//EV3颜色传感器实现类；构造方法中的参数是代表“端口号” 
		System.out.println(eV3ColorSensor.getColorID()); // 方法getColorID() 可以直接返回检测到的颜色ID

		SensorMode sensorMode = eV3ColorSensor.getColorIDMode();// 通过调用getColorIDMode()方法完成颜色的探测(即，开启颜色ID模式)；该方法返回的数据类型为SensorMode
		float[] floatSensorMode = new float[sensorMode.sampleSize()];// 通过sampleSize()方法，返回传感器采集到的“颜色ID”个数；每个采集到的“颜色ID”通过数组的方式进行存储

		sensorMode.fetchSample(floatSensorMode, 0);// 从数组中取出采集的"颜色ID"数

		/*
		 * 1.每一个采集的“颜色ID”数都通过数组元素输出的方式呈现
		 * 2.判断采集到的颜色ID并输出具体的颜色值
		 * 
		 */
		
		for (float colorId : floatSensorMode) {
			if (colorId == ColorInterface.BLACK) {
				LCD.drawString("BLACK", 0, 0);

			} else if (colorId == ColorInterface.BLUE) {
				LCD.drawString("BLUE", 0, 0);

			} else if (colorId == ColorInterface.BROWN) {
				LCD.drawString("BROWN", 0, 0);

			} else if (colorId == ColorInterface.CYAN) {
				LCD.drawString("CYAN", 0, 0);

			} else if (colorId == ColorInterface.DARK_GRAY) {
				LCD.drawString("DARK_GRAY", 0, 0);

			} else if (colorId == ColorInterface.GRAY) {
				LCD.drawString("GRAY", 0, 0);

			} else if (colorId == ColorInterface.GREEN) {
				LCD.drawString("GREEN", 0, 0);

			} else if (colorId == ColorInterface.LIGHT_GRAY) {
				LCD.drawString("LIGHT_GRAY", 0, 0);

			} else if (colorId == ColorInterface.MAGENTA) {
				LCD.drawString("MAGENTA", 0, 0);

			} else if (colorId == ColorInterface.NONE) {
				LCD.drawString("NONE", 0, 0);

			} else if (colorId == ColorInterface.ORANGE) {
				LCD.drawString("ORANGE", 0, 0);

			} else if (colorId == ColorInterface.PINK) {
				LCD.drawString("PINK", 0, 0);

			} else if (colorId == ColorInterface.RED) {
				LCD.drawString("RED", 0, 0);

			} else if (colorId == ColorInterface.WHITE) {
				LCD.drawString("WHITE", 0, 0);

			} else if (colorId == ColorInterface.YELLOW) {
				LCD.drawString("YELLOW", 0, 0);

			} 
		}
		eV3ColorSensor.close();// 关闭传感器
		Delay.msDelay(5000);

	}
}

package legoev3.demo.sensor;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

/**
 * 背景说明： 1.红外传感器(InfraRedSensor) 2.红外传感器的作用测距、定位。
 * 
 * API地址：
 * 	EV3IRSensor(类):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3IRSensor.html
 * 	SensorMode(接口):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/SensorMode.html
 * 	Port(接口):http://www.lejos.org/ev3/docs/lejos/hardware/port/Port.html
 * 	SensorPort(接口):http://www.lejos.org/ev3/docs/lejos/hardware/port/SensorPort.html
 * 
 * 
 * 
 * @author zhangyibin
 *
 */

public class IRSensorDemo {

	public static void main(String[] args) {
		/*
		 * 获取端口实例:getPort("S4")返回请求端口名称的端口对象
		 * EV3传感器端口的基本接口:S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
		 * 
		 * 
		 */
//		Port port = LocalEV3.get().getPort(String.valueOf(SensorPort.S4));
		
		/*
		 * EV3IRSensor(类): EV3红外线传感器实现类；构造方法中的参数是代表 端口号
		 * SensorMode(接口) 传感器模式接口；作用于存储getDistanceMode()方法返回的测量距离(测量距传感器前方物体的距离)
		 * getDistanceMode()方法的返回值是SensorMode类型。
		 * 
		 */
		
		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S4);
		SensorMode sensorMode = iRSensor.getDistanceMode();
		sensorMode.sampleSize();// 返回测量的距离数值

		LCD.drawString(String.valueOf(iRSensor.IR_CHANNELS), 0, 0);// 返回具体的端口
		LCD.drawString(String.valueOf((sensorMode.sampleSize())), 0, 0); // ?返回一个具体的探测距离(这里不知道是不是对的)

//		iRSensor.getDistanceMode();
//		LCD.drawString(String.valueOf(iRSensor.getDistanceMode()), 0, 0);
//		iRSensor.getAvailableModes();
		Delay.msDelay(10000);

	}
}

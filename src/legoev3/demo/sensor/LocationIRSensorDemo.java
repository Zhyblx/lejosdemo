package legoev3.demo.sensor;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 远程定位
 * 
 * API地址：
 * EV3IRSensor(类):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3IRSensor.html
 * 
 * 
 * @author zhangyibin
 *
 */
public class LocationIRSensorDemo {

	public static void main(String[] args) throws Exception {
		/*
		 * EV3IRSensor(类):EV3红外线传感器实现类；构造方法中的参数是代表“端口号”
		 * SensorPort(接口):EV3传感器端口的基本接口；示例：S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
		 * SensorMode(接口):该接口抽象了“传感器”模式的实现；
		 * 
		 */
/*
		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);
		SensorMode sensorMode = iRSensor.getSeekMode();
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		System.out.println(floatSensorMode.length);
		sensorMode.fetchSample(floatSensorMode, 0);

		for (int i = 0; i < floatSensorMode.length; i++) {
			Thread.sleep(1000);
			System.out.println(i+">>>>"+floatSensorMode[i]);

		}
		iRSensor.close();
*/
		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);
		SensorMode sensorMode = iRSensor.getSeekMode();
		float[] floatSensorMode = new float[sensorMode.sampleSize()]; 
		System.out.println(floatSensorMode.length);

		sensorMode.fetchSample(floatSensorMode, 0);
	
		for (int i = 0; i < floatSensorMode.length; i++) {
			Thread.sleep(1000);
			System.out.println(i+">>>>"+floatSensorMode[i]);

		}
		iRSensor.close();// 关闭传感器
		Delay.msDelay(5000);
	}
}

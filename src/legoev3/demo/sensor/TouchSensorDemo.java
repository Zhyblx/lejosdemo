package legoev3.demo.sensor;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 触摸传感器
 * 
 * API地址：
 * 	EV3TouchSensor(类)：http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3TouchSensor.html#getTouchMode--
 * 
 * @author zhangyibin
 *
 */

public class TouchSensorDemo {

	public static void main(String[] args) throws Exception {
		/*
		 * 
		 * EV3TouchSensor(类):EV3触摸传感器实现类；构造方法中的参数是代表“端口号”
		 * SensorPort(接口):EV3传感器端口的基本接口；示例：S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
		 * SensorMode(接口):该接口抽象了“传感器”模式的实现；
		 */

		EV3TouchSensor eV3TouchSensor = new EV3TouchSensor(SensorPort.S3);
		SensorMode sensorMode = eV3TouchSensor.getTouchMode(); // 调用方法getTouchMode()表示探测传感器的触摸模式。
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
//		System.out.println(floatSensorMode.length);
		sensorMode.fetchSample(floatSensorMode, 0);
		for (float touchNum : floatSensorMode) {
			/*
			 * 
			 * 1.判断：触摸传感器:返回值0表示未按下按钮，1表示已按下按钮
			 * 2.操作注意点：在测试触摸传感器的过程中，发现需“长按”触摸传感器；如果按下的频率过快会导致传感器探测不到“按下”操作。
			 * 
			 */
			if(touchNum==1.0) {
				LCD.drawString("click...", 0, 0);
				eV3TouchSensor.close();// 关闭传感器
				
			}
		}
		Delay.msDelay(5000);
	}
}

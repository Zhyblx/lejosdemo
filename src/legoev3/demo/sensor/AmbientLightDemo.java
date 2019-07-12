package legoev3.demo.sensor;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 颜色传感器：探测环境光线 类：AmbientLightDemo 
 * 
 * 作用：通过EV3提供的颜色传感器，探测环境光线强度
 * 
 * API地址：
 * 	EV3ColorSensor(类):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3ColorSensor.html
 * 
 * @author zhangyibin
 *
 */

public class AmbientLightDemo {

	/*
	 * 方法：getAmbientNum()作用于返回当前探测到的光线强度。 返回的探测值：在0.0～1.0之间，值越大表示光线越强。
	 * 
	 * EV3ColorSensor(类):EV3颜色传感器实现类；构造方法中的参数是代表“端口号”
	 * SensorPort(接口):EV3传感器端口的基本接口；示例：S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
	 * SensorMode(接口):该接口抽象了“传感器”模式的实现；
	 * 
	 */
	private EV3ColorSensor eV3ColorSensor = null;

	public float getAmbientNum() {
		eV3ColorSensor = new EV3ColorSensor(SensorPort.S2);
		float returnAmbientNum = 0;
		SensorMode sensorMode = eV3ColorSensor.getAmbientMode();// 该方法表示开启“环境模式”
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		sensorMode.fetchSample(floatSensorMode, 0);
		for (float ambientNum : floatSensorMode) {
			returnAmbientNum = ambientNum;

		}
		eV3ColorSensor.close();// 关闭传感器
		return returnAmbientNum;// 返回探测值

	}

	public static void main(String[] args) throws Exception {
		AmbientLightDemo ambientLightDemo = new AmbientLightDemo();
		float num = ambientLightDemo.getAmbientNum();
		LCD.drawString(String.valueOf(num), 0, 0);
		Delay.msDelay(5000);

	}
}

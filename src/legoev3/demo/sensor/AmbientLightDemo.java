package legoev3.demo.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 环境光线传感器 探测环境光线 标准化在0和1之间
 * 
 * @author zhangyibin
 *
 */

public class AmbientLightDemo {

	private static EV3ColorSensor eV3ColorSensor = new EV3ColorSensor(SensorPort.S2);
	public static void main(String[] args) throws Exception {
		
		SensorMode sensorMode = eV3ColorSensor.getAmbientMode();
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		sensorMode.fetchSample(floatSensorMode, 0);
		for (float ambientNum : floatSensorMode) {
			System.out.println("1"+ambientNum);
			System.out.println("2"+ambientNum);
			System.out.println("3"+ambientNum);
			System.out.println("4"+ambientNum);
			System.out.println("5"+ambientNum);
			System.out.println("6"+ambientNum);
			System.out.println("7"+ambientNum);


		}
		eV3ColorSensor.close();
		Delay.msDelay(10000);

	}

}

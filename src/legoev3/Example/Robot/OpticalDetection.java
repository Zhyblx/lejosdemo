package legoev3.Example.Robot;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

/**
 * 类：OpticalDetection(光学检测)
 * 
 * @author zhangyibin
 *
 */
public class OpticalDetection {

	private static EV3ColorSensor eV3ColorSensor = null;
	private static SensorMode sensorMode = null;

	public static float getOpticalDetection() {
		eV3ColorSensor = new EV3ColorSensor(SensorPort.S2);
		float returnAmbientNum = 0;
		sensorMode = eV3ColorSensor.getAmbientMode();// 该方法表示开启“环境模式”
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		sensorMode.fetchSample(floatSensorMode, 0);
		for (float ambientNum : floatSensorMode) {
			returnAmbientNum = ambientNum;

		}
		eV3ColorSensor.close();// 关闭传感器
		return returnAmbientNum;// 返回探测值

	}
}

package legoev3.Example.Robot.MARK_1;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;

/**
 * 
 * 类：RangeDetection(距离检测)
 * 
 * @author zhangyibin
 *
 */

public class RangeDetection {

	private static EV3IRSensor iRSensor = null;
	private static SensorMode sensorMode = null;

	public static float getRangeDetection() {
		iRSensor = new EV3IRSensor(SensorPort.S1);
		sensorMode = iRSensor.getDistanceMode();
		float returnDistanceNum = 0;
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		sensorMode.fetchSample(floatSensorMode, 0);
		for (int i = 0; i < floatSensorMode.length; i++) {
			returnDistanceNum = floatSensorMode[i];

		}
		LCD.drawString(String.valueOf(returnDistanceNum), 0, 1);
		iRSensor.close();// 关闭传感器
		return returnDistanceNum;

	}
}

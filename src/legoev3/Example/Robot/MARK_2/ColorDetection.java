package legoev3.Example.Robot.MARK_2;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

/**
 * 类：ColorDetection (颜色检测)
 * 
 * @author zhangyibin
 *
 */

public class ColorDetection {

	private static EV3ColorSensor eV3ColorSensor = null;
	private static SensorMode sensorMode = null;

	public static float getColorDetection() {
		float returnColorNum = 0;

		eV3ColorSensor = new EV3ColorSensor(SensorPort.S2);
		sensorMode = eV3ColorSensor.getColorIDMode();
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		sensorMode.fetchSample(floatSensorMode, 0);
		for (float colorId : floatSensorMode) {
			returnColorNum = colorId;

		}

		eV3ColorSensor.close(); // 关闭传感器
		LCD.drawString("Color:" + String.valueOf(returnColorNum), 0, 3);
		return returnColorNum;

	}
}

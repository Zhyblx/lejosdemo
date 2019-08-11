package legoev3.Example.Robot.MARK_4;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;

/**
 * 类：PositionSystem
 * 
 * 作用：定位坐标
 * 
 * @author zhangyibin
 *
 */

public class PositionSystem {

	public static float getCoordinate() throws Exception {
		Thread.sleep(2000);
		float coordinateNum = 0;
		EV3IRSensor eV3IRSensor = new EV3IRSensor(SensorPort.S1);
		SensorMode sensorMode = eV3IRSensor.getSeekMode();
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		sensorMode.fetchSample(floatSensorMode, 0);// 从数组中取出采集的"定位"的数据
		for (float num : floatSensorMode) {
			coordinateNum = num;

		}

		eV3IRSensor.close();
		return coordinateNum;

	}
}

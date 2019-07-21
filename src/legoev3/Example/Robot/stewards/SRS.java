package legoev3.Example.Robot.stewards;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

/**
 * 类：SRS(安全气囊）
 * 
 * @author zhangyibin
 *
 */

public class SRS {
	/*
	 * 如果SRSNum=true;说明安全气囊开启
	 */
	EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S3);

	public boolean getSRS() {
		boolean SRSNum = false;
		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);
		int command = iRSensor.getRemoteCommand(2);
		if (command != 0) {
			SRSNum = true;

		}
		iRSensor.close();
		return SRSNum;

	}
}

package legoev3.demo.sensor;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * 远程控制(遥控器)
 * 
 * API地址：
 * EV3IRSensor(类):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3IRSensor.html
 * 
 * @author zhangyibin
 *
 */
public class ControlIRSensorDemo {

	public static void main(String[] args) throws Exception {
		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);
		int cmd = iRSensor.getRemoteCommand(1);
		LCD.drawInt(cmd, 0, 0);

		byte[] buf = new byte[4];
		iRSensor.getRemoteCommands(buf, 0, 4);
		int i = 0;
		for (byte butyNum : buf) {
			if (butyNum != 0) {
				i++;
				LCD.drawInt(i, 0, 2);
			}

		}

		Delay.msDelay(3000);
		iRSensor.close();
	}
}

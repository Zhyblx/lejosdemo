package legoev3.demo.sensor;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class IRSensorDemo {

	public static void main(String[] args) {
		// 获取端口实例
		Port port = LocalEV3.get().getPort("S4");
		// 获取超声波EV3传感器
//		SensorModes sensorModes = new EV3IRSensor(port);
//		LCD.drawString(sensorModes.getName(), 0, 0);

		EV3IRSensor iRSensor = new EV3IRSensor(port);

//		iRSensor.getDistanceMode();
//		LCD.drawString(String.valueOf(iRSensor.getDistanceMode()), 0, 0);
//		iRSensor.getAvailableModes();

		LCD.drawString(String.valueOf(iRSensor.IR_CHANNELS), 0, 0);

		Delay.msDelay(10000);

	}
}

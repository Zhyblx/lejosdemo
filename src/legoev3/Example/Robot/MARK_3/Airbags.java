package legoev3.Example.Robot.MARK_3;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 类：Airbags 作用：遥控车的安全气囊
 * 
 * @author zhangyibin
 *
 */

public class Airbags {
	
	private EV3TouchSensor eV3TouchSensor = new EV3TouchSensor(SensorPort.S3);// 触摸传感器
	private int i = 0;
	public void getAirbags() {
		while (true) {
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				e.printStackTrace();

			}
			LCD.clear(8);
			LCD.drawString("count:" + String.valueOf(i), 0, 6);
			SensorMode sensorMode = eV3TouchSensor.getTouchMode();
			float[] floatSensorMode = new float[sensorMode.sampleSize()];
			sensorMode.fetchSample(floatSensorMode, 0);
			for (float touchNum : floatSensorMode) {
				if (touchNum == 1.0) {
					LCD.clear(8);
					LCD.drawString("security", 0, 6);
					eV3TouchSensor.close();// 关闭传感器
					Delay.msDelay(2000);
					System.exit(0); // 关闭程序

				}
			}
			i++;

		}
	}
}

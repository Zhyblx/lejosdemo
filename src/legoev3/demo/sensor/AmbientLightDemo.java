package legoev3.demo.sensor;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 环境光线传感器 探测环境光线 标准化在0和1之间
 * 
 * @author zhangyibin
 *
 */

public class AmbientLightDemo {

	private EV3ColorSensor eV3ColorSensor = new EV3ColorSensor(SensorPort.S2);

	// 探测光线强度
	public float getAmbientNum() {
		float returnAmbientNum = 0;
		SensorMode sensorMode = eV3ColorSensor.getAmbientMode();
		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		sensorMode.fetchSample(floatSensorMode, 0);
		for (float ambientNum : floatSensorMode) {
			returnAmbientNum = ambientNum;

		}
		return returnAmbientNum;

	}

	// 关闭探测器
	public void getColorSensorClose() {
		eV3ColorSensor.close();

	}

	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			AmbientLightDemo ambientLightDemo = new AmbientLightDemo();
			int i = 1;// 60秒
			while (i < 61) {
				try {
					Thread.sleep(1000);

				} catch (Exception e) {
					e.printStackTrace();

				}
				float num = ambientLightDemo.getAmbientNum(); // 探测到的数据
				if (num < 0.2) {
					LCD.drawString(".", i, 6);

				} else if (num >= 0.2 && num < 0.4) {
					LCD.drawString(".", i, 5);

				} else if (num >= 0.4 && num < 0.6) {
					LCD.drawString(".", i, 4);

				} else if (num >= 0.6 && num < 0.8) {
					LCD.drawString(".", i, 3);

				} else if (num >= 0.8 && num <= 1) {
					LCD.drawString(".", i, 2);
				}

				if (i == 60) {
					ambientLightDemo.getColorSensorClose();
					timer.cancel();

				}

				i++;
			}

		}

	};

	public static void main(String[] args) throws Exception {
		timer.schedule(timerTask, 0);

	}

//	private static EV3ColorSensor eV3ColorSensor = new EV3ColorSensor(SensorPort.S2);
//	public static void main(String[] args) throws Exception {
//		
//		SensorMode sensorMode = eV3ColorSensor.getAmbientMode();
//		float[] floatSensorMode = new float[sensorMode.sampleSize()];
//		sensorMode.fetchSample(floatSensorMode, 0);
//		for (float ambientNum : floatSensorMode) {
//			
//			System.out.println("1"+ambientNum);
//			System.out.println("2"+ambientNum);
//			System.out.println("3"+ambientNum);
//			System.out.println("4"+ambientNum);
//			System.out.println("5"+ambientNum);
//			System.out.println("6"+ambientNum);
//			System.out.println("7"+ambientNum);
//
//
//		}
//		eV3ColorSensor.close();
//		Delay.msDelay(10000);
//
//		
//	}

}

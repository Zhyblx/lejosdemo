package legoev3.Example.Robot.MARK_3;

import legoev3.Example.Robot.MARK_2.ColorDetection;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类：Telecar (遥控车)
 * 
 * 1 代表前进；1\2：6代表向左转 ； 1\4：10代表向右转
 * 
 * 3 代表后退；3\2：7代表向左转 ； 3\4：11代表向右转
 * 
 * @author zhangyibin
 *
 */

public class Telecar implements Runnable {

	private EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);// 远程传感器

	private RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C);
	private RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);

	@Override
	public void run() {
		int i = 5;
		while (true) {
			try {
				Thread.sleep(1000);
				LCD.drawString("sleep:" + String.valueOf(i), 0, 0);

			} catch (Exception e) {
				e.printStackTrace();

			}

			if (i == 1) {
				motorC.setSpeed(300);// 设置电机C的转速
				motorB.setSpeed(300);// 设置电机B的转速

				while (Button.DOWN.isDown() != true) {
					byte[] commandArrays = new byte[4];
					iRSensor.getRemoteCommands(commandArrays, 0, 4);
					// int i = 0; // 变量i 用于标记按下的次数
					for (float commandNum : commandArrays) {
						if (commandNum != 0) {
							if (commandNum == 1) {
								LCD.clear(2);
								LCD.drawString("forward:" + String.valueOf(commandNum), 0, 2);
								motorC.forward();// 前进
								motorB.forward();

							} else if (commandNum == 3) {
								LCD.clear(2);
								LCD.drawString("backward:" + String.valueOf(commandNum), 0, 2);
								motorC.backward();// 倒退
								motorB.backward();

							} else if (commandNum == 9) {
								LCD.clear(2);
								LCD.drawString("stop:" + String.valueOf(commandNum), 0, 2);
								motorC.stop();// 停止
								motorB.stop();

							} else if (commandNum == 10) {
								LCD.clear(2);
								LCD.drawString("forward&rotate:" + String.valueOf(commandNum), 0, 2);
								motorC.forward();// 前进
								motorB.forward();
								motorC.rotate(200);// 向前 向左转

							} else if (commandNum == 6) {
								LCD.clear(2);
								LCD.drawString("forward&rotate:" + String.valueOf(commandNum), 0, 2);
								motorC.forward();// 前进
								motorB.forward();
								motorB.rotate(200);// 向前 向右转

							} else if (commandNum == 7) {
								LCD.clear(2);
								LCD.drawString("backward&rotate:" + String.valueOf(commandNum), 0, 2);
								motorC.backward();// 倒退
								motorB.backward();
								motorC.rotate(200);// 向后 向左转

							} else if (commandNum == 11) {
								LCD.clear(2);
								LCD.drawString("backward&rotate:" + String.valueOf(commandNum), 0, 2);
								motorC.backward();// 倒退
								motorB.backward();
								motorB.rotate(200);// 向后 向右转

							} else if (commandNum == 5) {
								motorC.setSpeed(500);// 设置电机C的转速
								motorB.setSpeed(500);// 设置电机B的转速

							} else if (commandNum == 8) {
								motorC.setSpeed(300);// 设置电机C的转速
								motorB.setSpeed(300);// 设置电机B的转速

							} else if (commandNum == 2 || commandNum == 4) {
								// 颜色探测
								float colorNum = ColorDetection.getColorDetection();
								LCD.drawString("color:" + String.valueOf(colorNum), 0, 5);

							}
						}
					}
					Delay.msDelay(1000);// 延迟1秒

				}
				iRSensor.close();// 关闭传感器
				System.exit(0);
				break;

			}
			i--;

		}
	}

	private static Telecar telecar = new Telecar();
	private static Timer timer = new Timer();
	private static EV3TouchSensor eV3TouchSensor = new EV3TouchSensor(SensorPort.S3);// 触摸传感器
	private static int i = 0;
	private static TimerTask timerTack = new TimerTask() {
		@Override
		public void run() {
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
	};

	public static void main(String[] args) throws Exception {
		new Thread(telecar).start();
		timer.schedule(timerTack, 0, 500);

	}
}

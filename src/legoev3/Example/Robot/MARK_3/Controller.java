package legoev3.Example.Robot.MARK_3;

import legoev3.Example.Robot.MARK_2.ColorDetection;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * 类：Controller
 * 作用：遥控车的逻辑逻辑控制部分
 * 
 * @author zhangyibin
 *
 */

public class Controller {
	
	private EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);// 远程传感器
	private RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C);
	private RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);
	
	public void getController() {
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

}

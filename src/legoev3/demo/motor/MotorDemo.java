package legoev3.demo.motor;

import lejos.robotics.RegulatedMotor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类：MotorDemo 作用：示例EV3大型电机的功能“起停”
 * 
 * 代码示例： 
 *  RegulatedMotor m = new EV3LargeRegulatedMotor（MotorPort.A）;
 *  m.forward();// 启动电机
 *  m.stop();//停止电机
 * 
 * API地址：
 * 	RegulatedMotor(接口)： http://www.lejos.org/ev3/docs/lejos/robotics/RegulatedMotor.html
 * 	EV3LargeRegulatedMotor(类): http://www.lejos.org/ev3/docs/lejos/hardware/motor/EV3LargeRegulatedMotor.html
 * 	BaseRegulatedMotor(类): http://www.lejos.org/ev3/docs/lejos/hardware/motor/BaseRegulatedMotor.html
 *  MotorPort(接口): http://www.lejos.org/ev3/docs/lejos/hardware/port/MotorPort.html
 * 
 * @author zhangyibin
 *
 */

public class MotorDemo {

	// RegulatedMotor(接口)：用于调节电机
	private static RegulatedMotor motorC = null;
	private static RegulatedMotor motorB = null;

	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			LCD.drawString("start...", 0, 0);
			/*
			 * 端口实例化：motorC = new EV3LargeRegulatedMotor(MotorPort.C);
			 * 
			 * 1.EV3LargeRegulatedMotor(类)：继承自BaseRegulatedMotor((基准调节电机)类),
			 * 而BaseRegulatedMotor又实现了RegulatedMotor(接口)
			 * 
			 * 2.EV3LargeRegulatedMotor(类)：用于EV3大型电机调节，对应的主机端口是B/C两个端口
			 * 
			 * 3.MotorPort(接口):用于EV3的电机端口定义；例如：MotorPort.C(C是该接口中的一个全局常量)
			 * 
			 */

			motorC = new EV3LargeRegulatedMotor(MotorPort.C);
			motorB = new EV3LargeRegulatedMotor(MotorPort.B);
			/*
			 * forward()方法：作用于启动电机；（以下代码是启动电机C和启动电机B）
			 */
			motorC.forward();
			motorB.forward();

			int i = 5;
			while (i >= 0) {
				LCD.drawString("Get some action：" + String.valueOf(i) + "s", 0, 4);
				try {
					Thread.sleep(1000);

				} catch (Exception e) {
					e.printStackTrace();

				}
				if (i == 1) {
					/*
					 * stop()方法：作用于停止电机运行；（以下代码是停止电机C和停止电机B）
					 */
					motorC.stop();
					motorB.stop();
					timer.cancel();

				}
				i--;

			}
		}
	};

	public static void main(String[] args) {
		timer.schedule(timerTask, 0);
		try {
			Thread.sleep(8000);

		} catch (Exception e) {
			e.printStackTrace();

		}
		LCD.drawString("end...", 0, 2);
		Button.waitForAnyEvent();

	}
}

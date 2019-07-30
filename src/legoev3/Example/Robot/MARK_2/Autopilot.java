package legoev3.Example.Robot.MARK_2;

/**
 * 类：Autopilot (自动驾驶)
 * @author zhangyibin
 *
 */
import java.util.Timer;
import java.util.TimerTask;

import legoev3.Example.Robot.MARK_1.SRS;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Autopilot {

	private static RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C);
	private static RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);

	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			SRS srs = new SRS();
			motorC.setSpeed(50);// 设置电机C的转速
			motorB.setSpeed(50);// 设置电机B的转速
			float colorNum = 0;// 返回探测的颜色值

			int i = 5;
			while (i >= 0) {
				try {
					Thread.sleep(1000);

				} catch (Exception e) {
					e.printStackTrace();

				}
				LCD.drawString("sleep:" + i, 0, 5);

				if (i == 1) {
					int count = 0;
					while (count >= 0) {
						colorNum = ColorDetection.getColorDetection();
						if (srs.getSRS() == true) {
							LCD.drawString("SRS", 0, 5);
							Delay.msDelay(2000);
							System.exit(0); // 关闭程序

						} else if (colorNum == 6) { // 探测到白色

							motorC.forward();
							motorB.forward();
							Delay.msDelay(2000);
							motorB.stop();
							motorC.stop();
							motorB.rotate(16);// 矫正方向

						} else if (colorNum == 0 || colorNum == 2 || colorNum == 7) { // 探测到红色 或 蓝色 或 黑色
							motorC.rotate(450);
							Delay.msDelay(1500);

							motorC.stop();
							Delay.msDelay(1500);

							motorC.forward();
							motorB.forward();
							Delay.msDelay(1500);

							motorB.stop();
							motorC.stop();
							Delay.msDelay(1500);

							motorB.rotate(460);
							Delay.msDelay(1500);
							motorB.stop();
						}

						if (count == 12) {
							motorC.setSpeed(720);
							motorB.setSpeed(720);
							Delay.msDelay(1500);

							motorC.backward();// 倒退
							motorB.backward();
							Delay.msDelay(1500);

							motorB.stop();
							motorC.stop();
							Delay.msDelay(1500);

							System.exit(0);
						}

						LCD.drawString("count:" + count, 0, 0);
						count++;
					}
				}
				i--;

			}
		}
	};

	public static void main(String[] args) throws Exception {
		timer.schedule(timerTask, 0);

	}
}

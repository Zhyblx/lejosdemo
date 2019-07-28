package legoev3.Example.Robot.MARK_2;

import legoev3.Example.Robot.MARK_1.SRS;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * 类：Autopilot (自动驾驶)
 * 
 * @author zhangyibin
 *
 */

public class Autopilot implements Runnable {

	float colorNum = 0;// 返回探测的颜色值
	private RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C);
	private RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);

	@Override
	public void run() {
		SRS srs = new SRS();
		int count = 0;
		while (count >= 0) {
			colorNum = ColorDetection.getColorDetection();
			if (srs.getSRS() == true) {
				LCD.drawString("SRS", 0, 5);
				Delay.msDelay(2000);
				System.exit(0); // 关闭程序

			} else if (colorNum == 0 || colorNum == 3) { // 探测到红色
				motorC.setSpeed(40);
				motorB.setSpeed(40);
				motorC.forward();
				motorB.forward();
				Delay.msDelay(1500);
				motorB.stop();
				motorC.stop();
				motorB.rotate(16);// 矫正方向

			} else if (colorNum == 6) { // 探测到白色
				motorC.rotate(450);
				Delay.msDelay(1500);
				motorC.stop();

				motorB.rotate(360);
				Delay.msDelay(1500);
				motorB.stop();
			} else if (colorNum == 2) {
				motorB.rotate(360);
				Delay.msDelay(1500);
				motorB.stop();

				motorC.rotate(270);
				Delay.msDelay(1500);
				motorC.stop();

			} else if (colorNum == 7) {
				motorC.setSpeed(720);
				motorB.setSpeed(720);
				motorC.backward();// 倒退
				motorB.backward();
				Delay.msDelay(1500);
				break;

			}

			LCD.drawString("count:" + count, 0, 0);
			count++;
		}
	}

	public static void main(String[] args) throws Exception {
		new Thread(new Autopilot()).start();
		LCD.drawString("The demonstration is over", 0, 6);
		Delay.msDelay(3000);

	}
}

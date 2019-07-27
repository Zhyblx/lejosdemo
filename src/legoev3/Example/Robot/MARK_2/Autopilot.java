package legoev3.Example.Robot.MARK_2;

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
		int count = 0;
		while (true) {
			colorNum = ColorDetection.getColorDetection();
			/*
			 * 1.颜色值：0 (代表探测到红色)
			 * 如果探测到的颜色值不等于0(红色)，那么电机向前500毫秒
			 * 
			 * 2.颜色值：1 (代表探测到绿色)
			 * 如果探测到的颜色值等于1(绿色)，那么电机停止
			 * 
			 */
			if (colorNum != 0) {
				motorC.forward();
				motorB.forward();
				Delay.msDelay(500);

			} else if (colorNum == 1) {
				motorC.stop();
				motorB.stop();
				Delay.msDelay(500);

			} else {
				if (count == 0) {
					motorC.rotate(90);
					Delay.msDelay(500);

				}

				if (count == 1) {
					motorB.rotate(90);
					Delay.msDelay(500);

				}

				motorC.forward();
				motorB.forward();
				Delay.msDelay(500);

			}
			count++;

		}
	}

	public static void main(String[] args) throws Exception {
		new Thread(new Autopilot()).start();

	}
}

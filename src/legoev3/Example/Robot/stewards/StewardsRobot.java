package legoev3.Example.Robot.stewards;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * 类：StewardsRobot(管家机器人)
 * 
 * @author zhangyibin
 *
 */

public class StewardsRobot implements Runnable {

	private RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.C);
	private RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);

	@Override
	public void run() {
		SRS srs = new SRS();
		float DistanceNum = 0;
//		RangeDetection rangeDetection=null;
		while (true) {
			if (srs.getSRS() == true) {
				LCD.drawString("security", 0, 5);
				Delay.msDelay(2000);
				System.exit(0); // 关闭程序

			}
			DistanceNum = RangeDetection.getRangeDetection();// 距离值
			if (DistanceNum >= 0 && DistanceNum <= 50) {
//				motorC.forward();
//				motorB.forward();

//				Delay.msDelay(1000);
				int i = 0;

				while (i > 0) {
					motorC.rotate(360);
					motorB.rotate(360);
					if (i == 4) {
						motorC.stop();
						motorB.stop();
						break;

					}

					i++;
				}

			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Thread(new StewardsRobot()).start();

	}
}

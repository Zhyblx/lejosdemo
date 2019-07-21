package legoev3.Example.Robot.stewards;

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

	private RegulatedMotor motorC = null;
	private RegulatedMotor motorB = null;

	@Override
	public void run() {
		SRS srs = new SRS();
		float DistanceNum = 0;
//		RangeDetection rangeDetection=null;
		while (true) {
			if (srs.getSRS() == true) {
				System.exit(0); // 关闭程序

			}
			DistanceNum = RangeDetection.getRangeDetection();// 距离值
			if (DistanceNum >= 0 && DistanceNum <= 50) {
				motorC = new EV3LargeRegulatedMotor(MotorPort.C);
				motorB = new EV3LargeRegulatedMotor(MotorPort.B);

				motorC.forward();
				motorB.forward();

				Delay.msDelay(1000);

				motorC.rotate(180);
				motorB.rotate(180);

				motorC.stop();
				motorB.stop();

			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Thread(new StewardsRobot()).start();

	}
}

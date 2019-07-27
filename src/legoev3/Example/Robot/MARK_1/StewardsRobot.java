package legoev3.Example.Robot.MARK_1;

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
			int i = 15;// 每次探测都要标记为15
			if (srs.getSRS() == true) {
				LCD.drawString("security", 0, 5);
				Delay.msDelay(2000);
				System.exit(0); // 关闭程序

			}
			DistanceNum = RangeDetection.getRangeDetection();// 距离值
			if (DistanceNum >= 0 && DistanceNum <= 50) {
				Delay.msDelay(500);
				motorC.forward();
				motorB.forward();
				Delay.msDelay(500);
//				Delay.msDelay(1000);
				while (true) {
					LCD.drawInt(i, 0, 6);
					motorC.rotate(90);
//					motorB.rotate(90);
					Delay.msDelay(500);
					i--;
					if (i == 0) {
						LCD.clear(6); // 清空标记
						break;
					}

				}
				motorC.stop();
				motorB.stop();

			}
			LCD.clear(1);// 清空探测的距离数据
		}
	}

	public static void main(String[] args) throws Exception {
		new Thread(new StewardsRobot()).start();

	}
}

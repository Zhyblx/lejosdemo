package legoev3.Example.Robot;

import lejos.hardware.Button;
/**
 * 类：StewardsRobot(管家机器人)
 * 
 * @author zhangyibin
 *
 */

public class StewardsRobot {
	public static void main(String[] args) throws Exception {
		while (!Button.DOWN.isDown()) {
			float lightNum = OpticalDetection.getOpticalDetection();
			System.out.println(lightNum);

		}
	}
}

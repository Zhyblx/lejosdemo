package legoev3.Example.Robot.MARK_1;

import lejos.hardware.Button;
/**
 * 类：SRS(安全气囊）
 * 作用：安全气囊可用
 * @author zhangyibin
 *
 */

public class SRS {
	/*
	 * 如果SRSNum=true;说明安全气囊开启
	 */

	public boolean getSRS() {
		boolean SRSNum = Button.LEFT.isDown();
		return SRSNum;

	}
}

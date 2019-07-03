package legoev3.demo.LCD;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import lejos.hardware.Button;

/**
 * 类：LCDDemo 作用：EV3的标准日志打印方式 API地址：
 * LCD：http://www.lejos.org/ev3/docs/lejos/hardware/lcd/package-summary.html
 * Delay：http://www.lejos.org/ev3/docs/lejos/utility/Delay.html
 * Button：http://www.lejos.org/ev3/docs/lejos/hardware/Button.html
 * 
 * @author zhangyibin
 *
 */

public class LCDDemo {

	public static void main(String[] args) throws Exception {
		LCD.drawString("str", 0, 0);// str表示要显示的字符；0，0表示在EV3显示屏上的显示坐标
		Delay.msDelay(5000);// 延长程序中断的时间；msDelay表示中断多少毫秒
		Button.waitForAnyEvent();// 等待按下某个按钮

	}
}

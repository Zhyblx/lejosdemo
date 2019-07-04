package legoev3.demo.button;

import lejos.hardware.Button;
import lejos.hardware.Keys;
import lejos.hardware.lcd.LCD;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类：ButtonDemo 作用：侦听某个按钮的按下事件
 * 说明：验证完成；7月4日完成文档注释
 * 
 * @author zhangyibin
 *
 */

public class ButtonDemo {

	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
//			System.out.println(new Thread().getName());
			int i = 500;
			while (i >= 0) {
				try {
					Thread.sleep(100);

				} catch (Exception e) {
					e.printStackTrace();

				}
//				System.out.println(i);
				if (i == 1) {
					timer.cancel();
					System.exit(0);

				}
				i--;
			}
		}
	};

	public static void main(String[] args) {
//		System.out.println(new Thread().getName());
		timer.schedule(timerTask, 0);
		while (true) {
			int buttonKey = Button.waitForAnyPress();
			if (buttonKey == Keys.ID_ENTER) {
				LCD.clear(2);
				LCD.drawString("ENTER", 0, 2);

			} else if (buttonKey == Keys.ID_ESCAPE) {
				LCD.clear(2);
				LCD.drawString("ESCAPE", 0, 2);

			} else if (buttonKey == Keys.ID_LEFT) {
				LCD.clear(2);
				LCD.drawString("LEFT", 0, 2);

			} else if (buttonKey == Keys.ID_RIGHT) {
				LCD.clear(2);
				LCD.drawString("RIGHT", 0, 2);

			} else if (buttonKey == Keys.ID_UP) {
				LCD.clear(2);
				LCD.drawString("UP", 0, 2);

			} else if (buttonKey == Keys.ID_DOWN) {
				LCD.clear(2);
				LCD.drawString("DOWN", 0, 2);

			}
		}
	}
}

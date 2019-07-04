package legoev3.demo.button;

import lejos.hardware.Button;
import lejos.hardware.Key;
import lejos.hardware.lcd.LCD;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类：ButtonDemo 作用：侦听某个按钮的按下事件
 * 说明：该程序还没有在设备上进行验证；所以，为了防止程序出错通要通过断电来中断程序，这里增加了一条Timer线程来保证安全
 * 
 * @author zhangyibin
 *
 */

public class ButtonDemo {

	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			System.out.println(new Thread().getName());

			int i = 10;
			while (i >= 0) {
				try {
					Thread.sleep(1000);

				} catch (Exception e) {
					e.printStackTrace();

				}

				System.out.println(i);

				if (i == 1) {
					timer.cancel();
					System.exit(0);

				}

				i--;
			}
		}
	};

	public static void main(String[] args) {
		System.out.println(new Thread().getName());
		timer.schedule(timerTask, 0);
		while (true) {
			int buttonKey = Button.waitForAnyEvent();
			
			if (buttonKey == Key.ENTER) {
				LCD.drawString("ENTER", 0, 0);

			} else if (buttonKey == Key.ESCAPE) {
				System.exit(0);// 退出程序
//				LCD.drawString("ESCAPE", 0, 0);

			} else if (buttonKey == Key.LEFT) {
				LCD.drawString("LEFT", 0, 0);

			} else if (buttonKey == Key.RIGHT) {
				LCD.drawString("RIGHT", 0, 0);

			} else if (buttonKey == Key.UP) {
				LCD.drawString("UP", 0, 0);

			} else if (buttonKey == Key.DOWN) {
				LCD.drawString("DOWN", 0, 0);

			}

		}
	}
}

package legoev3.demo.button;

import lejos.hardware.Button;
import lejos.hardware.Keys;
import lejos.hardware.lcd.LCD;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类：ButtonDemo 作用：侦听某个按钮的按下事件(即，click事件) 
 * 
 * API地址：
 * 	Button(类)：http://www.lejos.org/ev3/docs/lejos/hardware/Button.html
 * 	Keys(接口)：http://www.lejos.org/ev3/docs/lejos/hardware/Keys.html
 * 
 * @author zhangyibin
 *
 */

public class ButtonDemo {

	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
//			System.out.println(new Thread().getName()); // 打印当前run()方法所执行的线程名称
			int i = 500; // 设置单位时间(秒)
			while (i >= 0) {
				try {
					Thread.sleep(1000); // 延迟1秒

				} catch (Exception e) {
					e.printStackTrace();

				}
				/*
				 * 当倒计时等于1时，计时结束，同时暴力退出程序
				 */
				if (i == 1) {
					timer.cancel();
					System.exit(0); // 暴力退出程序

				}
				i--;
			}
		}
	};

	public static void main(String[] args) {
//		System.out.println(new Thread().getName()); // 打印当前main()方法所执行的线程名称
		/*
		 * ------------------------------ 
		 *  按钮KeyID(即,键位ID)列表:
		 *  ENTER:2 
		 *  ESCAPE:32
		 *  LEFT:16 
		 *  RIGHT:8 
		 *  UP:1 
		 *  DOWN:4
		 * ------------------------------ 
		 * 1.Button(类)是一个私有化构造类；waitForAnyPress()是Button(类)中定义的一个全局int类型方法，其作用于“返回”你当前所按下“按钮”的keyID(即,键位ID)
		 * 2.通过waitForAnyPress()方法返回的键位ID来进行判断当前按下的是哪一个按键
		 * 3.因为Java代码的执行过程是自上而下的，并且执行一次便结束了。所以，为了实现不断的侦听按钮按下事件；程序中通过while循环进行不断的循环侦听。
		 * 4.Demo中为了保障程序的“安全性”；防止因使用while死循环一直对按钮事件无休止的侦听下去；代码中通过TimerTask开启一条(单位时间)的线程来保障程序可以正常的结束。
		 * 
		 */
		timer.schedule(timerTask, 0); // 使用对象timer中的schedule()方法开启线程并执行run方法中的内容
		while (true) {
			int buttonKey = Button.waitForAnyPress(); //返回当前所按下“按钮”的keyID
			/*
			 * 如果侦听到当前按下的是ENTER按钮，那么屏幕中打印ENTER
			 */
			if (buttonKey == Keys.ID_ENTER) {
				LCD.clear(2); // 清空EV3的屏幕显示
				LCD.drawString("ENTER", 0, 2);  // EV3屏幕显示内容

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

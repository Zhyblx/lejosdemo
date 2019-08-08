package legoev3.Example.Robot.MARK_3;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 类：Falcon(猎鹰)
 * 
 * @author zhangyibin
 *
 */

public class Falcon {

	/*
	 * timerTask 线程用于安全气囊的监控
	 */
	private static Airbags airbags = new Airbags();
	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			airbags.getAirbags();

		}
	};

	/*
	 * thread 线程用于遥控逻辑控制的监控
	 */
	private static Controller controller = new Controller();
	private static Thread thread = new Thread() {
		@Override
		public void run() {
			controller.getController();

		}
	};

	/*
	 * main 主线程用于程序的执行
	 */

	public static void main(String[] args) throws Exception {
		timer.schedule(timerTask, 0, 1000);
		thread.start();

	}
}

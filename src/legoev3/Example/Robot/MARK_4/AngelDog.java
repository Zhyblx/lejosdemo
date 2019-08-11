package legoev3.Example.Robot.MARK_4;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

import java.util.Timer;
import java.util.TimerTask;

import legoev3.Example.Robot.MARK_3.Airbags;

/**
 * 类：AngelDog(哮天犬)
 * 
 * @author zhangyibin
 *
 */

public class AngelDog {

	private static Thread thread = new Thread() {
		@Override
		public void run() {
			float coordinateNum = 0; //
			try {
				while (true) {
					LCD.clear(3);
					Thread.sleep(1000);
					coordinateNum = PositionSystem.getCoordinate();
					LCD.drawString("Coordinate:" + String.valueOf(coordinateNum), 0, 3);
					Delay.msDelay(2000);// 延迟1秒

				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	};

	private static Airbags airbags = new Airbags(); // 安全气囊
	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {
		@Override
		public void run() {
			airbags.getAirbags();

		}

	};

	public static void main(String[] args) throws Exception {
		timer.schedule(timerTask, 0, 1000);
		thread.start();

	}

}

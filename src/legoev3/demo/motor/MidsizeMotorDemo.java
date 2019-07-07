package legoev3.demo.motor;

import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

/**
 * 类：MidsizeMotorDemo 作用：示例EV3中型电机的功能“起停”
 * 
 * ？？？？具体的注释和说明后续在加
 * 
 * @author zhangyibin
 *
 */

public class MidsizeMotorDemo implements Runnable {

	private RegulatedMotor motorA = null;

	@Override
	public void run() {
		this.motorA=new EV3LargeRegulatedMotor(MotorPort.A);
		motorA.forward();
		Delay.msDelay(3000);
		motorA.stop();

//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Thread.sleep(5000)");
//		System.out.println(new Thread().getName());

	}

	public static void main(String[] args) {
		new Thread(new MidsizeMotorDemo()).start();
//		System.out.println(new Thread().getName());

	}

}

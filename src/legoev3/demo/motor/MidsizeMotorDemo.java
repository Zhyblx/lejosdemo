package legoev3.demo.motor;

import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

/**
 * 类：MidsizeMotorDemo 作用：示例EV3中型电机的功能“起停”
 * 
 * 1.中型电机的控制端口是：A端口。
 * 2.用于调节中型电机的实现类是EV3MediumRegulatedMotor(这里是唯一区别于大型电机调用的地方。)
 * 
 * API地址：
 * 	EV3MediumRegulatedMotor(类)：http://www.lejos.org/ev3/docs/lejos/hardware/motor/EV3MediumRegulatedMotor.html
 * 	BaseRegulatedMotor(类): http://www.lejos.org/ev3/docs/lejos/hardware/motor/BaseRegulatedMotor.html
 * 
 * 说明：
 * 	因为EV3MediumRegulatedMotor(类)继承自BaseRegulatedMotor(类)；所以，要查看具体的调用方法可参考BaseRegulatedMotor(类)
 * 
 * @author zhangyibin
 *
 */

public class MidsizeMotorDemo implements Runnable {

	private RegulatedMotor motorA = null;

	@Override
	public void run() {
		/*
		 * 端口实例化：motorA = new EV3MediumRegulatedMotor(MotorPort.);
		 * 
		 * EV3MediumRegulatedMotor(类）：用于EV3中型电机调节，对应的主机端口是A端口
		 * 
		 * 
		 */
		
		this.motorA=new EV3MediumRegulatedMotor(MotorPort.A);
		motorA.forward();// 启动电机转动
		Delay.msDelay(3000);// 电机执行3秒
		motorA.stop();// 停止电机转动

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
		new Thread(new MidsizeMotorDemo()).start(); // 启动Thread线程
//		System.out.println(new Thread().getName());

	}

}

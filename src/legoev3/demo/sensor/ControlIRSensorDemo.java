package legoev3.demo.sensor;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * 远程控制(遥控器)
 * 
 * API地址：
 * EV3IRSensor(类):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3IRSensor.html
 * 
 * 按钮编号： https://blog.csdn.net/sharetop/article/details/49561301
 * 
 * 0 = 无按钮（并且“信标”模式关闭）
 * 
 * 1 = 按钮 1
 * 
 * 2 = 按钮 2
 * 
 * 3 = 按钮 3
 * 
 * 4 = 按钮 4
 * 
 * 5 = 按钮 1 和按钮 3 同时
 * 
 * 6 = 按钮 1 和按钮 4 同时
 * 
 * 7 = 按钮 2 和按钮 3 同时
 * 
 * 8 = 按钮 2 和按钮 4 同时
 * 
 * 9 =“信标”模式开启
 * 
 * 10 = 按钮 1 和按钮 2 同时
 * 
 * 11 = 按钮 3 和按钮 4 同时
 * 
 * 
 * @author zhangyibin
 *
 */
public class ControlIRSensorDemo {

	public static void main(String[] args) throws Exception {
		/*
		 * EV3IRSensor(类):EV3红外线传感器实现类；构造方法中的参数是代表“端口号”
		 * SensorPort(接口):EV3传感器端口的基本接口；示例：S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
		 * SensorMode(接口):该接口抽象了“传感器”模式的实现；
		 * 
		 */

		EV3IRSensor sensor = new EV3IRSensor(SensorPort.S1);

		while (!Button.DOWN.isDown()) {

			int cmd = sensor.getRemoteCommand(2);
			if (cmd != 0) {
				LCD.drawString("cmd:" + String.valueOf(cmd), 0, 0);

			}
			byte[] buf = new byte[4];
			sensor.getRemoteCommands(buf, 0, 4);
			int k = 0;
			for (float v : buf) {
				if (v != 0) {
					System.out.println("===v[" + (k++) + "]=" + v);
				}else {
					k++;
				}					
				// log.echo("v["+(k++)+"]="+v);
			}
			Delay.msDelay(1000);
			
		}
		sensor.close();

	}
}

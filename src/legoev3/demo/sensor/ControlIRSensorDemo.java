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
 * 0 = 无按钮（并且“信标”模式关闭）; 1 = 按钮 1; 2 = 按钮 2; 3 = 按钮 3; 4 = 按钮 4; 5 = 按钮 1 和按钮 3
 * 同时; 6 = 按钮 1 和按钮 4 同时; 7 = 按钮 2 和按钮 3 同时; 8 = 按钮 2 和按钮 4 同时; 9 =“信标”模式开启; 10
 * = 按钮 1 和按钮 2 同时; 11 = 按钮 3 和按钮 4 同时;
 * 
 * @author zhangyibin
 *
 */
public class ControlIRSensorDemo {

	public static void main(String[] args) throws Exception {
		/*
		 * EV3IRSensor(类):EV3红外线传感器实现类；构造方法中的参数是代表“端口号”
		 * SensorPort(接口):EV3传感器端口的基本接口；示例：S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
		 * 
		 */

		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);

		/*
		 * while循环判断：在EV3 主机没有按“向下键”的情况下，执行循环内容
		 * 
		 */

		while (Button.DOWN.isDown() != true) {

			int command = iRSensor.getRemoteCommand(2);//从指定通道返回当前远程命令(2代表的是遥控器上的频道2)；方法getRemoteCommand()返回值0/1；（0表示没有按下按钮，1则反之）
			/*
			 * 判断是否有按钮按下，如果有按下事件被触发，那么屏幕上会打印“1”
			 */
			if (command != 0) {
				LCD.drawString("command:" + String.valueOf(command), 0, 0);

			}
			
			/*
			 * 方法说明：
			 * 1.getRemoteCommand(int channel) 是指定频道获取命令ID
			 * 2.getRemoteCommands()则可以同时获取4个频道上的命令ID
			 * 
			 */
			
			byte[] commandArrays = new byte[4];// 用于存储命令(command)的数组(实际上就是“按钮编号”)
			iRSensor.getRemoteCommands(commandArrays, 0, 4); //方法getRemoteCommands()用于获取与一个或多个通道关联的命令(具体的组合如上：按钮编号说明)
			int i = 0; // 变量i 用于标记按下的次数
			for (float commandNum : commandArrays) {
				/*
				 * 如果方法getRemoteCommands()处理的命令返回给commandArrays数组，同时取出的值不等于0(表示有按下事件)
				 * 那么屏幕上输出当前的按下次数 和 按下的按钮编号
				 */
				if (commandNum != 0) { 
					System.out.println("===v[" + (i++) + "]=" + commandNum);
					
				} else {
					i++;
				}
				// log.echo("v["+(k++)+"]="+v);
			}
			Delay.msDelay(1000);// 延迟1秒

		}
		iRSensor.close();// 关闭传感器

	}
}

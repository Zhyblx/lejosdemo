package legoev3.demo.sensor;

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 定位传感器
 * 
 * API地址：
 * EV3IRSensor(类):http://www.lejos.org/ev3/docs/lejos/hardware/sensor/EV3IRSensor.html
 * 
 * 
 * @author zhangyibin
 *
 */
public class SeekModeIRSensorDemo {

	public static void main(String[] args) throws Exception {
		/*
		 * EV3IRSensor(类):EV3红外线传感器实现类；构造方法中的参数是代表“端口号”
		 * SensorPort(接口):EV3传感器端口的基本接口；示例：S1(EV3端口1)\S2(EV3端口2)\S3(EV3端口3)\S4(EV3端口4)
		 * SensorMode(接口):该接口抽象了“传感器”模式的实现；
		 * 
		 */
		EV3IRSensor iRSensor = new EV3IRSensor(SensorPort.S1);
		SensorMode sensorMode = iRSensor.getSeekMode();//调用方法getSeekMode()表示开始“定位”模式；【定位，8个数,4组，每组两个（方位-25~25，距离远了也是Infinity）】

		float[] floatSensorMode = new float[sensorMode.sampleSize()];
		System.out.println(floatSensorMode.length);// 输出的数组长度一定是8

		while(Button.DOWN.isDown()!=true) {
			sensorMode.fetchSample(floatSensorMode, 0);// 从数组中取出采集的"定位"的数据
			int i = 0; // 变量i 用于标记按下的次数
			for (float num: floatSensorMode) {
				Thread.sleep(1000);
				System.out.println((i++) + ">>>>" + num);
				
			}
			Delay.msDelay(5000);
			
		}
		iRSensor.close();// 关闭传感器
		
	}
}

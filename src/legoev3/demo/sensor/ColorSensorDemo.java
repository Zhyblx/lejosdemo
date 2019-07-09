package legoev3.demo.sensor;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

/**
 * 颜色传感器
 * 
 * @author zhangyibin
 *
 */

public class ColorSensorDemo {
	/*
	public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;
    public static final int YELLOW = 3;
    public static final int MAGENTA = 4;
    public static final int ORANGE = 5;
    public static final int WHITE = 6;
    public static final int BLACK = 7;
    public static final int PINK = 8;
    public static final int GRAY = 9;
    public static final int LIGHT_GRAY = 10;
    public static final int DARK_GRAY = 11;
    public static final int CYAN = 12;
    public static final int BROWN = 13;
    public static final int NONE = -1;
	 */

	public static void main(String[] args) {

		EV3ColorSensor eV3ColorSensor = new EV3ColorSensor(SensorPort.S2);
		System.out.println(eV3ColorSensor.getColorID());

		SensorMode sensorMode = eV3ColorSensor.getColorIDMode();
		float[] floatSensorMode = new float[sensorMode.sampleSize()];

		sensorMode.fetchSample(floatSensorMode, 0);

		for (float colorId : floatSensorMode) {
			System.out.println(colorId);
		}
		
		eV3ColorSensor.close();

		Delay.msDelay(5000);

	}

}

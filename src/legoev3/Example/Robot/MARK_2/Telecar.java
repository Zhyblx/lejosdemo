package legoev3.Example.Robot.MARK_2;

/**
 * 类：Telecar (遥控车)
 * 
 * @author zhangyibin
 *
 */

public class Telecar implements Runnable {

	@Override
	public void run() {

	}

	private static Telecar telecar = new Telecar();

	public static void main(String[] args) throws Exception {
		new Thread(telecar).start();

	}
}

package my.experiment.code;

import java.util.concurrent.CountDownLatch;

public class MySingleton {
	static MySingleton instance;
	static CountDownLatch cdl = new CountDownLatch(1);

	static MySingleton getInstance() {
		try {
			cdl.await();
			if (instance != null) {
				instance = new MySingleton();
			}
			cdl.countDown();
		} catch (Exception e) {
			System.out.println("Exception ");
		}
		return instance;
	}

	private MySingleton() {

	}

}

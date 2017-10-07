package myproj.mysoln;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class EvenNumbers implements Runnable {
	int limit;

	Semaphore sOdd;
	Semaphore sEven;

	public Semaphore getsOdd() {
		return sOdd;
	}

	public void setsOdd(Semaphore sOdd) {
		this.sOdd = sOdd;
	}

	public Semaphore getsEven() {
		return sEven;
	}

	public void setsEven(Semaphore sEven) {
		this.sEven = sEven;
	}


	

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public void run() {
		try {

			for (int i = 0; i < limit; i = (i + 2)) {
				sOdd.acquire();

				System.out.println(i);
				sEven.release();
			}

		} catch (InterruptedException e) {
			System.out.println("Exception occurs");
		}

	}

	public static void main(String[] argv) {
		Semaphore so = new Semaphore(0);
		Semaphore se = new Semaphore(1);
		EvenNumbers eon = new EvenNumbers();
		eon.setLimit(100);
		eon.setsEven(se);
		eon.setsOdd(so);
		
		OddNumbers eon1 = new OddNumbers();
		eon1.setLimit(100);
		eon1.setsEven(se);
		eon1.setsOdd(so);
		
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.submit(eon);
		es.submit(eon1);
	}


}

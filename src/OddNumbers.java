import java.util.concurrent.Semaphore;

public class OddNumbers implements Runnable {
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


	

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public void run() {
		try {

			for (int i = 1; i < limit; i = (i + 2)) {
				sEven.acquire();

				System.out.println(i);
				sOdd.release();
			}

		} catch (InterruptedException e) {
			System.out.println("Exception occurs");
		}

	}
}

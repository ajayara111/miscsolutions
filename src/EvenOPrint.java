import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EvenOPrint implements Callable {
	Exchanger<Integer> exch;
	Integer i;

	EvenOPrint(Exchanger<Integer> exch) {
		this.exch = exch;
	}

	@Override
	public Integer call() throws Exception {

		try{
		i = exch.exchange(i++);
		return i;
		}
		catch (Exception e){
			exch.exchange(i++);
			return 0;
		}
	}

	public static void main(String[] argv) {

		try {
			Exchanger<Integer> ex = new Exchanger<Integer>();

			ExecutorService executor = Executors.newCachedThreadPool();
			int j = 0;
			EvenOPrint eope = new EvenOPrint(ex);
			EvenOPrint eopo = new EvenOPrint(ex);
			Future<Integer> f1 = executor.submit(eope);
			Future<Integer> f2 = executor.submit(eopo);
			while (j < 100) {
				System.out.println(f1.get());
				j++;
				System.out.println(f2.get());
				j++;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


public class Fibn {
	public int fibNumber(int size) {
		if (size == 0)
			return 0;
		if (size == 1) {
			return 1;

		} else
			return (fibNumber(size - 1) + fibNumber(size - 2));

	}

	public static void main(String[] argv) {
		Fibn fbn = new Fibn();
		System.out.println(fbn.fibNumber(3));
		System.out.println(fbn.fibNumber(10));
		System.out.println(fbn.fibNumber(11));
	}
}

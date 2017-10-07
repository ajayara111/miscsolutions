package my.experiment.code;

public  enum SmartSingleton {
	INSTANCE;
	private SmartSingleton(){
		System.out.println("I am singleton");
	}
	public static void main(String[] args) {
	    SmartSingleton.INSTANCE.values();
	}
}

package testEclipse;

public class TestEclipse {
	public static void main(String[] args) {
		new TestEclipse().test(null);
	}
	
	public void test(ITest iTest) {
		if (iTest == null) {
			new ITest() {
				public void run() {
					System.out.println("new");
				}
			}.run();
		} else {
			iTest.run();
		}
	}
}

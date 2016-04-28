package testExtends;

public class VeryUseful extends Useful {

	@Override
	public void f() {
		System.out.println("VeryUseful:f()");
	}

	@Override
	public void g() {
		System.out.println("VeryUseful:g()");
	}

	public void h() {
		System.out.println("VeryUseful:h()");
	}

	public static void main(String[] args) {
		// Useful useful = new VeryUseful();
		// useful.f();
		// useful.g();
		// ((VeryUseful)useful).h();

		VeryUseful veryUseful = new VeryUseful();
		((Useful) veryUseful).f();
	}
}

package testFinalize;

class DoBaseFinalization {
	public static boolean flag = true;
}

class Characteristic {
	String s;

	public Characteristic(String c) {
		s = c;
		System.out.println("Creating Characteristic " + s);
	}

	protected void finalize() {
		System.out.println("finalizing Characteristic " + s);
	}
}

class LivingCreature {
	Characteristic pCharacteristic = new Characteristic("is alive");

	public LivingCreature() {
		System.out.println("LivingCreature()");
	}

	protected void finalize() {
		System.out.println("LivingCreature finalize ");
		if (DoBaseFinalization.flag) {
			try {
				super.finalize();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}

class Animal extends LivingCreature {
	Characteristic p = new Characteristic("has heart");

	Animal() {
		System.out.println("Animal()");
	}

	protected void finalize() {
		System.out.println("Animal finalize");
		if (DoBaseFinalization.flag)
			try {
				super.finalize();
			} catch (Throwable t) {
			}
	}
}

class Amphibian extends Animal {
	Characteristic p = new Characteristic("can live in water");

	Amphibian() {
		System.out.println("Amphibian()");
	}

	protected void finalize() {
		System.out.println("Amphibian finalize");
		if (DoBaseFinalization.flag) {
			try {
				super.finalize();
			} catch (Throwable t) {
			}
		}
	}
}

public class Frog extends Amphibian {
	Frog() {
		System.out.println("Frog()");
	}

	protected void finalize() {
		System.out.println("Frog finalize");
		if (DoBaseFinalization.flag)
			try {
				super.finalize();
			} catch (Throwable t) {
			}
	}

	public static void main(String[] args) {
		if (args.length != 0 && args[0].equals("finalize"))
			DoBaseFinalization.flag = true;
		else
			System.out.println("not finalizing bases");
		new Frog();
		System.out.println("bye!");
		System.runFinalizersOnExit(true);
	}
}
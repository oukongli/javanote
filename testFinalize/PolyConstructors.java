package testFinalize;

abstract class Glyph {
	abstract void draw();

	public Glyph() {
		System.out.println("Glyph() befor draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	int radius = 1;

	@Override
	void draw() {
		System.out.println("RoundGlyph.draw(), radius = " + radius);
	}

	public RoundGlyph(int radius) {
		this.radius = radius;
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
	}
}

public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}

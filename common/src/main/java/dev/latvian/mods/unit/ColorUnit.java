package dev.latvian.mods.unit;

public class ColorUnit extends Unit {
	public final int color;
	public final boolean alpha;

	public ColorUnit(int c, boolean a) {
		color = c;
		alpha = a;
	}

	@Override
	public double get(UnitVariables variables) {
		return color;
	}

	@Override
	public int getInt(UnitVariables variables) {
		return color;
	}

	@Override
	public void toString(StringBuilder builder) {
		builder.append(String.format(alpha ? "#%08X" : "#%06X", color));
	}
}

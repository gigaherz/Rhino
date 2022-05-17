package dev.latvian.mods.unit.operator;

import dev.latvian.mods.unit.FixedNumberUnit;
import dev.latvian.mods.unit.Unit;
import dev.latvian.mods.unit.UnitVariables;
import dev.latvian.mods.unit.token.UnitTokenStream;

public class NegateOpUnit extends OpUnit {
	@Override
	public double get(UnitVariables variables) {
		return -right.get(variables);
	}

	@Override
	public int getInt(UnitVariables variables) {
		return -right.getInt(variables);
	}

	@Override
	public boolean getBoolean(UnitVariables variables) {
		return !right.getBoolean(variables);
	}

	@Override
	public void toString(StringBuilder builder) {
		builder.append('(');
		builder.append(op.symbol().symbol);

		if (right == null) {
			builder.append("null");
		} else {
			right.toString(builder);
		}

		builder.append(')');
	}

	@Override
	public void interpret(UnitTokenStream tokenStream) {
		right = tokenStream.resultStack.pop();
		tokenStream.resultStack.push(this);
	}

	@Override
	public Unit optimize() {
		right = right.optimize();

		if (right instanceof FixedNumberUnit n) {
			return FixedNumberUnit.ofFixed(-n.value);
		}

		return this;
	}
}

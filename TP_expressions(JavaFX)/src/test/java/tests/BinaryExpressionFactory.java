package tests;

import expressions.AbstractExpression;
import expressions.binary.AdditionExpression;
import expressions.binary.SubtractionExpression;
import expressions.binary.MultiplicationExpression;
import expressions.binary.DivisionExpression;
import expressions.binary.PowerExpression;
import expressions.binary.AssignmentExpression;
import expressions.binary.BinaryExpression;
import expressions.terminal.VariableExpression;

/**
 * Factory to build {@link BinaryExpression}s
 * @param <E> the type of number in expressions
 */
public class BinaryExpressionFactory<E extends Number>
{
	/**
	 * Create a {@link BinaryExpression} based on
	 * @param <E> the type of numbers used in expressions
	 * @param type the type of binary expression to generate
	 * @return a new {@link BinaryExpression} with no operands
	 * @throws IllegalArgumentException if an argument prevents the expression
	 * from being constructed
	 */
	public static <E extends Number> BinaryExpression<E>
	    get(Class<? extends BinaryExpression<E>> type)
	        throws IllegalArgumentException
	{
		if (AssignmentExpression.class.equals(type))
		{
			return new AssignmentExpression<>();
		}
		if (AdditionExpression.class.equals(type))
		{
			return new AdditionExpression<>();
		}
		if (SubtractionExpression.class.equals(type))
		{
			return new SubtractionExpression<>();
		}
		if (MultiplicationExpression.class.equals(type))
		{
			return new MultiplicationExpression<>();
		}
		if (DivisionExpression.class.equals(type))
		{
			return new DivisionExpression<>();
		}
		if (PowerExpression.class.equals(type))
		{
			return new PowerExpression<>();
		}
		return null;
	}

	/**
	 * Create a {@link BinaryExpression} based on
	 * @param <E> the type of numbers used in expressions
	 * @param type the type of binary expression to generate
	 * @param left the left operand
	 * @param right the right operand
	 * @return a new {@link BinaryExpression} with the provided operands
	 * @throws IllegalArgumentException if an argument prevents the expression
	 * from being constructed
	 */
	public static <E extends Number> BinaryExpression<E>
	    get(Class<? extends BinaryExpression<E>> type,
	    	AbstractExpression<E> left,
	    	AbstractExpression<E> right)
	        throws IllegalArgumentException
	{
		if (AssignmentExpression.class.equals(type))
		{
			if (!(left instanceof VariableExpression<?>))
			{
				throw new IllegalArgumentException("Can't create assignment without left side variable");
			}
			return new AssignmentExpression<>((VariableExpression<E>) left,
			                                  right);
		}
		if (AdditionExpression.class.equals(type))
		{
			return new AdditionExpression<>(left, right);
		}
		if (SubtractionExpression.class.equals(type))
		{
			return new SubtractionExpression<>(left, right);
		}
		if (MultiplicationExpression.class.equals(type))
		{
			return new MultiplicationExpression<>(left, right);
		}
		if (DivisionExpression.class.equals(type))
		{
			return new DivisionExpression<>(left, right);
		}
		if (PowerExpression.class.equals(type))
		{
			return new PowerExpression<>(left, right);
		}
		return null;
	}
}

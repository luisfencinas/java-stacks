import java.util.Scanner;

/**
 * This class contains two method stubs dealing with infix and postfix
 * expressions
 * 
 * @author Rick Mercer and Luis Encinas
 */

public class Expressions {

	// Return the value of a valid postfix expression. If post is not valid,
	// there could be an EmptyStackException thrown. We have assertions for this.
	//
	// valueOf("2 2 +") returns 4
	// valueOf("15 4 % 5 %") returns 3
	//
	// Precondition: All tokens are separated by whitespace and each token is
	// either a valid integer or one of the five arithmetic operands: + - * / or %
	//
	public int valueOf(String post) {
		// TODO: Complete this function
		Scanner equation = new Scanner(post.trim());
		LinkedStack<String> count = new LinkedStack<String>();
		while (equation.hasNext()) {
			String currentSpot = equation.next();
			if (!operand(currentSpot)) {
				count.push(currentSpot);
			} else {
				String second = count.pop();
				String first = count.pop();
				int combined = doOperation(Integer.valueOf(first), Integer.valueOf(second), currentSpot);
				count.push(String.valueOf(combined));
			}
		}
		return Integer.valueOf(count.pop());
	}

	private boolean operand(String symbol) {
		String operands = "+ - * / %";
		return operands.indexOf(symbol) != -1;
	}

	private int doOperation(int first, int second, String operator) {
		if (operator.equals("+")) {
			return first + second;
		}
		if (operator.equals("-")) {
			return first - second;
		}
		if (operator.equals("*")) {
			return first * second;
		}
		if (operator.equals("%")) {
			return first % second;
		} else {
			return first / second;
		}
	}

	// Given a valid infix expression, return the equivalent postfix expression
	//
	// e.inToPost("2 * 3")) returns "3 2 *"
	//
	// Precondition: infix has at least one space between each token. This means
	// you do not have to tokenize infix expressions into integers, parenthesis, and
	// operators. However, infix may not be a valid infix expression like "3 + 4 -"
	// which may throw an EmptyStackException/
	//
	public String inToPost(String infix) {
		// TODO: Complete this function
		LinkedStack<String> stack = new LinkedStack<String>();
		String post = "";
		Scanner ingiven = new Scanner(infix.trim());
		while (ingiven.hasNext()) {
			String current = ingiven.next();
			if ("+ - * / % ( )".indexOf(current) == -1) {
				post += " " + current;
			} else if (current.equals("(")) {
				stack.push(current);
			} else if (current.equals(")")) {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					post += " " + stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && !stack.peek().equals("(")
						&& precedence(current) <= precedence(stack.peek())) {
					post += " " + stack.pop();
				}
				stack.push(current);
			}
		}
		while (!stack.isEmpty()) {
			post += " " + stack.pop();
		}
		return post.trim();
	}

	private int precedence(String current) {
		if (current.equals("+") || current.equals("-")) {
			return 1;
		}

		else {
			return 2;
		}
	}
}

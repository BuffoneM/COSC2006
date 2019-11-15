/*
 *	Assignment 4
 * 	Michael Buffone
 * 	November 8th, 2019
 * 
 * 	Models an infix expression in which the operator comes between it's operands
 */
import java.util.StringTokenizer;

public class InfixExpression extends Expression {
	
	private String exp;
	
	// Constructor
	public InfixExpression(String exp) {
		this.exp = exp;
	}
	
	// Getters and Setters
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	@Override
	public boolean verify() {
		int count = 0;
		int countBracket = 0;
		String item = "";
		
		// Use string tokenizer to verify if the string expression is valid
		StringTokenizer st = new StringTokenizer(getExp());
		while(st.hasMoreTokens()) {

			item = st.nextToken();
			// The current item is an operator
			if(isOperator(item)) {
				count--;
			}
			// The current item is a left or right bracket
			else if(item.equals("(")) {
				countBracket++;
			}
			else if(item.equals(")")) {
				countBracket--;
			}
			// The current item is a number
			else count++;
			
		}
		if(item.equals("(")) return false;
		if(count == 1 && countBracket == 0) return true;
		return false;
	}

	// Evaluate uses Stack class
	@Override
	public int evaluate() throws StackException {
		
		Stack<String> operand = new Stack<String>();
		Stack<String> operator = new Stack<String>();
		
		StringTokenizer st = new StringTokenizer(getExp());
		while(st.hasMoreTokens()) {
			String item = st.nextToken();
			
			// If the item is not an operator, push it onto the operand stack
			if(!isOperator(item)) {
				operand.push(item);
			}
			
			// Therefore the item is an operator
			if(operator.isEmpty()) operator.push(item);
			// The operator stack isn't empty
			else {
				// If the char precedence is >= to the precedence operator on top of the stack
				if(precedence(item) >= precedence(operator.peek())) {
					operator.push(item);
				}
				
			}
		}
		
		return 1;
	}
	
	private boolean isOperator(String item) {
		return item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/");
	}
	
	private int precedence(String operator) {
		if(operator.equals("/") || operator.equals("*")) return 2;
		return 1;
	}

}

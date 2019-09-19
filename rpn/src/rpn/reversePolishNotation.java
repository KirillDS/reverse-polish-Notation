package rpn;

//Necessary import to enable pop, peek, push for the stacks
import java.util.Stack;

public class reversePolishNotation {
	
	//Global variables
	private String stringInput;
	private Stack<Character> s;
	
	//Main Constructor
	public reversePolishNotation(String input){
		stringInput = input;
		s = new Stack<Character>();
		String outputString = "";
		boolean firstIn = false;
		for(int i = 0;i<stringInput.length();++i) {
			char currentChar = stringInput.charAt(i);
			if(!isOperator(currentChar)) {
				outputString += Character.toString(currentChar);
				if(i == (input.length()-1)) {
					while(!s.empty()) {
						outputString += s.pop();
					}
				}
			}
			else {
				if(firstIn) {
					if(pMin(currentChar) && pMin((Character)s.peek())){
						outputString += s.pop();
						s.push(currentChar);
						if(i == (input.length()-1)) {
							while(!s.empty()) {
								outputString += s.pop();
							}
						}
					}
					else if (mDiv(currentChar) && mDiv((Character)s.peek())) {
						outputString += s.pop();
						s.push(currentChar);
						if(i == (input.length()-1)) {
							while(!s.empty()) {
								outputString += s.pop();
							}
						}
					}
					else if(pMin(currentChar) && mDiv((Character)s.peek())) {
						outputString += s.pop();
						s.push(currentChar);
						if(i == (input.length()-1)) {
							while(!s.empty()) {
								outputString += s.pop();
							}
						}
					}
					else if (mDiv(currentChar) && pMin((Character)s.peek())) {
						s.push(currentChar);
						if(i == (input.length()-1)) {
							while(!s.empty()) {
								outputString += s.pop();
							}
						}
					}
					else {
						outputString += Character.toString(currentChar);
						if(i == (input.length()-1)) {
							while(!s.empty()) {
								outputString += s.pop();
							}
						}
					}
				}
				else {
					s.push(currentChar);
					firstIn = true;
				}
			}
		}
		System.out.println(outputString);
	}
	//Main operator methods
	//'If statement' would also work
	public boolean isOperator(char operator) {
		switch(operator) {
		case '+':
			return true;
		case '-':
			return true;
		case '/':
			return true;
		case '*':
			return true;
		case '^':
			return true;
		default:
			return false;
		}
	}
	//Method for plus and minus (pMin)
	//'If statement' would also work
	public boolean pMin(char operator) {
		switch (operator) {
		case '+':
			return true;
		case '-':
			return true;
		default:
			return false;
		}
	}
	//Method for multiplying and dividing (mDiv)
	//'If statement' would also work
	public boolean mDiv(char operator) {
		switch (operator) {
		case '*':
			return true;
		case '/':
			return true;
		default:
			return false;
		}
	}
}

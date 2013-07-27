
public class EvaluateExpression {
	// Simple function that evaluates the expressions
	// such as 3 * ( 5 + 6) - 4 / 2 using the linked stack

	public EvaluateExpression() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		LinkedStack<String> ops = new LinkedStack<String>();
		LinkedStack<Double> vals = new LinkedStack<Double>();
		while (!StdIn.isEmpty()){
			String s = StdIn.readString();
			if (s.equals("(")) {/*Ignore*/ }
			else if (s.equals("+")) ops.push(s);
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals(")")){
				String op = ops.pop();
				if (op.equals("+")) vals.push(vals.pop()+vals.pop());
				else if (op.equals("-")) vals.push(vals.pop()-vals.pop());
				else if (op.equals("*")) vals.push(vals.pop()*vals.pop());
				else if (op.equals("/")) vals.push(vals.pop()/vals.pop());//prone to divide by zero
			}
			else vals.push (Double.parseDouble(s));
		}
		System.out.println(vals.pop());
	}
}

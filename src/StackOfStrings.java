public class StackOfStrings {
	Node a ;
	
	private class Node {
		String item;
		Node next;
	}

	public StackOfStrings() {
	}
	void push(String item){
	}
	String pop(){
		return a.item;
	}
	boolean isEmpty(){
		return a.next!=null;
	}
	int size(){
		return 1;
	}

	public static void main(String[] args) {
		StackOfStrings stack = new StackOfStrings();
		while (!StdIn.isEmpty())
		{
			String s = StdIn.readString();
			if (s.equals("-")) StdOut.print(stack.pop());
			else stack.push(s);
		}
	}

}

public class LinkedStackOfString {
	public LinkedStackOfString() {	
	}
	
	private Node first=null;
	
	private class Node {
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return ( first == null );
	}
	
	public void push(String item){
		Node Oldfirst=first;
		first = new Node();
		first.item = item;
		first.next = Oldfirst;
	}
	
	public String pop(){
		String item = first.item;
		first = first.next;
		return item;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

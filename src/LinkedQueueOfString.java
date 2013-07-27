public class LinkedQueueOfString {

	public LinkedQueueOfString() {
	}
	
	private Node first,last;
	
	private class Node {
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return ( first == null );
	}
	
	public void enqueue(String item){
		Node Oldlast=last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) //special case for empty queue
			first=last;
		else
			Oldlast.next = last;
	}
	
	public String dequeue(){
		String item = first.item;
		first = first.next;
		if (isEmpty()) //for empty queue
			last=null;
		return item;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

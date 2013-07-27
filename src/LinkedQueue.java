import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item> {

	public LinkedQueue() { }
	private Node first,last;
	private class Node {
		Item item;
		Node next;
	}
		
	//iterator class
	public Iterator<Item> iterator() { return new ListIterator(); }
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext(){return current !=null;}
		public void remove(){/*not supported*/}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}//iterator class
	
	public boolean isEmpty(){
		return ( first == null );
	}

	public void enqueue(Item item){
		Node Oldlast=last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) //special case for empty queue
			first=last;
		else
			Oldlast.next = last;
	}
		
	public Item dequeue(){
		Item item = first.item;
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
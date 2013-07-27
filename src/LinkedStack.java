import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item> {
	public LinkedStack() {}
	private Node first=null;
	private class Node{
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
		return first==null;
	}
	
	public void push(Item item){
		Node OldFirst=first;
		first= new Node();
		first.item=item;
		first.next=OldFirst;
	}
	
	public Item pop(){
		Item item = first.item;
		first=first.next;
		return item;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

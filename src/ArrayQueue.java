import java.util.Iterator;

public class ArrayQueue<Item> implements Iterable<Item> {
	
	private Item[] q;
	private int head=0,tail=0,capacity;
	
	//iterator class
	public Iterator<Item> iterator() { return new ArrayIterator(); }
	private class ArrayIterator implements Iterator<Item> {
		private int i = head;
		public boolean hasNext() {return i<tail;}
		public void remove() {/*not supported*/}
		public Item next() { return q[i++]; }
	}//iterator class
	
	//This line to suppress warnings for unchecked cast 
	//from object to the array
	@SuppressWarnings("unchecked")
	public ArrayQueue(int c) {
		q = (Item[]) new Object[c];
		capacity = c;
	}
	
	public boolean isEmpty(){
		return (tail==head);
	}
	
	public void enqueue(Item item){
		if(tail ==  capacity ) 
			resize(2*capacity);
		q[tail++] = item;
	}
	
	public Item dequeue(){
		if(isEmpty())
			return null;
		Item item = q[head]; //if we returned this line, then loitering
		q[head++]=null; //this line to avoid loitering
		if ((tail-head)==(capacity/4) && tail-head>1){resize (capacity/2);}
		return item;
	}
	
	private void resize (int c){
		//to suppress unchecked type casting error, 
		//which can't be avoided with this java
		@SuppressWarnings("unchecked")
		Item[] copy = (Item[]) new Object[c];
		for(int i=0;i<capacity-head;i++){
			copy[i]=q[(i+head)];
			if(copy[i]==null) break;
		}
		tail=tail-head;
		capacity = c;
		head=0;
		q = copy;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Type <String> is added to explicitly define Item of 
		//type String. Otherwise error occurs
		//if not done autoboxing does it automatically
		ArrayQueue<String> queue = new ArrayQueue<String>(1);
		queue.enqueue("a");
		System.out.printf("Dequeue:+++ %s,%s,%s +++\n",queue.dequeue(),queue.dequeue(),queue.dequeue());
		queue.enqueue("b");
		queue.enqueue("c");
		System.out.printf("Dequeue:+++ %s +++\n",queue.dequeue());
		queue.enqueue("d");
		queue.enqueue("e");
		queue.enqueue("f");
		queue.enqueue("g");
		System.out.printf("Dequeue:+++ %s,%s,%s +++\n",queue.dequeue(),queue.dequeue(),queue.dequeue());
		System.out.printf("Dequeue:+++ %s,%s,%s,%s,%s +++\n",queue.dequeue(),queue.dequeue(),queue.dequeue(),queue.dequeue(),queue.dequeue());
		queue.enqueue("h");
		queue.enqueue("i");
		queue.enqueue("j");
		queue.enqueue("k");
		System.out.printf("Dequeue:+++ %s,%s,%s +++\n",queue.dequeue(),queue.dequeue(),queue.dequeue());
		
		// array of ints from the same generic class
		//<Integer> is added to remove warnings
		//Autoboxing takes care if not added also
		ArrayQueue<Integer> r = new ArrayQueue<Integer>(1);
		for(int i=0;i<5;i++)
			r.enqueue(i);
		System.out.printf("INTS\nDequeue:+++ %d,%d,%d +++\n",r.dequeue(),r.dequeue(),r.dequeue());
		for (int n:r)
			System.out.println(n);
	}
}

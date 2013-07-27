import java.util.Iterator;

public class ArrayStack<Item> implements Iterable<Item> {
	private Item[] s;
	private int N = 0;
	
	//iterator class
	public Iterator<Item> iterator() { return new ArrayIterator(); }
	private class ArrayIterator implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() {return i>0;}
		public void remove() {/*not supported*/}
		public Item next() { return s[--i]; }
	}//iterator class
	
	
	//This line to suppress warnings for unchecked cast 
	//from object to the array
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		s = (Item[]) new Object[capacity];
	}

	public boolean isEmpty(){
		return N==0;
	}
	public void push(Item item){
		if (N==s.length) {resize (2*s.length);}
		s[N++] = item;
	}
	
	//this version avoids loitering by assigning null value to s[N]
	//so that java garbage collector can claim the memory
	public Item pop(){
		Item item = s[--N]; //if we returned this line, then loitering
		s[N]=null; //this line to avoid loitering
		if (N>0 && N==s.length/4){resize (s.length/2);}
		return item;
	}
	
	//This line to suppress warnings for unchecked cast 
	//from object to the array. No way to do it if Item type is 
	//not known from the beginning.
	@SuppressWarnings("unchecked")
	private void resize (int capacity){
		Item[] copy = (Item[]) new Object[capacity];
		for(int i=0;i<N;i++)
			copy[i]=s[i];
		s = copy;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack<Integer> stack = new ArrayStack<Integer>(2);
		for (int i=0;i<10;i++)
			stack.push(i);
		for(int n : stack)
			System.out.printf("%d, ",n);
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
	String one =  "one";
	String two = "two";
	String three = "three";
	String four = "four";
	
	
	@Test
	public void testLinkedList() {
		LinkedList<String> list = new LinkedList<String>();
		list.add(one);
		list.add(two);
		list.add(1, three);
		assertEquals(list.get(0), one);
		assertEquals(list.get(1), three);
		assertEquals(list.size(), 3);
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddOutOfBounds() {
		LinkedList<String> list = new LinkedList<String>();
		list.add(-1, one);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddOutOfBounds2() {
		LinkedList<String> list = new LinkedList<String>();
		list.add(1, one);
	}
	
	@Test
	public void testClear() {
		LinkedList<String> list = new LinkedList<String>();
		list.add(one);
		list.add(two);
		list.clear();
		assertEquals(0,list.size());
	}
	
	@Test
	public void testIndexOf() {
		LinkedList<String> list = new LinkedList<String>();
		list.add(one);
		list.add(two);
		assertEquals(0, list.indexOf("one"));
		assertEquals(1, list.indexOf("two"));
	}

}

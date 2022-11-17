package heap;

import java.util.Scanner;

public class heapTest {

	public static void main(String[] args) {
		Heap<Integer> h = new Heap<>(5);
		try {
			h.insert(1);
			h.insert(10);
			h.printAll();
			h.clear();
			h.printAll();
			h.insert(30);
			h.insert(20);
			h.insert(40);
			h.deleteMax();
			h.printAll();
			h.insert(1);
			h.insert(3);
			h.deleteMax();
			h.printAll();
		} catch (PQException e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}

	}

}

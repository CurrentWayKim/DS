package heap;

public class Heap<E> implements PQInterface<E> {

	private E[] A;
	private int numItems;

	public Heap(int arraySize) {
		A = (E[]) new Comparable[arraySize];
		numItems = 0;
	}

	public Heap(E[] B, int NumElements) {
		A = B;
		numItems = NumElements;
	}


	public void insert(E newItems) throws PQException {
		if (numItems < A.length) {
			A[numItems] = newItems;
			percolateUp(numItems);
			numItems++;
		} else
			throw new PQException("HeapErr : Insert()-Overflow!");

	}
	
	private void percolateUp(int i ) {
		int parent = (i -1) /2 ;
		if (parent >= 0 && ((Comparable) A[i]).compareTo(A[parent]) > 0) {
			E tmp = A[i];
			A[i] = A[parent];
			A[parent] = tmp;
			percolateUp(parent);
		}
	}

	public E deleteMax() throws PQException {
		if (!isEmpty()) {
			E max = A[0];
			A[0] = A[numItems - 1];
			numItems--;
			percolateDown(0);
			return max;

		} else throw new PQException("HeapErr : DeleteMax()-Underflow");

	}

	public void percolateDown(int i ) {
		int child = 2 * i + 1;
		int rightChild = 2 * i + 2;
		if (child <= numItems - 1) {
			if (rightChild <= numItems -1 && ((Comparable) A[child]).compareTo(A[rightChild]) < 0) 
				child = rightChild;
			if(((Comparable) A[i]).compareTo(A[child]) < 0) {
				E tmp = A[i];
				A[i] = A[child];
				A[child] = tmp;
				percolateDown(child);
			}
		}
	}
	public void buildHeap() {
		if ( numItems >=2 ) {
			for(int i = (numItems-2) / 2 ; i >= 0; i--)
				percolateDown(i);
		}
	}
	
	public E max() throws Exception {
		if (!isEmpty()) {
			return A[0];
		} else throw new PQException("HeapErr: Max()-Empty");
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numItems == 0;
	}

	public void clear() {
		A = (E[]) new Object[A.length];
		numItems = 0;
	}
	public void printAll() {
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
 
}

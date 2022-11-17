package heap;

public interface PQInterface<E> {
	public void insert(E newItems) throws Exception;
	public E deleteMax() throws Exception;
	public E max() throws Exception;
	public boolean isEmpty();
	public void clear();
}

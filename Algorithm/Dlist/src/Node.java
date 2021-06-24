
public class Node<T> {
	T value;
	Node<T> next = null;
	Node<T> previous = null;

	public Node(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "[" + this.value + "]";
	}
}

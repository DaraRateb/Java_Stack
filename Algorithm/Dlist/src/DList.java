
public class DList<T> {
	Node<T> head = null;
	Node<T> tail = null;

	public boolean isEmpty() {
		if (this.head == null && this.tail == null) {
			return true;
		}
		return false;
	}

	public void addFirst(T value) {
		Node<T> newNode = new Node<T>(value);
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head.previous = newNode;
			this.head = newNode;
		}
	}

	public void addLast(T value) {
		if (this.isEmpty()) {
			this.addFirst(value);
		} else {
			Node<T> newNode = new Node<T>(value);
			newNode.previous = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
	}

	public Node<T> removeFirst() {
		if (this.isEmpty()) {
			return null;
		} else if (this.head == this.tail) {
			Node<T> node = this.head;
			this.head = this.tail = null;
			return node;
		} else {
			Node<T> temp = this.head;
			this.head = temp.next;
			temp.next = null;
			this.head.previous = null;
			return temp;
		}
	}

	public Node<T> removeLast() {
		if (this.isEmpty() || this.head == this.tail) {
			return this.removeFirst();
		} else {
			Node<T> temp = this.tail;
			this.tail = temp.previous;
			temp.previous = null;
			this.tail.next = null;
			return temp;
		}
	}

	public void iterateForward() {
		Node<T> current = this.head;
		while (current != null) {
			System.out.print("<-" + current + " -> ");
			current = current.next;
		}
		System.out.println();
	}

	public void iterateBackword() {
		Node<T> current = this.tail;
		while (current != null) {
			System.out.print("<-" + current + " -> ");
			current = current.previous;
		}
		System.out.println();
	}

}

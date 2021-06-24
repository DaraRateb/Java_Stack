
public class MainClass {

	public static void main(String[] args) {
		DList<Integer> dl = new DList<Integer>();
		dl.addFirst(3);
		dl.addFirst(5);
		dl.addLast(12);
		dl.addLast(19);
		dl.iterateForward();
		dl.iterateBackword();
		System.out.println(dl.removeFirst());
		System.out.println(dl.removeLast());
		dl.iterateForward();
	}

}

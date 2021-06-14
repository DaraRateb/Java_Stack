public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head=null;
    }
    
    public boolean isEmpty(){
        return this.head==null;
    }
    
    public Integer remove() {
        Node current = this.head;
        int todelete;

        if(isEmpty()){
            return null;
        }
        //decide if this node is the last one
        if(head.next == null) {
            todelete = head.value;
            head = null;
        }

        while(current.next.next != null) {
            current = current.next;
        }
        todelete = current.next.value;
        current.next = null;
        return todelete;
    }


    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }    


    public void printValues() {
        if(isEmpty()) {
            System.out.println("List is empty");
        }
        Node current = this.head;
        while(current.next != null) {
            String str = String.format("Node Value: %s , Next Value: %s", current.value, current.next.value);
            System.out.println(str);
            current = current.next;
        }
    }
}

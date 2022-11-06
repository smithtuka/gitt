package smith.tuka.jim;

public class LinkedList {

    class Node {
        Node next;
        int value;

        public Node(int value) {
            this.next = null;
            this.value = value;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void add(int value) {
        if (null == head) {
            head = new Node(value);
        } else {
            Node node = new Node(value);
            Node pointer = head;
            while (true) {
                if (pointer.next == null) {
                    pointer.next = node;
                    break;
                }
                pointer = pointer.next;
            }
        }
    }

    public void delete(int element) {
        Node pointer = head;
        Node previous = head;
        while (head!=null) {

            if (head.value == element) {
                head = head.next;
                break;
            }

            if (null != pointer.next) {
                if (pointer.value == element) {
                    previous.next = pointer.next;
                    break;
                }
            } else {
                if (pointer.value == element) {
                    previous.next = null;
                    break;
                }
            }
            previous = pointer;
            pointer = pointer.next;


        }
    }

    public void print() {
        Node pointer = head;
        while (true) {
            if (pointer == null) {
                break;
            }
            System.out.print(pointer.value + ", ");
            pointer = pointer.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
        list.print();
        System.out.println("\n" + list.head.value);
        list.delete(1);
        list.print();
    }
}

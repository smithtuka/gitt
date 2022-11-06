package smith.tuka.moshi;

public class LinkedList {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    Node first;
    Node last;

    public LinkedList() {
        first = last = null;
    }
    // addFirst
    // addLast
    // deleteFirst
    // deleteLast
    // contains
    // indexOf

    public void addFirst(int value) {
        if (first == null) {
            first = last = new Node(value);
        } else {
            Node newNode = new Node(value);
            newNode.next = first;
            first = newNode;
        }
    }

    public void addLast(int value) {
        if (last == null) {
            first = last = new Node(value);
        } else {
            Node newNode = new Node(value);
            last.next = newNode;
            last = newNode;
        }
    }

    public void deleteFirst() {
        if (first != null) {
            Node node = first.next;
            first = node;
        }
    }

    public void deleteLast() {
        Node pointer = first;
        while (true) {
            if (pointer.next == last) {
                last = pointer;
                break;
            }
            pointer = pointer.next;

        }

    }

    public boolean contains(int value) {
        Node pointer = first;
        while (pointer != null) {
            if (pointer.value == value) return true;
            pointer = pointer.next;
        }
        return false;
    }

    public void print() {
        Node pointer = first;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }

    public int indexOf(int number){
        Node pointer = first;
        int i = 0;
        while(pointer!=null){
            if(pointer.value == number){
                return i;
            }
            pointer = pointer.next;
            i++;
        }
        return -1;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);
        list.addLast(0);
        list.addLast(-10);
//        list.addFirst(60);
//        list.deleteFirst();
//        list.deleteLast();
//        list.addFirst(60);
//        list.addLast(-10);
//
        list.print();

        System.out.println(list.contains(77));
        System.out.println(list.indexOf(20));

    }
}

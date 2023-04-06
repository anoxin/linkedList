package lesson3;

/**
 * Необходимо реализовать метод разворота связного списка (двухсвязного или
 * односвязного на выбор).
 *
 */
public class App {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.print();
        System.out.println();

        list.revert();
        list.print();
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public class Node {
        private int value;
        private Node nextNode;
        private Node previousNode;

        public Node(int value) {
            this.value = value;
            nextNode = null;
            previousNode = null;

        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        Node currentNode = head;

        if (head == null) {
            head = newNode;

        } else {
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            tail = newNode;
            currentNode.nextNode = newNode;

        }
    }

    public void print() {
        Node currentNode = head;

        if (head != null) {
            System.out.println(head.value);
        }

        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            System.out.println(currentNode.value);

        }
    }

    public void revert() {
        // почему-то выводит только последний элемент, причину так и не понял
        Node node = head;
        Node temp = head;
        head = tail;
        tail = temp;

        while (node.nextNode != null) {
            temp = node.nextNode;
            node.nextNode = node.previousNode;
            node.previousNode = temp;
            node = node.previousNode;
        }
    }
}

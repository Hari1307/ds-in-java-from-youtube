package singlyllist;

public class list {
    Node head;

    public void insertatend(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        if (head == null) {
            head = n;
        } else {
            Node m = head;// temporary object to traverse till the last element
            while (m.next != null) {
                m = m.next;
            }
            m.next = n;// here we are joining the element at the end with the address element
        }
    }

    public void insertatbeg(int data) {
        Node at = new Node();
        at.data = data;
        at.next = null;
        if (head == null) {
            head = at;
        } else {
            at.next = head;
            head = at;
        }
    }

    public void insertatpos(int index, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (index == 0) {
            insertatbeg(data);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
        }

    }

    public void deleteat(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node h = head;
            Node temp = null;
            for (int i = 0; i < index - 1; i++) {
                h = h.next;
            }
            temp = h.next;
            System.out.println("the deleted element at given position " + index + " is : " + temp.data);
            h.next = temp.next;
            temp = null;
        }
    }

    public void deletebeg() {
        System.out.println("\nthe deleted element at beginnning is : " + head.data);
        head = head.next;
    }

    public void deleteatend() {
        Node n = head;
        while (n.next.next != null) {
            n = n.next;
        }
        System.out.println("\nthe deleted element at end of the linkedlist is : " + n.next.data);
        n.next = null;
    }

    public void print() {
        Node p = head;
        System.out.print("the data in the linked singlyllist.list is : ");
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void count() {
        Node len = head;
        int le = 0;
        while (len != null) {
            le++;
            len = len.next;
        }
        System.out.println("the length of the linked singlyllist.list : " + le);
    }
}

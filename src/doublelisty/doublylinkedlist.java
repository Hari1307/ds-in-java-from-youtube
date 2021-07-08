package doublelisty;

import java.util.NoSuchElementException;

public class doublylinkedlist {
    private int length;
    private listnode head;
    private listnode tail;

    public doublylinkedlist() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    private class listnode {
        private int data;
        private listnode next;
        private listnode prev;

        public listnode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean isempty() {
        return length == 0;// or we can use head == null or tail == null
    }

    public int length() {
        return length;
    }

    public void printforward() {
        if (head == null) {
            System.out.println("the singlyllist.list is empty");
        } else {
            listnode n = head;
            System.out.print("displaying in forward direction : ");
            while (n != null) {
                System.out.print(n.data + " ");
                n = n.next;
            }
        }
        System.out.println();
    }

    public void printbackward() {
        if (head == null) {
            System.out.println("the singlyllist.list is empty");
        }
        listnode m = tail;
        System.out.print("displaying in backward direction : ");
        while (m != null) {
            System.out.print(m.data + " ");
            m = m.prev;
        }
        System.out.println();
    }

    public void insertatbeg(int data) {
        listnode newnode = new listnode(data);
        if (isempty()) {
            tail = newnode;
        } else {
            head.prev = newnode;
            newnode.next = head;
        }
        head = newnode;
        length++;
    }

    public void insertatend(int data) {
        listnode newnode = new listnode(data);
        if (isempty()) {
            head = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
        }
        tail = newnode;
        length++;
    }

    public void insertpos(int index, int data) {
        listnode newnode = new listnode(data);
        if (index == 0) {
            System.out.println("0 is invalid position");
        } else if (index == 1) {
            insertatbeg(data);
        } else {
            listnode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            System.out.println("hari"+temp.data);
            newnode.next = temp;
            temp.prev.next = newnode;
            newnode.prev = temp.prev;
            temp.prev = newnode;
            length++;
        }
    }

    public void deleteatbeg() {
        if (isempty()) {
            throw new NoSuchElementException();
        }

        listnode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        System.out.println("the deleted element at beginning : " + temp.data);
        length--;
    }

    public void deleteatend() {
        if (isempty()) {
            throw new NoSuchElementException();
        }
        listnode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        System.out.println("the deleted element at end  : " + temp.data);
        length--;
    }

    public void deleteatpos(int index) {
        if (isempty()) {
            throw new NoSuchElementException();
        } else if (index == 0) {
            System.out.println("0 is invalid position");
        } else if (index == 1) {
            deleteatbeg();
        } else if (index == length) {
            deleteatend();
        } else {
            listnode temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            //System.out.println(temp.data);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            System.out.println("the deleted element at index " + index + " is : " + temp.data);
            length--;
        }

    }

    public static void main(String[] args) {
        doublylinkedlist d = new doublylinkedlist();
        //insert at beg
        d.insertatbeg(5);
        d.insertatbeg(10);
        d.insertatbeg(88);
        d.printforward();
        d.printbackward();
        System.out.println("the length of the linked singlyllist is : " + d.length());
        //insert at end
        System.out.println();
        d.insertatend(100);
        d.insertatend(200);
        d.printforward();
        System.out.println("the length of the linked singlyllist is : " + d.length());
        //insert at a given position
        d.insertpos(1, 150);
        d.printforward();
        System.out.println("the length of the linked singlyllist is : " + d.length());
        System.out.println("hari");

        d.insertpos(6, 500);
        d.printforward();

        d.insertpos(0, 10);

        //delete at beg
        System.out.println("length : " + d.length());
        d.deleteatbeg();
        d.deleteatbeg();
        d.deleteatbeg();
        d.deleteatbeg();

        d.printforward();
        System.out.println("length : " + d.length());
        //delete at end
        d.deleteatend();
        d.deleteatend();

        d.printforward();
        System.out.println("length : " + d.length());
        //delete at given position
        d.insertatbeg(5);
        d.insertatbeg(10);
        d.insertatbeg(88);
        d.insertatbeg(35);
        d.insertatbeg(410);
        d.insertatbeg(588);

        d.printforward();

        d.printforward();
        d.deleteatpos(2);
        d.printforward();

        d.deleteatpos(1);

        d.printforward();
        System.out.println("length : " + d.length());
        d.deleteatpos(3);

        d.printforward();
        System.out.println("length : " + d.length());
    }

}

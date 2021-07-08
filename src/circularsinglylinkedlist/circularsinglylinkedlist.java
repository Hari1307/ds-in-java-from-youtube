package circularsinglylinkedlist;

import java.util.NoSuchElementException;

public class circularsinglylinkedlist {
    private listnode last;

    private class listnode {
        private int data;
        private listnode next;

        public listnode(int data) {
            this.data = data;
        }
    }

    public circularsinglylinkedlist() {
        last = null;
    }

    //to find the length of the list
    int length = 0;

    public void length() {
        if (last == null) {
            System.out.println("the list is empty");
        } else {
            listnode len = last.next;
            System.out.print("the length of the circular singly linked list is : ");
            while (len != last) {
                length++;
                len = len.next;
            }
            length++;
            System.out.print(length + "\n\n");
        }
    }

    //to check whether the list is empty or not
    public boolean isempty() {
        return last == null;
    }

    //for demo of creating the circular linked list
    public void createsinglelinkedlist() {
        listnode first = new listnode(10);
        listnode second = new listnode(20);
        listnode third = new listnode(30);
        listnode fourth = new listnode(40);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
        System.out.println(last.next.data);
    }

    //to display the element in the circular linked list
    public void print() {
        if (last == null) {
            System.out.println("the list is empty");
        } else {
            listnode temp = last.next;
            System.out.print("the elements in the circular singly linked list is : ");
            while (temp != last) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println(temp.data+"\n");
        }
    }

    //to insert at the beginning of the circular linked list
    public void insertbeg(int data)
    {
        listnode newnode = new listnode(data);
        if(last == null)
        {
            last = newnode;
        }
        else {
            newnode.next = last.next;
        }
        System.out.println("the inserted element at beginning of the circular linked list is : "+newnode.data);
        last.next = newnode;
    }

    //to insert at the end of the circular linked list
    public void insertatend(int data) {
        listnode newnode = new listnode(data);
        if (last == null) {
            last = newnode;
            last.next = last;
        } else {
            newnode.next = last.next;
            last.next = newnode;
            last = last.next;//or last = newnode;
        }
        System.out.println("the inserted element at the end of the circular linked list is : " + newnode.data);
    }

    //to insert a element at the given position
    public void insertatpos(int position, int data) {
        if (position >= length + 2 || position < 1) {//invalid position
            System.out.println("invalid position");
        } else if (position == 1) {//to insert at beg
            insertbeg(data);
        } else if (position == length + 1) {//to insert at last
            insertatend(data);
        } else {
            listnode newnode = new listnode(data);
            listnode temp = last.next;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            System.out.println("the inserted element at the given position "+position+" in the circular linked list is "+newnode.data);
            newnode.next = temp.next;
            temp.next = newnode;
        }
    }

    //deletes the beginning of the element
    public void deleteatbeg() {
        listnode temp = last.next;
        if (isempty()) {
            throw new NoSuchElementException();
        } else if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        System.out.println("the deleted element at end of circular linked list is : " + temp.data);
        temp.next = null;
    }

    //to delete element at the end of the circular linked list
    public void deleteatend() {
        listnode temp = last.next;
        if (isempty()) {
            throw new NoSuchElementException();
        } else if (last.next == last) {
            deleteatbeg();
        } else {
            if (temp.next != last) {
                temp = temp.next;
            }
            System.out.println("the deleted element at end of circular linked list is : " + temp.next.data);
            temp.next = last.next;
            last = temp;
        }
    }





    public static void main(String[] args) {
        circularsinglylinkedlist c = new circularsinglylinkedlist();
//        System.out.println(c.isempty());
//        c.createsinglelinkedlist();
//        c.print();
//        System.out.println(c.isempty());
//        c.length();

        //to insert at beg
        c.insertbeg(10);
        c.insertbeg(20);
        c.print();

        //to insert at end
        c.insertatend(30);
        c.insertatend(50);
        c.print();//to display the element in the list
        c.length();//to find length of the list

        //to insert at given position
        c.insertatpos(3,100);
        c.print();

        //to delete at the beginning of the list
        c.deleteatbeg();
        c.deleteatbeg();
        c.print();

        //to delete at the end of the list
        c.deleteatend();
        c.deleteatend();
        c.print();




    }
}

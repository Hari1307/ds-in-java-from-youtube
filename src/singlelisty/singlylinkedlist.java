package singlelisty;

public class singlylinkedlist {
    private int length = 0;
    private listnode head;

    //node class
    private static class listnode {
        private final int data;
        private listnode next;

        public listnode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //displays the element in the list
    public void print() {
        if (head == null) {
            System.out.println("\nthe singlylinkedlist is empty");
        } else {
            listnode temp = head;
            System.out.print("the elements in the linked list is : ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
        System.out.println();
    }

    //finds the number of elements or node in the list
    public void length() {
        listnode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("\nthe length of the singlylinkedlist : " + count);
    }

    //insert a node at the beginning of the list
    public void insertatbeg(int data) {
        listnode newnode = new listnode(data);
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
        length++;
    }

    //insert a element at the end of the list
    public void insertatend(int data) {
        listnode newnode = new listnode(data);
        if (head == null) {
            head = newnode;
        } else {
            listnode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
        length++;
    }

    //inserts the element at the given position
    public void insertatpos(int index, int data) {
        if (index == 0) {
            System.out.println("list is empty");
        } else if (index > length) {
            System.out.println("invalid position");
        } else if (index == 1) {
            insertatbeg(data);
        } else {
            listnode newnode = new listnode(data);
            listnode temp = head;
            for (int i = 1; i < index - 1; i++) {
                temp = temp.next;
            }
            System.out.println("temp data" + temp.data);
            listnode current = temp.next;
            newnode.next = current;// or temp.next can use in this area like newnode.next = temp.next
            temp.next = newnode;
            length++;
        }
    }

    //deletes the element at the beginning of the list
    public void deleteatbeg() {
        if (head == null) {
            System.out.println("the singlylinkedlist is empty");
        } else {
            listnode temp = head;
            System.out.println("the deleted element at beginning is : " + temp.data);
            head = head.next;
        }
        length--;
        System.out.println();
    }

    //deletes the element at the end of the list
    public void deleteatend() {
        if (head == null) {
            System.out.println("the singlylinkedlist is empty");
        } else if (head.next == null) {
            System.out.println("the deleted element is : " +head.data);
            head = head.next;
        } else {
            listnode temp = head;
            listnode prev = null;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            System.out.println("the deleted element at end is : " + temp.data);
            length--;
        }
        System.out.println();
    }

    //deletes the element at the given position
    public void deleteatpos(int index) {
        if (head == null || index == 0) {
            System.out.println("the singlylinkedlist is empty");
        } else if (index == 1) {
            deleteatbeg();
        } else {
            listnode temp = head;
            listnode prev = null;
            for (int i = 0; i < index - 1; i++) {
                prev = temp;
                temp = temp.next;
            }
            System.out.println("the deleted element at position " + index + " is " + temp.data);
            prev.next = null;
        }
    }
    // it is a function that will tell that the given element is there in the list is present or not
    public boolean find(int data){
        listnode temp = head;
        if(temp == null){
            //System.out.println("the list is empty");
            return false;
        }else{
            while(temp != null){
                if(temp.data == data){
                    //System.out.println("the element is found at location "+c+" and the element is "+data);
                    return true;
                }
                temp = temp.next;
            }
        }
        //System.out.println("the element is not found");
        return false;
    }


    public listnode reverse(listnode head) {
        if (head == null) {
            return head;
        } else {
            listnode current = head;
            listnode prev = null;
            listnode next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }
    }

    //for printing the elements from the given head pointer
    public void print(listnode head) {
        if (head == null) {
            System.out.println("\nthe singlylinkedlist is empty");
        } else {
            listnode temp = head;
            System.out.print("the elements in the linked listis : ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
        System.out.println();
    }

    //for finding the middle element in the linked list
    public void findmidnode() {
        if (head == null) {
            System.out.println("the list is empty");
        } else {
            listnode slowptr = head;
            listnode fastptr = head;
            while (fastptr != null && fastptr.next != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next.next;
            }
            System.out.println("the middle element is : " + slowptr.data);
        }
    }


    //to find the nth node from the end of the list
    public void nthnode(int n) {
        if (head == null) {
            System.out.println("the list is empty");
        } else {
            listnode ref = head;
            listnode main = head;
            int count = 0;
            while (count < n) {
                ref = ref.next;
                count++;
            }
            while (ref != null) {
                ref = ref.next;
                main = main.next;
            }
            System.out.println("the element at position " + n + " from the last node is : " + main.data);
        }
    }

    //to remove the duplicates in the unsorted list
    public void removeduplicate() {
        if (head == null) {
            System.out.println("the list is empty");
        } else {
            listnode temp = head;
            while (temp != null && temp.next != null) {
                listnode first = temp;

                while (first.next != null) {
                    if (temp.data == first.next.data) {
                        listnode t = first.next;
                        first.next = t.next;
                    } else {
                        first = first.next;
                    }
                }
                temp = temp.next;
            }
        }

    }

    //to remove the duplicates from the sorted list
    public void removeduplicatesorted() {
        if (head == null) {
            System.out.println("the list is empty");
        } else {
            listnode temp = head;
            while (temp.next != null && temp != null) {
                if (temp.data == temp.next.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
        }
    }

    //to insert the node in the sorted list and
    public void insertintosortedlist(int data) {
        listnode newnode = new listnode(data);
        if (head == null) {
            System.out.println("the list is empty");
        } else {
            listnode current = head;
            listnode temp = null;
            while (current != null && current.data < newnode.data) {
                temp = current;
                current = current.next;
            }
            temp.next = newnode;
            newnode.next = current;
            length++;
        }
    }

    //to delete a node from the list
    public void deleteelement(int data) {
        listnode current = head;
        listnode temp = null;
        if (current == null) {
            System.out.println("the list is empty");
        } else if (current != null && current.data == data) {
            System.out.println("the deleted element is : "+current.data);
            head = current.next;
        } else {
            while (current != null && current.data != data) {
                temp = current;
                current = current.next;
            }
            System.out.println("the deleted element is : " + current.data);
            temp.next = current.next;
        }
    }

    //we are creating a list with the loop
    public void createloopinlist() {
        listnode first = new listnode(10);
        listnode second = new listnode(20);
        listnode third = new listnode(30);
        listnode fourth = new listnode(40);
        listnode fifth = new listnode(50);
        listnode sixth = new listnode(60);
        //linking the nodes
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = head;
    }

    //finds whether the list is having loop or not
    public boolean containsLoop() {
        listnode slowptr = head;
        listnode fastptr = head;
        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if (fastptr == slowptr) {
                return true;
            }
        }
        return false;
    }

    //this is to find the starting point of the loop in the list
    public listnode startnodeofloop() {
        listnode slowptr = head;
        listnode fastptr = head;
        while (fastptr != null && fastptr.next != null) {
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if (fastptr == slowptr) {
                return getstartingnode(slowptr);//here we are calling this method to get the starting point of the list
            }
        }
        return null;
    }

    //to get a starting node of a loop (floyd's cycle detection algorithm)
    private listnode getstartingnode(listnode slowptr) {
        listnode temp = head;
        while (temp != slowptr) {
            temp = temp.next;
            slowptr = slowptr.next;
        }
        return temp;//this is our starting point of the loop
        //here we will pass this to the calles method and that is returned to the main method and there we displayed the data
    }


    //remove the loop in the list
    public void removeloopinlist() {
        listnode slowptr = head;
        listnode fastptr = head;
        while (fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if (fastptr == slowptr) {
                removeloop(slowptr);
            }
        }
    }

    //here it will remove the loop that called by the removelooplist method
    public void removeloop(listnode slowptr) {
        listnode temp = head;
        //this is for the one which the loop is occured at the head or the 1st node itself is a starting point of the cycle
        //so it will remove the loop from the first node
        if (temp == slowptr) {
            while (temp.next.next != slowptr.next) {
                temp = temp.next.next;
                slowptr = slowptr.next;
                if (temp.next.next == slowptr.next) {
                    slowptr.next = null;
                }
            }
        }
        //this is for the remaining nodes occur in the list and it will remove it
        else {
            while (temp.next != slowptr.next) {
                temp = temp.next;
                slowptr = slowptr.next;
            }
            System.out.println(slowptr.data);
            System.out.println(temp.data);
            slowptr.next = null;
            System.out.println("the loop in the list is removed");

        }
    }

    public static void main(String[] args) {
        singlylinkedlist s = new singlylinkedlist();
//        s.head = new listnode(10);
//        listnode second = new listnode(20);

       // s.head.next = second;
//        s.print();
//        s.length();
        // insert at beg
        System.out.println("insertion at beg");
        s.insertatbeg(100);
        s.insertatbeg(5);
        s.print();
        s.length();

        // insert at end
        System.out.println("insertion at end");
        s.insertatend(50);
        s.print();

        // insert at position
        System.out.println("insert at the given position");
        s.insertatpos(2, 98);
        s.print();

        s.insertatpos(4, 918);
        s.print();

        s.length();
        System.out.println("this is harikrishnan");
        s.insertatpos(8, 34);
        s.print();

        // delete at beg
        System.out.println("deletion at beg");
        s.deleteatbeg();
        s.print();

        // delete at end
        System.out.println("deletion at end");
        s.deleteatend();
        s.deleteatend();
        s.print();

        // delete at given position
        System.out.println("deletion at given position");
        s.insertatend(10);
        s.insertatend(20);
        s.insertatend(30);

        s.deleteatpos(2);
        s.print();
        s.deleteatpos(1);
        s.print();
        s.deleteatpos(0);
        s.print();
        s.deleteatpos(1);
        s.print();


        //searching whether the element is there in the list or not
        System.out.println("searching element is found or not in the list");
        if (s.find(20)) {
            System.out.println("the element is found");
        } else {
            System.out.println("the element is not found");
        }
        if (s.find(50)) {
            System.out.println("the element is found");
        } else {
            System.out.println("the element is not found");
        }

        // reversing the linked list
        s.insertatend(10);
        s.insertatend(550);
        s.insertatend(220);
        s.insertatend(104);
        s.insertatend(101);

       /*
        //before reverse
        System.out.println("the list before revering is : ");
        s.print();
        //after reverse
        listnode reverse = s.reverse(s.head);
        System.out.println("the list after reversing is : ");
        s.print(reverse);
        */

        //use the above commented code for reversing the list

        //for finding the mid node in the list
        s.print();
        s.findmidnode();

        //to find the nth element from the last of the list
        System.out.println("finding the nth element from the last node");
        s.nthnode(3);
        s.nthnode(2);
        s.print();
        s.length();

        s.deleteatbeg();
        //removes the duplicate element in the linked list in unsorted list and its time complexity is O(n^2)
        System.out.println("removing the duplicates in unsorted list");
        s.insertatbeg(20);
        s.insertatend(550);
        s.insertatend(220);
        s.insertatend(10);
        s.print();
        s.removeduplicate();
        s.print();
        s.length();

        s.deleteatend();
        s.deleteatend();
        s.deleteatend();
        s.deleteatend();
        s.deleteatend();
        s.deleteatend();


        //removes the duplicates from the sorted list
        System.out.println("removing the element at the sorted list");
        s.print();
        s.insertatend(10);
        s.insertatend(10);
        s.insertatend(20);
        s.insertatend(30);
        s.insertatend(30);

        s.print();
        s.removeduplicatesorted();
        s.print();


        //inserting a node in the sorted list
        s.print();
        s.insertintosortedlist(25);
        s.print();

        //to delete a parameterised (passed) element
        s.deleteelement(25);
        s.deleteelement(20);
        s.deleteelement(10);
        s.deleteelement(30);

        s.print();
        s.length();


        //finding whether the list is having loop or not
        //use the below 2 lines of code to create the list with loop and to find whether the list is having loop or not
/*

        s.createloopinlist();
        System.out.println(s.containsLoop());

*/



        //to find the starting point of the loop in the list(floyd's cycle detection algorithm)

        /*      steps to find the floyd's cycle detection algorithm
                1 : first we are finding the loop by knowing that the 2 pointer are meeting at the same node by following the slowptr and fastptr
                2 : then we are going to find the starting point of the loop by the temp pointer from head and the slow pointer by moving 1 steps by two of the pointers
                    when both are pointing to same node then it is the starting point of the loop
        */
        s.createloopinlist();
        System.out.println("\nthe starting point of the loop in the list is : "+s.startnodeofloop().data);


        //to remove the loop in the list

        s.removeloopinlist();
        s.print();


    }

}

package singlyllist;

public class mainmethod {
    public static void main(String[] args) {
        //the node class , singlyllist.list class and singlyllist.mainmethod class -> all combined is singly linked singlyllist.list another method
        list l = new list();
        l.insertatend(5);
        l.insertatend(10);
        l.insertatend(15);
        l.insertatend(20);
        l.insertatbeg(100);
        l.print();
        l.insertatpos(2, 200);
        l.insertatpos(0, 1000);

        l.print();

        l.count();

        l.deleteat(2);

        l.print();

        l.deletebeg();

        l.print();

        l.deleteatend();

        l.print();

        l.count();

    }

}

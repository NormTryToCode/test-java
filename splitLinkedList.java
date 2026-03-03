public class splitLinkedList {
    public static void main(String[] args) {
        SingularList myNewLinkedList = new SingularList();
        myNewLinkedList.pushQ(10);
        myNewLinkedList.pushQ(20);
        myNewLinkedList.pushQ(30);
        System.out.println(myNewLinkedList.countElements());
        SingularList splittedList = myNewLinkedList.splitList();
        splittedList.printList();
    }
    
}